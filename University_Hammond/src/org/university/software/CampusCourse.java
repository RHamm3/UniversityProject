package org.university.software;


import java.util.*;
import org.university.hardware.Classroom;
//import org.university.hardware.Department;
import org.university.people.Professor;
import org.university.people.Student;
import org.university.people.Staff;

public class CampusCourse extends Course{
	private int maxCourseLimit;
	private ArrayList<Integer> schedule;
	private Classroom room;
	
	CampusCourse() {
		maxCourseLimit = 0;
		schedule = new ArrayList<Integer>();
		setRoom(new Classroom());
	}
	
	
	
	public boolean availableTo(Student s1) {
		if (this.getStudentRoster().size() < this.getMaxCourseLimit()) {
			return true;
		}
		else 
			return false;
	}
	
	public boolean availableTo(Professor p1) {
		if (this.getProf().getName() != "Unknown") {
			System.out.println("The professor " + p1.getName() + " cannot be assigned to this campus course because professor " + this.getProf().getName() + 
					" is already assigned to the course " + this.getName() + ".");
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
	
	public void printSchedule() {
		Collections.sort(schedule);
		String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
		String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", 
				"12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm" };
		
		for (int i = 0; i < this.schedule.size(); i++) {
			int day = (schedule.get(i) / 100) - 1;
			int time = (schedule.get(i) % 10) - 1;
			System.out.println(Week[day] + " " + Slot[time] + " " + this.room.getRoomNumber());
		}
		
	}
	
	public void setRoomAssigned(Classroom room) {
		String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
		String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", 
				"12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm", };
		boolean conflict = false;
		
		for (int i = 0; i < room.getCourses().size(); i++) {
			for (int j = 0; j < room.getCourses().get(i).getSchedule().size(); j++) {
				for (int k = 0; k < this.getSchedule().size(); k++) {
					if (this.getSchedule().get(k) ==  room.getCourses().get(i).getSchedule().get(j)) {
						System.out.println(this.getDepartment().getDepartmentName() + "" + this.getCourseNumber() +
								" conflicts with " + room.getCourses().get(i).getDepartment().getDepartmentName() +
								"" + room.getCourses().get(i).getCourseNumber() + ". Conflicting time slot " + Week[(this.getSchedule().get(k) / 100) - 1] + " " +
								Slot[(this.getSchedule().get(k) % 10) - 1] + ". " + this.getDepartment().getDepartmentName() + 
								"" + this.getCourseNumber() + " course cannot be added to " + room.getRoomNumber() + "'s Schedule.");
						conflict = true;
					}
				}
			}
		}
		if (conflict == false) {
			this.room = room;
			room.addCourse(this);
		}
	}
	
	public int getMaxCourseLimit() {
		return maxCourseLimit;
	}

	public void setMaxCourseLimit(int maxCourseLimit) {
		this.maxCourseLimit = maxCourseLimit;
	}

	public ArrayList<Integer> getSchedule() {
		return schedule;
	}

	public void setSchedule(int s) {
		this.schedule.add(s);
	}

	public Classroom getRoom() {
		return room;
	}

	public void setRoom(Classroom room) {
		this.room = room;
	}
	
}
