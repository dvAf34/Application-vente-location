package article;

import java.util.StringTokenizer;

import article.FenetrePanier;
import SQL.Prepare;

public class DefinirPAdresse {

	public static Integer idDejaClient;

	public static Integer getIdDejaClient() {
		return idDejaClient;
	}

	public static void setIdDejaClient(Integer idDejaClient) {
		DefinirPAdresse.idDejaClient = idDejaClient;
	}

	public DefinirPAdresse(FenetrePanier f){
		// Chercher dans la BDD le client qui a le mail et MDP correspondant
		String mailTest = ((PDejaClient)f.pDejaClient).getTabTextField1()[0].getText();
		String mdpTest = ((PDejaClient)f.pDejaClient).getTabTextField1()[1].getText();
		Prepare requete = new Prepare();
		
		// Remplir les TextField avec les informations de la BDD
		idDejaClient= (Integer) requete.chercherClient(mailTest,mdpTest).get(0);
		((PCreation) f.pCreation).civilite1.setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(1)));
		((PCreation) f.pCreation).nom1.setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(2)));
		((PCreation) f.pCreation).prenom1.setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(3)));
		String date = String.valueOf(requete.chercherClient(mailTest,mdpTest).get(4));
		StringTokenizer st = new StringTokenizer(date, "-");
		String a = st.nextToken();
		String m = st.nextToken();
		String j = st.nextToken();
		System.out.println(a + m + j);
		((PCreation) f.pCreation).jour.setToolTipText(j);
		((PCreation) f.pCreation).mois.setToolTipText(m);
		((PCreation) f.pCreation).annee.setToolTipText(a);
		((PCreation) f.pCreation).email1.setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(5)));
		((PCreation) f.pCreation).mdp1.setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(6)));
		((PCreation) f.pCreation).pub1.setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(8)));
		if(requete.chercherClient(mailTest,mdpTest).get(10).equals("true")){
			((PAdresse) f.pAdresse).civilite1f.setSelected(true);
		}
		else if (requete.chercherClient(mailTest,mdpTest).get(10).equals("false")){
			((PAdresse) f.pAdresse).civilite2f.setSelected(true);
		}
	  	((PAdresse) f.pAdresse).getNom().setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(11)));
		((PAdresse) f.pAdresse).getPrenom().setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(12)));
		((PAdresse) f.pAdresse).getAdresse().setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(13)));
		((PAdresse) f.pAdresse).getCp().setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(14)));
		((PAdresse) f.pAdresse).getVille().setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(15)));
		((PAdresse) f.pAdresse).getTelephone().setText(String.valueOf(requete.chercherClient(mailTest,mdpTest).get(7)));
	}
}
