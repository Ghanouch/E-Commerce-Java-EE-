package com.cdg.eboutique.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cdg.eboutique.dao.IBoutiqueDao;
import com.cdg.eboutique.entities.Categorie;
import com.cdg.eboutique.entities.Client;
import com.cdg.eboutique.entities.Commande;
import com.cdg.eboutique.entities.Panier;
import com.cdg.eboutique.entities.Produit;
import com.cdg.eboutique.entities.Role;
import com.cdg.eboutique.entities.User;

@Transactional
public class BoutiqueMetierImpl implements IAdminCategoriesMetier {

	private IBoutiqueDao dao;
	
	@Override
	public Long ajouterProduit(Produit p, Long IdCat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p,IdCat);
	}

	@Override
	public void supprimerProduit(Long idPro) {
		dao.supprimerProduit(idPro);
		
	}

	@Override
	public void modifierProduit(Produit p) {
		dao.modifierProduit(p);
		
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idC) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idC);
	}

	@Override
	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		return dao.listProduits();
	}

	@Override
	public List<Produit> listProduitsParMc(String mc) {
		// TODO Auto-generated method stub
		return dao.listProduitsParMc(mc);
	}

	@Override
	public List<Produit> listProduitsSelectionne() {
		// TODO Auto-generated method stub
		return dao.listProduitsSelectionne();
	}

	@Override
	public List<Produit> listProduitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.listProduitsParCategorie(idCat);
	}

	@Override
	public Produit getProduit(Long idPro) {
		// TODO Auto-generated method stub
		return dao.getProduit(idPro);
	}

	@Override
	public Commande enrigistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return dao.enrigistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		// TODO Auto-generated method stub
		dao.supprimerCategorie(idCat);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		dao.modifierCategorie(c);
	}

	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		dao.ajouterUser(u);
	}

	@Override
	public void attribueRole(User u, Role e) {
		// TODO Auto-generated method stub
		dao.attribueRole(u, e);
	}

	public IBoutiqueDao getDao() {
		return dao;
	}

	public void setDao(IBoutiqueDao dao) {
		this.dao = dao;
	}

	
}
