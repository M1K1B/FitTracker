package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Korisnici database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnici.findAll", query="SELECT k FROM Korisnici k")
public class Korisnici implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnika;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumRodjenja;

	private String email;

	private String ime;

	private String lozinka;

	private String prezime;

	private double tezina;

	private double visina;

	//bi-directional many-to-one association to Omiljene
	@OneToMany(mappedBy="korisnici")
	private List<Omiljene> omiljenes;

	//bi-directional many-to-one association to Treninzi
	@OneToMany(mappedBy="korisnici")
	private List<Treninzi> treninzis;

	public Korisnici() {
	}

	public int getIdKorisnika() {
		return this.idKorisnika;
	}

	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getLozinka() {
		return this.lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public double getTezina() {
		return this.tezina;
	}

	public void setTezina(double tezina) {
		this.tezina = tezina;
	}

	public double getVisina() {
		return this.visina;
	}

	public void setVisina(double visina) {
		this.visina = visina;
	}

	public List<Omiljene> getOmiljenes() {
		return this.omiljenes;
	}

	public void setOmiljenes(List<Omiljene> omiljenes) {
		this.omiljenes = omiljenes;
	}

	public Omiljene addOmiljene(Omiljene omiljene) {
		getOmiljenes().add(omiljene);
		omiljene.setKorisnici(this);

		return omiljene;
	}

	public Omiljene removeOmiljene(Omiljene omiljene) {
		getOmiljenes().remove(omiljene);
		omiljene.setKorisnici(null);

		return omiljene;
	}

	public List<Treninzi> getTreninzis() {
		return this.treninzis;
	}

	public void setTreninzis(List<Treninzi> treninzis) {
		this.treninzis = treninzis;
	}

	public Treninzi addTreninzi(Treninzi treninzi) {
		getTreninzis().add(treninzi);
		treninzi.setKorisnici(this);

		return treninzi;
	}

	public Treninzi removeTreninzi(Treninzi treninzi) {
		getTreninzis().remove(treninzi);
		treninzi.setKorisnici(null);

		return treninzi;
	}

}