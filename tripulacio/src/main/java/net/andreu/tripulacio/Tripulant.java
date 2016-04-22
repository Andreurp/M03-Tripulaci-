package net.andreu.tripulacio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tripulant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int dni;
	private String nom;
	private String rang;
	
	public Tripulant(){
		super();
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRang() {
		return rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	
	
}
