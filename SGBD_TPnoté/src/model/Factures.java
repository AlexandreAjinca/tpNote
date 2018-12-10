package model;

import java.util.ArrayList;

public class Factures {
	private ArrayList<Integer> idCommandeFacture = new ArrayList<Integer>();
	private ArrayList<String> nomClientFacture = new ArrayList<String>();
	private ArrayList<String> prenomClientFacture = new ArrayList<String>();
	private ArrayList<String> adresseClientFacture = new ArrayList<String>();
	private ArrayList<String> villeClientFacture = new ArrayList<String>();
	private ArrayList<Float> montantFacture = new ArrayList<Float>();
	
	public ArrayList<Integer> getIdCommandeFacture() {
		return idCommandeFacture;
	}
	public ArrayList<String> getNomClientFacture() {
		return nomClientFacture;
	}
	public ArrayList<String> getPrenomClientFacture() {
		return prenomClientFacture;
	}
	public ArrayList<String> getAdresseClientFacture() {
		return adresseClientFacture;
	}
	public ArrayList<String> getVilleClientFacture() {
		return villeClientFacture;
	}
	public ArrayList<Float> getMontantFacture() {
		return montantFacture;
	}
	
}
