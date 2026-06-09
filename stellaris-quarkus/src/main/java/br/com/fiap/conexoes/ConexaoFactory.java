package br.com.fiap.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    // metodo de conexão com o banco de dados
    public Connection conexao() throws ClassNotFoundException, SQLException {
        String url = System.getenv("DATABASE_URL");

        if (url != null && url.startsWith("postgresql://")) {
            url = url.replace("postgresql://", "jdbc:postgresql://");
            // Adiciona porta padrão se não tiver
            if (!url.matches(".:\\d+/.")) {
                url = url.replaceFirst("(jdbc:postgresql://[^/]+)", "$1:5432");
            }
        }

        return DriverManager.getConnection(url);
    }
}
