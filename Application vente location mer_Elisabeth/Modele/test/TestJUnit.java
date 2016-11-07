package test;

import org.junit.Test;


import article.FenetrePrincipale;
import article.Item;

import static org.junit.Assert.assertNotNull;

public class TestJUnit {

   FenetrePrincipale f1= new FenetrePrincipale();


   @Test
   public void testquantite() {
	  
	   String qte = f1.qte.getText();
	   qte="1";
	   
	   assertNotNull(qte);
	   
      
   }
   
  
}