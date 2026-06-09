package br.com.fiap.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    // metodo de conexão com o banco de dados
    public Connection conexao() throws ClassNotFoundException, SQLException {
        try {
            String dbUrl = System.getenv("DATABASE_URL");
            java.net.URI uri = new java.net.URI(dbUrl);
            String host = uri.getHost();
            int port = uri.getPort();
            String path = uri.getPath();
            String userInfo = uri.getUserInfo();
            String user = userInfo.split(":")[0];
            String password = userInfo.split(":")[1];
            String query = uri.getQuery();

            String jdbcUrl = "jdbc:postgresql://" + host + ":" + port + path + (query != null ? "?" + query : "");

            return DriverManager.getConnection(jdbcUrl, user, password);
        } catch (java.net.URISyntaxException e) {
            throw new SQLException("URL inválida: " + e.getMessage());
        }
    }
}
