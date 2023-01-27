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
		Libro lib = new Libro("Harry Potter", 2000, 651, "Rowling", "Fantasy");
		Rivista riv = new Rivista("Libero", 2022, 57, Periodicita.SETTIMANALE);
		Utente ut = new Utente("Alessia", "Lacitignola", LocalDate.parse("1998-04-21"));
		Prestito pr1 = new Prestito(1, riv, LocalDate.parse("2022-12-12"), LocalDate.parse("2023-01-10"));
		Prestito pr2 = new Prestito(1, lib, LocalDate.parse("2022-12-12"));
		
		// Creazione Tabelle
		//saveElemento(lib);
		//saveElemento(riv);
		//saveUtente(ut);
		//savePrestito(pr1);
		//savePrestito(pr2);
		
		// Metodi
		//deleteElementoByIsbn(450000000000350L);
		
		//searchByIsbn(450000000000400L);
		//searchByAnno(2022);
		//searchByAutore("Rowling");
		//searchByTitolo("Harry");
		
		//searchPrestatiByNumUtente(1);
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
