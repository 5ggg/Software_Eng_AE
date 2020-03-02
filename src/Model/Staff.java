package Model;

public class Staff {

    protected int staffID;
    protected String firstName;
    protected String lastName;

    public Staff() {
    }

    public Staff(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    //   setter
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
