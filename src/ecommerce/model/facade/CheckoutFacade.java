package src.ecommerce.model.facade;

import src.ecommerce.model.Carrinho;
import src.ecommerce.model.Cliente;
import src.ecommerce.model.Responsability.ValidadorPedido;
import src.ecommerce.model.dao.PedidoDAO;
import src.ecommerce.model.strategy.EstrategiaDesconto;

import src.ecommerce.model.Pedido;

/**
 * Facade Pattern:
 * fornece uma interface simplificada para finalizar uma compra.
 */
public class CheckoutFacade {

    private PedidoDAO pedidoDAO;
    private ValidadorPedido validadores;

    public CheckoutFacade(
        PedidoDAO pedidoDAO,
        ValidadorPedido validadores
    ) {
        this.pedidoDAO = pedidoDAO;
        this.validadores = validadores;
    }

    /**
     * Coordena a criação e o armazenamento de um pedido.
     */
    public Pedido finalizarCompra(
        int idPedido,
        Cliente cliente,
        Carrinho carrinho,
        EstrategiaDesconto estrategia
    ) {

        // 1. Valida cliente e carrinho.
        validadores.validar(cliente, carrinho);

        // 2. Cria o pedido com uma cópia dos itens.
        Pedido pedido = new Pedido(idPedido, cliente, carrinho);

        // 3. Aplica a estratégia de desconto, se houver.
        if (estrategia != null) {

            double desconto = estrategia.calcularDesconto(
                pedido.getSubtotal()
            );

            pedido.aplicarDesconto(desconto);
        }

        // 4. Salva o pedido.
        pedidoDAO.salvar(pedido);

        // 5. Limpa o carrinho após a criação do pedido.
        carrinho.limpar();

        return pedido;
    }
}

