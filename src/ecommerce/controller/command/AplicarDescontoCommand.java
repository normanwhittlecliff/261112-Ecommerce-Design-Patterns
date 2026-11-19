package src.ecommerce.controller.command;

import src.ecommerce.view.MenuView;

public class AplicarDescontoCommand implements Command {
	private MenuView view;

    public AplicarDescontoCommand(MenuView view) {
        this.view = view;
    }

    /**
     * Executa a operação de visualização do carrinho.
     */
    @Override
    public void executar() {
        view.exibirMensagem(
            "A funcionalidade APLICAR DESCONTO será implementada em breve!"
        );
    }
}
