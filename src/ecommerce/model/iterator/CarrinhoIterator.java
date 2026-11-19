package src.ecommerce.model.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import src.ecommerce.model.vo.ItemCarrinho;

/**
 * Iterator concreto para percorrer os itens do carrinho.
 */
public class CarrinhoIterator implements Iterator<ItemCarrinho> {

    private final List<ItemCarrinho> itens;
    private int posicao;

    public CarrinhoIterator(List<ItemCarrinho> itens) {
        this.itens = itens;
        this.posicao = 0;
    }

    @Override
    public boolean hasNext() {
        return posicao < itens.size();
    }

    @Override
    public ItemCarrinho next() {

        if (!hasNext()) {
            throw new NoSuchElementException(
                "Não existem mais itens no carrinho."
            );
        }

        return itens.get(posicao++);
    }
}
