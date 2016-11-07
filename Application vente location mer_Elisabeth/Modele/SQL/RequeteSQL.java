package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JTable;

import article.Item;




public class RequeteSQL {

	
	ArrayList<String>imageArticle=new ArrayList<String>();
	ArrayList<String>infoArticle=new ArrayList<String>();
	
	ArrayList donnees=new ArrayList<>();
	String resultRequete="";
	ArrayList<Item>info = new ArrayList<>();
	
	Connection conn = null;
	Statement statement = null;
	
	
	public ArrayList<String> getImage()
	{
		
		ResultSet resultSet = null;
		
		try
		{
			conn = Connect.getConnection();

			
			statement = conn.createStatement();
			
			resultSet = statement.executeQuery("SELECT art_photo from article");
						
			while (resultSet.next())
			{
				imageArticle.add(resultSet.getString("art_photo"));
			}
			
			Iterator it = imageArticle.iterator();
					
					while(it.hasNext())
					{
						System.out.println(it.next());
					}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				conn.close();
			}
			catch (SQLException e)
			{
				// do nothing
				e.printStackTrace();
			}
			
		}
		return imageArticle;
	}
	
	public String getImagePanier(String nom)
	{
		
	
		PreparedStatement prepare=null;
		ResultSet a=null;
		
		
		try
		{
		

			String query="SELECT art_photo from article where art_nom = ? ";
			
			
			prepare= Connect.getConnection().prepareStatement(query);
			prepare.setString(1, nom);
			
			a =prepare.executeQuery();
			
			while(a.next())
			{
				resultRequete=a.getString("art_photo");
			}
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return resultRequete;
		}
		
		
	
	public  ArrayList<Item> readData()
	{
		
		ResultSet resultSet = null;
		
		try
		{
			conn = Connect.getConnection();
	
			statement = conn.createStatement();
			
			
			
			
			resultSet = statement.executeQuery("SELECT * from article");
						
			while (resultSet.next())
			{

				Item it = new Item(resultSet.getInt("art_code"),resultSet.getString("art_nom"),resultSet.getString("art_description"), resultSet.getDouble("art_prix_unitaire"),resultSet.getInt("art_stock"),resultSet.getInt("art_duree"),resultSet.getString("art_photo"));
				info.add(it);		
						
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				conn.close();
			}
			catch (SQLException e)
			{
				// do nothing
				e.printStackTrace();
			}
			
		}
		return info;
	}
	
	public void modifStock(String nom,Integer nvStock)
	{
		PreparedStatement prepare=null;
		int resultSet = 0;
		
		try
		{
			
			String query = ("UPDATE article set art_stock =? where art_nom= ?");
			
			prepare= Connect.getConnection().prepareStatement(query);
			prepare.setInt(1, nvStock);
			prepare.setString(2,nom);
			
			
			resultSet =prepare.executeUpdate();
						
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				
			
				conn.close();
			}
			catch (SQLException e)
			{
				// do nothing
				e.printStackTrace();
			}
			
		}
		
	}
	public void creationCommande(String d, String b,int cliId)
	{
		PreparedStatement prepare=null;
		int resultSet = 0;
		
		try
		{
			
			String query = ("INSERT INTO commande (com_date,com_statut,com_cli_id) VALUE (?,?,?)");
			
			prepare= Connect.getConnection().prepareStatement(query);
			prepare.setString(1, d );
			prepare.setString(2,b);
			prepare.setInt(3,cliId);
			
			resultSet =prepare.executeUpdate();
						
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				
			
				conn.close();
			}
			catch (SQLException e)
			{
				// do nothing
				e.printStackTrace();
			}
			
		}
		
	}
	
}

	

