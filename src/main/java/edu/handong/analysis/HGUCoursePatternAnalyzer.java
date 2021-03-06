package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import java.util.ArrayList;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	//private Student[] students;
	//private Course[] courses;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		
		//students = new Student[numOfStudents];
		students = new ArrayList<Student>(numOfStudents);

		String name;
		//int count = 0;
		
		for(int i=0; i<lines.length; i++) {
			
			name = lines[i].split(",")[1].trim();
			
			if(studentExist(students, new Student(name))) {
				continue;
			}
			
			//students[count] = new Student(name);
			students.add(new Student(name));
			//count++;
			
		}
		
		return students;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> students, Student student) {

		for(int i = 0; i < students.size(); i++) {
			if(students.get(i) != null && students.get(i).getName().equals(student.getName())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		
		//courses = new Course[numOfCourses];
		courses = new ArrayList<Course>(numOfCourses);
		
		String name;
		//int count = 0;
		
		for(int i=0; i<lines.length; i++) {
			
			name = lines[i].split(",")[2].trim();
			
			if(courseExist(courses, new Course(name))) {
				continue;
			}
			
			//courses[count] = new Course(name);
			courses.add(new Course(name));
			//count++;
			
		}
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course course) {
		
		for(int i = 0; i < courses.size(); i++) {
			if(courses.get(i) != null && courses.get(i).getCourseName().equals(course.getCourseName())) {
				return true;
			}
		}
		return false;
	}

}