package org.university.hardware;

import java.util.*;
import org.university.software.CampusCourse;
//import org.university.software.University;

public class Classroom {
	
	private String roomNumber;
	private ArrayList<CampusCourse> courses;
	private ArrayList<Integer> schedule;
	
	public Classroom() {
		setRoomNumber("Unknown 000");
		courses = new ArrayList<CampusCourse>();
		schedule = new ArrayList<Integer>();
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public ArrayList<CampusCourse> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<CampusCourse> courses) {
		this.courses = courses;
	}
	
	public void printSchedule() {
		
		String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
		String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", 
				"12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm" };

		ArrayList<Integer> temp = new ArrayList<Integer>();
		int test1, test2 = 0;
		int val1, val2 = 0;
		String dep = "a";
		String name = "a";
		String courseNum = "a";
		
		for (int i = 0; i < courses.size(); i++) {
			for (int j = 0; j < courses.get(i).getSchedule().size(); j++) {
				temp.add(courses.get(i).getSchedule().get(j));
			}
		}
		Collections.sort(temp);
		
		for (int i = 0; i < temp.size(); i++) {
			test1 = (temp.get(i) / 100) - 1;
			test2 = (temp.get(i) % 10) - 1;
			
			for (int j = 0; j < this.courses.size(); j++) {
				for (int k = 0; k < this.courses.get(j).getSchedule().size(); k++) {
					val1 = this.courses.get(j).getSchedule().get(k);
					val2 = temp.get(i);
					if(val1 == val2) {
						name = this.courses.get(j).getName();
						dep = this.courses.get(j).getDepartment().getDepartmentName();
						courseNum = Integer.toString(this.courses.get(j).getCourseNumber());
					}
				}
			}
			System.out.println(Week[test1] + " " + Slot[test2] + " " + dep + courseNum + " " + name);
		}
		
	}

	public ArrayList<Integer> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Integer> schedule) {
		this.schedule = schedule;
	}
	
	public void addSchedule(int s1) {
		this.schedule.add(s1);
	}
	
	public void addCourse(CampusCourse c1) {
		this.courses.add(c1);
	}
}
