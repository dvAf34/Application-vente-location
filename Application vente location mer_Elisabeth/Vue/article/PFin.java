package article;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PFin extends JPanel {

	JPanel nord= new JPanel();
    JPanel sud= new JPanel();
    JPanel ouest= new JPanel();
    JPanel est= new JPanel();
    JPanel centre= new JPanel();
    
	public PFin(FenetrePanier fen){
		
		JLabel label = new JLabel("Recapitulatif");
		
		nord.add(label);
		
		
		centre.add(fen.panel1);
		
		nord.setPreferredSize(new Dimension(590,50));
		sud.setPreferredSize(new Dimension(590,50));
		est.setPreferredSize(new Dimension(50,590));
		ouest.setPreferredSize(new Dimension(50,590));
		
		this.add(nord, BorderLayout.NORTH);
		this.add(est, BorderLayout.EAST);
		this.add(centre, BorderLayout.CENTER);
		this.add(ouest, BorderLayout.WEST);
		this.add(sud, BorderLayout.SOUTH);
	}
}
