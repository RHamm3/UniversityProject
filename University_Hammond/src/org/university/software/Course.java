package org.university.software;

import java.util.*;

import org.university.hardware.Department;
import org.university.people.Professor;
import org.university.people.Student;
import org.university.people.Staff;
import org.university.people.Person;

public abstract class Course {
	
	private ArrayList<Person> roster;
	private ArrayList<Staff> staffRoster;
	private int CourseNumber;
	private String Name;
	private Department department;
	private Professor prof;
	protected int creditUnits;
	
	public Course() {
		roster = new ArrayList<Person>();
		setStaffRoster(new ArrayList<Staff>());
		CourseNumber = 0;
		Name = "Unknown";
		setProf(new Professor());
		department = new Department();
		creditUnits = 0;
	}
	
	public abstract boolean availableTo(Student s1);
	
	public void addStudentToRoster(Student s1) {
		this.roster.add(s1);
	}
	
	public void addStaffToRoster(Staff s1) {
		this.staffRoster.add(s1);
	}
	
	public ArrayList<Person> getStudentRoster() {
		return roster;
	}

	public void setStudentRoster(Person s1) {
		this.roster.add(s1);
	}

	public int getCourseNumber() {
		return CourseNumber;
	}

	public void setCourseNumber(int courseNum) {
		this.CourseNumber = courseNum;
	}

	public String getName() {
		return Name;
	}

	public void setName(String courseName) {
		this.Name = courseName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public int getCreditsUnits() {
		return creditUnits;
	}

	public void setCreditUnits(int creditUnits) {
		this.creditUnits = creditUnits;
	}

	public ArrayList<Staff> getStaffRoster() {
		return staffRoster;
	}

	public void setStaffRoster(ArrayList<Staff> staffRos) {
		this.staffRoster = staffRos;
	}
	
	
}

