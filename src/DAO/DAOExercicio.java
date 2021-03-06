package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import Entidades.Personal.Exercicio;

public class DAOExercicio extends Conexao{
    Connection conexao = null;

    public DAOExercicio() throws SQLException {
        try {
            conexao = Conexao.createConnection();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public void adicionarExercicio(Exercicio ex) throws SQLException {
        try {
            String sql = "INSERT INTO TB_Exercicio(nome, membro, grupo, idAutor) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement st;
            st = this.conexao.prepareStatement(sql);
            st.setString(1, ex.getNome());
            st.setString(2, ex.getMembro());
            st.setString(3, String.valueOf(ex.getGrupo()));
            st.setInt(4, ex.getIdAutor());

            st.execute();
            st.close();

        } catch (Exception e) {
            System.out.println("INSERT ERROR: " + e);
        }

    }

    public ArrayList<Exercicio> buscarTodos() throws SQLException {
        ArrayList<Exercicio> exercicios = new ArrayList<>();

        String sql = "SELECT * FROM TB_Exercicio";

        PreparedStatement st;
        st = this.conexao.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while(rs.next()) {
            Exercicio ex = new Exercicio();
            ex.setIdExercicio(rs.getInt("idExercicio"));
            ex.setNome(rs.getString("nome"));
            ex.setMembro(rs.getString("membro"));
            ex.setGrupo(rs.getString("grupo").charAt(0));
            ex.setIdAutor(rs.getInt("idAutor"));
            exercicios.add(ex);
        }

        rs.close();
        st.close();

        return exercicios;

    }

    public Exercicio buscarId(int id) throws SQLException {

        String sql = "SELECT * FROM TB_Personal WHERE cref = ?";
        PreparedStatement st = this.conexao.prepareStatement(sql);

        st.setInt(1, id);

        ResultSet rs = st.executeQuery();

        Exercicio ex = new Exercicio();
        ex.setIdExercicio(rs.getInt("idExercicio"));
        ex.setNome(rs.getString("nome"));
        ex.setMembro(rs.getString("membro"));
        ex.setGrupo(rs.getString("grupo").charAt(0));
        ex.setIdAutor(rs.getInt("idAutor"));

        st.close();
        rs.close();

        return ex;

    }

    public void alterarExercicio(Exercicio ex) throws SQLException{
        String sql = "UPDATE TB_Exercicio SET nome = ?, membro = ?, grupo = ?, idAutor = ?";

        PreparedStatement st = this.conexao.prepareStatement(sql);
        st.setString(1, ex.getNome());
        st.setString(2, ex.getMembro());
        st.setString(3, String.valueOf(ex.getGrupo()));
        st.setInt(4, ex.getIdAutor());

        st.setInt(5, ex.getIdExercicio());

        st.execute();
        st.close();

    }

    public void excluirExercicio(int id) throws SQLException {
        String sql = "DELETE FROM TB_Exercicio WHERE idExercicio = ?";
        PreparedStatement st = this.conexao.prepareStatement(sql);

        st.setInt(1, id);
        
        st.execute();
        st.close();
    }
}
