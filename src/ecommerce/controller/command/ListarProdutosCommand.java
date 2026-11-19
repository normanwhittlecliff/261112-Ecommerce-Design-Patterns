package src.ecommerce.controller.command;

import src.ecommerce.model.dao.ProdutoDAOImpl;
import src.ecommerce.model.interator.Iterator;
import src.ecommerce.model.vo.ProdutoVO;
import src.ecommerce.view.MenuView;

/**
 * Uma Concrete Command que implementa a interface Command e define o que acontece quando executar() é chamado.
 */
public class ListarProdutosCommand implements Command{

	private MenuView view;
	
	

    public ListarProdutosCommand(MenuView view) {
        this.view = view;
    }

    /**
     * Executa a operação de listar produtos.
     */
    @Override
    public void executar() {
    	view.exibirTítulo("Lista de Produtos");
    	
    	Iterator<ProdutoVO> iterator = new ProdutoDAOImpl().criarIterator();
    	
    	if (!iterator.hasNext()) {
            System.out.println("Nenhum produto encontrado.");
            return;
        }
    	
    	while (iterator.hasNext()) {
    		System.out.println(iterator.next());
    	}
    	
//        for (ProdutoVO produto : new ProdutoDAOImpl().buscarTodos()) {
//            System.out.println(produto);
//        }
        
        
    }

}
