package com.cdg.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name ="users" )
public class User implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="user_id")
	private Long idUser;
	private String nomUser;
	private String passwd;
	private boolean activated;
	
		@OneToMany
		@JoinColumn(name="user_id")
	private Collection<Role> roles;
	public User(String nomUser, String passwd, boolean activated) {
		super();
		this.nomUser = nomUser;
		this.passwd = passwd;
		this.activated = activated;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public User() {
		super();
	}
	public User(Long idUser, String nomUser, String passwd, boolean activated, Collection<Role> roles) {
		super();
		this.idUser = idUser;
		this.nomUser = nomUser;
		this.passwd = passwd;
		this.activated = activated;
		this.roles = roles;
	}
	
	
	
	
}
