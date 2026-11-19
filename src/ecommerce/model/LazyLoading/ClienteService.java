package src.ecommerce.model.LazyLoading;

import java.util.List;

import src.ecommerce.model.Cliente;
import src.ecommerce.model.Pedido;
import src.ecommerce.model.dao.ClienteDAO;
import src.ecommerce.model.dao.PedidoDAO;

/**
 * Centraliza operações relacionadas aos clientes.
 *
 * Também coordena o carregamento sob demanda
 * do histórico de pedidos.
 */
public class ClienteService {

    private ClienteDAO clienteDAO;
    private PedidoDAO pedidoDAO;

    public ClienteService(
        ClienteDAO clienteDAO,
        PedidoDAO pedidoDAO
    ) {
        this.clienteDAO = clienteDAO;
        this.pedidoDAO = pedidoDAO;
    }

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarPorId(id);
    }

    public void cadastrarCliente(Cliente cliente) {
        clienteDAO.salvar(cliente);
    }

    /**
     * Lazy Loading:
     * carrega o histórico apenas quando solicitado.
     */
    public List<Pedido> consultarHistorico(Cliente cliente) {

        if (cliente == null) {
            throw new IllegalArgumentException(
                "Cliente não encontrado."
            );
        }

        List<Pedido> historico = cliente.getPedidos();

        if (historico.isEmpty()) {
            historico = pedidoDAO.listarPorCliente(cliente.getId());
            cliente.definirPedidos(historico);
        }

        return cliente.getPedidos();
    }
}

