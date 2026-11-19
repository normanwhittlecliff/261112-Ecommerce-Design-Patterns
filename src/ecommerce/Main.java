package src.ecommerce;

import src.ecommerce.controller.MenuController;
import src.ecommerce.view.MenuView;

public class Main {
 	public static void main(String[] args) {
		MenuView view = new MenuView();

        MenuController controller = new MenuController(view);

        controller.iniciar();
	}
}
