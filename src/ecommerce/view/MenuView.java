package src.ecommerce.view;

import java.util.Scanner;

public class MenuView {

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("\n================================");
        System.out.println("       E-COMMERCE CLI");
        System.out.println("================================");
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
}
