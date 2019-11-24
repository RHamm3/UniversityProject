package org.university.software;

import java.util.*;

import org.university.hardware.Department;
import org.university.people.Student;
import org.university.hardware.Classroom;

public class University {

	public ArrayList<Department> departmentList;
	private ArrayList<Course> courses;
	private ArrayList<Student> students;
	public ArrayList<Classroom> classroomList;
	
	public University() {
		departmentList = new ArrayList<Department>();
		courses = new ArrayList<Course>();
		students = new ArrayList<Student>();
		classroomList = new ArrayList<Classroom>();
	}
	
	public ArrayList<Department> getDepartments() {
		return departmentList;
	}

	public void setDepartments(ArrayList<Department> departments) {
		this.departmentList = departments;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public void printDepartmentList() {
		for (int i = 0; i < departmentList.size(); i++) {
			System.out.println(departmentList.get(i).getDepartmentName());
		}
	}
	public void printCourseList() { 
		for (int i = 0; i < departmentList.size(); i++) {
			for (int j = 0; j < departmentList.get(i).getCampusCourseList().size(); j++) {
				System.out.println(departmentList.get(i).getDepartmentName() + "" + departmentList.get(i).getCampusCourseList().get(j).getCourseNumber()
						+ " " + departmentList.get(i).getCampusCourseList().get(j).getName());
			}
		}
		for (int i = 0; i < departmentList.size(); i++) {
			for (int j = 0; j < departmentList.get(i).getOnlineCourseList().size(); j++) {
				System.out.println(departmentList.get(i).getDepartmentName() + "" + departmentList.get(i).getOnlineCourseList().get(j).getCourseNumber()
						+ " " + departmentList.get(i).getOnlineCourseList().get(j).getName());			
				}
		}
	}
	public void printStudentList() {
		for (int i = 0; i < departmentList.size(); i++) {
			for (int j = 0; j < departmentList.get(i).getStudentList().size(); j++) {
				System.out.println(departmentList.get(i).getStudentList().get(j).getName());
			}
		}
	}
	
	public void printStaffList() {
		for (int i = 0; i < departmentList.size(); i++) {
			for (int j = 0; j < departmentList.get(i).getStaffList().size(); j++) {
				System.out.println(departmentList.get(i).getStaffList().get(j).getName());
			}
		}
	}
	
	public void printProfessorList() {
		for (int i = 0; i < departmentList.size(); i++) {
			for (int j = 0; j < departmentList.get(i).getProfessorList().size(); j++) {
				System.out.println(departmentList.get(i).getProfessorList().get(j).getName());
			}
		}
	}

	public ArrayList<Classroom> getRooms() {
		return classroomList;
	}

	public void setRooms(ArrayList<Classroom> rooms) {
		this.classroomList = rooms;
	}
	
	public void addClassRoom(Classroom c1) {
		this.classroomList.add(c1);
	}
}

