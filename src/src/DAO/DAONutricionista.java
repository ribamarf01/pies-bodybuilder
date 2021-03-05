package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import src.Conexao.*;
import src.Entidades.Nutricionista.Nutricionista;
import src.Entidades.Utils.Endereco;

public class DAONutricionista extends Conexao {
    Connection conexao = null;

    public DAONutricionista() throws SQLException {
        try {
            conexao = Conexao.createConnection();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public void adicionarNutricionista(Nutricionista n) throws SQLException {
        try {
            String sql = "INSERT INTO TB_Nutricionista(crm, usuario) VALUES (?, ROW(?, ROW(?, ?, ?, ?), ?, ?, ?))";

            PreparedStatement st;
            st = this.conexao.prepareStatement(sql);
            st.setInt(1, n.getCrm());
            st.setString(2, n.getNome());
            st.setString(3, n.getEndereco().getRua());
            st.setInt(4, n.getEndereco().getNumero());
            st.setString(5, n.getEndereco().getBairro());
            st.setString(6, n.getEndereco().getCidade());
            st.setString(7, n.getEmail());
            st.setString(8, n.getSenha());
            st.setString(9, n.getTelefone());

            st.execute();
            st.close();

        } catch (Exception e) {
            System.out.println("INSERT ERROR: " + e);
        }

    }

    public ArrayList<Nutricionista> buscarTodos() throws SQLException {
        ArrayList<Nutricionista> nutricionistas = new ArrayList<>();

        String sql = "SELECT crm, (usuario).nome, (usuario).endereco.rua, (usuario).endereco.numero, (usuario).endereco.bairro, (usuario).endereco.cidade, (usuario).email, (usuario).senha FROM TB_Nutricionista";

        PreparedStatement st;
        st = this.conexao.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while(rs.next()) {
            Nutricionista n = new Nutricionista();
            Endereco e = new Endereco();
            n.setCrm(rs.getInt(1));
            n.setNome(rs.getString(2));
            e.setRua(rs.getString(3));
            e.setNumero(rs.getInt(4));
            e.setBairro(rs.getString(5));
            e.setCidade(rs.getString(6));
            n.setEndereco(e);
            n.setEmail(rs.getString(7));
            n.setTelefone(rs.getString(8));
            nutricionistas.add(n);
        }

        rs.close();
        st.close();

        return nutricionistas;

    }

    public Nutricionista buscarId(int id) throws SQLException {

        String sql = "SELECT * FROM TB_Nutricionista WHERE crm = ?";
        PreparedStatement st = this.conexao.prepareStatement(sql);

        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        Nutricionista n = new Nutricionista();
        Endereco e = new Endereco();
        while(rs.next()) {
            n.setCrm(rs.getInt(1));
            n.setNome(rs.getString(2));
            e.setRua(rs.getString(3));
            e.setNumero(rs.getInt(4));
            e.setBairro(rs.getString(5));
            e.setCidade(rs.getString(6));
            n.setEndereco(e);
            n.setEmail(rs.getString(7));
            n.setTelefone(rs.getString(8));
        }

        st.close();
        rs.close();

        return n;

    }

    public void alterarNutricionista(Nutricionista n) throws SQLException{
        String sql = "UPDATE TB_Nutricionista SET usuario.nome = ?, usuario.endereco.rua = ?, usuario.endereco.numero = ?, usuario.endereco.bairro = ?, usuario.endereco.cidade = ?, usuario.email = ?, usuario.senha = ?, usuario.telefone = ? WHERE crm = ?";

        PreparedStatement st = this.conexao.prepareStatement(sql);
        
        st.setString(1, n.getNome());
        st.setString(2, n.getEndereco().getRua());
        st.setInt(3, n.getEndereco().getNumero());
        st.setString(4, n.getEndereco().getBairro());
        st.setString(5, n.getEndereco().getCidade());
        st.setString(6, n.getEmail());
        st.setString(7, n.getSenha());
        st.setString(8, n.getTelefone());

        st.setInt(9, n.getCrm());

        st.execute();
        st.close();

    }

    public void excluirNutricionista(int id) throws SQLException {
        String sql = "DELETE FROM TB_Nutricionista WHERE crm = ?";
        PreparedStatement st = this.conexao.prepareStatement(sql);

        st.setInt(1, id);
        
        st.execute();
        st.close();
    }
}
