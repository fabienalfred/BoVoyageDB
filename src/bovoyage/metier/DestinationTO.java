package bovoyage.metier;

import bovoyage.entites.Destination;

public class DestinationTO {

	private int idDest;
	private String region;
	private String description;
	private String image;

	public DestinationTO(Destination d) {
		this.idDest = d.getIdDest();
		this.region = d.getRegion();
		this.description = d.getDescription();
	}

	public int getIdDest() {
		return idDest;
	}

	public void setIdDest(int id) {
		this.idDest = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
