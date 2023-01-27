package dao;

import entities.Utente;
import utils.JpaUtils;

public class UtenteDAO extends JpaUtils {
	
	public void save(Utente ut) {
		try {
			t.begin();
			em.persist(ut);
			t.commit();
			
			logger.info("Utente inserito correttamente!");
		}
		catch(Exception e) {
			logger.error("Errore nell'inserimento dell'Utente");
		}
	}
	
}
