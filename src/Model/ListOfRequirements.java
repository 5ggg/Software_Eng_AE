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

	// user could find a certain requirement from the list by ID.
	public Requirement find(int id) {
		for (Requirement r: listOfRequirement) {
			if (r.getId() == id) {
				return r;
			}
		}

		return null;
	}

	public void add(Requirement tr) {
		listOfRequirement.add(tr);
	}

	// check whether the
	public boolean match(Request request){
		Requirement requirement = request.getRequirement();
		for (Requirement r:this.listOfRequirement){
			Classes rClass = r.getClassRef();
			if (r.getId()==requirement.getId()
				&& ){
				if (classes.getTime().equals(rClass.getTime())){ // match the number and time
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Iterator<Requirement> iterator() {
		return this.listOfRequirement.iterator();
	}

}