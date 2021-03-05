package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import src.Conexao.*;
import src.Entidades.Personal.Personal;
import src.Entidades.Utils.Endereco;

public class DAOPersonal extends Conexao {
    Connection conexao = null;

    public DAOPersonal() throws SQLException {
        try {
            conexao = Conexao.createConnection();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public void adicionarPersonal(Personal p) throws SQLException {
        try {
            String sql = "INSERT INTO TB_Personal(cref, usuario) VALUES (?, ROW(?, ROW(?, ?, ?, ?), ?, ?, ?))";

            PreparedStatement st;
            st = this.conexao.prepareStatement(sql);
            st.setInt(1, p.getCref());
            st.setString(2, p.getNome());
            st.setString(3, p.getEndereco().getRua());
            st.setInt(4, p.getEndereco().getNumero());
            st.setString(5, p.getEndereco().getBairro());
            st.setString(6, p.getEndereco().getCidade());
            st.setString(7, p.getEmail());
            st.setString(8, p.getSenha());
            st.setString(9, p.getTelefone());

            st.execute();
            st.close();

        } catch (Exception e) {
            System.out.println("INSERT ERROR: " + e);
        }

    }

    public ArrayList<Personal> buscarTodos() throws SQLException {
        ArrayList<Personal> personais = new ArrayList<>();

        String sql = "SELECT cref, (usuario).nome, (usuario).endereco.rua, (usuario).endereco.numero, (usuario).endereco.bairro, (usuario).endereco.cidade, (usuario).email, (usuario).senha FROM TB_Personal";

        PreparedStatement st;
        st = this.conexao.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while(rs.next()) {
            Personal p = new Personal();
            Endereco e = new Endereco();
            p.setCref(rs.getInt(1));
            p.setNome(rs.getString(2));
            e.setRua(rs.getString(3));
            e.setNumero(rs.getInt(4));
            e.setBairro(rs.getString(5));
            e.setCidade(rs.getString(6));
            p.setEndereco(e);
            p.setEmail(rs.getString(7));
            p.setTelefone(rs.getString(8));
            personais.add(p);
        }

        rs.close();
        st.close();

        return personais;

    }

    public Personal buscarId(int id) throws SQLException {

        String sql = "SELECT cref, (usuario).nome, (usuario).endereco.rua, (usuario).endereco.numero, (usuario).endereco.bairro, (usuario).endereco.cidade, (usuario).email, (usuario).senha FROM TB_Personal WHERE cref = ?";
        PreparedStatement st = this.conexao.prepareStatement(sql);

        st.setInt(1, id);

        ResultSet rs = st.executeQuery();

        Personal p = new Personal();
        Endereco e = new Endereco();
        
        while(rs.next()) {
            p.setCref(rs.getInt(1));
            p.setNome(rs.getString(2));
            e.setRua(rs.getString(3));
            e.setNumero(rs.getInt(4));
            e.setBairro(rs.getString(5));
            e.setCidade(rs.getString(6));
            p.setEndereco(e);
            p.setEmail(rs.getString(7));
            p.setTelefone(rs.getString(8));
        }
        
        st.close();
        rs.close();

        return p;

    }

    public void alterarPersonal(Personal p) throws SQLException{
        String sql = "UPDATE TB_Personal SET usuario.nome = ?, usuario.endereco.rua = ?, usuario.endereco.numero = ?, usuario.endereco.bairro = ?, usuario.endereco.cidade = ?, usuario.email = ?, usuario.senha = ?, usuario.telefone = ? WHERE cref = ?";

        PreparedStatement st = this.conexao.prepareStatement(sql);
        
        st.setString(1, p.getNome());
        st.setString(2, p.getEndereco().getRua());
        st.setInt(3, p.getEndereco().getNumero());
        st.setString(4, p.getEndereco().getBairro());
        st.setString(5, p.getEndereco().getCidade());
        st.setString(6, p.getEmail());
        st.setString(7, p.getSenha());
        st.setString(8, p.getTelefone());

        st.setInt(9, p.getCref());

        st.execute();
        st.close();

    }

    public void excluirPersonal(int id) throws SQLException {
        String sql = "DELETE FROM TB_Personal WHERE cref = ?";
        PreparedStatement st = this.conexao.prepareStatement(sql);

        st.setInt(1, id);
        
        st.execute();
        st.close();
    }
}
