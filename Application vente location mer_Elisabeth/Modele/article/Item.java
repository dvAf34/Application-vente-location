package article;
/**this class defines the characteristics of an article*/
public class Item {

	
	
	private String description=null;
	private String nomItem=null;
	private Double prixUnitaire=null;
	private Integer duree=null;
	private Integer stock=null;
	private Integer codeArticle=null;
	private String codeAchatLocation=null;// la première lettre correspond au nom de l'article, un chiffre, la lettre qui précise location ou achat
	private String cheminPhoto;
	
	/**
	@param codeArticle,nomItem,description,prixUnitaire,stock,duree,cheminPhoto
	
	*codeArticle is a unic code for each article
	*nomItem is the name of the article
	*description is a short text who describe each article
	*prixUnitaire is the price of the article
	*stock is the number of copies available for each article
	*duree is a number equals to 0 if the article is for to be sold or superior to 0 if the article is for leasing
	*cheminPhoto is the path where the picture of the article is storaging
	*/
	
	
	public Item(Integer codeArticle,String nomItem,String description, Double prixUnitaire,Integer stock, Integer duree,String cheminPhoto) {
		super();
		this.setDescription(description);
		this.nomItem = nomItem;
		this.prixUnitaire = prixUnitaire;
		this.duree = duree;
		this.stock = stock;
		this.codeArticle=codeArticle;
		this.setCheminPhoto(cheminPhoto);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getNomItem() {
		return nomItem;
	}

	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}

	public Double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(Integer codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getCodeAchatLocation() {
		return codeAchatLocation;
	}

	public void setCodeAchatLocation(String codeAchatLocation) {
		this.codeAchatLocation = codeAchatLocation;
	}

	@Override
	public String toString() {
		return " Code article " + getCodeArticle()+" Nom: " + getNomItem()+" Description: " + getDescription() +  " Prix unitaire: "
				+ getPrixUnitaire() + " Duree: " + getDuree() + " Stock:  " + getStock()
				 + " Code achat location: " + getCodeAchatLocation();
	}

	public String getCheminPhoto() {
		return cheminPhoto;
	}

	public void setCheminPhoto(String cheminPhoto) {
		this.cheminPhoto = cheminPhoto;
	}
	
	
	 
	
	
}
