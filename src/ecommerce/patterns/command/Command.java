package src.ecommerce.patterns.command;

/**
 * DESIGN PATTERN: 
 * - COMMAND: O Command Pattern transforma uma solicitação em um objeto.
 */

/**
 * Interface que representa o contrato de execução de todos os comandos disponíveis no sistema.
 * Todas as classes de comando deverão implementar executar().
 */
public interface Command {

    /**
     * Executa a operação representada pelo comando.
     */
    public void executar();
}
