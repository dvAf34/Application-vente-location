package article;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
//import java.awt.Font;
//import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.omg.PortableServer.POAManagerPackage.State;


import article.DefinirParDefaut;
import comptabilite.Facturation;
import gestion.IArticlesLouesEtAchete;

import vente.EnregistrerAdresse;
import vente.EnregistrerClient;
import vente.EnregistrerLien;
import vente.InformationClient;
import vente.ItableauDeCommande;
import SQL.Connect;


public class FenetrePanier extends JFrame implements ItableauDeCommande{
	
	JPanel panel1= new JPanel();
	JPanel panelScroll= new JPanel();
	
	JPanel panBouton = new JPanel();
	
	
	JTextArea area = new JTextArea(4,50);
	
	JButton cmdValider = new JButton("Valider");
	JButton cmdAnnuler = new JButton("Annuler");
	ArrayList<JPanel>p;
	JLabel tot;
	public Boolean valideCommande=false;
	
	
	
		// panier			
	//JPanel pPanier= 					new PPanier();			
    JPanel pAccueil= 					new PAccueil();				
    public static JPanel pDejaClient= 	new PDejaClient();	
    public static JPanel pCreation= 	new PCreation();		
    public static JPanel pAdresse= 		new PAdresse();	
    public  JPanel pFin= 			new PFin(this);	

    //Le bouton qui va changer le panel
    //JButton bValPanier = 		new JButton("Valider le panier");			
    JButton bDejaClient = 		new JButton("J'ai d�j� un compte");		 
    JButton bCreaCompte = 		new JButton("Je souhaite cr�er mon compte");
    JButton bValDejaClient = 	new JButton("V A L I D E R");					
    JButton bAnnDejaClient = 	new JButton("Annuler");						
    JButton bValCreaCompte = 	new JButton("V A L I D E R");					
    JButton bAnnCreaCompte = 	new JButton("Annuler");						
    JButton bValAdresse = 		new JButton("V A L I D E R");	
	public FenetrePrincipale f;
    
    
    

    //Constructeur de ta fen�tre
    public FenetrePanier(FenetrePrincipale f,Facturation fact){
    	
    	this.f=f;
       JScrollPane scrollpane= new JScrollPane(panelScroll);
       scrollpane.setPreferredSize(new Dimension(500,500));
       
       //panelScroll.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,500, 0, 500),panelScroll.getBorder()));
    	panelScroll.setBackground(Color.WHITE);
       p=new ArrayList<JPanel>(f.test.size());
    	
    	
    	cmdValider.setBackground(Color.WHITE);
    	cmdValider.setMargin(new Insets(5,5,5,5));
    	
    	
    	
    	cmdAnnuler.setBackground(Color.WHITE);
		
    	
    	
		
		init();
		
		panel1=(JPanel)this.getContentPane();
		
		panel1.setBackground(Color.WHITE);
		
		//panel1.setLayout(new GridLayout(f.test.size()+2,1,0,1));
		panelScroll.setLayout(new GridLayout(f.test.size(),1,0,1));
		panel1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 100, 1, 100),panel1.getBorder()));
		
		panBouton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panBouton.add(cmdAnnuler);
		panBouton.add(cmdValider);
		panBouton.setBackground(Color.WHITE);
		
		
		tot= new JLabel();
		
		Font font = new Font("Serif", Font.PLAIN,25);
		tot.setText(fact.affiche());
		tot.setFont(font);
		tot.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,500,0,100),tot.getBorder()));
		
	

		area.setForeground(getForeground());
		area.setAlignmentX(CENTER_ALIGNMENT);
		
		area.setBackground(getBackground());	
		area.setBackground(Color.WHITE);
		
		
		
		
