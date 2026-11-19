package src.ecommerce.model.Responsability;

import src.ecommerce.model.Cliente;
import src.ecommerce.model.Carrinho;

/**
 * Verifica se o carrinho pode ser convertido em pedido.
 */
public class ValidadorCarrinho extends ValidadorPedido {

    @Override
    protected void executarValidacao(
        Cliente cliente,
        Carrinho carrinho
    ) {

        if (carrinho == null || carrinho.estaVazio()) {
            throw new IllegalArgumentException(
                "O carrinho está vazio."
            );
        }

        if (carrinho.calcularTotal() <= 0) {
            throw new IllegalArgumentException(
                "O valor da compra precisa ser maior que zero."
            );
        }
    }
}

