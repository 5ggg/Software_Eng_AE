package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ListOfRequirements implements Iterable<Requirement> {

	private ArrayList<Requirement> listOfRequirement = new ArrayList<Requirement>();

	private static ListOfRequirements instance = new ListOfRequirements();
	public static ListOfRequirements getInstance(){
		return instance;
	}

	public ArrayList<Requirement> getRequirements() {
		return listOfRequirement;
	}

	public Requirement find(int identifier) {
		for (Requirement tr: listOfRequirement) {
			if (tr.getId() == identifier) {
				return tr;
			}
		}

		return null;
	}


	public void add(Requirement tr) {
		listOfRequirement.add(tr);
	}

	// match the request
	public boolean match(Request request){
		Requirement requirement = request.getrequirment();
		Classes classes = request.getClassRef();
		for (Requirement r:this.listOfRequirement){
			Classes rClass = r.getClassRef();
			if (r.getId()==requirement.getId()){
				if (classes.getTime().equals(rClass.getTime())){ // match the number and time
					return true;
				}
			}
		}
		return false;
	}

//
//	public ArrayList<Requirement> getAllRequirementsConnectedToARequest(Request request){
//		ArrayList<Requirement> requirements = new ArrayList<>();
//		int desiredId = request.getrequirment().getId();
//		for(Requirement requirement:this.listOfRequirement){
//			if (desiredId == requirement.getId()){
//				requirements.add(requirement);
//			}
//		}
//		return requirements;
//	}

	// match all request
//	public ListOfRequirements getAllRequirementsConnectedToARequest(Request request) {
//		ListOfRequirements listOfTeachingRequirements = new ListOfRequirements();
//		int desiredId = request.getrequirment().getId();
//		for(Requirement teachingRequirement : this.listOfRequirement) {
//			if(desiredId==teachingRequirement.getId()) {
//				listOfTeachingRequirements.add(teachingRequirement);
//			}
//		}
//		return listOfTeachingRequirements;
//	}


	@Override
	public Iterator<Requirement> iterator() {
		return this.listOfRequirement.iterator();
	}

}