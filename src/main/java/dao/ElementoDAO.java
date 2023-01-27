package dao;

import java.util.List;

import javax.persistence.Query;

import entities.ElementoBiblioteca;
import entities.Libro;
import utils.JpaUtils;


public class ElementoDAO extends JpaUtils {

	// Metodo per salvare gli elementi sul database
	public void save(ElementoBiblioteca eb) {
		try {
			t.begin();
			em.persist(eb);
			t.commit();
			logger.info("Elemento inserito correttamente");
		}
		catch(Exception e) {
			logger.error("Errore nell'inserimento dell'Elemento");
		}
	}
	
	
	// Metodo Rimozione di un elemento del catalogo dato un codice ISBN
	public void deleteByIsbn(long isbn) {
		ElementoBiblioteca eb = em.find(ElementoBiblioteca.class, isbn);
		
		if(eb == null) {
			System.out.println("Elemento non trovato");
			return;
		}
		
		try {
			t.begin();
			em.remove(eb);
			t.commit();
			logger.info("Elemento eliminato");
		}
		catch(Exception e) {
			logger.error("Errore nell'eliminazione dell'Elemento");
		}
	}
	
	
	// Metodo Rimozione di un elemento del catalogo dato un codice ISBN
	public void searchByIsbn(long isbn) {
		ElementoBiblioteca eb = em.find(ElementoBiblioteca.class, isbn);
		
		if(eb == null) {
			logger.error("Elemento non trovato");
			return;
		}
		
		System.out.println("Dati Elemento con codice " + isbn);
		System.out.printf("Titolo: %s, Anno pubblicazione: %d, Pagine: %d%n", eb.getTitolo(), eb.getAnnoPubblicazione(), eb.getNPagine());
	}
	
	// Metodo Ricerca elemento per anno pubblicazione con NamedQuery
	public void searchByAnno(int anno) {
		try {
			Query q = em.createNamedQuery("searchByAnno");
			q.setParameter("anno", anno);
			
			List<ElementoBiblioteca> results = q.getResultList();
			
			System.out.println("Ricerca elemento per anno pubblicazione:");
	
			if(results.isEmpty()) {
				logger.error("Nessun elemento trovato");
			} else {
				for(ElementoBiblioteca el : results) {
					System.out.println(el);
				}
			}
		} catch(Exception e) {
			logger.error("Errore nella ricerca");
		} finally {
			em.close();
		}
	}
	
	
	// Metodo Ricerca elemento per autore con Named Query
	public void searchByAutore(String autore) {
		try {
			Query q = em.createNamedQuery("searchByAutore");
			q.setParameter("autore", autore);
			
			List<Libro> results = q.getResultList();
			
			System.out.println("Ricerca elemento per autore:");
			
			if(results.isEmpty()) {
				logger.error("Nessun elemento trovato");
			} else {
				for(Libro l : results) {
					System.out.println(l);
				}
			}
		} catch(Exception e) {
			logger.error("Errore nella ricerca");
		} finally {
			em.close();
		}
	}
	
	
	// Metodo Ricerca per titolo o parte di esso
	public void searchByTitolo(String titolo) {
		try {
			Query q = em.createNamedQuery("searchByTitolo");
			q.setParameter("titolo", "%" + titolo + "%");
			
			List<ElementoBiblioteca> results = q.getResultList();
			
			System.out.println("Ricerca per titolo o parte di esso:");
			
			if(results.isEmpty()) {
				logger.error("Nessun elemento trovato");
			} else {
				for(ElementoBiblioteca e : results) {
					System.out.println(e);
				}
			}
		} catch(Exception e) {
			logger.error("Errore nella ricerca");
		} finally {
			em.close();
		}
	}
	
}
