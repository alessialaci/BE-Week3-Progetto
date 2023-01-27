package dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
	public void searchPrestatiByNumUtente(long tessera) {
		try {
			t.begin();

			Query query = em.createNamedQuery("searchPrestatiByNumUtente");
			query.setParameter("tessera", tessera);
			List<Prestito> results = query.getResultList();

			t.commit();
			System.out.println("Elementi attualmente in prestito dato un numero di tessera utente:");
			if(results.isEmpty()) {
				logger.error("Nessun elemento trovato!");
			} else {
				for(Prestito pr : results) {
					System.out.println(pr);
				}
			}

		} catch (Exception ex) {
			logger.error("Errore nella ricerca");
			em.getTransaction().rollback();
			throw ex;
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
