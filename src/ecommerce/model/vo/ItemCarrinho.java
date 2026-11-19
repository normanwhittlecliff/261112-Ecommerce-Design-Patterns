package src.ecommerce.model.vo;

import src.ecommerce.model.vo.ProdutoVO;

/**
 * Representa um produto dentro do carrinho
 * e a quantidade selecionada pelo cliente.
 */
public class ItemCarrinho {

    private ProdutoVO produto;
    private int quantidade;

    public ItemCarrinho(ProdutoVO produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        }
    }

    public void definirQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        }
    }

    /**
     * Calcula o subtotal deste item.
     */
    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }
}

