package src.ecommerce.view;

import src.ecommerce.model.ItemPedido;
import src.ecommerce.model.Pedido;

/**
 * View responsável pela apresentação dos pedidos.
 */
public class PedidoView {

    public void exibirPedido(Pedido pedido) {

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("\n========== PEDIDO ==========");
        System.out.println("Número: " + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Data: " + pedido.getDataCriacao());
        System.out.println("Status: " + pedido.getStatus());

        System.out.println("\nProdutos:");

        for (ItemPedido item : pedido.getItens()) {

            System.out.printf(
                "%s | %d unidade(s) | R$ %.2f%n",
                item.getNomeProduto(),
                item.getQuantidade(),
                item.calcularSubtotal()
            );
        }

        System.out.println("----------------------------");
        System.out.printf("Subtotal: R$ %.2f%n", pedido.getSubtotal());
        System.out.printf("Desconto: R$ %.2f%n", pedido.getDesconto());
        System.out.printf("Total: R$ %.2f%n", pedido.getTotal());
        System.out.println("============================");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}

