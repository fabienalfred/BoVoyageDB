package bovoyage.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bovoyage.entites.DatesVoyage;
import bovoyage.entites.Destination;

public class DestinationDAO {

	private EntityManagerFactory emf;
	
	
	public DestinationDAO() {
		emf = Persistence.createEntityManagerFactory("bovoyage");
	}
	
	@SuppressWarnings("unchecked")
	public List<Destination> getDestinations(){
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Destination.getDestinations");
		List<Destination> destinations = query.getResultList();
		em.close();
		return destinations;
	}
	
	public Destination getDestinationById(int id){
		EntityManager em = emf.createEntityManager();
		Destination d = em.find(Destination.class, id);
		em.close();
		return d;
	}
	
	public List<String> getImages(Destination destination){
		EntityManager em = emf.createEntityManager();
		Destination d = em.merge(destination);
		List<String> images = new ArrayList<>(d.getImages());
		em.close();
		return images;
	}
	
	public List<DatesVoyage> getDatesVoyages(Destination destination){
		EntityManager em = emf.createEntityManager();
		Destination d = em.merge(destination);
		List<DatesVoyage> dates = new ArrayList<>(d.getDatesVoyages());
		em.close();
		return dates;
	}
	
}
