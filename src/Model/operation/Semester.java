package model.operation;

/**
 * Separately designed a class to represent the object semester,
 * including the year and the number of semesters
 */
public class Semester {

	private static int num = 0;
	private int semesterNumber;
	private int semesterYear;

	public Semester(int semesterNumber, int semesterYear) {
		this.semesterNumber = semesterNumber;
		this.semesterYear = semesterYear;
		num++;
	}

	// write method to return the detail information of Semesters. (might be useless)
	public String write() {
		return +this.getSemesterNumber() + " " + this.getSemesterYear();
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

	public boolean equals(Semester semester) {
		if (semester.getSemesterNumber() == this.getSemesterNumber()
				&& semester.getSemesterYear() == this.getSemesterYear()) {
			return true;
		} else {
			return false;
		}
	}
}
