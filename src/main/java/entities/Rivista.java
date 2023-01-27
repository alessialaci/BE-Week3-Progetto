package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import enums.Periodicita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@DiscriminatorValue("Rivista")
@Table(name = "riviste")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rivista extends ElementoBiblioteca {
	
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Rivista(String titolo, int annoPubblicazione, int nPagine, Periodicita periodicita) {
		super(titolo, annoPubblicazione, nPagine);
		this.periodicita = periodicita;
	}
	
	@Override
	public String toString() {
		return "Rivista: CodiceIsbn = " + getCodiceIsbn() +", titolo = " + getTitolo() + ", anno pubblicazione = " + getAnnoPubblicazione() + ", numero pagine = " + getNPagine() + ", periodicità = " + periodicita;
	}

}
