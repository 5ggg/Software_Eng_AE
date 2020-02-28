package Model;

public class Class {

    private String className;
    private int classID;
    private Semester semester;

    public Class(String className, int classID, Semester semester){
        this.setClassName(className);
        this.setclassId(classID);
        this.setSemester(semester);
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

    // Semester
    public Semester getSemester() {
        return semester;
    }
    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
