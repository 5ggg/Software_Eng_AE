package Model;

public class Teacher extends Staff {
    public String subject;

    public Teacher (int ID, String firstName, String lastName, String subject){
        super(ID, firstName, lastName);
        this.subject = subject;
    }
}
