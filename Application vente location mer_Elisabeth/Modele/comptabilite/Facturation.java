package comptabilite;


import article.Item;
import vente.InformationClient;
import vente.Panier;
/**this class take the information of the class Panier and the class Encaisser and show them*/
public class Facturation {

	
	
	
	private Encaisser encaisser;



	private Panier panier;
	
	
	/**
	@param panier, encaisser
	*panier give the information of the articles put in the basket by the client
	*encaisser give the information of the total price of all this articles
	*/
	public Facturation(Panier panier, Encaisser encaisser)
	{
		super();
		this.panier=panier;
		this.encaisser=encaisser;
		
		
		
	}
	
	
	
	
	
	public String affiche()
	{
		
		
		
		
		//System.out.println(toString1());
		return toString1();
		
		

		
		
	}
	

	
	public String toString1()
	{
		
		
		String result="";
		
		
		
		result=encaisser.toString();
		
		
		
		return result;
		
		
		
	}


	
}

