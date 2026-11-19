package src.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.List;

import src.ecommerce.model.Pedido;

/**
 * Implementação em memória do PedidoDAO bem massa
 */
public class PedidoDAOImpl implements PedidoDAO {

    private final List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public Pedido buscarPorId(int id) {

        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }

        return null;
    }

    @Override
    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos);
    }

    @Override
    public List<Pedido> listarPorCliente(int idCliente) {

        List<Pedido> resultado = new ArrayList<>();

        for (Pedido pedido : pedidos) {

            if (pedido.getCliente().getId() == idCliente) {
                resultado.add(pedido);
            }
        }

        return resultado;
    }
}
