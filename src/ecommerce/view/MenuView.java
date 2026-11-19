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
    	System.out.println("1 - Listar Produtos");
    	System.out.println("2 - Visualizar detalhes de um livro");
        System.out.println("3 - Adicionar produto ao carrinho");
        System.out.println("4 - Visualizar carrinho");
        System.out.println("5 - Remover produto do carrinho");
        System.out.println("6 - Aplicar desconto / cupom");
        System.out.println("7 - Finalizar compra");
        System.out.println("\n0 - Sair");
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
