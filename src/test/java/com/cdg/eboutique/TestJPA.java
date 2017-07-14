package com.cdg.eboutique;

import static org.junit.Assert.*;

import java.util.List;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdg.eboutique.entities.Categorie;
import com.cdg.eboutique.entities.Produit;
import com.cdg.eboutique.metier.IAdminCategoriesMetier;

public class TestJPA {
	
	ClassPathXmlApplicationContext context;
	
	@Before
	public void setUp()
	{
		context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
	}
	
	@Test
	public void test() {
		
		try{
		IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
		List<Categorie> lisCat1 = metier.listCategories();
		metier.ajouterCategorie(new Categorie("Pc Portable", "Pc New", null, "image.jpg"));
		metier.ajouterCategorie(new Categorie("Pc Poste", "Pc Old", null, "image.jpg"));
		List<Categorie> lisCat2 = metier.listCategories();
		assert(lisCat1.size() + 2 == lisCat2.size());
		
		}catch(Exception e)
		{
			assertTrue(e.getMessage() , false);
		}
	}
	
	@Test
	public void testDAO()
	{
		try{
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
			List<Produit> prods1 = metier.listProduits();
			metier.ajouterProduit(new Produit("HP Compat","decription",15d,15,true,null),1L);
			metier.ajouterProduit(new Produit("AZERTY","decription",15d,15,true,null),1L);
			List<Produit> prods2 = metier.listProduits();
			assert(prods1.size() + 2 == prods2.size());
			
			}catch(Exception e)
			{
				assertTrue(e.getMessage() , false);
			}
	}

}
