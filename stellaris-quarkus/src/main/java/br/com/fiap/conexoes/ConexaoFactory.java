package br.com.fiap.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    // metodo de conexão com o banco de dados
    public Connection conexao() throws ClassNotFoundException, SQLException {
        String url = System.getenv("DATABASE_URL");

        // Converte postgresql://user:pass@host:port/db para jdbc:postgresql://host:port/db
        if (url != null && url.startsWith("postgresql://")) {
            url = url.replace("postgresql://", "jdbc:postgresql://");
            // Remove credenciais da URL e passa separadamente
            java.net.URI uri = java.net.URI.create(url.replace("jdbc:", ""));
            String host = uri.getHost();
            int port = uri.getPort();
            String db = uri.getPath().substring(1);
            String userInfo = uri.getUserInfo();
            String user = userInfo.split(":")[0];
            String pass = userInfo.split(":")[1];

            url = "jdbc:postgresql://" + host + ":" + port + "/" + db;
            return DriverManager.getConnection(url, user, pass);
        }

        return DriverManager.getConnection(url);
    }
}
