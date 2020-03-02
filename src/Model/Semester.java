package model;

import javax.management.RuntimeOperationsException;

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

	public String toWriter() {
		return +this.getsemesterNumber() + " " + this.getsemesterYear();
	}

	public int getsemesterNumber() {
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
		if (semester.getsemesterNumber() == this.getsemesterNumber()
				&& semester.getSemesterYear() == this.getSemesterYear()) {
			return true;
		} else {
			return false;
		}
	}
}
