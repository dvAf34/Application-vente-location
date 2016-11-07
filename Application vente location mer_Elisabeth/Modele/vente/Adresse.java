package vente;

public class Adresse {

	String civilite;
	String nom;
	String prenom;
	String adresse;
	String cp;
	String ville;
	
	
	
	public Adresse(String civilite, String nom, String prenom, String adresse, String cp, String ville) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		
	}


	public String getCivilite() {
		return civilite;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public String getCp() {
		return cp;
	}


	public String getVille() {
		return ville;
	}





	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	
	public Adresse() {
		super();
		
	}


	@Override
	public String toString() {
		return "Adresse [civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", cp=" + cp + ", ville=" + ville + ", telephone="  + "]";
	}
	
	
	
	
}
