package org.university.software;

import org.university.people.Student;
import org.university.people.Staff;
import org.university.people.Professor;


public class OnlineCourse extends Course{
	
	public boolean availableTo(Student s1) {
		boolean test = true;
		if (s1.getCurrentlyEnrolledCredits() < 6) {
			test = false;
			System.out.println("Student " + s1.getName() + " has only " + s1.getCurrentlyEnrolledCredits() +
					" on campus credits enrolled. Should have at least 6 credits registered before registering "
					+ "online courses.");
		}
		return test;
	}
	public boolean availableTo(Professor p1) {
		if (this.getProf().getName() != "Unknown") {
			System.out.println("The professor cannot be assigned to this online course because professor " + this.getProf().getName() + 
					" is already assigned to the online course " + this.getName() + ".");
			return false;
		}
		else 
			return true;
	}
	public boolean availableTo(Staff s1) {
		boolean test = true;
		if (s1.getCurrentlyEnrolledCredits() != 0) {
			test = false;
		}
		return test;
	}
	
}
