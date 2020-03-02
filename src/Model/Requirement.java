package model;

/**
 * \the class director create the teaching requirement based their need.
 */
public class Requirement {

	private static int num;
	private int id;
	private Classes requirementClass; // a certain class.

	public Requirement(int id, Classes requirementClass) {
		this.id = id;
		this.requirementClass = requirementClass;
		if (num<=id){
			num=id+1;
		}
	}

	public String toWriter(){
		return this.getId()+" "+this.getRequirementClass().getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Classes getRequirementClass() {
		return requirementClass;
	}

	public void setRequirementClass(Classes requirementClass) {
		this.requirementClass = requirementClass;
	}

}
