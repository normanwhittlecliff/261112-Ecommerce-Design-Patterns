package src.ecommerce.controller.command;

import src.ecommerce.view.MenuView;

public class AdicionarProdutoNoCarrinhoCommand implements Command {
	private MenuView view;

    public AdicionarProdutoNoCarrinhoCommand(MenuView view) {
        this.view = view;
    }

    /**
     * Executa a operação de visualização do carrinho.
     */
    @Override
    public void executar() {
        view.exibirMensagem(
            "A funcionalidade ADICIONAR AO CARRINHO será implementada em breve!"
        );
    }
}
