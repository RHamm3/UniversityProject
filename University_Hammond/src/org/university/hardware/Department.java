package org.university.hardware;

import java.util.*;

import org.university.people.Professor;
import org.university.people.Student;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;
import org.university.people.Staff;

public class Department {
	
	private String depName;
	private ArrayList<OnlineCourse> onlineCourseList;
	private ArrayList<CampusCourse> campusCourseList;
	private ArrayList<Student> roster;
	private ArrayList<Professor> professors;
	private ArrayList<Staff> staffList;
	
	public Department() {
		depName = "Unknown";
		campusCourseList = new ArrayList<CampusCourse>();
		roster = new ArrayList<Student>();
		professors = new ArrayList<Professor>();
		campusCourseList = new ArrayList<CampusCourse>();
		onlineCourseList = new ArrayList<OnlineCourse>();
		staffList = new ArrayList<Staff>();
	}
	
	public void printCourseList() { 
		for (int i = 0; i < campusCourseList.size(); i++) {
			System.out.println(this.getDepartmentName() + "" + campusCourseList.get(i).getCourseNumber() + " "
					+ campusCourseList.get(i).getName());
		}
		for (int j = 0; j < onlineCourseList.size(); j++) {
			System.out.println(this.getDepartmentName() + this.onlineCourseList.get(j).getCourseNumber() + " " 
					+ this.onlineCourseList.get(j).getName());
		}
	}
	
	public void printStudentList() {
		for (int i = 0; i < roster.size(); i++) {
			System.out.println(roster.get(i).getName());
		}
	}
	public void printProfessorList() {
		for (int i = 0; i < professors.size(); i++) {
			System.out.println(professors.get(i).getName());
		}
	}
	public void printStaffList() {
		for (int i = 0; i < staffList.size(); i++) {
			System.out.println(staffList.get(i).getName());
		}
	}
	
	public void addStaff(Staff s1) {
		this.staffList.add(s1);
		s1.setDepartment(this);
	}
	
	public String getDepartmentName() {
		return depName;
	}

	public void setDepartmentName(String d1) {
		this.depName = d1;
	}

	public ArrayList<OnlineCourse> getOnlineCourseList() {
		return onlineCourseList;
	}

	public void setOnlineCourseList(ArrayList<OnlineCourse> onlineCourseList) {
		this.onlineCourseList = onlineCourseList;
	}
	
	public ArrayList<CampusCourse> getCampusCourseList() {
		return campusCourseList;
	}

	public void setCampusCourseList(ArrayList<CampusCourse> campusCourseList) {
		this.campusCourseList = campusCourseList;
	}

	public ArrayList<Student> getStudentList() {
		return roster;
	}

	public void setStudentList(ArrayList<Student> roster) {
		this.roster = roster;
	}
	
	public void addCourse(CampusCourse c1) {
		this.campusCourseList.add(c1);
		c1.setDepartment(this);
	}
	
	public void addCourse(OnlineCourse c1) {
		this.onlineCourseList.add(c1);
		c1.setDepartment(this);
	}
	
	public void addProfessor(Professor p1) {
		this.professors.add(p1);
		p1.setDep(this);
	}
	
	public void addStudent(Student s1) {
		this.roster.add(s1);
		s1.setDepartment(this);
	}

	public ArrayList<Professor> getProfessorList() {
		return professors;
	}

	public void getProfessorList(ArrayList<Professor> professors) {
		this.professors = professors;
	}

	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(ArrayList<Staff> staffList) {
		this.staffList = staffList;
	}
	
}

