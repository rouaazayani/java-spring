package net.itbs.spring.data.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 4,max = 15)
	private String designation;
	@DecimalMin("200")
	private double prix;
	private int quantite;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", prix=" + prix + ", quantite=" + quantite + "]";
	}
	public Produit(@NotNull @Size(min = 4, max = 15) String designation, @DecimalMin("200") double prix, int quantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Produit(Long id, @NotNull @Size(min = 4, max = 15) String designation, @DecimalMin("200") double prix,
			int quantite) {
		super();
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Produit() {
		super();
	}
	
}
