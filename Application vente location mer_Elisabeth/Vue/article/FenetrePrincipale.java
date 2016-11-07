package article;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.omg.PortableServer.POAManagerPackage.State;

import comptabilite.Encaisser;
import comptabilite.Facturation;
import vente.InformationClient;
import vente.ItableauDeCommande;
import vente.Panier;
import SQL.RequeteSQL;




public class FenetrePrincipale extends JFrame implements ItableauDeCommande{

	public ArrayList<Image>imageArticles=new ArrayList<Image>();
	private ArrayList<JButton>items=new ArrayList<JButton>();
	public Double prixtab=0.0;
	Panel1 p1= new Panel1();
	public Encaisser encaisser = new Encaisser();
	
	public ArrayList<Integer>quantiteCommande=new ArrayList<Integer>();
	private Integer quantite=0;
	private Panier panier=new Panier(encaisser);
	
	private JPanel panel1=new JPanel();
	private JPanel panelScroll=new JPanel();
	
	
	private JPanel panel2=new JPanel();
	
	
	
	private JPanel photo=new JPanel();
	
	private JPanel description= new JPanel();
	private JPanel panBas = new JPanel();
	private JButton ajouterPanier = new JButton("Ajouter au panier");
	public JButton voirPanier= new JButton("voir mon panier");
	private JButton voirPanierCatalogue=new JButton("voir le panier");
	private JButton revenirCatalogue= new JButton("revenir au catalogue");
	public JTextField qte = new JTextField(5);
	public JLabel lqteNondispo= new JLabel();
	public RequeteSQL r = new RequeteSQL();
	public JLabel nom = new JLabel();
	private JLabel prix = new JLabel();
	public Integer stock=0;
	public Integer duree=0;
	ImageIcon fond= new ImageIcon();
	BufferedImage fondbis;
	
	
	public String image="";
	public ArrayList<String>cheminImage=new ArrayList<>();
	public ArrayList<Item>test = new ArrayList<>();
	
	

	
	


	
	
	public FenetrePrincipale() 
	{
		init();
		
		Integer taillebdd= r.getImage().size();
		 
		
	//*******************************************catalogue****************************************
		
		
		
		//this.getContentPane().add(panel1);
		panel1.setOpaque(true);
		panelScroll.setMinimumSize(new Dimension(500,500));
		
		
		
		
//		try {
//			Image fondbis = ImageIO.read(new File("plongee.jpg"));
//			fond.setImage(fondbis.getScaledInstance(900,900,Image.SCALE_DEFAULT ));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		JLabel fondPanel1 = new JLabel();
//		fondPanel1.setIcon(fond);
				
		
		
ImageIcon logo= new ImageIcon();
		
		try {
			Image logobis = ImageIO.read(new File("plouf.png"));
			logo.setImage(logobis.getScaledInstance(80, 80,Image.SCALE_DEFAULT ));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel logoPlouf = new JLabel("Location et vente de mat�riel de plong�e");
		
		JPanel test = new JPanel();
		logoPlouf.setIcon(logo);
		
		test.setPreferredSize(new Dimension (500,90));
		test.setBackground(Color.WHITE);
		
		test.add(logoPlouf);
		p1.add(test, BorderLayout.NORTH);
		//panel1.add(test, BorderLayout.NORTH);
		
		
		
	
		
		
		
		p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(-10,0,0,0),panelScroll.getBorder()));
		//panel1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(-10,0,0,0),panelScroll.getBorder()));
		
