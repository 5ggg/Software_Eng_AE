package Model;

import java.io.PrintStream;

public class Teacher extends Staff {

    private static int num;
    private String subject;
    private String availableDate;
    private Request request;

    public Teacher(String firstName, String lastName, String subject, String availableDate) {
        super(firstName, lastName);
        this.subject = subject;
        this.availableDate = availableDate;
        this.setStaffID(num);
        num++;
    }

    /**
     * submit the teaching request
     */
    public void submitRequest(String className, String classDate){
        Class aClass = new Class(className,classDate);
    }

    public String toWriter() {
        return this.getFirstName()+this.getLastName()+" "+this.subject+" "+this.availableDate;
    }

    public void print(PrintStream ps) {
        ps.print(this.getStaffID() + " " + this.getFirstName()+this.getLastName()
                + " " + this.subject + " " + this.availableDate + "\n");
    }

    public String getSubject() {
        return subject;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
