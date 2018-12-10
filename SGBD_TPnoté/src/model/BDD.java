package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class BDD {
	private static Connection conn;
	private static Statement stmt;
	
	private static Fournisseurs frnsseur;
	private static Produits prduits;
	private static Fournitures frnitures;
	private static Clients clts;
	private static ContenuFournitures ctnFrnitures;
	private static Commandes cmds;
	private static ContenuCommandes ctnCmds;
	private static Factures fctrs;
	
	public BDD()
	{
		frnsseur = new Fournisseurs();
		prduits = new Produits();
		frnitures = new Fournitures();
		clts = new Clients();
		ctnFrnitures = new ContenuFournitures();
		ctnCmds = new ContenuCommandes();
		cmds = new Commandes();
		fctrs = new Factures();
		initConnection();
	}
	
	/*
	 * 	BDD va load les informations de toutes les tables et les stocker dans des array list
	 *  BDD controller recevant une base de données en paramètres, il pourra recharger
	 *  les informations après avoir modifié le contenu
	 */
	
	public static void initConnection()
	{
		
		Properties userInfo = new Properties();
		userInfo.setProperty("user", "root");
		userInfo.setProperty("password", "");
		
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bddfleuriste?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowMultiQueries=true", userInfo);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		loadFournisseursInfo();
		loadFournituresInfo();
		loadContenuFournituresInfo();
		loadProduitsInfo();
		loadClientsInfo();
		loadCommandesInfo();
		loadContenuCommandesInfo();
		loadFacturesInfo();
	}
		
	public static Fournisseurs getFrnsseur() {
		return frnsseur;
	}

	public static Produits getPrduits() {
		return prduits;
	}

	public static Fournitures getFrnitures() {
		return frnitures;
	}

	public static Clients getClts() {
		return clts;
	}

	public static ContenuFournitures getCtnFrnitures() {
		return ctnFrnitures;
	}

	public static Commandes getCmds() {
		return cmds;
	}

	public static ContenuCommandes getCtnCmds() {
		return ctnCmds;
	}

	public static Factures getFctrs() {
		return fctrs;
	}
	

	public static void loadFournisseursInfo() 
	{
		frnsseur.getIdFournisseurs().clear();
		frnsseur.getNomFournisseurs().clear();
		frnsseur.getPrenomFournisseurs().clear();
		frnsseur.getAdresseFournisseurs().clear();
		frnsseur.getVilleFournisseurs().clear();
		try {
			String sql = "SELECT * FROM Fournisseur;";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				frnsseur.getIdFournisseurs().add(rs.getInt(1));
				frnsseur.getNomFournisseurs().add(rs.getString(2));
				frnsseur.getPrenomFournisseurs().add(rs.getString(3));
				frnsseur.getAdresseFournisseurs().add(rs.getString(4));
				frnsseur.getVilleFournisseurs().add(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadProduitsInfo() 
	{
		prduits.getIdProduits().clear();
		prduits.getNomProduits().clear();
		prduits.getCategorieProduits().clear();
		prduits.getEspeceProduits().clear();
		prduits.getPrixProduits().clear();
		prduits.getQuantiteProduits().clear();
		try {
			String sql = "SELECT * FROM Produit;";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				prduits.getIdProduits().add(rs.getInt(1));
				prduits.getNomProduits().add(rs.getString(2));
				prduits.getCategorieProduits().add(rs.getString(3));
				prduits.getEspeceProduits().add(rs.getString(4));
				prduits.getPrixProduits().add(rs.getFloat(5));
				prduits.getQuantiteProduits().add(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadFournituresInfo() 
	{
		frnitures.getIdFourniture().clear();
		frnitures.getIdFournisseurs().clear();
		frnitures.getMontantFourniture().clear();
		try {
			String sql = "SELECT * FROM Fourniture;";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				frnitures.getIdFourniture().add(rs.getInt(1));
				frnitures.getIdFournisseurs().add(rs.getInt(2));
				frnitures.getMontantFourniture().add(rs.getFloat(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadClientsInfo() 
	{
		clts.getIdClient().clear();
		clts.getNomClient().clear();
		clts.getPrenomClient().clear();
		clts.getAdresseClient().clear();
		clts.getVilleClient().clear();
		clts.getReductionClient().clear();
		try {
			String sql = "SELECT * FROM Client;";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				clts.getIdClient().add(rs.getInt(1));
				clts.getNomClient().add(rs.getString(2));
				clts.getPrenomClient().add(rs.getString(3));
				clts.getAdresseClient().add(rs.getString(4));
				clts.getVilleClient().add(rs.getString(5));
				clts.getReductionClient().add(rs.getFloat(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadContenuFournituresInfo() 
	{
		ctnFrnitures.getIdContenuFourniture().clear();
		ctnFrnitures.getIdProduitsFourniture().clear();
		ctnFrnitures.getQuantiteProduitsFourniture().clear();
		try {
			String sql = "SELECT * FROM ContenuFourniture;";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ctnFrnitures.getIdContenuFourniture().add(rs.getInt(1));
				ctnFrnitures.getIdProduitsFourniture().add(rs.getInt(2));
				ctnFrnitures.getQuantiteProduitsFourniture().add(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadCommandesInfo() 
	{
		cmds.getIdCommande().clear();
		cmds.getIdCommandeClient().clear();
		try {
			String sql = "SELECT * FROM Commande;";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				cmds.getIdCommande().add(rs.getInt(1));
				cmds.getIdCommandeClient().add(rs.getInt(2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadContenuCommandesInfo() 
	{
		ctnCmds.getIdContenuCommande().clear();
		ctnCmds.getIdProduitCommande().clear();
		ctnCmds.getQuantiteProduitCommande().clear();
		try {
			String sql = "SELECT * FROM ContenuCommande;";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ctnCmds.getIdContenuCommande().add(rs.getInt(1));
				ctnCmds.getIdProduitCommande().add(rs.getInt(2));
				ctnCmds.getQuantiteProduitCommande().add(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadFacturesInfo() 
	{
		fctrs.getIdCommandeFacture().clear();
		fctrs.getNomClientFacture().clear();
		fctrs.getPrenomClientFacture().clear();
		fctrs.getAdresseClientFacture().clear();
		fctrs.getVilleClientFacture().clear();
		fctrs.getMontantFacture().clear();
		try {
			String sql = "SELECT * FROM Facture;";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				fctrs.getIdCommandeFacture().add(rs.getInt(1));
				fctrs.getNomClientFacture().add(rs.getString(2));
				fctrs.getPrenomClientFacture().add(rs.getString(3));
				fctrs.getAdresseClientFacture().add(rs.getString(4));
				fctrs.getVilleClientFacture().add(rs.getString(5));
				fctrs.getMontantFacture().add(rs.getFloat(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 *  Je vois cette fonction comme ça:
	 *  L'utilisateur peut avoir une fenetre dans laquelle il sélectionne un client, 
	 *  des produits et leurs quantites et genere la commande
	 *  cela introduit dans la base de données des nouvelles entrées pour 
	 *  Commandes, ContenuCommande et Facture
	 *  
	 *  En pratique lorsque l'utilisateur valide sa commande, le buttonlistener 
	 *  va récupérer et formatter les informations pour convenir à cette fonction
	 *  Les ArrayList doivent avoir des index correspondants 
	 *  (nomProduits[1] <=> quantiteProduits[1])
	 */
	public void addCommandtoBDD(int idClient, ArrayList<String> nomProduits, ArrayList<Integer> quantiteProduits)
	{
		try {
			double total = 0;
			int idCommande;
			int idProduit;
			ResultSet rs;
			String sql = "SELECT MAX(id) FROM Commande;";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			idCommande = rs.getInt(1)+1;
			
			sql = "INSERT INTO Commande VALUES (" + idCommande + ", " + idClient + ");";
			stmt.executeUpdate(sql);
			for(int i=0; i<nomProduits.size(); i++)
			{
				sql = "UPDATE Produit SET quantite = quantite - " + quantiteProduits.get(i) + " WHERE nom = '" + nomProduits.get(i) + "';";
				stmt.executeUpdate(sql);
				sql = "SELECT id FROM Produit WHERE nom = '" + nomProduits.get(i) + "';";
				rs = stmt.executeQuery(sql);
				rs.next();
				idProduit = rs.getInt(1);
				sql = "INSERT INTO ContenuCommande VALUES (" + idCommande + ", " + idProduit + ", " + quantiteProduits.get(i) +");";
				stmt.executeUpdate(sql);
				sql = "SELECT prix_unitaire FROM Produit WHERE nom = '" + nomProduits.get(i) + "';";
				rs = stmt.executeQuery(sql);
				rs.next();
				total = total + ((rs.getFloat(1)*quantiteProduits.get(i)*1.15));
			}
			sql = "SELECT * FROM Client WHERE id = " + idClient + ";";
			rs = stmt.executeQuery(sql);
			rs.next();
			String nomClient = rs.getString(2);
			String prenomClient = rs.getString(3);
			String adresseClient = rs.getString(4);
			String villeClient = rs.getString(5);
			float reductionClient = rs.getFloat(6);
			float montant = (float)(total - (total * (reductionClient/100)));
			sql = "INSERT INTO Facture VALUES (" + idCommande + ", '" + nomClient + "', '" + prenomClient + "', '" + adresseClient + "', '" + villeClient + "', " + montant +");"; 
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
