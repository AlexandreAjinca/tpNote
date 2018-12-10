package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

import model.BDD;

public class ViewApplication extends JFrame{
	JLabel companyName;
	
	JButton commandButton;
	JButton suppliersButton;
	JButton clientsButton;
	
	public ViewApplication() {
		companyName = new JLabel("Fleurs");
		
		commandButton = new JButton("Nouvelle commande");
		suppliersButton = new JButton("Liste des fournisseurs");
		clientsButton = new JButton("Liste des clients");
				
		JPanel pan = new JPanel();
		this.setSize(500, 500);
        this.setTitle("My shop application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan);
        this.setLayout(new FlowLayout());
        
        this.getContentPane().add(companyName);

        this.getContentPane().add(commandButton);
        this.getContentPane().add(suppliersButton);
        this.getContentPane().add(clientsButton);
        
        JTable tableau = new JTable(new TableProductsView());
        
        getContentPane().add(new JScrollPane(tableau));
        
        this.setVisible(true);
	}
}
