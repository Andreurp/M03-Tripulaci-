package net.andreu.tripulacio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tripulant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String dni;
	private String nom;
	private String rang;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="matricula_vaixell")
	private Vaixell vaxeill;
	
	public Tripulant(){
		super();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
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

	public Vaixell getVaxeill() {
		return vaxeill;
	}

	public void setVaxeill(Vaixell vaxeill) {
		this.vaxeill = vaxeill;
	}
	
	
}