		panelScroll.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,80,10,80),panelScroll.getBorder()));
		
		
		JPanel panGauche= new JPanel();
		
		voirPanierCatalogue.addActionListener(new AppActionListener());
		
		
		
		voirPanierCatalogue.setBackground(Color.YELLOW);
		
		
		
		panGauche.setLayout((new GridLayout(taillebdd,1,0,20)));
	
		
		try{
			
			
			 
			 for (int i =0; i< taillebdd;i++)
			 {
				 Image article = ImageIO.read(new File(r.readData().get(i).getCheminPhoto()));
				 
				 imageArticles.add(article);
				
			 }
			 
		}
		catch(IOException e)
		{
			 e.printStackTrace();
		}
		
		
		
		
		for(int i=0; i<imageArticles.size();i++){
			
		JButton art= new JButton();
		
		ImageIcon imArt= new ImageIcon();
		
		art.setBackground(Color.WHITE);
		
		imArt.setImage(imageArticles.get(i).getScaledInstance(80, 80,Image.SCALE_DEFAULT ));
		
		art.setIcon(imArt);
		items.add(art);
		
		
			
		if (r.readData().get(i).getStock()==0)
		{
			art.setEnabled(false);
		}
		
		}
		
		int alpha = 40; // 50% transparent
		Color blanctransp = new Color(255, 255, 255, alpha);
		
		
		JPanel panDroit= new JPanel();
		panDroit.setLayout(new GridLayout(taillebdd*3,1,0,20));
		panDroit.setBackground(blanctransp);
		
		
	
		
		for(int i = 0; i<items.size();i++)
		{
			
			items.get(i).addActionListener(new AppActionListener());
			
			panGauche.add(items.get(i));
			panGauche.setBackground(blanctransp);
			
			panelScroll.add(panGauche, BorderLayout.WEST);
			
		}
		
		
			for(int i =0; i<taillebdd;i++)
			{
			panDroit.add(new JLabel(""+r.readData().get(i).getNomItem()));
			panDroit.add(new JLabel("Prix: "+String.valueOf(r.readData().get(i).getPrixUnitaire())));
			panDroit.add(new JLabel("Stock: "+String.valueOf(r.readData().get(i).getStock())));
			panelScroll.add(panDroit, BorderLayout.CENTER);
			}
			
		
	
	
			int alpha2 = 127; // 50% transparent
			Color blanctransp2 = new Color(255, 255, 255, alpha2);
			
	panelScroll.setBackground(blanctransp2);
			
			
	

	
	JScrollPane scrollpane = new JScrollPane(panelScroll);
	
	scrollpane.setBackground(blanctransp2);
	
	p1.add(scrollpane,BorderLayout.CENTER);
	//panel1.add(scrollpane,BorderLayout.CENTER);

	p1.add(voirPanierCatalogue,BorderLayout.SOUTH);
	//panel1.add(voirPanierCatalogue,BorderLayout.SOUTH);
	
	
	
	
