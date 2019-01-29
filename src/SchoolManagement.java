
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar.Builder;
import java.util.Scanner;

import com.zubiri.school.*;

import java.io.*;

public class SchoolManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		School school = new School("zubiri");
		System.out.println("Welcome to the school management program./n /tWhat do you want to do?/n"
				+ "0-Exit/n 1- Change the school name/n 2- Manage teachers /n 3- Manage students/n 4- Manage administratives/n 5- Save/n ");
		String option = sc.next();
		sc.nextLine();
		switch(option) {
		default:System.out.println("Enter a number, try again."); break;
		case "1":
			System.out.println("Enter the name you want for your school.");
			school.setSchoolName(sc.nextLine());
			System.out.println("Done.");
			break;
		case "2":
			System.out.println("Welcome to Teachers management option. What do you want?");
			System.out.println("1- View Information/n 2- Modify Information/n 3-Delete Information/n 4-New Teacher/n 0-Exit");
			String teacherOption = sc.next();
			sc.nextLine();
			switch(teacherOption) {
			case "1":
				if(school.getTeachers().size()>0) {
					System.out.println("Whose information do you want to view? (Enter the ID of the Teacher you want to find)");
					school.findTeacher(sc.nextLine());
						
				}else
					System.out.println("There's no Teacher created yet.");
				break;
			case "4":
				System.out.println("*NEW TEACHER*");
				Teacher teacher = new Teacher();
				System.out.println("Name:");
				String possibleName = sc.next();
				sc.nextLine();
				while(!teacher.checkName(possibleName)) {
					System.out.println("Enter a valid name (no numbers)");
					possibleName=sc.next();
					sc.nextLine();
				}
				teacher.setName(possibleName);
				System.out.println("Birth date:");
				System.out.println("year:");
				int year = sc.nextInt();
				System.out.println("month:");
				int month = sc.nextInt();
				System.out.println("day:");
				int day = sc.nextInt();
				Calendar birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day).build();
				while(!teacher.checkDate(birthDate)){
					System.out.println("Enter a valid date");
					System.out.println("year:");
					year = sc.nextInt();
					System.out.println("month:");
					month = sc.nextInt();
					System.out.println("day:");
					day = sc.nextInt();
					birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day).build();
				}
				teacher.setBirthDate(birthDate);
				System.out.println("DNI:");
				String dni = sc.next();
				sc.nextLine();
				while(!teacher.checkDni(dni)) {
					System.out.println("Enter a valid DNI");
					dni=sc.next();
					sc.nextLine();
				}
				teacher.setDni(dni);
				System.out.println("Telephone number:");
				String phoneNumber= sc.next();
				sc.nextLine();
				while(!teacher.checkPhoneNumber(phoneNumber)) {
					System.out.println("Enter a valid phone number");
					phoneNumber=sc.next();
					sc.nextLine();
				}
				teacher.setPhoneNumber(phoneNumber);
				System.out.println("Salary:");
				double salary = sc.nextDouble();
				while(!teacher.checkSalary(salary)) {
					System.out.println("Enter a valid salary");
					salary=sc.nextDouble();
				}
				teacher.setSalary(salary);
				System.out.println("Joined");
				System.out.println("year:");
				year = sc.nextInt();
				System.out.println("month:");
				month = sc.nextInt();
				System.out.println("day:");
				day = sc.nextInt();
				Calendar joined = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day).build();
				while(!teacher.checkDate(joined)){
					System.out.println("Enter a valid date");
					System.out.println("year:");
					year = sc.nextInt();
					System.out.println("month:");
					month = sc.nextInt();
					System.out.println("day:");
					day = sc.nextInt();
					joined = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day).build();
				}
				teacher.setJoined(joined);
				System.out.println("Is she/he a tutor? (y/n)");
				boolean askAgain = true;
				while (askAgain == true) {
					String back = sc.next().toLowerCase();
					sc.nextLine();
					switch (back) {
					case "y":
						System.out.println("What class is she/he tutor of?");
						teacher.setTutor(sc.next());
						sc.nextLine();
						break;
					case "n":
						break;
					default:
						System.out.println("Please, select a possible value(y/n)");
						break;
					}
				}
				System.out.println("How many subjects do she/he teach?");
				int numberOfSubjects = sc.nextInt();
				for(int i = 0; i<numberOfSubjects; i++) {
					System.out.println("enter one subject");
					teacher.addSubject(sc.next());
					sc.nextLine();
				}
				
				break;
			}
		}
		
	}

}
