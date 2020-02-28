package Model;

public class Request {


    private int requestId;
    private int classId;
    private int numOfTeacher;
    private int status;


    public Request(int numOfTeacher, int requestId) {

        this.numOfTeacher = numOfTeacher;
        this.requestId = requestId;
    }

    public int getRequestId() {
        return requestId;
    }
    public int getNumOfTeacher() {
        return numOfTeacher;
    }
    public void setNumOfTeacher(int numOfTeacher) {
        this.numOfTeacher = numOfTeacher;
    }
    public int getClassId() {
        return classId;
    }


    // status =1 / 2
    // 1 means accept
    // 2 means reject
    public void requestAccepted() {
    }
    public void requestRejected() {
    }

    // print it out here.
}
