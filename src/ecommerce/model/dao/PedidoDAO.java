package src.ecommerce.model.dao;

import java.util.List;

import src.ecommerce.model.Pedido;

/**
 * Contrato de persistência dos pedidos.
 *
 * DAO Pattern.
 */
public interface PedidoDAO {

    void salvar(Pedido pedido);

    Pedido buscarPorId(int id);

    List<Pedido> listarTodos();

    List<Pedido> listarPorCliente(int idCliente);
}
