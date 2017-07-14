package com.cdg.eboutique.metier;

import java.util.List;

import com.cdg.eboutique.entities.Categorie;
import com.cdg.eboutique.entities.Client;
import com.cdg.eboutique.entities.Commande;
import com.cdg.eboutique.entities.Panier;
import com.cdg.eboutique.entities.Produit;

public interface InternauteMetier {

	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idC);
	public List<Produit> listProduits();
	public List<Produit> listProduitsParMc(String mc);
	public List<Produit> listProduitsSelectionne();
	public List<Produit> listProduitsParCategorie(Long idCat);
	public Produit getProduit(Long idPro);
	public Commande enrigistrerCommande(Panier p , Client c);

}
