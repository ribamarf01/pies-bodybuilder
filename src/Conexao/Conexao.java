package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexao {

    public static Connection createConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = null;
            String url = "jdbc:postgresql:DB_Bodybuilder";
            String user = "postgres";
            String password = "123";

            con = DriverManager.getConnection(url, user, password);
            
            return con;
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
