package src.ecommerce.model.service;

import java.util.List;

import src.ecommerce.model.Pedido;
import src.ecommerce.model.dao.PedidoDAO;


/**
 * Executa operações relacionadas aos pedidos.
 */
public class PedidoService {

    private final PedidoDAO pedidoDAO;

    public PedidoService(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public Pedido buscarPedido(int id) {
        return pedidoDAO.buscarPorId(id);
    }

    public List<Pedido> listarPedidos() {
        return pedidoDAO.listarTodos();
    }

    public List<Pedido> listarPedidosDoCliente(int idCliente) {
        return pedidoDAO.listarPorCliente(idCliente);
    }
}

