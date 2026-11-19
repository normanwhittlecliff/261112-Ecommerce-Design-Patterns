package src.ecommerce.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Representa um cliente cadastrado na loja.
 * A classe mantém os dados básicos do cliente.
 */
public class Cliente {

    private int id;
    private String nome;
    private String email;

    // Lazy Loading: o histórico não é carregado imediatamente.
    private List<Pedido> pedidos;

    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;

        this.pedidos = null;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Retorna o histórico de pedidos.
     *
     * O carregamento acontece apenas na primeira chamada.
     * Nas chamadas seguintes, a lista já estará disponível.
     */
    public List<Pedido> getPedidos() {

        if (pedidos == null) {
            pedidos = new ArrayList<>();

            // A integração com PedidoDAO será feita
            // pelo serviço responsável pelo histórico.
        }

        return pedidos;
    }

    public void definirPedidos(List<Pedido> pedidos) {
        this.pedidos = new ArrayList<>(pedidos);
    }

    @Override
    public String toString() {
        return "Cliente: " + nome +
               " | E-mail: " + email;
    }
}
