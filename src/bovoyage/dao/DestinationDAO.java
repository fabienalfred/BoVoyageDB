package bovoyage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bovoyage.metier.Destination;

public class DestinationDAO {

	private EntityManager em;
	
	
	public DestinationDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bovoyage");
		em = emf.createEntityManager();
	}
	
	@Deprecated
	@SuppressWarnings("unchecked")
	public List<Destination> getDestinations(){
		Query query = em.createNamedQuery("Destination.getDestinations");
		return query.getResultList();
	}
	
	public Destination getDestinationById(int id){
		return em.find(Destination.class, id);
	}
	
	@Deprecated
	@SuppressWarnings("unchecked")
	public List<Destination> getDestinationsById(int id){
		Query query = em.createNamedQuery("Destination.getDestinationsById");
		query.setParameter("id", id);
		return query.getResultList();
	}
	
}
