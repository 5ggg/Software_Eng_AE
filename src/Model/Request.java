package model;


/**
 * the teacher submit the teaching request
 */
public class Request {

	private static int num;
	private int id;
	private Teacher teacher;
	private Classes classInfo;
	private int approval; // 0 means rejected, 1 means approved


	public Request(int id, Teacher teacher, Classes classInfo, int approval) {
		this.setId(id);
		this.setTeacher(teacher);
		this.setClassInfo(classInfo);
		this.approval = approval;
		this.setId(num);
		num++;
	}

	public void approve(Request request){
		request.setApproval(1);
	}

	public void reject(Request request){
		request.setApproval(0);
	}

	// write method to return the detail information of Requests.
	public String write(){
		return this.getId()+" "
				+ "Teacher ID:" + this.getTeacher().getStaffID()+" "
				+ "Teaching subject:"+this.getTeacher().getSubject()+" "
				+this.getClassInfo().getId()+" "+this.getApproval();
	}


	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
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


	public Classes getClassInfo() {
		return classInfo;
	}


	public void setClassInfo(Classes classInfo) {
		this.classInfo = classInfo;
	}

}
