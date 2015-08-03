package bovoyage.metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Panier {

	private List<DateVoyage> voyages = new ArrayList<>();
	
	
	public Panier() {
	}
	
	
	public void add(DateVoyage voyage){
		this.voyages.add(voyage);
	}
	
	public void remove(DateVoyage voyage){
//		this.voyages.remove(voyage);
		Iterator<DateVoyage> it = voyages.iterator();
		while(it.hasNext()){
			if(it.next().equals(voyage))
				it.remove();
		}
	}
	
	public void clear(){
		this.voyages.clear();
	}
	
	public List<DateVoyage> getVoyages(){
		return this.voyages;
	}
	
}
