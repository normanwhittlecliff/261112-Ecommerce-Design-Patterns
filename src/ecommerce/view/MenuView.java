package src.ecommerce.view;

import java.util.Scanner;

/**
 * 
 * 
 * @author Norman
 */
public class MenuView {

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
    	exibirTítulo("E-COMMERCE CLI");
        System.out.println("1. Listar produtos");
        System.out.println("2. Visualizar carrinho");
        System.out.println("0. Sair");
        System.out.println("================================");
        System.out.print("Escolha uma opção: ");
    }

    public String lerOpcao() {
        return scanner.nextLine();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println("\nSystem: " + mensagem);
    }

    public void exibirMensagemErro(String mensagem) {
        System.out.println("\nSystem: [ERROR] " + mensagem);
    }
    
    public void exibirLinha() {
    	System.out.println("================================");
    }
    
    public void exibirTítulo(String title) {
    	exibirLinha();
    	System.out.println("       " + title);
    	exibirLinha();
    }
}
