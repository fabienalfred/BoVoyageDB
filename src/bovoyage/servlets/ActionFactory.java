package bovoyage.servlets;

import bovoyage.servlets.actions.ActionAddVoyage;
import bovoyage.servlets.actions.ActionDetailsDest;
import bovoyage.servlets.actions.ActionHome;
import bovoyage.servlets.actions.ActionRemoveVoyage;

public class ActionFactory {

	public static Action getAction(String cde){
		Action action = null;
		if(cde == null || cde.isEmpty())
			cde = "home";
		
		switch(cde){
		case "home":
			action = new ActionHome();
			break;
		case "details_dest":
			action = new ActionDetailsDest();
			break;
		case "add":
			action = new ActionAddVoyage();
			break;
		case "rem":
			action = new ActionRemoveVoyage();
			break;
//		case "chg_places":
//			action = new ActionChangeNbPlaces();
//			break;
		}
		return action;
	}
	
}
