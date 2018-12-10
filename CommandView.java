package view;

import java.awt.*;

import javax.swing.*;

import model.BDD;
import model.Clients;
import model.Commandes;
import model.Produits;

public class CommandView extends JFrame{
	private JComboBox<String> fleur;
	private JTextField nombre;
	private JButton add;
	private JTextField produits;
	private JComboBox<String> client;
	private JButton commander;
	
	private Commandes command;
	
	public static void main(String[] args) {  
        CommandView a = new CommandView();  
    }  
	
	
	public CommandView() {
		this.setSize(300, 300);
		
		GridBagLayout grid = new GridBagLayout();  
        GridBagConstraints gbc = new GridBagConstraints();  
        setLayout(grid);  
        setTitle("Nouvelle commande");  
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        fleur = new JComboBox<String>();
        Produits prods = BDD.getPrduits();
        for(int i= 0;i<prods.getNomProduits().size();i++) {
        	fleur.addItem(prods.getNomProduits().get(i));
        }
        this.add(fleur);
        
        gbc.gridx = 2;
        gbc.gridy=0;
        gbc.gridwidth=1;
        nombre = new JTextField();
        this.add(nombre);
        
        gbc.gridx=3;
        gbc.gridy=0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add = new JButton("ajouter");
        
        gbc.gridx = 0;
        gbc.gridy=1;
        gbc.gridheight=fleur.getHeight();
        produits = new JTextField();
        this.add(produits);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        client = new JComboBox<String>();
        Clients clts = BDD.getClts();
        for(int i = 0; i< clts.getNomClient().size();i++) {
        	client.addItem(clts.getNomClient().get(i));
        }
        this.add(client);
        
        gbc.gridx = 2;
        gbc.gridy = 6;
        commander = new JButton("Commander!");
        this.add(commander);
        
        this.setVisible(true);
	}
}
