package src.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.ecommerce.model.Cliente;
import src.ecommerce.model.Carrinho;
import src.ecommerce.model.vo.ItemCarrinho;

/**
 * Representa uma compra finalizada ou em andamento.
 *
 * O pedido possui uma cópia dos itens do carrinho,
 * preservando os preços registrados no momento da compra.
 */
public class Pedido {

    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens;

    private LocalDateTime dataCriacao;
    private StatusPedido status;

    private double subtotal;
    private double desconto;
    private double total;

    public Pedido(int id, Cliente cliente, Carrinho carrinho) {

        if (cliente == null || carrinho == null || carrinho.estaVazio()) {
            throw new IllegalArgumentException(
                "Não é possível criar um pedido inválido."
            );
        }

        this.id = id;
        this.cliente = cliente;
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;

        this.itens = new ArrayList<>();

        // Copia os itens e os preços do carrinho.
        for (ItemCarrinho item : carrinho) {
            itens.add(
                new ItemPedido(
                    item.getProduto(),
                    item.getQuantidade()
                )
            );
        }

        this.subtotal = calcularSubtotal();
        this.desconto = 0;
        this.total = subtotal;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getTotal() {
        return total;
    }

    private double calcularSubtotal() {

        double valor = 0;

        for (ItemPedido item : itens) {
            valor += item.calcularSubtotal();
        }

        return valor;
    }

    /**
     * Aplica um desconto ao pedido.
     *
     * O desconto não pode ser negativo nem ultrapassar
     * o valor total da compra.
     */
    public void aplicarDesconto(double valorDesconto) {

        if (valorDesconto < 0 || valorDesconto > subtotal) {
            throw new IllegalArgumentException(
                "Valor de desconto inválido."
            );
        }

        this.desconto = valorDesconto;
        this.total = subtotal - desconto;
    }

    public void alterarStatus(StatusPedido novoStatus) {
        if (novoStatus == null) {
            throw new IllegalArgumentException(
                "Status inválido."
            );
        }

        this.status = novoStatus;
    }
}
