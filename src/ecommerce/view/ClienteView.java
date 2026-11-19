package src.ecommerce.view;

import src.ecommerce.model.Cliente;

/**
 * View responsável pela apresentação dos clientes.
 */
public class ClienteView {

    public void exibirCliente(Cliente cliente) {

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("\n========== CLIENTE ==========");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("E-mail: " + cliente.getEmail());
        System.out.println("=============================");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}

