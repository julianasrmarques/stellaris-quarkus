package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public Connection minhaConexao;

    // metodo construtor com parâmetro vazio
    public ReservaDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Reserva reserva) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_STA_RESERVA (PACKAGE_ID, PASSENGER_NAME, EMAIL, NUMBER_OF_PEOPLE, TRAVEL_DATE, STATUS) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, reserva.getPackageId());
        stmt.setString(2, reserva.getPassengerName());
        stmt.setString(3, reserva.getEmail());
        stmt.setInt(4, reserva.getNumberOfPeople());
        stmt.setString(5, reserva.getTravelDate());
        stmt.setString(6, "pendente");

        stmt.execute();
        stmt.close();

        return "Reserva cadastrada com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM T_STA_RESERVA WHERE ID = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Reserva deletada com sucesso!";
    }

    // Update
    public String atualizar(Reserva reserva) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE T_STA_RESERVA SET TRAVEL_DATE = ?, STATUS = ? WHERE ID = ?");
        stmt.setString(1, reserva.getTravelDate());
        stmt.setString(2, reserva.getStatus());
        stmt.setInt(3, reserva.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Reserva atualizada com sucesso!";
    }

    // Select
    public List<Reserva> selecionar() throws SQLException {
        List<Reserva> listaReservas = new ArrayList<Reserva>();
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM T_STA_RESERVA");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Reserva reserva = new Reserva();
            reserva.setId(rs.getInt("ID"));
            reserva.setPackageId(rs.getInt("PACKAGE_ID"));
            reserva.setPassengerName(rs.getString("PASSENGER_NAME"));
            reserva.setEmail(rs.getString("EMAIL"));
            reserva.setNumberOfPeople(rs.getInt("NUMBER_OF_PEOPLE"));
            reserva.setTravelDate(rs.getString("TRAVEL_DATE"));
            reserva.setStatus(rs.getString("STATUS"));
            listaReservas.add(reserva);
        }

        rs.close();
        stmt.close();

        return listaReservas;
    }

    // Buscar por ID
    public Reserva buscarPorId(int id) throws SQLException {
        Reserva reserva = null;

        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM T_STA_RESERVA WHERE ID = ?");
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            reserva = new Reserva();
            reserva.setId(rs.getInt("ID"));
            reserva.setPackageId(rs.getInt("PACKAGE_ID"));
            reserva.setPassengerName(rs.getString("PASSENGER_NAME"));
            reserva.setEmail(rs.getString("EMAIL"));
            reserva.setNumberOfPeople(rs.getInt("NUMBER_OF_PEOPLE"));
            reserva.setTravelDate(rs.getString("TRAVEL_DATE"));
            reserva.setStatus(rs.getString("STATUS"));
        }

        rs.close();
        stmt.close();

        return reserva;
    }
}
