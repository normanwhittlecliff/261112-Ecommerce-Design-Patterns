package src.ecommerce.controller.command;


import src.ecommerce.view.MenuView;

/**
 * Comando responsável por solicitar a visualização do carrinho.
 */
public class VisualizarCarrinhoCommand implements Command {

    private MenuView view;

    public VisualizarCarrinhoCommand(MenuView view) {
        this.view = view;
    }

    /**
     * Executa a operação de visualização do carrinho.
     */
    @Override
    public void executar() {
        view.exibirMensagem(
            "A funcionalidade do carrinho será implementada em breve!"
        );
    }
}
