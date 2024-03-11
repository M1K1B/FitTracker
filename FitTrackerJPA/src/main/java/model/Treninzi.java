package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Treninzi database table.
 * 
 */
@Entity
@NamedQuery(name="Treninzi.findAll", query="SELECT t FROM Treninzi t")
public class Treninzi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTreninga;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datum;

	private String naziv;

	//bi-directional many-to-one association to Korisnici
	@ManyToOne
	@JoinColumn(name="idKorisnika")
	private Korisnici korisnici;

	//bi-directional many-to-one association to Uradio
	@OneToMany(mappedBy="treninzi", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Uradio> uradios;

	public Treninzi() {
	}

	public int getIdTreninga() {
		return this.idTreninga;
	}

	public void setIdTreninga(int idTreninga) {
		this.idTreninga = idTreninga;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Korisnici getKorisnici() {
		return this.korisnici;
	}

	public void setKorisnici(Korisnici korisnici) {
		this.korisnici = korisnici;
	}

	public List<Uradio> getUradios() {
		return this.uradios;
	}

	public void setUradios(List<Uradio> uradios) {
		this.uradios = uradios;
	}

	public Uradio addUradio(Uradio uradio) {
		getUradios().add(uradio);
		uradio.setTreninzi(this);

		return uradio;
	}

	public Uradio removeUradio(Uradio uradio) {
		getUradios().remove(uradio);
		uradio.setTreninzi(null);

		return uradio;
	}

}