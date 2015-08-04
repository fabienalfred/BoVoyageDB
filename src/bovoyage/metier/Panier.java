package bovoyage.metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Panier {

	private List<Voyage> voyages = new ArrayList<>();
	
	
	public Panier() {
	}
	
	
	public void add(Voyage voyage){
		this.voyages.add(voyage);
	}
	
	public void remove(int index){
		this.voyages.remove(index);
	}
	
	@Deprecated
	public void remove(Voyage voyage){
		this.voyages.remove(voyage);
	}
	
	public void clear(){
		this.voyages.clear();
	}
	
	public List<Voyage> getVoyages(){
		return this.voyages;
	}
	
}
