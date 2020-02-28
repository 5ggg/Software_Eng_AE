package Model;

public class Teacher extends Staff {
    public String subject;
    public Date availableDate;


    public Teacher (int ID, String firstName, String lastName, String subject, Date availableDate){
        super(ID, firstName, lastName);
        this.subject = subject;
        this.availableDate = availableDate;
    }

    // maybe split it out, not extends
}
