package view;

import javax.swing.table.AbstractTableModel;

import model.BDD;
import model.Produits;

public class TableProductsView extends AbstractTableModel{
	private final Object[][] products;
	private final String[] headers = {"ID", "Nom", "Catégorie", "Espèce", "Prix Unitaire", "Quantité"};
	
	public TableProductsView() {
		super();
		Produits prduits = BDD.getPrduits();
		int i;
		products = new Object[prduits.getIdProduits().size()][6];
		for(i=0; i< prduits.getIdProduits().size(); i++)
		{
			products[i][0] = prduits.getIdProduits().get(i);
			products[i][1] = prduits.getNomProduits().get(i);
			products[i][2] = prduits.getCategorieProduits().get(i);
			products[i][3] = prduits.getEspeceProduits().get(i);
			products[i][4] = prduits.getPrixProduits().get(i);
			products[i][5] = prduits.getQuantiteProduits().get(i);
		}
	}
	
	public int getRowCount()
	{
		return products.length;
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
		return products[rowIndex][columnIndex];
	}
}
