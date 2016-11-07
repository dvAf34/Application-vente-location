package vente;

public class ClientReel {

	boolean civilite1 ; 
	private String nom; 
	private String prenom; 
	private int jour; 
	private int mois;
	private int annee;
	private String email;
	private String mdp;
	private boolean pub;
	private boolean civiliteF;
	private String nomF;
	private String prenomF;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	
	

	public ClientReel(boolean civilite1, String nom, String prenom, int jour, int mois, int annee, String email,
			String mdp, boolean pub, boolean civiliteF, String nomF, String prenomF, String adresse, String codePostal,
			String ville, String telephone) {
		super();
		this.civilite1 = civilite1;
		this.nom = nom;
		this.prenom = prenom;
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
		this.email = email;
		this.mdp = mdp;
		this.pub = pub;
		this.civiliteF = civiliteF;
		this.nomF = nomF;
		this.prenomF = prenomF;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}
	
//	public ClientReel(){
//		super();
//	}





	public boolean isCivilite1() {
		return civilite1;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getJour() {
		return jour;
	}

	public int getMois() {
		return mois;
	}

	public int getAnnee() {
		return annee;
	}

	public String getEmail() {
		return email;
	}

	public String getMdp() {
		return mdp;
	}

	public boolean isPub() {
		return pub;
	}

	public boolean isCiviliteF() {
		return civiliteF;
	}

	public String getNomF() {
		return nomF;
	}

	public String getPrenomF() {
		return prenomF;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setCivilite1(boolean civilite1) {
		this.civilite1 = civilite1;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}

	public void setCiviliteF(boolean civiliteF) {
		this.civiliteF = civiliteF;
	}

	public void setNomF(String nomF) {
		this.nomF = nomF;
	}

	public void setPrenomF(String prenomF) {
		this.prenomF = prenomF;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "ClientReel [\r\ncivil\t=" + civilite1 + ", \r\nnom\t=" + nom + ", \r\nprenom\t=" + prenom + ", \r\nDDN\t=" + jour + "/"
				+ mois + "/" + annee + ", \r\nemail\t=" + email + ", \r\nmdp\t=" + mdp + ", \r\npub\t=" + pub + ", \r\ncivilF\t="
				+ civiliteF + ", \r\nnomF\t=" + nomF + ", \r\nprenomF\t=" + prenomF + ", \r\nadresse\t=" + adresse + ", \r\nCP\t="
				+ codePostal + ", \r\nville\t=" + ville + ", \r\ntel\t=" + telephone + "]";
	}

}