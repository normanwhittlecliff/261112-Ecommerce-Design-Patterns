package src.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.List;

import src.ecommerce.model.Cliente;

/**
 * Implementação em memória do ClienteDAO.
 *
 * Posteriormente, esta classe poderá ser substituída
 * por uma implementação que utilize banco de dados.
 */
public class ClienteDAOImpl implements ClienteDAO {

    private final List<Cliente> clientes = new ArrayList<>();

    @Override
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }

    @Override
    public Cliente buscarPorEmail(String email) {

        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                return cliente;
            }
        }

        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }
}
