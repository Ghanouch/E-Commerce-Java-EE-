package com.cdg.eboutique.metier;

import java.util.List;

import com.cdg.eboutique.entities.Categorie;
import com.cdg.eboutique.entities.Role;
import com.cdg.eboutique.entities.User;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier {

	public Long ajouterCategorie(Categorie c );
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	
	public void ajouterUser(User u );
	public void attribueRole(User u, Role e);
	
}
