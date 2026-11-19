package src.ecommerce.controller;

import src.ecommerce.model.Carrinho;
import src.ecommerce.model.service.CarrinhoService;
import src.ecommerce.model.vo.ProdutoVO;

/**
 * Controller responsável pelas operações do carrinho.
 *
 * MVC:
 * recebe solicitações da View e delega as operações
 * ao CarrinhoService.
 */
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    public void adicionarProduto(ProdutoVO produto, int quantidade) {
        carrinhoService.adicionarProduto(produto, quantidade);
    }

    public boolean removerProduto(int idProduto) {
        return carrinhoService.removerProduto(idProduto);
    }

    public Carrinho visualizarCarrinho() {
        return carrinhoService.consultarCarrinho();
    }

    public double consultarTotal() {
        return carrinhoService.consultarTotal();
    }

    public void limparCarrinho() {
        carrinhoService.esvaziarCarrinho();
    }
}

