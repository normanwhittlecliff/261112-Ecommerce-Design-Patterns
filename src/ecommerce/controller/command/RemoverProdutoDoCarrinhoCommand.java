package src.ecommerce.controller.command;

import src.ecommerce.view.MenuView;

public class RemoverProdutoDoCarrinhoCommand implements Command{
	
	private MenuView view;

    public RemoverProdutoDoCarrinhoCommand(MenuView view) {
        this.view = view;
    }

    /**
     * Executa a operação de visualização do carrinho.
     */
    @Override
    public void executar() {
        view.exibirMensagem(
            "A funcionalidade REMOVER DO CARRINHO será implementada em breve!"
        );
    }
}
