package src.ecommerce.model.service;

import src.ecommerce.model.Carrinho;
import src.ecommerce.model.vo.ProdutoVO;

/**
 * Executa as operações de negócio do carrinho.
 */
public class CarrinhoService {

    private final Carrinho carrinho;

    public CarrinhoService(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void adicionarProduto(ProdutoVO produto, int quantidade) {
        carrinho.adicionarProduto(produto, quantidade);
    }

    public boolean removerProduto(int idProduto) {
        return carrinho.removerProduto(idProduto);
    }

    public Carrinho consultarCarrinho() {
        return carrinho;
    }

    public double consultarTotal() {
        return carrinho.calcularTotal();
    }

    public void esvaziarCarrinho() {
        carrinho.limpar();
    }
}

