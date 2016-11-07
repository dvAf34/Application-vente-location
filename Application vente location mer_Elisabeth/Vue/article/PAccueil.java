package article;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PAccueil extends JPanel {		// accueil

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel nord= new JPanel();

	public PAccueil(){
		JLabel label = new JLabel("Pour valider votre commande, veuillez vous identifier.");
		nord.add(label);
		
		nord.setPreferredSize(new Dimension(590,50));

		this.add(nord, BorderLayout.NORTH);

	}
}
