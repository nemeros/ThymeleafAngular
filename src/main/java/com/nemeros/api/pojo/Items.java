package com.nemeros.api.pojo;

public class Items {
	private long id;
	private String nom;
	
	public Items(){
		
	}
	
	public Items(long id, String nom){
		this.id = id;
		this.nom = nom;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
