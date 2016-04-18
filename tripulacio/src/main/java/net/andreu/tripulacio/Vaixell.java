package net.andreu.tripulacio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vaixell {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int matricula;
	private String nom;
	
	public Vaixell(){
		super();
	}
	public Vaixell(String nom){
		this.nom=nom;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
