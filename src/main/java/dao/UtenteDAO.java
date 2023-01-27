package dao;

import entities.Utente;
import utils.JpaUtils;

public class UtenteDAO extends JpaUtils {
	
	public void save(Utente ut) {
		try {
			t.begin();
			em.persist(ut);
			t.commit();
			
			System.out.println("Utente inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento dell'Utente");
		}
	}
	
}
