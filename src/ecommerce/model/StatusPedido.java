package src.ecommerce.model;

/**
 * Estados possíveis de um pedido
 */
public enum StatusPedido {

    AGUARDANDO_PAGAMENTO,
    PAGO,
    EM_PROCESSAMENTO,
    ENVIADO,
    ENTREGUE,
    CANCELADO,
    ROUBADO
}
