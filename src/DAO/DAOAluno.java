package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import Entidades.Aluno.Aluno;
import Entidades.Utils.Endereco;

public class DAOAluno extends Conexao {
    
    Connection conexao = null;

    public DAOAluno() throws SQLException {
        try {
            conexao = Conexao.createConnection();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public void adicionarAluno(Aluno a) throws SQLException {
        try {
            String sql = "INSERT INTO TB_Aluno(usuario, idExames, idFichaAnamnese, idDieta, idTreino) VALUES (ROW(?, ROW(?, ?, ?, ?), ?, ?, ?), ?, ?, ?, ?)";
            PreparedStatement st;
            st = this.conexao.prepareStatement(sql);
            // USER ROW
            st.setString(1, a.getNome());
            // USER ADRESS ROW
            st.setString(2, a.getEndereco().getRua());
            st.setInt(3, a.getEndereco().getNumero());
            st.setString(4, a.getEndereco().getBairro());
            st.setString(5, a.getEndereco().getCidade());

            st.setString(6, a.getEmail());
            st.setString(7, a.getSenha());
            st.setString(8, a.getTelefone());
            st.setInt(9, a.getIdExames());
            st.setInt(10, a.getIdFichaAnamnese());
            st.setInt(11, a.getIdDieta());
            st.setInt(12, a.getIdTreino());

            st.execute();
            st.close();
            System.out.println("X");

        } catch (Exception e) {
            System.out.println("INSERT ERROR: " + e);
        }

    }

    public ArrayList<Aluno> buscarTodos() throws SQLException {
        ArrayList<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT id, (usuario).nome, (usuario).endereco.rua, (usuario).endereco.numero, (usuario).endereco.bairro, (usuario).endereco.cidade, (usuario).email, (usuario).senha, idExames, idFichaAnamnese, idDieta, idTreino FROM TB_Aluno";

        PreparedStatement st;
        st = this.conexao.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while(rs.next()) {
            Aluno a = new Aluno();
            Endereco e = new Endereco();
            
            a.setId(rs.getInt(1));
            a.setNome(rs.getString(2));
            e.setRua(rs.getString(3));
            e.setNumero(rs.getInt(4));
            e.setBairro(rs.getString(5));
            e.setCidade(rs.getString(6));
            a.setEndereco(e);
            a.setEmail(rs.getString(7));
            a.setSenha(rs.getString(8));
            a.setIdExames(rs.getInt(9));
            a.setIdFichaAnamnese(rs.getInt(10));
            a.setIdDieta(rs.getInt(11));
            a.setIdTreino(rs.getInt(12));

            alunos.add(a);
        }

        rs.close();
        st.close();

        return alunos;

    }

    public Aluno buscarId(int id) throws SQLException {

        String sql = "SELECT id, (usuario).nome, (usuario).endereco.rua, (usuario).endereco.numero, (usuario).endereco.bairro, (usuario).endereco.cidade, (usuario).email, (usuario).senha, idExames, idFichaAnamnese, idDieta, idTreino FROM TB_Aluno WHERE id = ?";
        PreparedStatement st = this.conexao.prepareStatement(sql);

        st.setInt(1, id);

        ResultSet rs = st.executeQuery();

        Aluno a = new Aluno();
        Endereco e = new Endereco();
        while(rs.next()) {    
            a.setId(rs.getInt(1));
            a.setNome(rs.getString(2));
            e.setRua(rs.getString(3));
            e.setNumero(rs.getInt(4));
            e.setBairro(rs.getString(5));
            e.setCidade(rs.getString(6));
            a.setEndereco(e);
            a.setEmail(rs.getString(7));
            a.setSenha(rs.getString(8));
            a.setIdExames(rs.getInt(9));
            a.setIdFichaAnamnese(rs.getInt(10));
            a.setIdDieta(rs.getInt(11));
            a.setIdTreino(rs.getInt(12));
        }
        st.close();
        rs.close();

        return a;

    }

    public void alterarAluno(Aluno a) throws SQLException{
        String sql = "UPDATE TB_Aluno SET usuario.nome = ?, usuario.endereco.rua = ?, usuario.endereco.numero = ?, usuario.endereco.bairro = ?, usuario.endereco.cidade = ?, usuario.email = ?, usuario.senha = ?, usuario.telefone = ? WHERE id = ?";

        PreparedStatement st = this.conexao.prepareStatement(sql);
        st.setString(1, a.getNome());
        st.setString(2, a.getEndereco().getRua());
        st.setInt(3, a.getEndereco().getNumero());
        st.setString(4, a.getEndereco().getBairro());
        st.setString(5, a.getEndereco().getCidade());
        st.setString(6, a.getEmail());
        st.setString(7, a.getSenha());
        st.setString(8, a.getTelefone());

        st.setInt(9, a.getId());

        st.execute();
        st.close();

    }

    public void excluirAluno(int id) throws SQLException {
        String sql = "DELETE FROM TB_Aluno WHERE id = ?";
        PreparedStatement st = this.conexao.prepareStatement(sql);

        st.setInt(1, id);
        
        st.execute();
        st.close();
    }

}