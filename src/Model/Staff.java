package Model;

public class Staff {

    // or Name + ID
    private String firstName;
    private String lastName;

    public Staff (String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
