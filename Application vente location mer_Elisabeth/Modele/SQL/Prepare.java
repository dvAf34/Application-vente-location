package SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Prepare
{

	Statement statement = null;
	String resultSet = null;
	String adresse;
	ArrayList<Comparable> client2 = new ArrayList<Comparable>();
	
	public ArrayList<Comparable> chercherClient(String mailTest, String mdpTest)
	{
		
		try
		{
			Connection conn = Connect.getConnection();
			
			 
			 
			 
			 String query = "SELECT idclient,cli_civilite,cli_nom,cli_prenom,cli_datedenaissance,cli_email,cli_mdp,adr_telephone,cli_publicite,idadresse,adr_civilite,adr_nom,adr_prenom,adr_adresse,adr_cp,adr_ville FROM client,lien_adresse,adresse  ";
		      query += " WHERE (cli_email = ?";
		      query += " and cli_mdp = ?) and (idclient = cli_id) and (idadresse = adr_id)";
		      PreparedStatement prepare = conn.prepareStatement(query);
		      //On cr�e l'objet avec la requ�te en param�tre
		      
		      prepare.setString(1, mailTest);
		      prepare.setString(2, mdpTest);
		      ResultSet resultSet = prepare.executeQuery();

		      // On r�cup�re les donn�es dans un ArrayList					// indice
		      while (resultSet.next()){
		    	client2.add(resultSet.getInt("idclient"));					//0
				client2.add(resultSet.getString("cli_civilite"));			//1
				client2.add(resultSet.getString("cli_nom"));				//2
				client2.add(resultSet.getString("cli_prenom"));				//3
				client2.add(resultSet.getString("cli_datedenaissance"));	//4
				client2.add(resultSet.getString("cli_email"));				//5
				client2.add(resultSet.getString("cli_mdp"));				//6
				client2.add(resultSet.getString("adr_telephone"));			//7
				client2.add(resultSet.getString("cli_publicite"));			//8
				client2.add(resultSet.getString("idadresse"));				//9
				client2.add(resultSet.getString("adr_civilite"));			//10
				client2.add(resultSet.getString("adr_nom"));				//11
				client2.add(resultSet.getString("adr_prenom"));				//12
				client2.add(resultSet.getString("adr_adresse"));			//13
				client2.add(resultSet.getInt("adr_cp"));					//14
				client2.add(resultSet.getString("adr_ville"));				//15
			}
		      
		      prepare.close();
		      
		    }
		
		      catch (Exception e) {
		      e.printStackTrace();
		    }
		
		return client2;
	}
}
