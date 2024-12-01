package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsável pelo gerenciamento de usuários.
 *
 * <p>Essa classe fornece um método para consultar o login e senha de um usuário.</p>
 *
 * @author Liggia Elena Taboada Cruz
 * @version 1.0
 */
public class User {
    public Connection conectarBD() {
        /**
         * Função responsável por tentar conectar com um banco de dados
         *
         * <p>Essa classe não possui parametros de entrada.</p>
         *
         * @return uma conexão
         */
        Connection conn = null;
        try {
            Class.forName("com.mysql.DriverManager").newInstance(); //Tenta carregar a classe do driver JDBC para MySQL.
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; // Define a URL de conexão com o banco de dados.
            conn = DriverManager.getConnection(url);
        } catch (Exception e) { } //tratamento de exceção ainda não esta finalizado
        return conn;
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) {
        /**
         * Função responsável por verificar o login de um usuário
         *
         * @params login Representa o login podendo ser um código, email, etc
         * @params senha Representa o senha escolhida pelo usuário
         * @return um boolean que diz se o usuário existe
         */
        String sql = "";
        Connection conn = conectarBD();   //faz a conexão com o bd
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "'";
        try {
            Statement st = conn.createStatement(); //tenta criar statement para fazer consultas no bd
            ResultSet rs = st.executeQuery(sql);  //armazena o resultado da busca
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome"); // Obtém o valor da coluna "nome" da linha atual do ResultSet e armazena na variável 'nome'.
            }
        } catch (Exception e) { } //tratamento de exceção ainda não esta finalizado
        return result;
    }
} // fim da class