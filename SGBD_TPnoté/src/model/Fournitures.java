package model;

import java.util.ArrayList;

public class Fournitures {
	private ArrayList<Integer> idFourniture = new ArrayList<Integer>();
	private ArrayList<Integer> idFournisseur = new ArrayList<Integer>();
	private ArrayList<Float> montantFourniture = new ArrayList<Float>();
	
	public ArrayList<Integer> getIdFourniture() {
		return idFourniture;
	}
	public ArrayList<Integer> getIdFournisseurs() {
		return idFournisseur;
	}
	public ArrayList<Float> getMontantFourniture() {
		return montantFourniture;
	}

}
