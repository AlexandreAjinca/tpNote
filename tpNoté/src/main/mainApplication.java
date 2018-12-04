package main;

import controller.BDDController;
import model.BDD;
import view.ViewApplication;

public class mainApplication {

	public static void main(String[] args) {
		BDD model = new BDD();
		ViewApplication view = new ViewApplication();
		BDDController controller  = new BDDController(model,view);
	}
}
