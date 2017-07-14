package com.cdg.eboutique.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cdg.eboutique.entities.Categorie;
import com.cdg.eboutique.entities.Client;
import com.cdg.eboutique.entities.Commande;
import com.cdg.eboutique.entities.LigneCommande;
import com.cdg.eboutique.entities.Panier;
import com.cdg.eboutique.entities.Produit;
import com.cdg.eboutique.entities.Role;
import com.cdg.eboutique.entities.User;

public class BoutiqueDaoImp implements IBoutiqueDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Categorie c").getResultList();
	}

	@Override
	public Categorie getCategorie(Long idC) {
		// TODO Auto-generated method stub
		return em.find(Categorie.class, idC);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		// TODO Auto-generated method stub
		Categorie c = getCategorie(idCat);
		em.remove(c);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
		
	}

	@Override
	public Long ajouterProduit(Produit p, Long IdCat) {
		// TODO Auto-generated method stub
		p.setCategorie(getCategorie(IdCat));
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		return em.createQuery("from Produit").getResultList();
	}

	@Override
	public List<Produit> listProduitsParMc(String mc) {
		// TODO Auto-generated method stub
		Query query =  em.createQuery("select p from Produit p where p.designation like :x or description like :x");
		query.setParameter("x","%"+ mc + "%");
		return query.getResultList();
	}
	
	@Override
	public List<Produit> listProduitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
	  Query q = em.createQuery("select p from Produit p where  p.idCategorie = :x");
	  q.setParameter("x", idCat);
	  return q.getResultList();
	}

	@Override
	public List<Produit> listProduitsSelectionne() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Produit p where  p.selectionne = true").getResultList();
	}

	@Override
	public Produit getProduit(Long idPro) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, idPro);
	}

	@Override
	public void supprimerProduit(Long idPro) {
		 em.remove(getProduit(idPro));
		
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
		
	}

	@Override
	public void ajouterUser(User u) {
		em.persist(u);
		
	}

	@Override
	public void attribueRole(User u, Role e) {
		em.persist(e);
		u.getRoles().add(e) ;
		em.persist(u);
		
	}

	@Override
	public Commande enrigistrerCommande(Panier p, Client client) {
		// TODO Auto-generated method stub
		em.persist(client);
		Commande c = new Commande();
		c.setClient(client);
		c.setLignes(p.getCommandes());
		c.setDateCommande(new Date());
		for(LigneCommande lc : p.getCommandes())
			em.persist(lc);
		em.persist(c);
		return c;
	}

	

	

	

}
