package src.ecommerce.controller.command;

import src.ecommerce.view.MenuView;

public class VisualizarProtudoDetalhadoCommand implements Command{
	private MenuView view;

    public VisualizarProtudoDetalhadoCommand(MenuView view) {
        this.view = view;
    }

    /**
     * Executa a operação de visualização do carrinho.
     */
    @Override
    public void executar() {
        view.exibirMensagem(
            "A funcionalidade Visualizar Produto Detalhado será implementada em breve!"
        );
    }
}
