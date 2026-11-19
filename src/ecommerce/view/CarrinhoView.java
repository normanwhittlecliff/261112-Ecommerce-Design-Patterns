package src.ecommerce.view;

import src.ecommerce.model.Carrinho;
import src.ecommerce.model.vo.ItemCarrinho;

/**
 * View responsável pela apresentação do carrinho.
 */
public class CarrinhoView {

    public void exibirCarrinho(Carrinho carrinho) {

        System.out.println("\n========== MEU CARRINHO ==========");

        if (carrinho.estaVazio()) {
            System.out.println("Seu carrinho está vazio.");
            return;
        }

        for (ItemCarrinho item : carrinho) {

            System.out.println(
                item.getProduto().getNome()
                + " | Quantidade: " + item.getQuantidade()
                + " | Subtotal: R$ "
                + String.format("%.2f", item.calcularSubtotal())
            );
        }

        System.out.println("----------------------------------");
        System.out.printf("Total: R$ %.2f%n", carrinho.calcularTotal());
        System.out.println("==================================");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}

