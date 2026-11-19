package src.ecommerce.model;

import src.ecommerce.model.vo.ProdutoVO;

/**
 * Representa uma cópia dos dados de um produto
 * no momento em que o pedido foi realizado.
 *
 * Não depende do ProdutoVO original depois da criação.
 */
public class ItemPedido {

    private final int idProduto;
    private final String nomeProduto;
    private final double precoUnitario;
    private final int quantidade;

    public ItemPedido(ProdutoVO produto, int quantidade) {

        this.idProduto = produto.getId();
        this.nomeProduto = produto.getNome();
        this.precoUnitario = produto.getPreco();
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularSubtotal() {
        return precoUnitario * quantidade;
    }
}
