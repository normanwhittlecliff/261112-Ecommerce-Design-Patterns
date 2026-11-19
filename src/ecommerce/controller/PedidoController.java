package src.ecommerce.controller;

import java.util.List;

import src.ecommerce.model.Pedido;
import src.ecommerce.model.service.PedidoService;


/**
 * Controller responsável pela consulta de pedidos.
 */
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public Pedido buscarPedido(int id) {
        return pedidoService.buscarPedido(id);
    }

    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    public List<Pedido> listarPedidosDoCliente(int idCliente) {
        return pedidoService.listarPedidosDoCliente(idCliente);
    }
}

