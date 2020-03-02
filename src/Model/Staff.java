package model;

public abstract class Staff {

    private static int num;
    protected int staffID;
    protected String firstName;
    protected String lastName;


    public Staff(int staffID, String firstName, String lastName) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        if (num<=staffID){
            num=staffID+1;
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

    public String toWriter() {
        return this.getStaffID()+" "+this.getFirstName()+" "+this.getLastName()+" ";
    }
}
