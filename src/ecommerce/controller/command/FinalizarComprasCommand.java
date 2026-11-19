package src.ecommerce.controller.command;

import src.ecommerce.view.MenuView;

public class FinalizarComprasCommand implements Command{
	private MenuView view;

    public FinalizarComprasCommand(MenuView view) {
        this.view = view;
    }

    /**
     * Executa a operação de visualização do carrinho.
     */
    @Override
    public void executar() {
        view.exibirMensagem(
            "A funcionalidade FINALIZAR COMPRAS será implementada em breve!"
        );
    }
}
