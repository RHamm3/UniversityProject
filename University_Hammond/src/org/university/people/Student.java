package org.university.people;

//import java.util.*;

import org.university.hardware.Department;
//import org.university.software.Course;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;

public class Student extends Person{
	
	private int completedUnits;
	private int requiredCredits;
	private int currentlyEnrolledCredits;
	private int tuitionFee;
	
	public Student() {
		name = "Unknown";
		department = new Department();
		setRequiredCredits(0);
		setCompletedUnits(0);	
		currentlyEnrolledCredits = 0;
		tuitionFee = 0;
	}
	
	public void addCurrentlyEnrolledCredits(int x) {
		currentlyEnrolledCredits = currentlyEnrolledCredits + x;
	}
	
	public void addCourse(CampusCourse c1) {
		if (!c1.availableTo(this)) {
			System.out.println(this.getName() + " can't add Campus Course " + c1.getDepartment().getDepartmentName() + c1.getCourseNumber() 
			+ " " + c1.getName() + ". Because this Campus course has enough student.");	
		}
		else if (detectConflict(c1) == false) {
			this.campusCourses.add(c1);
			this.addCurrentlyEnrolledCredits(c1.getCreditsUnits());
			c1.setStudentRoster(this);	
			this.setTuitionFee((c1.getCreditsUnits() * 300));
		}
	}
	
	public void addCourse(OnlineCourse c1) {
		if (c1.availableTo(this) == true) {
			this.onlineCourses.add(c1);
			c1.setStudentRoster(this);
			if (c1.getCreditsUnits() == 3) {
				this.setTuitionFee(2000);
			}
			else if (c1.getCreditsUnits() == 4) {
				this.setTuitionFee(3000);
			}
		}
		else {
			System.out.println(" " + this.getName() + " can't add online Course " + c1.getDepartment().getDepartmentName() + c1.getCourseNumber()
			+ " " + c1.getName() + ". Because this student doesn't have enough Campus course credit.");
		}
	}
	
	public void dropCourse(CampusCourse c1) {
		int test = 0;
		int temp = 0;
		int creditVal = 0;
		for (int i = 0; i < this.getCampusCourses().size(); i++) {
			creditVal = creditVal + this.getCampusCourses().get(i).getCreditsUnits();
		}
		for(int i = 0; i < campusCourses.size(); i++) {
			if (campusCourses.get(i).getName() == c1.getName()) {
				test = 1;
				temp = i;
			}
		}
		if (test == 0) {
			System.out.println("The course " + c1.getDepartment().getDepartmentName() + c1.getCourseNumber() + " could not be dropped because "
					+ this.getName() + " is not enrolled in " + c1.getDepartment().getDepartmentName() + c1.getCourseNumber() + ".");
			return;
		}
		else if ((creditVal - c1.getCreditsUnits()) < 6 && this.getOnlineCourses().size() != 0) {
			System.out.println(this.getName() + " can't drop this CampusCourse, because this student doesn't have enough campus course "
					+ "credit to hold the online course");
			return;
		}
		else
			campusCourses.remove(temp);
			c1.getStudentRoster().remove(this);
			this.setCurrentlyEnrolledCredits(creditVal - c1.getCreditsUnits());
			this.setTuitionFee(-(c1.getCreditsUnits() * 300));
	}
	
	public void dropCourse(OnlineCourse c1) {
		int test = 0;
		int temp = 0;
		for(int i = 0; i < onlineCourses.size(); i++) {
			if (onlineCourses.get(i).getName() == c1.getName()) {
				test = 1;
				temp = i;
			}
		}
		if (test == 0) {
			System.out.println("The course " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + " could not be dropped because "
					+ this.getName() + " is not enrolled in " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + ".");
			return;
		}
		else 
			onlineCourses.remove(temp);
			this.setCurrentlyEnrolledCredits(this.getCurrentlyEnrolledCredits() - c1.getCreditsUnits());
			if (c1.getCreditsUnits() == 3) {
				this.setTuitionFee(-(2000));
			}
			else 
				this.setTuitionFee(-(3000));
	}
	
	public int getCompletedUnits() {
		return completedUnits;
	}

	public void setCompletedUnits(int completedUnits) {
		this.completedUnits = completedUnits;
	}

	public int getRequiredCredits() {
		return requiredCredits;
	}

	public void setRequiredCredits(int requiredCredits) {
		this.requiredCredits = requiredCredits;
	}
	
	public int requiredToGraduate() {
		int temp = requiredCredits - (completedUnits + currentlyEnrolledCredits);
		return temp;
	}

	public int getCurrentlyEnrolledCredits() {
		return currentlyEnrolledCredits;
	}

	public void setCurrentlyEnrolledCredits(int currentlyEnrolledCredits) {
		this.currentlyEnrolledCredits = currentlyEnrolledCredits;
	}

	public int getTuitionFee() {
		return tuitionFee;
	}

	public void setTuitionFee(int tuitionFee) {
		this.tuitionFee = tuitionFee + this.tuitionFee;
	}
}
