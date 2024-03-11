package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Omiljene database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljene.findAll", query="SELECT o FROM Omiljene o")
public class Omiljene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOmiljene;

	//bi-directional many-to-one association to Korisnici
	@ManyToOne
	@JoinColumn(name="idKorisnika")
	private Korisnici korisnici;

	//bi-directional many-to-one association to Vezbe
	@ManyToOne
	@JoinColumn(name="idVezbe")
	private Vezbe vezbe;

	public Omiljene() {
	}

	public int getIdOmiljene() {
		return this.idOmiljene;
	}

	public void setIdOmiljene(int idOmiljene) {
		this.idOmiljene = idOmiljene;
	}

	public Korisnici getKorisnici() {
		return this.korisnici;
	}

	public void setKorisnici(Korisnici korisnici) {
		this.korisnici = korisnici;
	}

	public Vezbe getVezbe() {
		return this.vezbe;
	}

	public void setVezbe(Vezbe vezbe) {
		this.vezbe = vezbe;
	}

}