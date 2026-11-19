package src.ecommerce.model.Responsability;

import src.ecommerce.model.Cliente;
import src.ecommerce.model.Carrinho;

/**
 * Chain of Responsibility:
 * cada validador executa uma verificação e, se estiver tudo correto passa para o próximo.
 */
public abstract class ValidadorPedido {

    private ValidadorPedido proximo;

    public ValidadorPedido definirProximo(ValidadorPedido proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public void validar(Cliente cliente, Carrinho carrinho) {

        executarValidacao(cliente, carrinho);

        if (proximo != null) {
            proximo.validar(cliente, carrinho);
        }
    }

    protected abstract void executarValidacao(
        Cliente cliente,
        Carrinho carrinho
    );
}

