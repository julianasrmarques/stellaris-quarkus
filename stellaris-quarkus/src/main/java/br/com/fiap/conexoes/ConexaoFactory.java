package br.com.fiap.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    // metodo de conexão com o banco de dados
    public Connection conexao() throws ClassNotFoundException, SQLException {
        String url = System.getenv("DATABASE_URL");
        // Converte o formato da URL para JDBC
        if (url != null && url.startsWith("postgresql://")) {
            url = url.replace("postgresql://", "jdbc:postgresql://");
        }
        return DriverManager.getConnection(url);
    }
}
