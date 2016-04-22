package net.andreu.tripulacio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Vaixell {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int matricula;
	private String nom;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="VAIXELL_ID")
	List<Tripulant> tripulants;
	
	public Vaixell(){
		super();
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
	public List<Tripulant> getTripulants() {
		return tripulants;
	}
	
	public void setTripulants(List<Tripulant> tripulants) {
		this.tripulants = tripulants;
	}
}
