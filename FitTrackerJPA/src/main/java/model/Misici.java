package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the Misici database table.
 * 
 */
@Entity
@NamedQuery(name="Misici.findAll", query="SELECT m FROM Misici m")
public class Misici implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMisica;

	private String naziv;

	//bi-directional many-to-one association to Pogadja
	@OneToMany(mappedBy="misici")
	private List<Pogadja> pogadjas;

	public Misici() {
	}

	public int getIdMisica() {
		return this.idMisica;
	}

	public void setIdMisica(int idMisica) {
		this.idMisica = idMisica;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Pogadja> getPogadjas() {
		return this.pogadjas;
	}

	public void setPogadjas(List<Pogadja> pogadjas) {
		this.pogadjas = pogadjas;
	}

	public Pogadja addPogadja(Pogadja pogadja) {
		getPogadjas().add(pogadja);
		pogadja.setMisici(this);

		return pogadja;
	}

	public Pogadja removePogadja(Pogadja pogadja) {
		getPogadjas().remove(pogadja);
		pogadja.setMisici(null);

		return pogadja;
	}

}