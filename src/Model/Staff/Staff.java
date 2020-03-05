package model.Staff;

public abstract class Staff {

    private static int a;
    protected int staffID;
    protected String firstName;
    protected String lastName;

    // The constructor Staff, inherited by the other person.
    public Staff(int staffID, String firstName, String lastName) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        if (a<=staffID){
            a=staffID+1;
        }
    }

    //    getter
    public int getStaffID() {
        return staffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//       setter  (Not used till now)
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // write method to return the detail information of Staff.
    public String write() {
        return this.getStaffID()+" "+this.getFirstName()+" "+this.getLastName()+" ";
    }
}
