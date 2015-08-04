package bovoyage.metier;

public class Voyage {

	private String region;
	private DateVoyage dateVoyage;
	private int nbPlaces;

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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
