package model;

import java.util.ArrayList;

public class Produits {
	private ArrayList<Integer> idProduits = new ArrayList<Integer>();
	private ArrayList<String> nomProduits = new ArrayList<String>();
	private ArrayList<String> categorieProduits = new ArrayList<String>();
	private ArrayList<String> especeProduits = new ArrayList<String>();
	private ArrayList<Float> prixProduits = new ArrayList<Float>();
	private ArrayList<Integer> quantiteProduits = new ArrayList<Integer>();
	

	public ArrayList<Integer> getIdProduits() {
		return idProduits;
	}
	public ArrayList<String> getNomProduits() {
		return nomProduits;
	}
	public ArrayList<String> getCategorieProduits() {
		return categorieProduits;
	}
	public ArrayList<String> getEspeceProduits() {
		return especeProduits;
	}
	public ArrayList<Float> getPrixProduits() {
		return prixProduits;
	}
	public ArrayList<Integer> getQuantiteProduits() {
		return quantiteProduits;
	}
}
