package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "prestiti")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "searchPrestatiByNumUtente", query = "SELECT p FROM Prestito p WHERE p.numTessera = :tessera AND p.restituzioneEffettiva IS NULL")
@NamedQuery(name = "searchPrestitiScaduti", query = "SELECT p FROM Prestito p WHERE p.restituzioneEffettiva IS NULL AND p.restituzionePrevista < CURRENT_DATE")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private long numTessera;
	
	@Column(name = "elemento_prestato")
	private String elemPrestato;

	@Column(name = "inizio_prestito")
	private LocalDate inizioPrestito;
	
	@Column(name = "restituzione_prevista")
	private LocalDate restituzionePrevista;
	
	@Column(name = "restituzione_effettiva")
	private LocalDate restituzioneEffettiva;

	public Prestito(long numTessera, ElementoBiblioteca elemPrestato, LocalDate inizioPrestito, LocalDate restituzioneEffettiva) {
		this.numTessera = numTessera;
		this.elemPrestato = elemPrestato.getTitolo();
		this.inizioPrestito = inizioPrestito;
		this.restituzionePrevista = this.setRestituzionePrevista(inizioPrestito);
		this.restituzioneEffettiva = restituzioneEffettiva;
	}
	
	public Prestito(long numTessera, ElementoBiblioteca elemPrestato, LocalDate inizioPrestito) {
		this.numTessera = numTessera;
		this.elemPrestato = elemPrestato.getTitolo();
		this.inizioPrestito = inizioPrestito;
		this.restituzionePrevista = this.setRestituzionePrevista(inizioPrestito);
	}
	

	public LocalDate setRestituzionePrevista(LocalDate restituzionePrevista) {
		return this.restituzionePrevista = this.inizioPrestito.plusDays(30);
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", numeroUtente=" + numTessera + ", elemPrestato=" + elemPrestato
				+ ", inizioPrestito=" + inizioPrestito + ", restituzionePrevista=" + restituzionePrevista
				+ ", restituzioneEffettiva=" + restituzioneEffettiva + "]";
	}
	
}
