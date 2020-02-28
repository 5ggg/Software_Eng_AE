package Model;

public class Class {

    private String className;
    private int classID;
    private Date date;

    public Class(String className, int classID, Date date){
        this.className = className;
        this.classID = classID;
        this.date = date;

//        this.setClassName(className);
//        this.setClassID(classID);
//        this.setDate(date);
    }

    // ClassName
    public String getClassName(){
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    // ClassID
    public int getClassID(){
        return classID;
    }
    public void setClassID(int classID) {
        this.classID = classID;
    }

    // Date
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
