package view;

import java.awt.*;

import javax.swing.*;

import model.BDD;
import model.Commandes;
import model.Produits;

public class CommandView extends JFrame{
	private JComboBox fleur;
	private JTextField quantité;
	private JButton add;
	private JTable produits;
	private JComboBox client;
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
        Produits prods = BDD.getPrduits();
        fleur = new JComboBox<String>();
        for(int i= 0;i<prods.getNomProduits().size();i++) {
        	fleur.addItem(prods.getNomProduits().get(i));
        }
        this.add(fleur);
        
        this.setVisible(true);
	}
}
