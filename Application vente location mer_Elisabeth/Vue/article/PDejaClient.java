package article;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class PDejaClient extends JPanel {			// deja client 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel containerDejaClient = new JPanel();
	private JPanel titre1=new JPanel();
	private JPanel titre11=new JPanel();
	private JPanel titre12=new JPanel();
	private JLabel str1 =new JLabel("VOUS ETES DEJA CLIENT\r\n");
	private JLabel str11 =new JLabel("Pour acc�der � votre compte, veuillez vous identifier.");

	private JPanel champs1=new JPanel();
	private String[] tabString1={"Email","Mot de passe"};
	private JLabel[] tabLabel1 = new JLabel[tabString1.length];
	private JButton[] tabButtonBas1 = new JButton[tabString1.length];

	private JPanel reponse1=new JPanel();

	private JPanel pied1 =new JPanel();
	private String[] tabString11 = {"V A L I D E R","Annuler"};
	private JButton[] tabButton1 = new JButton[tabString1.length];
	private JFormattedTextField[] tabTextField1= new JFormattedTextField[tabString1.length];
	
	
	JPanel nord= new JPanel();
    JPanel sud= new JPanel();
    JPanel ouest= new JPanel();
    JPanel est= new JPanel();
    JPanel centre= new JPanel();
    
	public PDejaClient(){
		
		titre11.add(str1);
		titre12.add(str11);
		titre1.add(titre11);
		titre1.add(titre12);
		titre11.setPreferredSize(new Dimension(300,30));
		titre12.setPreferredSize(new Dimension(300,30));
		titre1.setPreferredSize(new Dimension(600,100));
					
		champs1.setLayout(new GridLayout(2,1,5,5));
		champs1.setPreferredSize(new Dimension(200,56));
		for (int i=0; i<tabString1.length;i++){
			tabLabel1[i]= new JLabel(tabString1[i]);
			tabLabel1[i].setHorizontalAlignment(SwingConstants.RIGHT);
			champs1.add(tabLabel1[i]);
		}

		reponse1.setLayout(new GridLayout(2,1,10,10));
		reponse1.setPreferredSize(new Dimension(300,56));
		for (int i=0;i<tabString1.length;i++){
			getTabTextField1()[i]= new JFormattedTextField();
			getTabTextField1()[i].setPreferredSize(new Dimension(30,30));
			getTabTextField1()[i].setHorizontalAlignment(SwingConstants.LEFT);
			reponse1.add(getTabTextField1()[i]);
		}
		
		nord.setPreferredSize(new Dimension(590,50));
		sud.setPreferredSize(new Dimension(590,50));
		est.setPreferredSize(new Dimension(50,590));
		ouest.setPreferredSize(new Dimension(50,590));
		
		this.add(titre1, BorderLayout.NORTH);
		this.add(champs1, BorderLayout.CENTER);
		this.add(reponse1, BorderLayout.EAST);
		this.add(pied1, BorderLayout.SOUTH);
	}

	public JFormattedTextField[] getTabTextField1() {
		return tabTextField1;
	}

	public void setTabTextField1(JFormattedTextField[] tabTextField1) {
		this.tabTextField1 = tabTextField1;
	}
}
