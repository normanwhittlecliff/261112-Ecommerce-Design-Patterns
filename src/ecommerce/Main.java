package src.ecommerce;

import src.ecommerce.controller.CarrinhoController;
import src.ecommerce.controller.ClienteController;
import src.ecommerce.controller.MenuController;
import src.ecommerce.controller.PedidoController;
import src.ecommerce.model.Carrinho;
import src.ecommerce.model.Cliente;
import src.ecommerce.model.LazyLoading.ClienteService;
import src.ecommerce.model.Responsability.ValidadorCarrinho;
import src.ecommerce.model.Responsability.ValidadorCliente;
import src.ecommerce.model.Responsability.ValidadorPedido;
import src.ecommerce.model.dao.ClienteDAO;
import src.ecommerce.model.dao.ClienteDAOImpl;
import src.ecommerce.model.dao.PedidoDAO;
import src.ecommerce.model.dao.PedidoDAOImpl;
import src.ecommerce.model.facade.CheckoutFacade;
import src.ecommerce.model.service.CarrinhoService;
import src.ecommerce.model.service.PedidoService;
import src.ecommerce.view.MenuView;

public class Main {
	
	/** MAIN
	 * 
	 * 
	 */
 	public static void main(String[] args) {
 		
 		// DAOs
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        PedidoDAO pedidoDAO = new PedidoDAOImpl();
        
        // Services
        Carrinho carrinho = new Carrinho();

        CarrinhoService carrinhoService =
            new CarrinhoService(carrinho);

        ClienteService clienteService =
            new ClienteService(clienteDAO, pedidoDAO);

        PedidoService pedidoService =
            new PedidoService(pedidoDAO);

        // Cadeia de validação
        ValidadorPedido validadores = new ValidadorCliente();
        validadores.definirProximo(new ValidadorCarrinho());

        // Facade
        CheckoutFacade checkoutFacade =
            new CheckoutFacade(pedidoDAO, validadores);

        // Controllers
        CarrinhoController carrinhoController =
            new CarrinhoController(carrinhoService);

        ClienteController clienteController =
            new ClienteController(clienteService);

        PedidoController pedidoController =
            new PedidoController(pedidoService);

        // Exemplo de cliente inicial
        Cliente cliente = new Cliente(
            1,
            "Cliente Exemplo",
            "cliente@email.com"
        );

        clienteController.cadastrarCliente(cliente);

        System.out.println("Sistema inicializado!");
 		
		MenuView view = new MenuView();
        MenuController controller = new MenuController(view);
        controller.iniciar();
	}
 	
 	
}
