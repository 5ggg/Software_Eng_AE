package model.Staff;

import model.operation.Semester;

public class Teacher extends Staff {


    private final String subject;
    private final Semester semester;
    private final String time;

    public Teacher(int staffID, String firstName, String lastName, String subject,
                   Semester availableSemester,
                   String availableTime) {
        super(staffID, firstName, lastName);
        this.subject = subject;  // split the subject name from the Classes object.
        this.semester = availableSemester;
        this.time = availableTime;

    }

    public String getSubject() {
        return subject;
    }

    public Semester getSemester(){
        return semester;
    }

    public String getTime(){
        return time;
    }
}
