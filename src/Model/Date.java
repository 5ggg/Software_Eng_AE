package Model;

public class Date{

    // semesterNumber is 1 or 2 (or 1,2,3)
    // semesterYear is a certain year read from a file
    private int semesterNumber;
    private int semesterYear;

    public Date(int semesterNumber, int semesterYear) {
        this.setSemesterNumber(semesterNumber);
        this.setSemesterYear(semesterYear);
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public int getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(int semesterYear) {
        this.semesterYear = semesterYear;
    }

//    public boolean equals() {
//            if(getSemesterNumber()==this.getSemesterNumber()
//                    &&
//               getSemesterYear()==this.getSemesterYear())
//            {
//                return true;
//            }
//            else{
//                return false;
//            }
    }

}