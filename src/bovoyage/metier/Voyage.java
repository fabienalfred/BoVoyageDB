package bovoyage.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bovoyage.entites.DatesVoyage;

public class Voyage implements Serializable {

	private String region;
	private DatesVoyage datesVoyage;
	private int nbPlaces;
	private List<Voyageur> voyageurs = new ArrayList<Voyageur>();
	
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public DatesVoyage getDatesVoyage() {
		return datesVoyage;
	}

	public void setDatesVoyage(DatesVoyage dateVoyage) {
		this.datesVoyage = dateVoyage;
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
