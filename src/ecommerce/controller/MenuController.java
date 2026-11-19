package src.ecommerce.controller;

import src.ecommerce.view.MenuView;

public class MenuController {

    private MenuView view;
    private boolean running;

    public MenuController(MenuView view) {
        this.view = view;
        this.running = true;
    }

    public void iniciar() {

        while (running) {

            view.exibirMenu();

            String opcao = view.lerOpcao();

            switch (opcao) {

                case "1":
                    listarProdutos();
                    break;

                case "2":
                    visualizarCarrinho();
                    break;

                case "0":
                    encerrarSistema();
                    break;

                default:
                    view.exibirMensagemErro(
                        "Opção inválida. Tente novamente."
                    );
                    break;
            }
        }
    }

    private void listarProdutos() {
        view.exibirMensagem("A funcionalidade de produtos será implementada em breve!");
    }

    private void visualizarCarrinho() {
        view.exibirMensagem("A funcionalidade do carrinho será implementada em breve!");
    }

    private void encerrarSistema() {

        view.exibirMensagem("Obrigado por utilizar o E-Commerce CLI!");

        running = false;
    }
}
