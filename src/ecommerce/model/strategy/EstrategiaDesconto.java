package src.ecommerce.model.strategy;

/**
 * Strategy Pattern:
 * define um contrato para diferentes algoritmos de desconto, 
 * já que vários descontos podem existir. Cupom, Black Month, etc...
 */
public interface EstrategiaDesconto {

    double calcularDesconto(double subtotal);
}
