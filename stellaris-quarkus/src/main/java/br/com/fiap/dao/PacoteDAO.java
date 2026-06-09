package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Pacote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacoteDAO {

    public Connection minhaConexao;

    // metodo construtor com parâmetro vazio
    public PacoteDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Pacote pacote) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_STA_PACOTE (ID, NAME, DESTINATION, DESCRIPTION, PRICE, DURATION, AVAILABLE_SEATS, IMAGE_URL) VALUES (SEQ_STA_PACOTE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, pacote.getName());
        stmt.setString(2, pacote.getDestination());
        stmt.setString(3, pacote.getDescription());
        stmt.setDouble(4, pacote.getPrice());
        stmt.setString(5, pacote.getDuration());
        stmt.setInt(6, pacote.getAvailableSeats());
        stmt.setString(7, pacote.getImageUrl());

        stmt.execute();
        stmt.close();

        return "Pacote cadastrado com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM T_STA_PACOTE WHERE ID = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Pacote deletado com sucesso!";
    }

    // Update
    public String atualizar(Pacote pacote) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE T_STA_PACOTE SET NAME = ?, DESTINATION = ?, DESCRIPTION = ?, PRICE = ?, DURATION = ?, AVAILABLE_SEATS = ?, IMAGE_URL = ? WHERE ID = ?");
        stmt.setString(1, pacote.getName());
        stmt.setString(2, pacote.getDestination());
        stmt.setString(3, pacote.getDescription());
        stmt.setDouble(4, pacote.getPrice());
        stmt.setString(5, pacote.getDuration());
        stmt.setInt(6, pacote.getAvailableSeats());
        stmt.setString(7, pacote.getImageUrl());
        stmt.setInt(8, pacote.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Pacote atualizado com sucesso!";
    }

    // Select
    public List<Pacote> selecionar() throws SQLException {
        List<Pacote> listaPacotes = new ArrayList<Pacote>();
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM T_STA_PACOTE");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Pacote pacote = new Pacote();
            pacote.setId(rs.getInt("ID"));
            pacote.setName(rs.getString("NAME"));
            pacote.setDestination(rs.getString("DESTINATION"));
            pacote.setDescription(rs.getString("DESCRIPTION"));
            pacote.setPrice(rs.getDouble("PRICE"));
            pacote.setDuration(rs.getString("DURATION"));
            pacote.setAvailableSeats(rs.getInt("AVAILABLE_SEATS"));
            pacote.setImageUrl(rs.getString("IMAGE_URL"));
            listaPacotes.add(pacote);
        }

        rs.close();
        stmt.close();

        return listaPacotes;
    }

    // Buscar por ID
    public Pacote buscarPorId(int id) throws SQLException {
        Pacote pacote = null;

        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM T_STA_PACOTE WHERE ID = ?");
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            pacote = new Pacote();
            pacote.setId(rs.getInt("ID"));
            pacote.setName(rs.getString("NAME"));
            pacote.setDestination(rs.getString("DESTINATION"));
            pacote.setDescription(rs.getString("DESCRIPTION"));
            pacote.setPrice(rs.getDouble("PRICE"));
            pacote.setDuration(rs.getString("DURATION"));
            pacote.setAvailableSeats(rs.getInt("AVAILABLE_SEATS"));
            pacote.setImageUrl(rs.getString("IMAGE_URL"));
        }

        rs.close();
        stmt.close();

        return pacote;
    }
}
