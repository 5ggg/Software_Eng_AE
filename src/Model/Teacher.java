package model;

public class Teacher extends Staff {


    private final String subject;
    private final Semester semester;

    public Teacher(int staffID, String firstName, String lastName, String subject, Semester availableSemester) {
        super(staffID, firstName, lastName);
        this.subject = subject;  // split the subject name from the Classes object.
        this.semester = availableSemester;

    }

    public String getSubject() {
        return subject;
    }
}
