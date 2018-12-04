package model;

import java.sql.*;
import java.util.Properties;

public class BDD {
	private static Connection conn;
	private static Statement stmt;
	
	public static void initConnection()
	{
		
		Properties userInfo = new Properties();
		userInfo.setProperty("user", "root");
		userInfo.setProperty("password", "");
		
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bddmusic?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowMultiQueries=true", userInfo);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void exercice1() 
	{
		
		try {
			String sql = "SELECT Titre FROM Album A JOIN Chanteur C ON A.chanteur = C.nom JOIN Producteur P ON A.producteur = p.nom WHERE p.pays = 'France' AND c.pays = 'France';";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println("'" + rs.getString(1) + "'");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
