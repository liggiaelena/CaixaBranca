package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.DriverManager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) { }
        return conn;
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) { //nó 1
        String sql = "";
        Connection conn = conectarBD(); //nó 2
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "'";
        try {
            Statement st = conn.createStatement(); //nó 3
            ResultSet rs = st.executeQuery(sql); //nó 4

            if (rs.next()) { //nó 5
                result = true;  //nó 6
                nome = rs.getString("nome");
            }
        } catch (Exception e) { } //nó 7
        return result; //nó 8
    }
} // fim da class