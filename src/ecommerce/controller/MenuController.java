package src.ecommerce.controller;

import java.util.HashMap;
import java.util.Map;

import src.ecommerce.controller.command.Command;
import src.ecommerce.controller.command.ListarProdutosCommand;
import src.ecommerce.controller.command.SairCommand;
import src.ecommerce.controller.command.VisualizarCarrinhoCommand;
import src.ecommerce.view.MenuView;

/**
 * Controller responsável por controlar o menu principal.
 *
 * DESIGN PATTERN: COMMAND
 *
 * Esta classe desempenha o papel de Invoker.
 *
 * O Invoker é responsável por armazenar e solicitar
 * a execução dos comandos, mas não precisa conhecer
 * os detalhes de suas implementações.
 *
 * O Controller recebe uma opção do usuário, encontra
 * o comando correspondente no Map e solicita sua execução.
 * 
 * @author Norman
 */
public class MenuController {

    private MenuView view;

    // Indica se o menu principal continua em execução.
    private boolean running;

    //Armazena os comandos disponíveis no menu.
    private Map<String, Command> commands;

    public MenuController(MenuView view) {
        this.view = view;
        this.running = true;

        inicializarComandos();
    }

    /** COMMADN
     * Registra todos os comandos disponíveis no menu.
     *
     * Ao adicionar uma nova funcionalidade, basta criar
     * um novo Concrete Command e registrá-lo neste método.
     */
    private void inicializarComandos() {
    	commands = new HashMap<>();
    	commands.put("1", new ListarProdutosCommand(view));
    	commands.put("2", new VisualizarCarrinhoCommand(view));
    	commands.put("0", new SairCommand(view, this::encerrar));
    }

    /**
     * Inicia o ciclo de execução do menu.
     */
    public void iniciar() {

        while (running) {
            view.exibirMenu();  // Shows user the menu
            String opcao = view.lerOpcao();  // Waits for user to enter it's choice.

            // Procura o comando associado à opção digitada.
            Command command = commands.get(opcao);

            if (command != null) {command.executar();} 
            else {view.exibirMensagemErro("Opção inválida. Tente novamente.");}
        }
    }

    /**
     * Altera o estado do Controller para encerrar o menu.
     */
    private void encerrar() {
        running = false;
    }
}