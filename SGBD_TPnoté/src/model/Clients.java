package model;

import java.util.ArrayList;

public class Clients {
	private ArrayList<Integer> idClient = new ArrayList<Integer>();
	private ArrayList<String> nomClient = new ArrayList<String>();
	private ArrayList<String> prenomClient = new ArrayList<String>();
	private ArrayList<String> adresseClient = new ArrayList<String>();
	private ArrayList<String> villeClient = new ArrayList<String>();
	private ArrayList<Float> reductionClient = new ArrayList<Float>();
	
	public ArrayList<Integer> getIdClient() {
		return idClient;
	}
	public ArrayList<String> getNomClient() {
		return nomClient;
	}
	public ArrayList<String> getPrenomClient() {
		return prenomClient;
	}
	public ArrayList<String> getAdresseClient() {
		return adresseClient;
	}
	public ArrayList<String> getVilleClient() {
		return villeClient;
	}
	public ArrayList<Float> getReductionClient() {
		return reductionClient;
	}
	
}
