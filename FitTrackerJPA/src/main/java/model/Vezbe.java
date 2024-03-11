package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the Vezbe database table.
 * 
 */
@Entity
@NamedQuery(name="Vezbe.findAll", query="SELECT v FROM Vezbe v")
public class Vezbe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVezbe;

	private String naziv;

	private int ocena;

	private String opis;

	private String slika;

	//bi-directional many-to-one association to Omiljene
	@OneToMany(mappedBy="vezbe")
	private List<Omiljene> omiljenes;

	//bi-directional many-to-one association to Pogadja
	@OneToMany(mappedBy="vezbe")
	private List<Pogadja> pogadjas;

	//bi-directional many-to-one association to Uradio
	@OneToMany(mappedBy="vezbe")
	private List<Uradio> uradios;

	public Vezbe() {
	}

	public int getIdVezbe() {
		return this.idVezbe;
	}

	public void setIdVezbe(int idVezbe) {
		this.idVezbe = idVezbe;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getSlika() {
		return this.slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public List<Omiljene> getOmiljenes() {
		return this.omiljenes;
	}

	public void setOmiljenes(List<Omiljene> omiljenes) {
		this.omiljenes = omiljenes;
	}

	public Omiljene addOmiljene(Omiljene omiljene) {
		getOmiljenes().add(omiljene);
		omiljene.setVezbe(this);

		return omiljene;
	}

	public Omiljene removeOmiljene(Omiljene omiljene) {
		getOmiljenes().remove(omiljene);
		omiljene.setVezbe(null);

		return omiljene;
	}

	public List<Pogadja> getPogadjas() {
		return this.pogadjas;
	}

	public void setPogadjas(List<Pogadja> pogadjas) {
		this.pogadjas = pogadjas;
	}

	public Pogadja addPogadja(Pogadja pogadja) {
		getPogadjas().add(pogadja);
		pogadja.setVezbe(this);

		return pogadja;
	}

	public Pogadja removePogadja(Pogadja pogadja) {
		getPogadjas().remove(pogadja);
		pogadja.setVezbe(null);

		return pogadja;
	}

	public List<Uradio> getUradios() {
		return this.uradios;
	}

	public void setUradios(List<Uradio> uradios) {
		this.uradios = uradios;
	}

	public Uradio addUradio(Uradio uradio) {
		getUradios().add(uradio);
		uradio.setVezbe(this);

		return uradio;
	}

	public Uradio removeUradio(Uradio uradio) {
		getUradios().remove(uradio);
		uradio.setVezbe(null);

		return uradio;
	}

}