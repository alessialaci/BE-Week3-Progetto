package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "archivio")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "archivio_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "searchByAnno", query = "SELECT el FROM ElementoBiblioteca el WHERE el.annoPubblicazione = :anno")
@NamedQuery(name = "searchByTitolo", query = "SELECT el FROM ElementoBiblioteca el WHERE el.titolo LIKE :titolo")
abstract public class ElementoBiblioteca {
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "isbn_seq" )
	@SequenceGenerator( name = "isbn_seq", sequenceName = "isbn_seq" )
	private long codiceIsbn;
	
	private String titolo;

	@Column(name = "anno_pubblicazione")
	private int annoPubblicazione;
	
	private int nPagine;
	
	public ElementoBiblioteca(String titolo, int annoPubblicazione, int nPagine) {
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.nPagine = nPagine;
	}
	
	@Override
	public String toString() {
		return "Codice ISBN = " + this.getCodiceIsbn() + ", titolo = " + this.getTitolo() + ", Anno pubblicazione = " + this.getAnnoPubblicazione() + ", Pagine = " 
	+ this.getNPagine();
	}
	
}
