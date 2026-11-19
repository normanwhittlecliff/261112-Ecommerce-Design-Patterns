package src.ecommerce.model.interator;


/**
 * @author Norman
 * @param <T> Isso significa que nossa interface é genérica e futuramente poderemos 
 * 			reutilizá-la para percorrer outras coleções, como os produtos do carrinho
 */
public interface Iterator<T> {

    /**
     * Verifica se ainda existem elementos disponíveis.
     *
     * @return true se houver um próximo elemento;
     *         false caso todos já tenham sido percorridos.
     */
    boolean hasNext();

    /**
     * 
     * @return próximo elemento disponível.
     */
    T next();
}
