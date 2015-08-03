package bovoyage.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dates_voyages")
public class DateVoyage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kp_date_voyage")
	private int idDateVoyage;
	@Column(name = "date_depart")
	private Date dateDepart;
	@Column(name = "date_retour")
	private Date dateRetour;
	private double prixHT;

	public DateVoyage() {
	}

	public int getIdDateVoyage() {
		return idDateVoyage;
	}

	public void setIdDateVoyage(int idDateVoyage) {
		this.idDateVoyage = idDateVoyage;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