//		Enumeration <String> en = f.table.keys();
//		
//		Enumeration <Double>en0=f.table.elements();
//		
//		Integer i =0;
		
	
		
		for (int j =0; j<f.test.size();j++)
		{
			
			JLabel limDiminue = new JLabel();
			JPanel panImage = new JPanel();
			panImage.setLayout(new GridLayout(2, 1));
			JTextArea area = new JTextArea(4,50);
			
			ImageIcon imArticle= new ImageIcon()	;
			Image article = null;
			
				try {
					article = ImageIO.read(new File(f.test.get(j).getCheminPhoto()));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
			imArticle.setImage(article.getScaledInstance(80, 80,Image.SCALE_DEFAULT ));;
					
			
			limDiminue.setIcon(imArticle);
			
			panImage.add(limDiminue);
			
			area.setForeground(getForeground());
			
			area.setText("\tNom:  " +f.test.get(j).getNomItem()+ "\r\n\n" + "\tPrix:  " + f.test.get(j).getPrixUnitaire()+ "\r\n\n" + "\tQte:  "+ f.quantiteCommande.get(j) );
			area.setEditable(false);
			
			
			panImage.add(area);
			
			panImage.setBackground(Color.WHITE);
			
			//p.add(panImage);
			panelScroll.add(panImage,BorderLayout.NORTH);
			//panel1.add(panImage,BorderLayout.NORTH);
			
		
		}
		
		
		panel1.add(scrollpane,BorderLayout.NORTH);
		panel1.add(tot,BorderLayout.CENTER);
		panel1.add(panBouton, BorderLayout.SOUTH);
			
		
//		while(en.hasMoreElements())
//		{
//			
//			
//			JLabel limDiminue = new JLabel();
//			JPanel panImage = new JPanel();
//			JTextArea area = new JTextArea(4,50);
//			
//			ImageIcon imArticle= new ImageIcon()	;
//			Image article = null;
//			
//				try {
//					article = ImageIO.read(new File(f.cheminImage.get(i)));
//				} catch (IOException e) {
//					
//					e.printStackTrace();
//				}
//			
//			imArticle.setImage(article.getScaledInstance(80, 80,Image.SCALE_DEFAULT ));;
//					
//			
//			limDiminue.setIcon(imArticle);
//			
//			panImage.add(limDiminue);
//			
//			area.setForeground(getForeground());
//			
//			area.setText("\tNom:  " +en.nextElement()+ "\r\n\n" + "\tPrix:  " + en0.nextElement()+ "\r\n\n" + "\tQte:  "+ f.quantiteCommande.get(i) );
//			area.setEditable(false);
//			
//			
//			panImage.add(area);
//			
//			panImage.setBackground(Color.WHITE);
//			
//			p.add(panImage);
//			panel1.add(p.get(i),BorderLayout.WEST);
//			
//			i++;
//		}
		
		
		//this.add(scroll,BorderLayout.NORTH);
    	
    	
    	
        //Ecouteur sur le bouton
			this.cmdValider.addActionListener(		new EcouteurBoutonChanger());
	        this.bDejaClient.addActionListener(		new EcouteurBoutonChanger());
	        this.bCreaCompte.addActionListener(		new EcouteurBoutonChanger());
	        this.bValDejaClient.addActionListener(	new EcouteurBoutonChanger());
	        this.bAnnDejaClient.addActionListener(	new EcouteurBoutonChanger());
	        this.bValCreaCompte.addActionListener(	new EcouteurBoutonChanger());
	        this.bAnnCreaCompte.addActionListener(	new EcouteurBoutonChanger());
	        this.bValAdresse.addActionListener(		new EcouteurBoutonChanger());
        
       
	        bDejaClient.setPreferredSize(new Dimension(200,50));
	        bCreaCompte.setPreferredSize(new Dimension(200,50));
	        JPanel panel=new JPanel();
	        panel.add(bDejaClient);
	        panel.add(bCreaCompte);
	        panel.setPreferredSize(new Dimension(220,150));
        
        //Par d�faut, on place le bouton dans le premier panel qui est dans la fen�tre
       // this.panel1.add(this.cmdValider);
        
        
	       
	        this.pAccueil.add(panel);
	        this.pDejaClient.add(	this.bValDejaClient);
	        this.pDejaClient.add(	this.bAnnDejaClient);
	        this.pCreation.add(		this.bValCreaCompte);
	        this.pCreation.add(		this.bAnnCreaCompte);
	        this.pAdresse.add(		this.bValAdresse);
	        
        
        this.setContentPane(this.panel1);
    
    }
    public void init()
	{
		this.setTitle(" P A N I E R");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}
		
     
    //M�thode qui change le panel de ta fen�tre
    public void aller1(){
        this.setContentPane(this.panel1);
        this.repaint();
        this.revalidate();
    }
    
    public void allerAccueil(){
        this.setContentPane(this.pAccueil);
        this.repaint();
        this.revalidate();
    }
    public void allerDejaClient(){
        this.setContentPane(this.pDejaClient);
        this.repaint();
        this.revalidate();
    }
    public void allerCreationCompte(){
        this.setContentPane(this.pCreation);
        this.repaint();
        this.revalidate();
    }
    public void allerAdresse(){
        this.setContentPane(this.pAdresse);
        this.repaint();
        this.revalidate();
    }
    public void allerFin(){
        this.setContentPane(this.pFin);
        this.repaint();
        this.revalidate();
    }

    //Ecouteur de ton bouton
    public class EcouteurBoutonChanger implements ActionListener{
        public void actionPerformed(ActionEvent clic) {
            if ((clic.getSource() == cmdValider)||(clic.getSource() == bAnnCreaCompte)||(clic.getSource() == bAnnDejaClient)){
            	allerAccueil();
            }
            if (clic.getSource() == bDejaClient){
            	allerDejaClient();
            }
            if (clic.getSource() == bCreaCompte){
            	allerCreationCompte();
            }	
            if (clic.getSource() == bValDejaClient){
            	
            	// Cette m�thode remplit les champs ADRESSE si le client a d�ja un compte
            	new DefinirPAdresse(FenetrePanier.this);			
            	allerAdresse();
            	//new DefinirPanel5(FenetrePanier.this);
            	valideCommande=true;
            	//aller5();
            }	
            if(clic.getSource() == bValCreaCompte)	
            {
            	
				
            	try {
            		new EnregistrerClient(FenetrePanier.this);
            	}	
            	catch (Exception e) {
            		e.printStackTrace();
            	}
            	
            	// Si les donn�es sont valides on passe au panel suivant, sinon on revient sur le meme
            	if (EnregistrerClient.validClient){ 
            		// Cette m�thode copie la civilite, le nom, le pr�nom du panel pr�c�dent
                	new DefinirParDefaut(FenetrePanier.this);
                	allerAdresse();
            	}
            	else{
            		allerCreationCompte();
            	}
            }
            
            if (clic.getSource() == bValAdresse){
            	valideCommande=true;
            	
            	
            	String valide=String.valueOf(valideCommande);
            	
            	try {
					new EnregistrerAdresse(FenetrePanier.this);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
            	
            	if (EnregistrerAdresse.validAdresse){
            		try {
    					new EnregistrerLien();
    					
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
            		
Calendar calendar = Calendar.getInstance();
                	
                	String date = String.valueOf(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE));
                	try {
                		
                		Integer id=null;
                		
                		if (EnregistrerClient.IDClient!= null){
                			id = EnregistrerClient.IDClient;
                		}
                		else if (EnregistrerClient.IDClient== null){
                			id = DefinirPAdresse.getIdDejaClient();
                		}
    					FenetrePanier.this.f.r.creationCommande(date, valide, id);
    					
    					
    					
    				} catch (Exception e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}	
            		allerFin();
            	}
            	else{
            		

            		allerAdresse();
            	}
            	
            	
            	
            	
            	
            	
            	
            }
            if(clic.getSource()==cmdAnnuler){
            	tabCommande.clear();
            	System.exit(0);
            	
            }
            	
        }
    }
  
    	
    	
	


    }



