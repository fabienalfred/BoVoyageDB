package bovoyage.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "destinations")
@NamedQueries({ @NamedQuery(name = "Destination.getDestinations", 
							query = "FROM Destination d ORDER BY d.region"),
				@NamedQuery(name = "Destination.getDestinationsById", 
							query = "SELECT d FROM Destination d WHERE d.idDest = :id")})
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kp_destination")
	private int idDest;
	private String region;
	private String description;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ke_destination")
	private List<DatesVoyage> datesVoyages = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name = "images", joinColumns = @JoinColumn(name = "ke_destination"))
	@Column(name = "image")
	private List<String> images = new ArrayList<>();

	public Destination() {
	}

	public int getIdDest() {
		return idDest;
	}

	public void setIdDest(int idDest) {
		this.idDest = idDest;
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

	public List<DatesVoyage> getDatesVoyages() {
		return datesVoyages;
	}

	public void setDatesVoyages(List<DatesVoyage> dateVoyages) {
		this.datesVoyages = dateVoyages;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
