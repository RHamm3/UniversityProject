package org.university.people;

import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.Department;
//import org.university.software.Course;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;

public abstract class Person {
	protected String name;
	protected Department department;
	protected ArrayList<Integer> schedule;
	protected ArrayList<CampusCourse> campusCourses;
	protected ArrayList<OnlineCourse> onlineCourses;
	
	Person() {
		name = "Unknown";
		department = new Department();
		schedule = new ArrayList<Integer>();
		campusCourses = new ArrayList<CampusCourse>();
		onlineCourses = new ArrayList<OnlineCourse>();
	}
	
	public abstract void addCourse(CampusCourse c1);
	public abstract void addCourse(OnlineCourse c1);
	public abstract void dropCourse(CampusCourse c1);
	public abstract void dropCourse(OnlineCourse c1);
	
	public boolean detectConflict(CampusCourse c1) {
		String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
		String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", 
				"12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm", };
		boolean test = false;
		
		for (int i = 0; i < campusCourses.size(); i++) {
			for (int j = 0; j < campusCourses.get(i).getSchedule().size(); j++) {
				for (int k = 0; k < c1.getSchedule().size(); k++) {
					int temp1 = c1.getSchedule().get(k);
					int temp2 = campusCourses.get(i).getSchedule().get(j);
					if(temp1 == temp2) {
						System.out.println(c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() + " course cannot be added to " + this.getName() + 
								"'s Schedule. " + c1.getDepartment().getDepartmentName() + "" + c1.getCourseNumber() +  " conflicts with " + campusCourses.get(i).getDepartment().getDepartmentName()
								+ "" + campusCourses.get(i).getCourseNumber() + ". Conflicting time slot is " + Week[(c1.getSchedule().get(k) / 100) - 1] + 
								" " + Slot[(c1.getSchedule().get(k) % 10) - 1] + ".");
						test = true;
					}
				}
			}
		}
		return test;
	}
	
	public void printSchedule() {
		
		String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
		String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", 
				"12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm", };
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int test1, test2 = 0;
		int val1, val2 = 0;
		String dep = "a";
		String name = "a";
		String courseNum = "a";
		
		for (int i = 0; i < campusCourses.size(); i++) {
			for (int j = 0; j < campusCourses.get(i).getSchedule().size(); j++) {
				temp.add(campusCourses.get(i).getSchedule().get(j));
			}
		}
		Collections.sort(temp);
		
		for (int i = 0; i < temp.size(); i++) {
			test1 = (temp.get(i) / 100) - 1;
			test2 = (temp.get(i) % 10) - 1;
			
			for (int j = 0; j < this.campusCourses.size(); j++) {
				for (int k = 0; k < this.campusCourses.get(j).getSchedule().size(); k++) {
					val1 = this.campusCourses.get(j).getSchedule().get(k);
					val2 = temp.get(i);
					if(val1 == val2) {
						name = this.campusCourses.get(j).getName();
						dep = this.campusCourses.get(j).getDepartment().getDepartmentName();
						courseNum = Integer.toString(this.campusCourses.get(j).getCourseNumber());
					}
				}
			}
			System.out.println(Week[test1] + " " + Slot[test2] + " " + dep + courseNum + " " + name);
		}
		for (int i = 0; i < this.onlineCourses.size(); i++) {
			System.out.println(this.onlineCourses.get(i).getCourseNumber() + " " + this.onlineCourses.get(i).getName());
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public ArrayList<Integer> getSchedule() {
		return schedule;
	}
	public void setSchedule(ArrayList<Integer> schedule) {
		this.schedule = schedule;
	}
	public ArrayList<CampusCourse> getCampusCourses() {
		return campusCourses;
	}
	public void setCampusCourses(ArrayList<CampusCourse> campusCourses) {
		this.campusCourses = campusCourses;
	}
	public ArrayList<OnlineCourse> getOnlineCourses() {
		return onlineCourses;
	}
	public void setOnlineCourses(ArrayList<OnlineCourse> onlineCourses) {
		this.onlineCourses = onlineCourses;
	}
}
