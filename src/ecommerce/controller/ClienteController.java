package src.ecommerce.controller;

import java.util.List;

import src.ecommerce.model.Cliente;
import src.ecommerce.model.Pedido;
import src.ecommerce.model.LazyLoading.ClienteService;

/**
 * Controller responsável pelas operações de clientes.
 */
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void cadastrarCliente(Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
    }

    public Cliente buscarCliente(int id) {
        return clienteService.buscarCliente(id);
    }

    public List<Pedido> consultarHistorico(Cliente cliente) {
        return clienteService.consultarHistorico(cliente);
    }
}

