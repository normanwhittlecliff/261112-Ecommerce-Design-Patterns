package src.ecommerce.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import src.ecommerce.model.vo.ItemCarrinho;
import src.ecommerce.model.vo.ProdutoVO;
import src.ecommerce.model.iterator.CarrinhoIterator;

/**
 * Representa o carrinho de compras do cliente.
 *
 * Responsabilidades:
 * - Adicionar produtos.
 * - Remover produtos.
 * - Alterar quantidades.
 * - Calcular o valor total.
 * - Disponibilizar um Iterator para percorrer os itens.
 */
public class Carrinho implements Iterable<ItemCarrinho> {

    private final List<ItemCarrinho> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    /**
     * Adiciona um produto ao carrinho.
     *
     * Se o produto já estiver presente,
     * sua quantidade será incrementada.
     */
    public void adicionarProduto(ProdutoVO produto, int quantidade) {

        if (produto == null || quantidade <= 0) {
            throw new IllegalArgumentException(
                "Produto ou quantidade inválida."
            );
        }

        for (ItemCarrinho item : itens) {

            if (item.getProduto().getId() == produto.getId()) {
                item.adicionarQuantidade(quantidade);
                return;
            }
        }

        itens.add(new ItemCarrinho(produto, quantidade));
    }

    /**
     * Remove completamente um produto do carrinho.
     */
    public boolean removerProduto(int idProduto) {

        return itens.removeIf(
            item -> item.getProduto().getId() == idProduto
        );
    }

    /**
     * Retorna a quantidade total de unidades no carrinho.
     */
    public int getQuantidadeTotal() {

        int quantidade = 0;

        for (ItemCarrinho item : itens) {
            quantidade += item.getQuantidade();
        }

        return quantidade;
    }

    /**
     * Calcula o valor total da compra antes dos descontos.
     */
    public double calcularTotal() {

        double total = 0;

        for (ItemCarrinho item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }

    public void limpar() {
        itens.clear();
    }

    public List<ItemCarrinho> getItens() {
        return new ArrayList<>(itens);
    }

    /**
     * Iterator Pattern:
     * permite percorrer os itens sem expor diretamente
     * a implementação interna da coleção.
     */
    @Override
    public Iterator<ItemCarrinho> iterator() {
        return new CarrinhoIterator(itens);
    }
}
