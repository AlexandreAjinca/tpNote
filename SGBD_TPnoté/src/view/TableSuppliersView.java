package view;

import javax.swing.table.AbstractTableModel;

import model.BDD;
import model.Fournisseurs;

public class TableSuppliersView extends AbstractTableModel{
	private final Object[][] suppliers;
	private final String[] headers = {"ID", "Nom", "Prénom", "Adresse", "Ville"};
	
	public TableSuppliersView() {
		super();
		Fournisseurs frn = BDD.getFrnsseur();
		int i;
		suppliers = new Object[frn.getIdFournisseurs().size()][5];
		for(i=0; i< frn.getIdFournisseurs().size(); i++)
		{
			suppliers[i][0] = frn.getIdFournisseurs().get(i);
			suppliers[i][1] = frn.getNomFournisseurs().get(i);
			suppliers[i][2] = frn.getPrenomFournisseurs().get(i);
			suppliers[i][3] = frn.getAdresseFournisseurs().get(i);
			suppliers[i][4] = frn.getVilleFournisseurs().get(i);
		}
	}
	
	public int getRowCount()
	{
		return suppliers.length;
	}
	
	public int getColumnCount()
	{
		return headers.length;
	}
	
	public String getColumnName(int columnIndex)
	{
		return headers[columnIndex];
	}
	
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		return suppliers[rowIndex][columnIndex];
	}
}
