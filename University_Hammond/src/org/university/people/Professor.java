package org.university.people;

import java.util.*;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;

public class Professor extends Employee{
	private String name;
	private double fieldSalary;
	private ArrayList<Course> courses;
	private Department dep;
	
	public Professor() {
		setName("Unknown");
		setSalary(0);
		courses = new ArrayList<Course>();
		setDep(new Department());
	}
	
	public void addCourse(CampusCourse c1) {
		if (detectConflict(c1) == false && c1.availableTo(this) == true) {
			this.campusCourses.add(c1);
			c1.setProf(this);
		}
	}
	
	public void addCourse(OnlineCourse c1) {
		if (c1.availableTo(this) == true) {
			this.onlineCourses.add(c1);
			c1.setProf(this);
		}
	}

	public void dropCourse(CampusCourse c1) {
		int test = 0;
		for(int i = 0; i < campusCourses.size(); i++) {
			if (campusCourses.get(i).getName() == c1.getName()) {
				test = 1;
				campusCourses.remove(i);
			}
		}
		if (test == 0) {
			System.out.println("The course " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + " could not be dropped because "
					+ this.getName() + " is not enrolled in " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + ".");
		}
	}
	public void dropCourse(OnlineCourse c1) {
		int test = 0;
		for(int i = 0; i < onlineCourses.size(); i++) {
			if (onlineCourses.get(i).getName() == c1.getName()) {
				test = 1;
				onlineCourses.remove(i);
			}
		}
		if (test == 0) {
			System.out.println("The course " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + " could not be dropped because "
					+ this.getName() + " is not enrolled in " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + ".");
		}
	}
	
	public double earns() {
		return fieldSalary / 26;
	}
	public void raise(double x) {
		fieldSalary = fieldSalary + fieldSalary * (x / 100);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}


	public double getFieldSalary() {
		return fieldSalary;
	}


	public void setSalary(double fieldSalary) {
		this.fieldSalary = fieldSalary;
	}
	
	
}
