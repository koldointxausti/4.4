package com.zubiri.school;

import java.util.ArrayList;

public class School {

	private ArrayList<Administrative> administratives = new ArrayList<Administrative>();
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private ArrayList<Student> students = new ArrayList<Student>();
	private String schoolName = "";

	public School(String schoolName) {
		this.schoolName = schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	// ADMINISTRATIVES MANAGEMENT

	public ArrayList<Administrative> getAdministratives() {
		return administratives;
	}

	public void setAdministratives(ArrayList<Administrative> administratives) {
		this.administratives = administratives;
	}

	/**
	 * 
	 * @param index of the administrative you want in the arraylist
	 * @return the administrative class object in that index
	 */
	public Administrative getAdministrative(int index) {
		return administratives.get(index);
	}

	/**
	 * 
	 * @param administrative you want to add
	 *                       <p>
	 *                       When you add an administrative to the arraylist, it
	 *                       will generate an ID automatically and it will be saved
	 *                       in each Administrative object as a property
	 *                       </p>
	 */
	public void addAdministrative(Administrative administrative) {
		generateID(administrative);
		administratives.add(administrative);
	}

	/**
	 * 
	 * @param administrativeID
	 * @return the index of the administrative who has that ID
	 */
	public int findAdministrative(String administrativeID) {
		for (int i = 0; i < administratives.size(); i++)
			if (administratives.get(i).getAdministrativeID().matches(administrativeID))
				return i;
		return -1;
	}

	/**
	 * 
	 * @param index of the administrative you want to delete
	 */
	public void deleteAdministrative(int index) {
		administratives.remove(index);
	}

	/**
	 * 
	 * @param index          of the administrative you want to modify
	 * @param administrative object with the new information that you want to change
	 */
	public void modifyAdministrative(int index, Administrative administrative) {
		administratives.add(index, administrative);
	}

	/**
	 * 
	 * @param administrative object which you create the ID for
	 */
	public void generateID(Administrative administrative) {
		administrative.setAdministrativeID("A" + (administratives.size() + 1));
	}

	// TEACHERS MANAGEMENT

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}

	/**
	 * 
	 * @param index of the teacher you want in the arraylist
	 * @return the teacher class object in that index
	 */
	public Teacher getTeacher(int index) {
		return teachers.get(index);
	}

	/**
	 * 
	 * @param index of the teacher you want in the arraylist
	 * @return the teacher class object in that index
	 */
	public void addTeacher(Teacher teacher) {
		generateID(teacher);
		teachers.add(teacher);
		orderTeachers2();
	}

	/**
	 * 
	 * @param teacher you want to add
	 *                <p>
	 *                When you add an teacher to the arraylist, it will generate an
	 *                ID automatically and it will be saved in each Administrative
	 *                object as a property
	 *                </p>
	 */
	public int findTeacher(String teacherID) {
		for (int i = 0; i < teachers.size(); i++)
			if (teachers.get(i).getTeacherID().matches(teacherID))
				return i;
		return -1;
	}

	public void printTeachers() {
		if (teachers.size() > 0) {
			for (int i = 0; i < teachers.size(); i++) {
				// we think it would be more useful using the getTeachers().get() entering the
				// index we want (instead of the name)
				System.out.println("- " + teachers.get(i).getTeacherID() + "\t" + teachers.get(i).getName());
			}
		} else
			System.out.println("There's no teacher created yet.");
	}

	/**
	 * 
	 * @param index of the teacher you want to delete
	 */
	public void deleteTeacher(int index) {
		teachers.remove(index);
	}

	/**
	 * 
	 * @param index   of the teacher you want to modify
	 * @param teacher object with the new information that you want to change
	 */
	public void modifyTeacher(int index, Teacher teacher) {
		teachers.add(index, teacher);
		orderTeachers();
	}

	/**
	 * 
	 * @param teacher object which you create the ID for
	 */
	public void generateID(Teacher teacher) {
		teacher.setTeacherID("T" + (teachers.size() + 1));
	}

	/**
	 * <p>
	 * This method orders alphabetically all the teachers by name
	 * </p>
	 */
	public void orderTeachers() {
		Teacher aux = new Teacher();
		boolean repeat = true;
		boolean wrong = false;
		while (repeat && teachers.size() > 1) {
			for (int i = 0; i < teachers.size() - 2; i++) {
				if (teachers.get(i).getName().compareTo(teachers.get(i + 1).getName()) > 0) {
					aux = teachers.get(i);
					teachers.remove(i);
					teachers.set(i, teachers.get(i + 1));
					teachers.remove(i + 1);
					teachers.set(i + 1, aux);
					wrong = true;
				} else if (i == teachers.size() - 1 && wrong == false) {
					break;
				}
			}
			if (wrong == false)
				repeat = false;
		}

	}

	public void orderTeachers2() {
		if (teachers.size() > 1) {
			int smallestIndex = 0;
			

			for (int j = 0; j < teachers.size(); j++) {
				for (int i = j; i < teachers.size() - 1; i++) {

					if (teachers.get(smallestIndex).getName().compareTo(teachers.get(i).getName()) > 0) {

						smallestIndex = i;
					}

				}

				Teacher aux = teachers.get(smallestIndex);
				teachers.remove(smallestIndex);
				teachers.set(smallestIndex+1, teachers.get(j));
				teachers.set((j), aux);
				
			}

		}
	}

	// STUDENTS MANAGEMENT

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	/**
	 * 
	 * @param index of the student you want in the arraylist
	 * @return the student class object in that index
	 */
	public Student getStudent(int index) {
		return students.get(index);
	}

	/**
	 * 
	 * @param index of the student you want in the arraylist
	 * @return the student class object in that index
	 */
	public void addStudent(Student student) {
		generateID(student);
		students.add(student);
	}

	/**
	 * 
	 * @param student you want to add
	 *                <p>
	 *                When you add an student to the arraylist, it will generate an
	 *                ID automatically and it will be saved in each Administrative
	 *                object as a property
	 *                </p>
	 */
	public int findStudent(String studentID) {
		for (int i = 0; i < students.size(); i++)
			if (students.get(i).getStudentID().matches(studentID))
				return i;
		return -1;
	}

	/**
	 * 
	 * @param index of the student you want to delete
	 */
	public void deleteStudent(int index) {
		students.remove(index);
	}

	/**
	 * 
	 * @param index   of the student you want to modify
	 * @param student object with the new information that you want to change
	 */
	public void modifyStudent(int index, Student student) {
		students.add(index, student);
	}

	/**
	 * 
	 * @param student object which you create the ID for
	 */
	public void generateID(Student student) {
		student.setStudentID("S" + (students.size() + 1));
	}

	/**
	 * @param classroom you want to find the tutor of
	 * @return position of the teacher object with that classroom assigned in tutor
	 */
	public int tutorOf(String classroom) {
		for (int i = 0; i < teachers.size(); i++) {
			if (teachers.get(i).getTutor().equals(classroom))
				return i;
		}
		return -1;
	}
}
