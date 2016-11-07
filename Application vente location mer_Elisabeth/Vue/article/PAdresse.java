package article;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import vente.ClientReel;





public class PAdresse extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 ArrayList<ClientReel> listeClient = new ArrayList<ClientReel>();
	
	public ArrayList<ClientReel> getListeClient() {
		return listeClient;
	}
	public void setListeClient(ArrayList<ClientReel> listeClient) {
		this.listeClient = listeClient;
	}

	JPanel titre3=new JPanel();
	JPanel titre31=new JPanel();
	JPanel titre32=new JPanel();
	JLabel str3 =new JLabel("ADRESSE DE FACTURATION\r\n");
	JLabel str31 =new JLabel("Pour acc�der au paiement, veuillez renseigner votre adresse de facturation.");
	
	JPanel champs3=new JPanel();
	String[] tabString3={"Civilit�","Nom","Pr�nom","Adresse","Code postal","Ville","T�l�phone"};
	

	JLabel[] tabLabel3 = new JLabel[tabString3.length];
	
	JPanel reponse3=new JPanel();
	JPanel civilitef = new JPanel ();
	JRadioButton civilite1f=new JRadioButton("Monsieur");
	JRadioButton civilite2f=new JRadioButton("Madame");
	ButtonGroup bgf = new ButtonGroup();
	public JTextField nom = new JTextField();
	public JTextField prenom = new JTextField();
	public JTextField adresse = new JTextField();
	public JTextField cp = new JTextField();
	public JTextField ville = new JTextField();
	public JTextField telephone = new JTextField();

	public PAdresse(){
		titre31.add(str3);
		titre32.add(str31);
		titre3.add(titre31);
		titre3.add(titre32);
		titre3.setPreferredSize(new Dimension(600,100));
		
		champs3.setLayout(new GridLayout(7,1,5,5));
		champs3.setPreferredSize(new Dimension(196,300));
		for (int i=0; i<tabString3.length;i++){
			tabLabel3[i]= new JLabel(tabString3[i]);
			tabLabel3[i].setHorizontalAlignment(SwingConstants.RIGHT);
			champs3.add(tabLabel3[i]);
		}
		
		reponse3.setLayout(new GridLayout(7,1,10,10));
		reponse3.setPreferredSize(new Dimension(300,300));
		
		civilitef.add(civilite1f);
		civilitef.add(civilite2f);
		reponse3.add(civilitef);
		reponse3.add(nom);
		reponse3.add(prenom);
		reponse3.add(adresse);
		reponse3.add(cp);
		reponse3.add(ville);
		reponse3.add(telephone);
		
		this.add(titre3, BorderLayout.NORTH);
		this.add(champs3, BorderLayout.CENTER);
		this.add(reponse3, BorderLayout.EAST);
	}

	public JRadioButton getCivilite1f() {
		return civilite1f;
	}
	public JTextField getNom() {
		return nom;
	}
	public JTextField getPrenom() {
		return prenom;
	}
	public JTextField getAdresse() {
		return adresse;
	}
	public JTextField getCp() {
		return cp;
	}
	public JTextField getVille() {
		return ville;
	}
	public JTextField getTelephone() {
		return telephone;
	}
	public void setNom(JTextField nom) {
		this.nom = nom;
	}
	public void setPrenom(JTextField prenom) {
		this.prenom = prenom;
	}
	public void setAdresse(JTextField adresse) {
		this.adresse = adresse;
	}
	public void setCp(JTextField cp) {
		this.cp = cp;
	}
	public void setVille(JTextField ville) {
		this.ville = ville;
	}
	public void setTelephone(JTextField telephone) {
		this.telephone = telephone;
	}
	
	

	
	
	
}
