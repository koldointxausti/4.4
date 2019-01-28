package com.zubiri.school;

import java.util.ArrayList;

public class Teacher extends Worker{
	
	private String teacherID = "";
	private String tutor = "";
	private ArrayList<String> subjects = new ArrayList<String>();
	
	public String getTeacherID() {

		return teacherID;

	}
	
	public void setTeacherID(String teacherID) {

		this.teacherID = teacherID;

	}
	
	public String getTutor() {
		
		return tutor;
		
	}

	public void setTutor(String tutor) {

		if (isTutor())

			this.tutor = tutor;

	}
	
	public ArrayList<String> getSubjects() {

		return subjects;

	}

	public void setSubjects(ArrayList<String> subjects) {

			this.subjects = subjects;

	}
	
	public void addSubject(String subject) {
		subjects.add(subject);
	}

	public String getSubject(int index) {
		return subjects.get(index);
	}
	
	public void deleteSubject(int index) {
		subjects.remove(index);
	}
	
	//if there is no subject found -1
	public int findSubject(String subject) {
		return subjects.indexOf(subject);
	}
	
	public void modifySubjet(int index, String subject) {
		
		subjects.add(index, subject);
		
	}
	
	public boolean isTutor() {
		
		if(tutor.matches(""))
			return false;
		return true;
		
	}
}
