package model;

import java.util.ArrayList;

public class Fournisseurs {
	private ArrayList<Integer> idFournisseurs = new ArrayList<Integer>();
	private ArrayList<String> nomFournisseurs = new ArrayList<String>();
	private ArrayList<String> prenomFournisseurs = new ArrayList<String>();
	private ArrayList<String> adresseFournisseurs = new ArrayList<String>();
	private ArrayList<String> villeFournisseurs = new ArrayList<String>();
	
	public ArrayList<Integer> getIdFournisseurs() {
		return idFournisseurs;
	}
	
	public ArrayList<String> getNomFournisseurs() {
		return nomFournisseurs;
	}
	
	public ArrayList<String> getPrenomFournisseurs() {
		return prenomFournisseurs;
	}

	public ArrayList<String> getAdresseFournisseurs() {
		return adresseFournisseurs;
	}

	public ArrayList<String> getVilleFournisseurs() {
		return villeFournisseurs;
	}

}
