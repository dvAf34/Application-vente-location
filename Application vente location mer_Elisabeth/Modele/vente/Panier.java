package vente;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JLabel;

import SQL.RequeteSQL;


import article.Item;
import comptabilite.Encaisser;
import comptabilite.Facturation;
import gestion.Location;
import gestion.Achat;
import gestion.IArticlesLouesEtAchete;
import article.FenetrePrincipale;


/**this class check the stock available for the items and sends them in the class Achat or Location  according to the value of the variable durree of the item*/
public class Panier implements ItableauDeCommande ,IArticlesLouesEtAchete {

	
	
	
	
	
 
	Location location;
	Achat achat;
	FenetrePrincipale fenetre;
	
	
	public Panier(Encaisser encaisser) {
		super();

		location = new Location(encaisser);
		achat= new Achat(encaisser);
		
	}


	
	public  void remplirPanier(FenetrePrincipale f)
	{
		
		Enumeration en = tabCommande.keys();
		
		Enumeration <Integer >en0 = tabCommande.elements();	
		
		Integer index=null;
		Double aux=0.0;
		
		
		while(en.hasMoreElements())
		{
			String param = (String) en.nextElement();
			
			 for(int i=0;i<f.test.size();i++)  
	         {  
	            if(f.test.get(i).getNomItem().equals(param))  
	            {  
	               
	            	index=i;
	            	
	            }  
	         }  
			
			
			 
			Integer valeurDeLaCle= tabCommande.get(param).intValue();
				Integer nouveauStock=f.test.get(index).getStock()-valeurDeLaCle;
				
				f.r.modifStock(f.test.get(index).getNomItem(), nouveauStock);
			
			
			if(f.test.get(index).getDuree()==0)
			{
				
				
				aux = valeurDeLaCle*f.test.get(index).getPrixUnitaire();
				achat.setPrixAchat(aux);//(valeurDeLaCle* f.prixtab));
				
				
				
				//itemAchete.put(String.valueOf(en.nextElement()), (double) f.prixtab);
				
			}
			else if (f.test.get(index).getDuree()>0)
			{
			
				location.setDateLocation(f.test.get(index).getDuree().intValue());
				aux = valeurDeLaCle*f.test.get(index).getPrixUnitaire();
				location.setPrixLocation((aux));
				//itemLoue.put(String.valueOf(en.nextElement()), String.valueOf(f.prixtab)+" "+"duree de location:  "+f.duree+"jours");
				
			}
		
			}//while
		
	

	}
		

	
	
	
		
	public void affiche()
	{
		System.out.println("Panier:");
		
		Enumeration<String> en0=tabCommande.keys();
		
		Enumeration<Integer> en= tabCommande.elements();
		
		while (en.hasMoreElements()) {
			
			System.out.println(en0.nextElement()+"            "+en.nextElement());
			  
		}
		
		
		
		
				location.affiche();
				
				achat.affiche();
				
				
				
		System.out.println("************************************************************");	
		
	}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	

