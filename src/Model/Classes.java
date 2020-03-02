package model;

public class Classes {

    private static int a; //Auxiliary parameter
    private int id;      // as mark
    private String name; // className should be equals to the subject(in the Teacher Object)
    private String time; // We assume that there are only three options here: M/N/A
                         // (present the time using the String M or N or A
                         // M means Morning （9：00-11：00）
                         // N means Noon （11：00-13：00）
                         // A means Afternoon （14：00-16：00）
    private Semester semester; // semester, include semester year and semester number.


    public Classes(int id, String name, String time, Semester semester) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.semester = semester;
        if (a<=id){  // maybe useful
            a=id+1;
        }
    }

    // write method to return the detail information of Classes.
    public String write() {
        return this.getId()+" "+ this.getName()+ " "
                + this.getTime()+" "
                + this.getSemester().getSemesterNumber() + " "
                + this.getSemester().getSemesterYear() + " ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
