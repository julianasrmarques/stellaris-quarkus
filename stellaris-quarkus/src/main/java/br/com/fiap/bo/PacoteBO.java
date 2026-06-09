package br.com.fiap.bo;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entities.Pacote;

import java.sql.SQLException;
import java.util.ArrayList;

public class PacoteBO {

    PacoteDAO pacoteDAO;

    // Selecionar
    public ArrayList<Pacote> selecionarBo() throws ClassNotFoundException, SQLException {
        pacoteDAO = new PacoteDAO();
        // Regra de negocios
        return (ArrayList<Pacote>) pacoteDAO.selecionar();
    }

    // Buscar por ID
    public Pacote buscarPorIdBo(int id) throws ClassNotFoundException, SQLException {
        PacoteDAO pacoteDao = new PacoteDAO();
        // Regra de negocios
        return pacoteDao.buscarPorId(id);
    }

    // Inserir
    public void inserirBo(Pacote pacote) throws ClassNotFoundException, SQLException {
        if (pacote.getName() == null || pacote.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do pacote é obrigatório");
        }
        if (pacote.getPrice() <= 0) {
            throw new IllegalArgumentException("Preço do pacote deve ser maior que zero");
        }
        if (pacote.getAvailableSeats() <= 0) {
            throw new IllegalArgumentException("Número de vagas deve ser maior que zero");
        }
        PacoteDAO pacoteDao = new PacoteDAO();
        // Regra de negocios
        pacoteDao.inserir(pacote);
    }

    // Atualizar
    public void atualizarBo(Pacote pacote) throws ClassNotFoundException, SQLException {
        if (pacote.getName() == null || pacote.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do pacote é obrigatório");
        }
        if (pacote.getPrice() <= 0) {
            throw new IllegalArgumentException("Preço do pacote deve ser maior que zero");
        }
        PacoteDAO pacoteDao = new PacoteDAO();
        // Regra de negocios
        pacoteDao.atualizar(pacote);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        PacoteDAO pacoteDao = new PacoteDAO();
        // Regra de negocios
        pacoteDao.deletar(id);
    }
}
