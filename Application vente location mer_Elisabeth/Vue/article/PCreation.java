package article;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PCreation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabel str2 = new JLabel();
	public String[] tabString2={"Civilit�","Nom","Pr�nom","Date de naissance","Email","Choisir un mot de passe","Recevoir les offres promotionnelles"};
	public JLabel[] tabLabel = new JLabel[tabString2.length];

	public JPanel reponse = new JPanel();
	public JPanel civilite = new JPanel();
	public JRadioButton civilite1=new JRadioButton("Monsieur");
	
	// On r�cup�re les informations dans les champs
	public JRadioButton getCivilite1() {
		return civilite1;
	}

	public JTextField getNom1() {
		return nom1;
	}

	public JTextField getPrenom1() {
		return prenom1;
	}

	public JComboBox<String> getJour() {
		return jour;
	}

	public JComboBox<String> getMois() {
		return mois;
	}

	public JComboBox<String> getAnnee() {
		return annee;
	}

	public void setJour(JComboBox jour) {
		this.jour = jour;
	}

	public void setMois(JComboBox mois) {
		this.mois = mois;
	}

	public void setAnnee(JComboBox annee) {
		this.annee = annee;
	}

	public JTextField getEmail1() {
		return email1;
	}

	public JPasswordField getMdp1() {
		return mdp1;
	}

	public JCheckBox getPub1() {
		return pub1;
	}
	

	public void setNom1(JTextField nom1) {
		this.nom1 = nom1;
	}

	public void setPrenom1(JTextField prenom1) {
		this.prenom1 = prenom1;
	}


	public JRadioButton civilite2=new JRadioButton("Madame");
	public ButtonGroup bg = new ButtonGroup();
	public JPanel nom = new JPanel();
	public JTextField nom1 = new JTextField();
	private JPanel prenom = new JPanel();
	public JTextField prenom1 = new JTextField();
	private JPanel naissance = new JPanel();
	private String[] tabJour={"JOUR\t\t","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	JComboBox jour = new JComboBox(tabJour);
	private String[]tabMois= {"MOIS\t","janvier","f�vrier","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","d�cembre"};
	 JComboBox mois = new JComboBox(tabMois);
	private Integer[] tabInt={1920, 1921, 1922, 1923, 1924, 1925, 1926, 1927, 1928, 1929, 1930, 1931, 1932, 1933, 1934, 1935, 1936, 1937, 1938, 1939, 1940, 1941, 1942, 1943, 1944, 1945, 1946, 1947, 1948, 1949, 1950, 1951, 1952, 1953, 1954, 1955, 1956, 1957, 1958, 1959, 1960, 1961, 1962, 1963, 1964, 1965, 1966, 1967, 1968, 1969, 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016};
	 JComboBox annee = new JComboBox(tabInt);
	private JPanel email = new JPanel();
	public JTextField email1 = new JTextField();
	private JPanel mdp = new JPanel();
	public JPasswordField mdp1 = new JPasswordField();
	private JPanel pub = new JPanel();
	JCheckBox pub1 = new JCheckBox("J'accepte");
    
	public PCreation(){
		
		JPanel texte2 = new JPanel();
		str2 =new JLabel("Pour cr�er votre compte, veuillez renseigner les champs suivants.");
		texte2.add(str2);
		texte2.setPreferredSize(new Dimension(600,100));
		
		JPanel champs = new JPanel();
		champs.setPreferredSize(new Dimension(196,300));
		champs.setLayout(new GridLayout(7,1,5,5));
		for (int i=0; i<tabString2.length;i++){
			tabLabel[i]= new JLabel(tabString2[i]);
			tabLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);
			champs.add(tabLabel[i]);
		}
		
		reponse.setPreferredSize(new Dimension(300,300));
		reponse.setLayout(new GridLayout(7,1));
		bg.add(civilite1);
		bg.add(civilite2);
		civilite1.setSelected(true);
		civilite.add(civilite1);
		civilite.add(civilite2);
		reponse.add(civilite);
		nom1.setPreferredSize(new Dimension (300,30));
		nom.add(nom1);
		reponse.add(nom);
		prenom1.setPreferredSize(new Dimension (300,30));
		prenom.add(prenom1);
		reponse.add(prenom);
		jour.setPreferredSize(new Dimension (75,30));
		mois.setPreferredSize(new Dimension (75,30));
		annee.setPreferredSize(new Dimension(75,30));
		naissance.add(jour);
		naissance.add(mois);
		naissance.add(annee);
		reponse.add(naissance);
		email1.setPreferredSize(new Dimension (300,30));
		email.add(email1);
		reponse.add(email);
		mdp1.setPreferredSize(new Dimension (300,30));
		mdp.add(mdp1);
		reponse.add(mdp);
		pub1.setSelected(true);
		pub.add(pub1);
		reponse.add(pub);

		this.add(texte2, BorderLayout.NORTH);
		this.add(champs, BorderLayout.CENTER);
		this.add(reponse, BorderLayout.EAST);
	}

	
}
