package src.ecommerce.model.dao;

import java.util.List;

import src.ecommerce.model.Cliente;

/**
 * DAO (Data Access Object):
 */
public interface ClienteDAO {

    void salvar(Cliente cliente);

    Cliente buscarPorId(int id);

    Cliente buscarPorEmail(String email);

    List<Cliente> listarTodos();
}
