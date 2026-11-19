package src.ecommerce.patterns.command;

import src.ecommerce.view.MenuView;

/**
 * Uma Concrete Command que implementa a interface Command e define o que acontece quando executar() é chamado.
 */
public class ListarProdutosCommand implements Command{

	private MenuView view;

    /**
     * Permite que o comando apresente mensagens ao usuário
     * sem precisar utilizar System.out diretamente.
     */
    public ListarProdutosCommand(MenuView view) {
        this.view = view;
    }

    /**
     * Executa a operação de listar produtos.
     *
     * Por enquanto, a funcionalidade é apenas ilustrativa.
     * Posteriormente, poderemos conectar este comando ao Controller
     * de produtos ou a um serviço de catálogo.
     */
    @Override
    public void executar() {
        view.exibirMensagem(
            "A funcionalidade de produtos será implementada em breve!"
        );
    }

}
