package model;


/**
 * the teacher submit the teaching request
 */
public class Request {

	private static int num;
	private int id;
	private Teacher teacher;
	private Requirement requirment;
	private String approval; // 0 means rejected, 1 means approved


	public Request(Teacher teacher, Requirement requirment) {
		this.setTeacher(teacher);
		this.setrequirment(requirment);
		this.approval = "0";
		this.setId(num);
		num++;
	}


	public Request(int id, Teacher teacher, Requirement requirment, String approval) {
		this.id = id;
		this.teacher = teacher;
		this.requirment = requirment;
		this.approval = approval;
		if (num<=id){
			num=id+1;
		}
	}

	public String toWriter(){
		return this.getId()+" "
				+ "Teacher ID:" + this.getTeacher().getStaffID()+" "
				+ "Teaching subject:"+this.getTeacher().getSubject()+" "
				+this.getrequirment().getId()+" "+this.getApproval();
	}

//	public Request(int id, Teacher teacher, Requirement requirment) {
//		this.setTeacher(teacher);
//		this.setrequirment(requirment);
//		this.approval = false;
//		this.setId(id);
//	}


	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public Requirement getrequirment() {
		return requirment;
	}


	public void setrequirment(Requirement requirment) {
		this.requirment = requirment;
	}

}
