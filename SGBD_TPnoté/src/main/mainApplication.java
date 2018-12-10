package main;

import java.util.ArrayList;

import controller.BDDController;
import model.BDD;
import view.TableView;
import view.ViewApplication;

public class mainApplication {

	public static void main(String[] args) {
		BDD model = new BDD();
		ViewApplication view = new ViewApplication();
		BDDController controller  = new BDDController(model,view);
		
		TableView tb = new TableView(1);
		TableView tb2 = new TableView(2);
		
		/*
		//Test Fonctionne
		ArrayList<Integer> quantiteProduits = new ArrayList<Integer>();
		quantiteProduits.add(2);
		quantiteProduits.add(4);
		ArrayList<String> nomProduits = new ArrayList<String>();
		nomProduits.add("rose");
		nomProduits.add("tulipe");
		model.addCommandtoBDD(1, nomProduits, quantiteProduits);
		
		
		BDD.loadProduitsInfo();
		TableView tb3 = new TableView(3);
		*/
	}
}
