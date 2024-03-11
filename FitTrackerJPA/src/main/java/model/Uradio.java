package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Uradio database table.
 * 
 */
@Entity
@NamedQuery(name="Uradio.findAll", query="SELECT u FROM Uradio u")
public class Uradio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUradio;

	private int brPonavljanja;

	private int brSerija;

	//bi-directional many-to-one association to Treninzi
	@ManyToOne
	@JoinColumn(name="idTreninga")
	private Treninzi treninzi;

	//bi-directional many-to-one association to Vezbe
	@ManyToOne
	@JoinColumn(name="idVezbe")
	private Vezbe vezbe;

	public Uradio() {
	}

	public int getIdUradio() {
		return this.idUradio;
	}

	public void setIdUradio(int idUradio) {
		this.idUradio = idUradio;
	}

	public int getBrPonavljanja() {
		return this.brPonavljanja;
	}

	public void setBrPonavljanja(int brPonavljanja) {
		this.brPonavljanja = brPonavljanja;
	}

	public int getBrSerija() {
		return this.brSerija;
	}

	public void setBrSerija(int brSerija) {
		this.brSerija = brSerija;
	}

	public Treninzi getTreninzi() {
		return this.treninzi;
	}

	public void setTreninzi(Treninzi treninzi) {
		this.treninzi = treninzi;
	}

	public Vezbe getVezbe() {
		return this.vezbe;
	}

	public void setVezbe(Vezbe vezbe) {
		this.vezbe = vezbe;
	}

}