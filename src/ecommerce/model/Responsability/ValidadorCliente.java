package src.ecommerce.model.Responsability;

import src.ecommerce.model.Cliente;
import src.ecommerce.model.Carrinho;

/**
 * Verifica se existe um cliente válido para a compra.
 */
public class ValidadorCliente extends ValidadorPedido {

    @Override
    protected void executarValidacao(
        Cliente cliente,
        Carrinho carrinho
    ) {

        if (cliente == null) {
            throw new IllegalArgumentException(
                "É necessário selecionar um cliente."
            );
        }

        if (cliente.getNome() == null ||
            cliente.getNome().trim().isEmpty()) {

            throw new IllegalArgumentException(
                "O cliente precisa possuir um nome."
            );
        }
    }
}

