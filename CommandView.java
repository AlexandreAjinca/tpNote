package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	
	private BDD bd;
	private int idCommand;
	private ArrayList<String> nomProduits;
	private ArrayList<Integer> quantités;
	private int idClient;
	
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
        
        bd = new BDD();
                
        nomProduits = new ArrayList<String>();
        quantités = new ArrayList<Integer>();
        
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        fleur = new JComboBox<String>();
        Produits prods = BDD.getPrduits();
        for(int i= 0;i<prods.getNomProduits().size();i++) {
        	fleur.addItem(prods.getNomProduits().get(i));
        }
        this.add(fleur,gbc);
        
        gbc.gridx = 2;
        gbc.gridy=0;
        gbc.gridwidth=1;
        nombre = new JTextField();
        this.add(nombre,gbc);
        
        gbc.gridx=3;
        gbc.gridy=0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add = new JButton("ajouter");
        
        class AjouterProduitListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==add) {
					nomProduits.add((String) fleur.getSelectedItem());
					quantités.add(Integer.parseInt(nombre.getText()));
					produits.setText(produits.getText() + "\n " + fleur.getSelectedItem() + " " + Integer.parseInt(nombre.getText()));
				}
			}
        }
        
        add.addActionListener(new AjouterProduitListener());
        this.add(add,gbc);
        
        gbc.gridx = 0;
        gbc.gridy=1;
        gbc.gridheight=fleur.getHeight();
        produits = new JTextField();
        this.add(produits,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        client = new JComboBox<String>();
        Clients clts = BDD.getClts();
        for(int i = 0; i< clts.getNomClient().size();i++) {
        	client.addItem(clts.getNomClient().get(i));
        }
        this.add(client,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        commander = new JButton("Commander!");
        
        class CreerCommandeListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==commander) {
					idClient = client.getSelectedIndex();
					Clients cl = new Clients();
					bd.addCommandtoBDD(cl.getIdClient().get(idClient), nomProduits, quantités);
				}
			}
        }
        commander.addActionListener(new CreerCommandeListener());
   
        this.add(commander,gbc);
        
        Commandes cmd = BDD.getCmds();
        idCommand = cmd.getIdCommande().size()+1;
        
        
        
        this.setVisible(true);
	}
}
