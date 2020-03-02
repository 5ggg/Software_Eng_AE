package Model;

/**
 * Teaching request
 */
public class Request {

    private static int num;
    private int requestId;
    private int classId;
    private int numOfTeacher;
    private int status;
    private String requiredSubject;
    private String time; // Date


    public Request(int classId, int numOfTeacher, int status, String requiredSubject,String time) {
        this.classId = classId;
        this.numOfTeacher = numOfTeacher;
        this.status = status;
        this.requiredSubject = requiredSubject;
        this.time = time;
        this.requestId = num;
        num++;
    }



    // status =1 / 2
    // 0 not check
    // 1 means accept
    // 2 means reject

    // xxx


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
    public String getRequiredSubject() {
        return requiredSubject;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRequiredSubject(String requiredSubject) {
        this.requiredSubject = requiredSubject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
