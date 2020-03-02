package Model;


/**
 * Teaching requirement
 */
public class Class {

    private static int num;
    private int classID;
    private String className; // subject  // className should be equals to the subject(in the Teacher Object)
    private String classDate; // Date

    public Class(String className, String classDate) {
        this.classID = num;
        this.className = className;
        this.classDate = classDate;
        num++;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }

}
