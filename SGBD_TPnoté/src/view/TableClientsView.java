package view;

import javax.swing.table.AbstractTableModel;

import model.BDD;
import model.Clients;

public class TableClientsView extends AbstractTableModel{
	private final Object[][] clients;
	private final String[] headers = {"ID", "Nom", "Prénom", "Adresse", "Ville", "Réduction"};
	
	public TableClientsView() {
		super();
		Clients clts = BDD.getClts();
		int i;
		clients = new Object[clts.getIdClient().size()][6];
		for(i=0; i< clts.getIdClient().size(); i++)
		{
			clients[i][0] = clts.getIdClient().get(i);
			clients[i][1] = clts.getNomClient().get(i);
			clients[i][2] = clts.getPrenomClient().get(i);
			clients[i][3] = clts.getAdresseClient().get(i);
			clients[i][4] = clts.getVilleClient().get(i);
			clients[i][5] = clts.getReductionClient().get(i);
		}
	}
	
	public int getRowCount()
	{
		return clients.length;
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
		return clients[rowIndex][columnIndex];
	}
}
