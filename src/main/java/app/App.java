package app;

import java.time.LocalDate;

import dao.ElementoDAO;
import dao.PrestitoDAO;
import dao.UtenteDAO;
import entities.ElementoBiblioteca;
import entities.Libro;
import entities.Prestito;
import entities.Rivista;
import entities.Utente;
import enums.Periodicita;

public class App {

	public static void main(String[] args) {
		
		// Istanziamento classi
		Libro lib = new Libro("Titolo libro 1", 2010, 450, "Mario", "Horror");
		Rivista riv = new Rivista("Titolo rivista 20", 2015, 88, Periodicita.MENSILE);
		Utente ut = new Utente("Alessia", "Lacitignola", LocalDate.parse("1998-04-21"));
		Prestito pr = new Prestito(ut, riv, LocalDate.parse("2022-12-12"));
		
		// Creazione Tabelle
		//ElementoBiblioteca el1 = saveElemento(lib);
		//ElementoBiblioteca el2 = saveElemento(riv);
		//Utente u = saveUtente(ut);
		//Prestito p = savePrestito(pr);
		
		// Metodi
		//deleteElementoByIsbn(450000000000050L);
		
		//searchByIsbn(450000000000050L);
		//searchByAnno(2015);
		//searchByAutore("Mario");
		//searchByTitolo("ivista");
		
		//searchPrestatiByNumUtente(3); //NON VA
		//searchPrestitiScaduti();

	}
	
	private static ElementoBiblioteca saveElemento(ElementoBiblioteca eb) {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.save(eb);
		return eb;
	}
	
	private static Utente saveUtente(Utente ut) {
		UtenteDAO utenteDAO = new UtenteDAO();
		utenteDAO.save(ut);
		return ut;
	}
	
	private static Prestito savePrestito(Prestito pr) {
		PrestitoDAO prestitoDAO = new PrestitoDAO();
		prestitoDAO.save(pr);
		return pr;
	}
	
	private static void deleteElementoByIsbn(long isbn) {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.deleteByIsbn(isbn);
	}
	
	private static void searchByIsbn(long isbn) {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.searchByIsbn(isbn);
	}
	
	private static void searchByAutore(String autore) {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.searchByAutore(autore);
	}

	private static void searchByAnno(int anno) {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.searchByAnno(anno);
	}
	
	private static void searchByTitolo(String titolo) {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.searchByTitolo(titolo);
	}
	
	private static void searchPrestatiByNumUtente(long numTessera) {
		PrestitoDAO prestitoDAO = new PrestitoDAO();
		prestitoDAO.searchPrestatiByNumUtente(numTessera);
	}
	
	private static void searchPrestitiScaduti() {
		PrestitoDAO prestitoDAO = new PrestitoDAO();
		prestitoDAO.searchPrestitiScaduti();
	}

}
