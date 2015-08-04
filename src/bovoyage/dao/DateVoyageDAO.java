package bovoyage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bovoyage.metier.DateVoyage;

public class DateVoyageDAO {

	private EntityManager em;
	
	
	public DateVoyageDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bovoyage");
		em = emf.createEntityManager();
	}
	
	public DateVoyage getVoyageById(int id){
		return em.find(DateVoyage.class, id);
	}
	
	@Deprecated
	@SuppressWarnings("unchecked")
	public List<DateVoyage> getVoyagesById(int id){
		Query query = em.createNamedQuery("DateVoyage.getVoyageById");
		query.setParameter("idDV", id);
		return query.getResultList();
	}
	
}
