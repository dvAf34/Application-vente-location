package test;
import org.junit.Test;


import article.FenetrePrincipale;
import article.Item;

import static org.junit.Assert.assertNotNull;
public class testArticle {
	


	   FenetrePrincipale f1= new FenetrePrincipale();


	   @Test
	  
	   public void article() {
			  
		   Item it = new Item(null,"palmes","description",16.0,200,0,null);
		   
		   
		   assertNotNull(it.getStock());
		   
	      
	   }
	}

