package Model;

public class Staff {

    // or Name + ID
    private int staffID;
    private String firstName;
    private String lastName;

    public Staff (int staffID, String firstName, String lastName){
        this.setStaffID(staffID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
    //    getter
    public int getStaffID(){
        return staffID;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    //  setter
    public void setStaffID(int staffID){
        this.staffID = staffID;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
