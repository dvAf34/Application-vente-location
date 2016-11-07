package gestion;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import comptabilite.Encaisser;



public class Location implements IArticlesLouesEtAchete{

	
	
	private Integer caution=null;
	private Double prixLocation=null;
	private Integer stock=null;
	private ArrayList<Double>prix=new ArrayList<Double>();
	private Integer dureeLocation=null;
	private Double sommeL=0.0;
	private Double coefLocation=null;
	private Encaisser encaisser = new Encaisser();
	
	
	public Location(Encaisser encaisser) {
		super();
		
		this.encaisser=encaisser;
	}


	public Integer getCaution() {
		return caution;
	}


	public void setCaution(Integer caution) {
		this.caution = caution;
	}


	
	public ArrayList<Double> getPrix()
	{
		return prix ;
	}
	
	public void setPrix(ArrayList<Double> prix)
	{
		this.prix=prix;
	}
	
	public Double getPrixLocation() {
		
		return prixLocation;
	}

	public Double getCoefLocation() {
		
		return coefLocation;
	}
	
	public void setCoefLocation(Double coefLocation)
	{
		this.coefLocation=coefLocation;
	}
	

	public void setPrixLocation(Double prixLocation) {
		
		
		prix.add(prixLocation*coefLocation);
		this.prixLocation = prixLocation;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public Integer getdureeLocation() {
		return dureeLocation;
	}


	public void setDateLocation(Integer dureeLocation) {
		if (dureeLocation==1)
		{
			 setCoefLocation(1.0);
		}
		else if(dureeLocation==2)
		{
			 setCoefLocation(1.8);
		}
		else if(dureeLocation==7)
		{
			setCoefLocation(2.5);
		}
		
		this.dureeLocation = dureeLocation;
	}


	
	
	public void gereStock()
	{
		
	}
	
	public void envoyerRappel()
	{
		
	}
	
	
	
	public Double calculPrix()
	{
		
		sommeL=0.0;
		
		Iterator<Double> it= prix.iterator();
		
		while(it.hasNext())
		{
			sommeL+=it.next();
			
		}
		
		
		encaisser.setPrixTotal(sommeL);
		
		
		return sommeL;
		
		
	}
	
	
	public void affiche()
	{
		System.out.println("\r\n"+"Articles loues");
		
		Enumeration<String> en0=itemLoue.keys();
		
		Enumeration<String> en= itemLoue.elements();
		
				
		while (en.hasMoreElements()) {
			
			System.out.println(en0.nextElement()+"            "+en.nextElement());
			  
		}
		
		System.out.println("Total location");
		System.out.println(toString());
	}
	public 	String toString()
	{
		
		String result="";
		
		calculPrix();
		result+=sommeL;
		
		System.out.println(result);	
		return result+"\r\n";
		
	}
	
	
	
}
