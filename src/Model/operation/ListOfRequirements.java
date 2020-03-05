package model.operation;

import java.util.ArrayList;

public class ListOfRequirements{

	private ArrayList<Requirement> listOfRequirement = new ArrayList<Requirement>();

	private static ListOfRequirements instance = new ListOfRequirements();

	public static ListOfRequirements getInstance() {
		return instance;
	}

	public ArrayList<Requirement> getRequirements() {
		return listOfRequirement;
	}

	// user could find a certain requirement from the list by ID.
	public Requirement find(int id) {
		for (Requirement r : listOfRequirement) {
			if (r.getId() == id) {
				return r;
			}
		}

		return null;
	}

	public void add(Requirement tr) {
		listOfRequirement.add(tr);
	}

	// check whether the request could match the requirement
	// this method should auto-use
	public boolean matchable(Request request) {

		for (Requirement r : this.listOfRequirement) {
//			Classes rClass = r.getRequirementClass();
			if (request.getTeacher().getSubject() == r.getRequirementClass().getName()
					&& request.getTeacher().getSemester() == r.getRequirementClass().getSemester()
					&& request.getTeacher().getTime() == r.getRequirementClass().getTime()) {
				return true;
			}
		}
		return false;
	}
}