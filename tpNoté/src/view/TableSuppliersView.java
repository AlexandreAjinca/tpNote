package view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class TableSuppliersView extends JFrame{
	public JTextField informations;
	
	public TableSuppliersView() {
		JPanel pan = new JPanel();
		this.setSize(500, 500);
        this.setTitle("My shop application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan);
        this.setLayout(new FlowLayout());

        this.getContentPane().add(informations);
        
        this.setVisible(true);
	}
}
