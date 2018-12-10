package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableView extends JFrame{
	
	public TableView(int id)
	{
		super();
		JTable tableau;
		if(id == 1)
		{
			setTitle("Suppliers Table");
			tableau = new JTable(new TableSuppliersView());
		}
		else
		{
			setTitle("Clients Table");
			tableau = new JTable(new TableClientsView());
		}
		if(id == 3)
		{
			setTitle("Products Table");
			tableau = new JTable(new TableProductsView());
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		this.setVisible(true);
		pack();
	}
}
