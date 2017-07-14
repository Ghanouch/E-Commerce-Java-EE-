package com.cdg.eboutique.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande implements Serializable {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLigne;
		@ManyToOne
		@JoinColumn(name = "idCommande")
	private Commande commande;
		@ManyToOne
		@JoinColumn(name = "idProduit")
	private Produit produit;
	private int quantite;
	private double prix;
	
	public Long getIdLigne() {
		return idLigne;
	}
	public void setIdLigne(Long idLigne) {
		this.idLigne = idLigne;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public LigneCommande() {
		super();
	}
	public LigneCommande(Commande commande, Produit produit, int quantite, int prix) {
		super();
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
		this.prix = prix;
	}
	
	
	

}
