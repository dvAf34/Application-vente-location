package article;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class Panel1 extends JPanel {

	BufferedImage fond;
	Image fond2;
	
	public Panel1()
	{
	try {
		fond = ImageIO.read(new File("plongee.jpg"));
		fond2=fond.getScaledInstance(900,730,BufferedImage.SCALE_DEFAULT );
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(fond2, 0, 0, null);
		
	}
	
	
	
	
}
