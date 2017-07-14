package com.cdg.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Client implements Serializable {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
		@Size(min=5 , max = 20)
	private String nomClient;
	private String adress;
		@Email
	private String email;
	private String tel;
	@OneToMany(mappedBy = "client")
	private Collection<Commande> commandes;
	public Client(String nomClient, String adress, String email, String tel) {
		super();
		this.nomClient = nomClient;
		this.adress = adress;
		this.email = email;
		this.tel = tel;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Collection<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	public Client(Long idClient, String nomClient, String adress, String email, String tel,
			Collection<Commande> commandes) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adress = adress;
		this.email = email;
		this.tel = tel;
		this.commandes = commandes;
	}
	public Client() {
		super();
	}
	

	
}