this.revalidate();
this.repaint();
	
	
	//********************************************item**************************************************	
	
	
	panel2.setBackground(new Color(133,192,241));
	panel2.setLayout(new BorderLayout());
	
	revenirCatalogue.addActionListener(new AppActionListenerItem());
	
	photo.setBackground(new Color(133,192,241));
	
	photo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	photo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(150, 50, 100, 5),photo.getBorder()));
	
	
	description.setLayout(new GridLayout(8,1,5,0));
	description.setBackground(new Color(133,192,241));
	description.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(150, 30, 5, 5),description.getBorder()));
		
	panBas.setLayout(new GridLayout(2, 2));
	panBas.setBackground(new Color(133,192,241));
	ajouterPanier.addActionListener(new AppActionListenerItem());
	ajouterPanier.setBackground(Color.YELLOW);
	ajouterPanier.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED,Color.yellow, Color.gray));
	panBas.add(ajouterPanier);
	panBas.add(qte);
	panBas.add(voirPanier);
	panBas.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 250, 150, 250),panBas.getBorder()));
		
	voirPanier.addActionListener(new AppActionListenerItem());
	voirPanier.setVisible(false);
	
	panel2.setBorder(BorderFactory.createLineBorder(Color.CYAN));
	
	
	panel2.add(revenirCatalogue,BorderLayout.NORTH);
	
	panel2.add(photo,BorderLayout.WEST);
	
	panel2.add(description,BorderLayout.EAST);
	
	panel2.add(panBas,BorderLayout.SOUTH);
	
	
	

	
	lqteNondispo.setText("La quantité demandé n'est pas disponible");
	lqteNondispo.setVisible(false);
	panel2.add(lqteNondispo);
	
	
	
	
		
	
		}
	
	
	public void init()
	{
		this.setTitle("Catalogue");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(500,730);
		this.add(p1);
		
	
		
		
	}
	
	public void init2()
	{
		this.setTitle("Article");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setSize(1000,1000);
		this.setResizable(false);
		
		
	}
	
	
	
	class AppActionListener implements ActionListener {
		
		
		
		public AppActionListener()
		
		{
			
		}
		
			public void actionPerformed(ActionEvent e)
			{
			
				
			if(e.getSource()==voirPanierCatalogue)
			{
				AppActionListenerItem a=new AppActionListenerItem();
				a.affichePanier();
			
			}
			if (e.getSource()==items.get(0))
				{
				
				
				item(0);
				stock =r.readData().get(0).getStock();
				
				
				}
			else if (e.getSource()==items.get(1))
			{
			
				item(1);
				stock =r.readData().get(1).getStock();
				
			}
			else if (e.getSource()==items.get(2))
			{
			
				item(2);	
				stock =r.readData().get(2).getStock();
				

			}
			else if (e.getSource()==items.get(3))
			{
				item(3);
				stock =r.readData().get(3).getStock();
				

			}
			
			else if (e.getSource()==items.get(4))
			{
				item(4);
				stock =r.readData().get(4).getStock();
				

			}
			
			}
			
			public void item (int index)
			{
				
				init2();
				description.removeAll();
				photo.removeAll();
				
				nom.setText(r.readData().get(index).getNomItem());
				image=r.getImagePanier(nom.getText());
				description.add(nom);
				
				description.add(new JLabel(""+r.readData().get(index).getDescription()));
				
				duree=r.readData().get(index).getDuree();
				if(duree>0)
				{
				description.add(new JLabel("Location"+r.readData().get(index).getDuree()+"jours"));
				}
				
				prixtab=r.readData().get(index).getPrixUnitaire();
				String prixEnTexte=String.valueOf(r.readData().get(index).getPrixUnitaire());
				
				prix.setText("PRIX: "+prixEnTexte+" euros");
				description.add(prix);
				
				
				
				photo.add(new JLabel (new ImageIcon(r.readData().get(index).getCheminPhoto())));
				

				setContentPane(panel2);
				
			}

	}
			
	class AppActionListenerItem implements ActionListener {
				
				
				public AppActionListenerItem()
				{
					
				}
				
					public void actionPerformed(ActionEvent e)
					{
						
						
						
					if (e.getSource()==ajouterPanier)
						
						
						{
						
						
						
						quantite=Integer.parseInt(qte.getText());
						

						
						if((quantite>0)&&(quantite<=stock))
						{
							lqteNondispo.setVisible(false);
							Item test1=new Item(null,nom.getText(),null,prixtab,stock,duree,image);
							test.add(test1);
							
							
							quantiteCommande.add(quantite);
																		
							tabCommande.put(nom.getText(),quantite);
							
							
							voirPanier.setVisible(true);
						}
						else {
							
							lqteNondispo.setText("La quantité demandé n'est pas disponible");
							lqteNondispo.setVisible(true);
							panel2.add(lqteNondispo);
							qte.setText("");
						}
						
						
						
						
						}
					
					
					
					if(e.getSource()==voirPanier)
					{
						
						verifStock();
						affichePanier();	
						
						
					}

					if(e.getSource()==revenirCatalogue)
					{
						init();
						getContentPane().remove(panel2);
						setContentPane(p1);
						qte.setText("");
						quantite=null;
						
						
					}
					
					}
	
			/**
			verifStock verified that the amount ordered by the client is in agreement with the item number in stock
			*/
			private void verifStock()
			{
				
				
				if((test.size())==0)
				{
					
					JLabel panierVide = new JLabel();
					panierVide.setVisible(true);
					panierVide.setText("Panier vide !");
					Facturation facture = new Facturation(panier,encaisser);
					FenetrePanier fen = new FenetrePanier(FenetrePrincipale.this,facture);
					
					fen.panel1.add(panierVide,BorderLayout.CENTER);
					
				}
				
				else if (test.size()>0)
				{
				


					
					panier.remplirPanier(FenetrePrincipale.this);
				
					
				//}//for
				
				}//else
				}//verifStock
				
				
				
			
			private void affichePanier()
			{
				
				
				panier.affiche();
				Facturation facture = new Facturation(panier,encaisser);
				FenetrePanier fen = new FenetrePanier(FenetrePrincipale.this,facture);
				
				
				}
				
				
			
	}
}

	

	
	