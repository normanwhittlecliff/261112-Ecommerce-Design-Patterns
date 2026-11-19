package src.ecommerce.model.strategy;

/**
 * Estratégia de desconto por valor fixo
 * Exemplo: R$20,00 de desconto
 */
public class DescontoFixo implements EstrategiaDesconto {

    private final double valor;

    public DescontoFixo(double valor) {

        if (valor < 0) {
            throw new IllegalArgumentException(
                "O desconto não pode ser negativo."
            );
        }

        this.valor = valor;
    }

    @Override
    public double calcularDesconto(double subtotal) {
        return Math.min(valor, subtotal);
    }
}
