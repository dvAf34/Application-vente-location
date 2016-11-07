package comptabilite;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;

import gestion.Achat;
import gestion.Location;
import vente.Panier;
/**this class  calculate the total price of purchases made by the client*/
public class Encaisser {

	
	private Double prixTotal=0.0;
	
	private ArrayList<Double>tabPrixTotal=new ArrayList<Double>();
	private Double totalCommandeHT=0.0;
	private static final  double tauxTVA=5.5; 
	private Double totalTTC=0.0;
	
	
	
	
	public Encaisser ()
	{
		
		
	}


	
	
	public Double getPrixTotal() {
		
	
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		
		
		tabPrixTotal.add(prixTotal);
			
		
		this.prixTotal = prixTotal;
	}
	

	

	public ArrayList<Double> getTabPrixTotal()
	{
		return tabPrixTotal;
		
	}
	
	public Double getTotalCommandeHT()
	{
		return totalCommandeHT;
		
	}
	
	public void setTotalCommandeHT(Double totalCommandeHT)
	{
		
		this.totalCommandeHT=totalCommandeHT;
	}
	
	public void setTabPrixTotal(ArrayList<Double>tabPrixTotal)
	{
		this.tabPrixTotal=tabPrixTotal;
	}
	
	/** the function calculPrixTotal  use the element in the array tabPrixTotal wich contain each price of each article put in the basket by the client. 
	*This function add each element of the array and return a total of this calcul.
	
	@return totalCommandeHT Return the total of the calcul.
	*/
	
	
	public   Double calculPrixTotal( )
	{
		
		totalCommandeHT=0.0;
		
		
		
		Iterator<Double> it= tabPrixTotal.iterator();
		
		while(it.hasNext())
		{
			totalCommandeHT+=it.next();
			
		}
		
		
		
		return totalCommandeHT;
	}
	
	
	/** this part calculating the totalTTC with a formula and return this number
	@return Return the totatTTC of the client's basket
	*/
	
	public Double getTotalTTC() {
		totalTTC=(totalCommandeHT*(1+tauxTVA/100));
		return totalTTC;
	}





	public void setTotalTTC(Double totalTTC) {
		
		
		this.totalTTC =totalTTC ;
		
	}
	
	public void calculDatedeRetour()
	{
		
		
		
		
	}
	
	public void affiche()
	{
		
		System.out.println();
		
		System.out.println("Total");
		System.out.println(toString());
	}
	public 	String toString()
	{
		
		String result="";
		
		
		calculPrixTotal();
		result+="Prix HT: "+ totalCommandeHT+"\r\n";
		result+="Prix TTC: "+getTotalTTC();
		
		
		return result;
		
	}
	
	
}
