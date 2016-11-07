package vente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import SQL.Connect;
import article.PCreation;


import article.FenetrePanier;

public class EnregistrerClient {
	
	
	public static Integer IDClient;
	// Pour enregistrer le client, Fenetre doit avoir validClient=true
	public static boolean validClient;
	private FenetrePanier f;

	public EnregistrerClient(FenetrePanier f) {
		this.f=f;
		// On v�rifie que les donn�es sont valides
		PCreation panel = (PCreation) f.pCreation;
		if (	panel.getNom1().getText().trim().length()==0						||
				panel.getPrenom1().getText().trim().length()==0 					||
				panel.getMois().getSelectedItem().toString().equals("MOIS\t")		||
				panel.getJour().getSelectedItem().toString().equals("JOUR\t\t")		||
				panel.getEmail1().getText().trim().length()==0						||
				panel.getMdp1().getText().trim().length()==0						){
			validClient = false;
		}
		// Si les donn�es sont valides, on les envoie � la base de donn�es
		else{
			validClient=true;
			try {
				create();
			}
			catch (Exception e) {
				System.out.println("ERROR");
			}
		}
	}

	public void create() throws Exception {
		
		// On change les boolean en String
		String civilite;
		if (( (PCreation) f.pCreation).getCivilite1().isSelected()){
			civilite="true";
		}
		else{
			civilite="false";
		}
		String publicite;
		if (( (PCreation) f.pCreation).getPub1().isSelected()){
			publicite="true";
		}
		else{
			publicite="false";
		}
		// On met la date en String et au bon format
		String a = ((PCreation) f.pCreation).getAnnee().getSelectedItem().toString();
		int b = ((PCreation) f.pCreation).getMois().getSelectedIndex();
		int c = ((PCreation) f.pCreation).getJour().getSelectedIndex();
		String strDate = a+"-"+b+"-"+c;
		
		// Formulation de la requ�te du client � cr�er
		String query = "INSERT INTO client(cli_civilite,cli_nom,cli_prenom,cli_datedenaissance,cli_email,cli_mdp,cli_publicite)VALUES (?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = (PreparedStatement) Connect.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, civilite);
		preparedStatement.setString(2, ((PCreation) f.pCreation).getNom1().getText());
		preparedStatement.setString(3, ((PCreation) f.pCreation).getPrenom1().getText());
		preparedStatement.setString(4, strDate);	
		preparedStatement.setString(5, ((PCreation) f.pCreation).getEmail1().getText());
		preparedStatement.setString(6, ((PCreation) f.pCreation).getMdp1().getText());
		preparedStatement.setString(7, publicite);

		// Cr�ation du client
		preparedStatement.execute();
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		while (resultSet.next()){
			 IDClient =resultSet.getInt(1);
		}	
		
		
	}


	
	
}
