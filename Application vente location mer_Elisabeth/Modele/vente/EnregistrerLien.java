package vente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import SQL.Connect;
import article.DefinirPAdresse;


public class EnregistrerLien {
	
//	Integer d;
	
//	Integer e = EnregistrerAdresse.IDAdresse;
	
	
	public EnregistrerLien() throws Exception{

		
		try {
			create();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void create() throws Exception {
		
		// Formulation de la requ�te de l'adresse � cr�er
	
		String query="SET foreign_key_checks=0";
		ResultSet resulset= (ResultSet) Connect.getConnection().createStatement().executeQuery(query);
		
		//preparedStatement.executeQuery();
		
		 query = "INSERT INTO lien_adresse(cli_id,adr_id)VALUES (?,?)";
		PreparedStatement preparedStatement = (PreparedStatement) Connect.getConnection().prepareStatement(query);
		
		Integer d = null;
		if (EnregistrerClient.IDClient!= null){
			d = EnregistrerClient.IDClient;
		}
		else if (EnregistrerClient.IDClient== null){
			d = DefinirPAdresse.getIdDejaClient();
		}
		
		preparedStatement.setLong(1, d);
		preparedStatement.setLong(2, EnregistrerAdresse.IDAdresse);
		
	
		// Cr�ation de l'adresse
		preparedStatement.execute();
		
	
	}

}
