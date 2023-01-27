package dao;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Prestito;
import utils.JpaUtils;


public class PrestitoDAO extends JpaUtils {
	
	// Metodo per salvare il prestito sul database
	public void save(Prestito pr) {
		try {
			t.begin();
			em.persist(pr);
			t.commit();
			
			logger.info("Prestito inserito correttamente!");
		}
		catch(Exception e) {
			logger.error("Errore nell'inserimento del Prestito");
		}
	}
	
	// Metodo Ricerca degli elementi attualmente in prestito dato un numero di tessera utente con NamedQuery
	public void searchPrestatiByNumUtente(long numTessera) {
		try {
			Query q = em.createNamedQuery("searchPrestatiByNumUtente");
			q.setParameter("numTessera", numTessera);
			
			List<Prestito> results = q.getResultList();
			
			System.out.println("Ricerca degli elementi attualmente in prestito dato un numero di tessera utente:");
			
			if(results.isEmpty()) {
				logger.error("Nessun elemento trovato!");
			} else {
				for(Prestito pr : results) {
					System.out.println(pr);
				}
			}
		} catch(Exception e) {
			logger.error("Errore nella ricerca");
		}
	}
	
	// Metodo Ricerca di tutti i prestiti scaduti e non ancora restituiti con NamedQuery
	public void searchPrestitiScaduti() {
		try {
			Query q = em.createNamedQuery("searchPrestitiScaduti");
			
			List<Prestito> results = q.getResultList();
			
			System.out.println("Ricerca di tutti i prestiti scaduti e non ancora restituiti:");
			
			if(results.isEmpty()) {
				logger.error("Nessun elemento trovato!");
			} else {
				for(Prestito pr : results) {
					System.out.println(pr);
				}
			}
		} catch(Exception e) {
			logger.error("Errore nella ricerca");
		}
	}
	
}
