package src.ecommerce.model.interator;


/**
 * DESIGN PATTERN: ITERATOR
 *
 * Esta interface representa o Aggregate (Agregado) do padrão Iterator.
 *
 * Em vez de permitir que outras classes acessem diretamente sua coleção interna, 
 * o agregado fornece um objeto responsável pela iteração.
 *
 * @param <T> tipo de elemento armazenado.
 */
public interface Aggregate<T> {

    /**
     * Cria e retorna um Iterator para percorrer a coleção.
     */
    Iterator<T> criarIterator();
}
