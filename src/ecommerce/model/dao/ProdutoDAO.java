package src.ecommerce.model.dao;

import java.util.List;

import src.ecommerce.model.interator.Aggregate;
import src.ecommerce.model.vo.ProdutoVO;

//Padrão DAO: (Data Access Object) - Interface
//define quais operações o banco de dados deve saber fazer
//Esconde a complexidade de como os dados são salvos
//só as "assinaturas" dos métodos. 

public interface ProdutoDAO extends Aggregate<ProdutoVO> {
    
	// busca todos os produtos cadastrados.
    List<ProdutoVO> buscarTodos();
	
    //salva um produto no banco 
    void salvar(ProdutoVO produto);
    
    
    //busca um único produto pelo seu ID
    ProdutoVO buscarPorId(int id);
}