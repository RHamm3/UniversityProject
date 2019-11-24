package org.university.people;

import org.university.software.*;

public class Staff extends Employee{
	private double payRate;
	private int hoursWorked;
	private int tuitionFee;
	private int currentlyEnrolledCredits;
	
	public Staff() {
		setPayRate(0);
		setMonthlyHours(0);
		setTuitionFee(0);
		setCurrentlyEnrolledCredits(0);
	}
	
	public boolean detectConflict() {
		if (this.getCampusCourses().size() + this.getOnlineCourses().size() > 0) {
			return true;
		}
		else
			return false;
	}
	
	public void addCurrentlyEnrolledCredits(int c) {
		currentlyEnrolledCredits = currentlyEnrolledCredits + c; 
	}
	
	public void addCourse(CampusCourse c1) {
		if (this.detectConflict() == true || c1.availableTo(this) == false) {
			if (this.getCampusCourses().size() > 0) {
			System.out.println(this.getCampusCourses().get(0).getDepartment().getDepartmentName() + "" + this.getCampusCourses().get(0).getCourseNumber() + " is removed from " + this.getName() + 
					"'s schedule(Staff can only take one class at a time). " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + 
					" has been added to " + this.getName() + "'s Schedule.");
			}
			else if (this.getOnlineCourses().size() > 0) {
				System.out.println(this.getOnlineCourses().get(0).getDepartment().getDepartmentName() + "" + this.getOnlineCourses().get(0).getCourseNumber() + " is removed from " + this.getName() + 
						"'s schedule(Staff can only take one class at a time). " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + 
						" has been added to " + this.getName() + "'s Schedule.");
			}
			this.getCampusCourses().clear();
			this.getOnlineCourses().clear();
			this.campusCourses.add(c1);
			this.setCurrentlyEnrolledCredits(c1.getCreditsUnits());
			c1.addStaffToRoster(this);	
			this.setTuitionFee(c1.getCreditsUnits() * 300);
		}
		else if (detectConflict() == false && c1.availableTo(this) == true) {
			this.campusCourses.add(c1);
			this.addCurrentlyEnrolledCredits(c1.getCreditsUnits());
			c1.addStaffToRoster(this);	
			this.setTuitionFee(c1.getCreditsUnits() * 300);
		}
	}
	
	public void addCourse(OnlineCourse c1) {
		if (c1.availableTo(this) == true && detectConflict() == false) {
			this.onlineCourses.add(c1);
			this.addCurrentlyEnrolledCredits(c1.getCreditsUnits());
			c1.addStaffToRoster(this);
			this.setTuitionFee(c1.getCreditsUnits() * 300);
			if (c1.getCreditsUnits() == 3) {
				this.setTuitionFee(2000);
			}
			else if (c1.getCreditsUnits() == 4) {
				this.setTuitionFee(3000);
			}
		}
		else if (c1.availableTo(this) == false || detectConflict() == true) {
			if (this.getCampusCourses().size() > 0) {
				System.out.println(this.getCampusCourses().get(0).getDepartment().getDepartmentName() + "" + this.getCampusCourses().get(0).getCourseNumber() + " is removed from " + this.getName() + 
						"'s schedule(Staff can only take one class at a time). " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + 
						" has been added to " + this.getName() + "'s Schedule.");
				}
				else if (this.getOnlineCourses().size() > 0) {
					System.out.println(this.getOnlineCourses().get(0).getDepartment().getDepartmentName() + "" + this.getOnlineCourses().get(0).getCourseNumber() + " is removed from " + this.getName() + 
							"'s schedule(Staff can only take one class at a time). " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + 
							" has been added to " + this.getName() + "'s Schedule.");
				}
			this.getOnlineCourses().clear();
			this.getCampusCourses().clear();
			this.onlineCourses.add(c1);
			this.setCurrentlyEnrolledCredits(c1.getCreditsUnits());
			c1.addStaffToRoster(this);	
			if (c1.getCreditsUnits() == 3) {
				this.setTuitionFee(2000);
			}
			else 
				this.setTuitionFee(3000);
		}
	}
	
	public void dropCourse(CampusCourse c1) {
		
	}
	
	public void dropCourse(OnlineCourse c1) {
		
	}
	
	public void raise(double x) {
		payRate = payRate + payRate * (x / 100);
	}
	
	public double earns() {
		return (hoursWorked * payRate);
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setMonthlyHours(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int getTuitionFee() {
		return tuitionFee;
	}

	public void setTuitionFee(int tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	public int getCurrentlyEnrolledCredits() {
		return currentlyEnrolledCredits;
	}

	public void setCurrentlyEnrolledCredits(int currentlyEnrolledCredits) {
		this.currentlyEnrolledCredits = currentlyEnrolledCredits;
	}
	
	
}
