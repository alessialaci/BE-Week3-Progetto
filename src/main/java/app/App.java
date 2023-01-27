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
		
		Libro lib = new Libro("Titolo libro 5", 2013, 400, "Mary", "Fantasy");
		Rivista riv = new Rivista("Titolo rivista 22", 2015, 100, Periodicita.SEMESTRALE);
		Utente ut = new Utente("Peach", "Ciclamini", LocalDate.parse("1995-05-11"));
		Prestito pr = new Prestito(ut, riv, LocalDate.parse("2023-01-28"));
		
		//ElementoBiblioteca el = saveElemento(riv);
		//Utente u = saveUtente(ut);
		//Prestito p = savePrestito(pr);
		//deleteElementoByIsbn();
		
		//searchByAutore("Mario");
		//searchByAnno(2014);
		//searchByTitolo("ibro");
		
		//searchPrestatiByNumUtente(3); //NON FUNZIONAAAAAAAAAA
		searchPrestitiScaduti();

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
	
	private static void deleteElementoByIsbn() {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.deleteByIsbn(300);
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
