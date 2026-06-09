package br.com.fiap.bo;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entities.Reserva;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservaBO {

    ReservaDAO reservaDAO;

    // Selecionar
    public ArrayList<Reserva> selecionarBo() throws ClassNotFoundException, SQLException {
        reservaDAO = new ReservaDAO();
        // Regra de negocios
        return (ArrayList<Reserva>) reservaDAO.selecionar();
    }

    // Buscar por ID
    public Reserva buscarPorIdBo(int id) throws ClassNotFoundException, SQLException {
        ReservaDAO reservaDao = new ReservaDAO();
        // Regra de negocios
        return reservaDao.buscarPorId(id);
    }

    // Inserir
    public void inserirBo(Reserva reserva) throws ClassNotFoundException, SQLException {
        if (reserva.getPassengerName() == null || reserva.getPassengerName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do passageiro é obrigatório");
        }
        if (reserva.getEmail() == null || !reserva.getEmail().contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        if (reserva.getNumberOfPeople() <= 0) {
            throw new IllegalArgumentException("Número de passageiros deve ser maior que zero");
        }
        if (reserva.getTravelDate() == null || reserva.getTravelDate().trim().isEmpty()) {
            throw new IllegalArgumentException("Data de viagem é obrigatória");
        }
        ReservaDAO reservaDao = new ReservaDAO();
        // Regra de negocios
        reservaDao.inserir(reserva);
    }

    // Atualizar
    public void atualizarBo(Reserva reserva) throws ClassNotFoundException, SQLException {
        if (reserva.getTravelDate() == null || reserva.getTravelDate().trim().isEmpty()) {
            throw new IllegalArgumentException("Data de viagem é obrigatória");
        }
        ReservaDAO reservaDao = new ReservaDAO();
        // Regra de negocios
        reservaDao.atualizar(reserva);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        ReservaDAO reservaDao = new ReservaDAO();
        // Regra de negocios
        reservaDao.deletar(id);
    }
}
