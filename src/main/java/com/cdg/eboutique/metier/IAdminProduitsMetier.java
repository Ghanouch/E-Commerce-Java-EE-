package com.cdg.eboutique.metier;

import java.util.List;

import com.cdg.eboutique.entities.Produit;

public interface IAdminProduitsMetier extends InternauteMetier {

	public Long ajouterProduit(Produit p, Long  IdCat);
	public void supprimerProduit(Long idPro);
	public void modifierProduit(Produit p);
	
}
