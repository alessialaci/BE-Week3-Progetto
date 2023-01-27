package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@DiscriminatorValue("Libro")
@Table(name = "libri")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "searchByAutore", query = "SELECT l FROM Libro l WHERE l.autore = :autore")
public class Libro extends ElementoBiblioteca {
	
	private String autore;
	private String genere;
	
	public Libro(String titolo, int annoPubblicazione, int nPagine, String autore, String genere) {
		super(titolo, annoPubblicazione, nPagine);
		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro: CodiceIsbn = " + getCodiceIsbn() +", titolo = " + getTitolo() + ", autore = " + autore + ", genere = " + genere
				+ ", anno pubblicazione = " + getAnnoPubblicazione() + ", numero pagine = " + getNPagine();
	}
	
}
