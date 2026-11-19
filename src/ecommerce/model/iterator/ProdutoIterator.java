package src.ecommerce.model.iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import src.ecommerce.model.vo.ProdutoVO;

/**
 * DESIGN PATTERN: ITERATOR
 *
 * Esta classe representa o ConcreteIterator do padrão. Ela controla a posição 
 * atual da navegação e fornece os produtos um por vez
 */
public class ProdutoIterator implements Iterator<ProdutoVO> {

    // Lista de produtos que será percorrida.
    private final List<ProdutoVO> produtos;

    // Controla a posição do próximo elemento. Come;a em zero pq Java.
    private int posicaoAtual;

    /**
     *
     * @param Recebe a coleção que será percorrida.
     */
    public ProdutoIterator(List<ProdutoVO> produtos) {

        if (produtos == null) {
            throw new IllegalArgumentException(
                    "A lista de produtos não pode ser nula.");
        }

        // Cria uma cópia da lista recebida.
        this.produtos = new ArrayList<>(produtos);

        // Inicializa a navegação no primeiro elemento.
        this.posicaoAtual = 0;
    }

    /**
     * Verifica se ainda existe algum produto pra percorrer.
     *
     * @return true caso exista próximo
     */
    @Override
    public boolean hasNext() {
        return posicaoAtual < produtos.size();
    }

    /**
     * Retorna o próximo produto da coleção. Após retornar o produto, avança a posição atual.
     *
     * @return próximo ProdutoVO.
     * @throws NoSuchElementException caso não existam
     *         mais produtos disponíveis.
     */
    @Override
    public ProdutoVO next() {

        if (!hasNext()) {
            throw new NoSuchElementException(
                    "Não existem mais produtos no catálogo.");
        }

        // Recupera o produto da posição atual.
        ProdutoVO produto = produtos.get(posicaoAtual);

        // Avança para a próxima posição.
        posicaoAtual++;

        return produto;
    }
}
