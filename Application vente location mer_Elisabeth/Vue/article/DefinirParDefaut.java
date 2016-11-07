package article;

import article.PAdresse;
import article.PCreation;
import article.FenetrePanier;
import vente.ClientReel;


public class DefinirParDefaut {

	private FenetrePanier f;

	public DefinirParDefaut(FenetrePanier f){
		
		this.f=f;
		String nomtruc=((PCreation)f.pCreation).nom1.getText();
		((PAdresse) f.pAdresse).getNom().setText(nomtruc);
		String prenomtruc=((PCreation)f.pCreation).prenom1.getText();
		((PAdresse) f.pAdresse).getPrenom().setText(prenomtruc);
		
		if (((PCreation)f.pCreation).civilite1.isSelected()){
			((PAdresse) f.pAdresse).civilite1f.setSelected(true);
			
		}
		else if(((PCreation)f.pCreation).civilite2.isSelected());{
			((PAdresse) f.pAdresse).civilite2f.setSelected(true);
		}
		
		((PAdresse) f.pAdresse).bgf.add(((PAdresse)f.pAdresse).civilite1f);
		((PAdresse) f.pAdresse).bgf.add(((PAdresse)f.pAdresse).civilite2f);
	}
	
}
