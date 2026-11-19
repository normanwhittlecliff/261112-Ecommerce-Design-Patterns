package src.ecommerce.controller.command;

import src.ecommerce.view.MenuView;

/**
 * Comando responsável por encerrar a execução do sistema.
 *
 * DESIGN PATTERN: COMMAND
 *
 * Esta classe encapsula a ação de sair do programa
 * em um objeto independente.
 */
public class SairCommand implements Command {

    private MenuView view;
    private Runnable runnable;

    public SairCommand(MenuView view, Runnable acaoEncerramento) {
        this.view = view;
        this.runnable = acaoEncerramento;
    }

    /**
     * Exibe a mensagem de encerramento e executa a ação responsável por finalizar o menu criada no MenuController
     */
    @Override
    public void executar() {
        view.exibirMensagem("Obrigado por utilizar o E-Commerce CLI! Saindo..."        );
        runnable.run();
    }
}