package src.ecommerce.model.strategy;

/**
 * Estratégia de desconto percentual.
 * Exemplo: 10% de desconto pq sim.
 */
public class DescontoPercentual implements EstrategiaDesconto {

    private final double percentual;

    public DescontoPercentual(double percentual) {

        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException(
                "Percentual inválido."
            );
        }

        this.percentual = percentual;
    }

    @Override
    public double calcularDesconto(double subtotal) {
        return subtotal * percentual / 100;
    }
}

