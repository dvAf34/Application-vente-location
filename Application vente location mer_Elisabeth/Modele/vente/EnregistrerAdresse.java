package vente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import SQL.Connect;
import article.PAdresse;
import article.FenetrePanier;

import article.FenetrePanier;

public class EnregistrerAdresse {
	
	
	
	
	private FenetrePanier f;
	public static Integer IDAdresse;
	public static boolean validAdresse;
	
		
		
		public EnregistrerAdresse(FenetrePanier f) throws Exception{
			this.f=f;
			
			if(
					((PAdresse)f.pAdresse).getNom().getText().trim().length()==0	||
					((PAdresse) f.pAdresse).getPrenom().getText().trim().length()==0	||
					((PAdresse) f.pAdresse).getAdresse().getText().trim().length()==0	||
					!((PAdresse) f.pAdresse).getCp().getText().matches("[0-9]*" )	||
					((PAdresse) f.pAdresse).getCp().getText().trim().length()==0	||
					((PAdresse) f.pAdresse).getVille().getText().trim().length()==0	||
					((PAdresse) f.pAdresse).getTelephone().getText().trim().length()==0){
				validAdresse=false;
			}
			else{
				validAdresse=true;
				try {
					create();
				} 
				catch (Exception e) {
					System.out.println("erreur");
				}
			}
			

		}
		
		public void create() throws Exception {
			// Changer les boolean et date en String
			String civilite;
			if (( (PAdresse) f.pAdresse).getCivilite1f().isSelected()){
				civilite="true";
			}
			else{
				civilite="false";
			}

			// Formulation de la requ�te de l'adresse � cr�er
			String query = "INSERT INTO adresse(adr_civilite,adr_nom,adr_prenom,adr_adresse,adr_cp,adr_ville,adr_telephone)VALUES (?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) Connect.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, civilite);
			preparedStatement.setString(2, ((PAdresse) f.pAdresse).getNom().getText());
			preparedStatement.setString(3, ((PAdresse) f.pAdresse).getPrenom().getText());
			preparedStatement.setString(4, ((PAdresse) f.pAdresse).getAdresse().getText());	
			preparedStatement.setString(5, ((PAdresse) f.pAdresse).getCp().getText());
			preparedStatement.setString(6, ((PAdresse) f.pAdresse).getVille().getText());
			preparedStatement.setString(7, ((PAdresse) f.pAdresse).getTelephone().getText());
			
			// Cr�ation de l'adresse
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			while (resultSet.next()){
				IDAdresse = resultSet.getInt(1);
			}	
	
	}

}
