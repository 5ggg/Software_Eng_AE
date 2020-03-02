package model;

public class Classes {

    private static int num;
    private int id;
    private String name; // className should be equals to the subject(in the Teacher Object)
    private String time; // maybe useful later  (i.e.)
    private Semester semester; // semester, include year and semester number.


//    public Classes(String name,String time, Semester semester) {
//        this.setName(name);
//        this.setSemester(semester);
//        this.setTime(time);
//        this.setId(num);
//    }

    public Classes(int id, String name, String time, Semester semester) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.semester = semester;
        if (num<=id){
            num=id+1;
        }
    }

    public String toWriter() {
        return this.getId()+" "+ this.getName()+
                " "+this.getTime()+" "+this.getSemester().getId();
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
