package gestion;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import article.Item;
import article.FenetrePrincipale;
import comptabilite.Encaisser;

/**

*this class puts in a table the prices of items put in the basket and wich are only for sale
*/

public class Achat implements IArticlesLouesEtAchete{

	private Double prixAchat=0.0;
	private ArrayList<Double>prix=new ArrayList<Double>();
	private Double sommeA=0.0;
	private Encaisser encaisser=new Encaisser();
	
	/**
	@param encaisser
	*encaisser receives the information calculated by the class Achat
	*/
	public Achat(Encaisser encaisser)
	{
		this.encaisser=encaisser;
		
	}
	
	


	public Double getPrixAchat() {
		return prixAchat;
	}

/**when an item is put in the basket in the class Panier, his price is set in the function setPrixAchat wich add this price in the array prix
*/ 
	public void setPrixAchat(Double prixAchat) {
		prix.add(prixAchat);
		
		this.prixAchat = prixAchat;
	}
	
	/**
	this function calculating the total price of items wich are only for sale by adding every element of the table prix
	@return the total price of items
	*/
	public Double calculPrix()
	{
		
		sommeA=0.0;
		
		Iterator<Double> it= prix.iterator();
		
		System.out.println(prix);
		
		while(it.hasNext())
		{
			sommeA+=it.next();
			
		}
		
		encaisser.setPrixTotal(sommeA);
		
		return sommeA;
		
		
	}
	
	public Double getSommeA()
	{
		return sommeA;
		
	}
	
	public void setSommeA(Double sommeL)
	{
		this.sommeA=sommeL;
	}
	
	public void affiche()
	{
//		System.out.println("Articles achet�s: ");
//		Enumeration<String> en0=itemAchete.keys();
//		
//		Enumeration<Double> en= itemAchete.elements();
//		
//				
//		while (en.hasMoreElements()) {
//			
//			System.out.println(en0.nextElement()+"            "+en.nextElement());
//			  
//		}
//		
		System.out.println("Total achat ");
		
		System.out.println(toString());
	}
	public 	String toString()
	{
		
		String result="";
		
		
		
		calculPrix();
		result+=sommeA;
		
		
		
		
		return result;
		
	}




	
	
	
	
	
}
