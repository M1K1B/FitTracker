package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Pogadja database table.
 * 
 */
@Entity
@NamedQuery(name="Pogadja.findAll", query="SELECT p FROM Pogadja p")
public class Pogadja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPogadja;

	//bi-directional many-to-one association to Misici
	@ManyToOne
	@JoinColumn(name="idMisica")
	private Misici misici;

	//bi-directional many-to-one association to Vezbe
	@ManyToOne
	@JoinColumn(name="idVezbe")
	private Vezbe vezbe;

	public Pogadja() {
	}

	public int getIdPogadja() {
		return this.idPogadja;
	}

	public void setIdPogadja(int idPogadja) {
		this.idPogadja = idPogadja;
	}

	public Misici getMisici() {
		return this.misici;
	}

	public void setMisici(Misici misici) {
		this.misici = misici;
	}

	public Vezbe getVezbe() {
		return this.vezbe;
	}

	public void setVezbe(Vezbe vezbe) {
		this.vezbe = vezbe;
	}

}