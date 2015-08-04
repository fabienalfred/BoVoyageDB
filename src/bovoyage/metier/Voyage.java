package bovoyage.metier;

import java.util.ArrayList;
import java.util.List;

public class Voyage {

	private String region;
	private DateVoyage dateVoyage;
	private int nbPlaces;
	private List<Voyageur> voyageurs = new ArrayList<Voyageur>();
	
	
	public Voyage() {
	}

	public Voyage(String region, DateVoyage dateVoyage, int nbPlaces) {
		this.region = region;
		this.dateVoyage = dateVoyage;
		this.nbPlaces = nbPlaces;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public DateVoyage getDateVoyage() {
		return dateVoyage;
	}

	public void setDateVoyage(DateVoyage dateVoyage) {
		this.dateVoyage = dateVoyage;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public List<Voyageur> getVoyageurs() {
		return voyageurs;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
