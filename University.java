import java.util.Scanner;
/**
 * 
 * @author Carter Jones
 *This class is the main class for the whole shebang, although in retrospect maybe it shouldn't be. It's quite the workhorse. 
 *It has a lot of its own methods... that could probably be exported to another class. 
 *Then again, maybe I should just port the main method here to a UniversityTester class, rather than work this poor thing to death.
 *
 */


public class University {

	
	/**
	 * This here is the immense number of variables and arrays used to make this program function.
	 * The studentRoster array will hold a list of students.
	 * The courseList array will hold a list of courses.
	 * The University object we have here (u) is used to invoke some of the University's own methods.
	 * The other variables are used to doing work on students and courses.
	 * The Student object on the bottom (currently) is used to attempting to find a student by Id... currently a feature that isn't working quite right.
	 */
	private static Student[] studentRoster;
	private static Course[] courseList;
	private static University u = new University();
	private static String studentName = "";
	private static String studentId = "";
	private static String major = "";
	private static String courseName = "";
	private static String courseId = "";
	private static String instructor="";
	private static Student targetStudent;
	private static Course targetCourse;
	private static CourseStudent enrollment;
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		/**This is the scanner we will use to take user input.*/
		Scanner in = new Scanner(System.in);
		
		/**First we create and initialize an array to house our list of Students.*/
		studentRoster = new Student[10];
		
		/**Then we do the same for our courses.*/
		courseList = new Course[10];
		
		/**We prime our array with a sample student.*/
		studentRoster[0] = new Student("Jeremy Greene", "0001", "Biology");
		
		//This loop will just go ahead and initialize the whole damn thing with blanks.
		for(int i = 0; i < studentRoster.length; i++) {
			studentRoster[i] = new Student("", "", "");
		}
		
		/**We do the same with a sample course.*/
		courseList[0] = new Course("Intro to Dabbing", "D101", "Dr. Fleek Fleekenstein");
		
		/**This how we use the UniversityGreeter(), which is a method of the University class. It provides our greeting.*/
		System.out.println(u.universityGreeter());
		
		/**We then display the Main Menu to the console.*/
		System.out.println(mainMenu);
		
		/**And now we use the option variable to take in the user's input.*/
		String option = in.nextLine();
		
		/**We create an iterator variable here to make sure the thing doesn't goof up below in the while loops.*/
		int i = 0;
		
		//This is the while loop that will hypothetically house the main menu. Option must be "q" to quit.
		while(option != "q") {

			
		switch(option) {
			
			case "1": 
				while ( i < studentRoster.length)
				{
					if (studentRoster[i] == null) {
						break;
					}
					
					else 
					{
						System.out.println(studentRoster[i].studentProfile(studentRoster[i]));
						i++;
						continue;
					}
				
				}
				
				/**
				 * The following block of code resets option to "" and provides the option 
				 * to either return to the main menu or quit. It is repeated with every case.
				 * It could probably be automated, but I haven't figured that out yet.
				 */
				option = "";
				System.out.println("Return to main menu? (y/n)");
				option = in.nextLine();
				if(option.equals("y")) {
					option = "";
					System.out.println(mainMenu);
					option = in.nextLine();
					i = 0;
					continue;
				}
				else if (option.equals("n")) {
					System.out.println("Thanks for using the System. Godspeed.");
					option = "q";
					break;
				}
				
				option = "";
				i = 0;
				continue;
				
			case "2": 
				while (i < courseList.length)
				{
					if (courseList[i] == null) {
						break;
					}
					
					else 
					{	
						System.out.println(courseList[i].courseProfile(courseList[i]));
						i++;
						continue;
					}
				}
				
				//Same block as Case 1
				System.out.println("Return to main menu? (y/n)");
				option = in.nextLine();
				if(option.equals("y")) {
					option = "";
					System.out.println(mainMenu);
					option = in.nextLine();
					i = 0;
					continue;
				}
				else if (option.equals("n")) {
					System.out.println("Thanks for using the System. Godspeed.");
					option = "q";
					break;
				}
				
				option = "";
				i = 0;
				continue;
				
			case "3":
				System.out.println("Add student to the University Roster: ");
				System.out.println("Name: ");
				studentName = in.nextLine();
				System.out.println("ID: ");
				studentId = in.nextLine();
				System.out.println("Major: ");
				major = in.nextLine();
				
				for(i = 0; i < studentRoster.length; i++) {
					if(studentRoster[i] == null) {
						studentRoster[i] = u.createStudent(studentName, studentId, major);
						break;
					}
					else
						continue;
				}
				
				//Same block as Case 1.
				System.out.println("Return to main menu? (y/n)");
				option = in.nextLine();
				if(option.equals("y")) {
					option = "";
					System.out.println(mainMenu);
					option = in.nextLine();
					i = 0;
					continue;
				}
				else if (option.equals("n")) {
					System.out.println("Thanks for using the System. Godspeed.");
					option = "q";
					break;
				}
				
				option = "";
				i = 0;
				continue;
				
			case "4":
				System.out.println("Add course to University: ");
				System.out.println("Name: ");
				courseName = in.nextLine();
				System.out.println("ID: ");
				courseId = in.nextLine();
				System.out.println("Instructor: ");
				instructor = in.nextLine();
				
				for(i = 0; i < courseList.length; i++) {
					if(studentRoster[i] == null) {
						courseList[i] = u.createCourse(courseName, courseId, instructor);
						break;
					}
					else
						continue;
					
				}
				
				//Same block as Case 1. 
				System.out.println("Return to main menu? (y/n)");
				option = in.nextLine();
				if(option.equals("y")) {
					option = "";
					System.out.println(mainMenu);
					option = in.nextLine();
					i = 0;
					continue;
				}
				else if (option.equals("n")) {
					System.out.println("Thanks for using the System. Godspeed.");
					option = "q";
					break;
				}
				
				option = "";
				i = 0;
				continue;
				
			case "5":
				
				System.out.println("Search for a student by ID: ");
				int targetId = in.nextInt();
				targetStudent = u.findStudentById(Integer.toString(targetId));
				
				System.out.println(targetStudent.studentProfile(targetStudent));
				System.out.println("Search for a course by ID: ");
				String targetCourseId = in.nextLine();
				u.findCourseById(targetCourseId);
				
		
				//Same block as Case 1.
				System.out.println("Return to main menu? (y/n)");
				option = in.nextLine();
				
				if(option.equals("y")) {
					option = "";
					System.out.println(mainMenu);
					option = in.nextLine();
					i = 0;
					continue;
				}
				
				else if (option.equals("n")) {
					option ="";
					System.out.println("Thanks for using the System. Godspeed.");
					option = "q";
					break;
				}
				
				option = "";
				i = 0;
				continue;
				
			case "6":
				
				//Same block as Case 1.
				System.out.println("Return to main menu? (y/n)");
				option = in.nextLine();
				
				if(option.equals("y")) {
					option = "";
					System.out.println(mainMenu);
					option = in.nextLine();
					i = 0;
					continue;
				}
				
				else if (option.equals("n")) {
					option ="";
					System.out.println("Thanks for using the System. Godspeed.");
					option = "q";
					break;
				}
				
				option = "";
				i = 0;
				continue;
			
			case "7":
			
				//Same block as Case 1.
				System.out.println("Return to main menu? (y/n)");
				option = in.nextLine();
				
				if(option.equals("y")) {
					option = "";
					System.out.println(mainMenu);
					option = in.nextLine();
					i = 0;
					continue;
				}
				
				else if (option.equals("n")) {
					option ="";
					System.out.println("Thanks for using the System. Godspeed.");
					option = "q";
					break;
				}
				
				option = "";
				i = 0;
				continue;
			
			case "8":
				
				//Same block as Case 1.
				System.out.println("Return to main menu? (y/n)");
				option = in.nextLine();
				
				if(option.equals("y")) {
					option = "";
					System.out.println(mainMenu);
					option = in.nextLine();
					i = 0;
					continue;
				}
				
				else if (option.equals("n")) {
					option ="";
					System.out.println("Thanks for using the System. Godspeed.");
					option = "q";
					break;
				}
				
				option = "";
				i = 0;
				continue;
			
			case "9":
				
				//Same block as Case 1.
				System.out.println("Return to main menu? (y/n)");
				option = in.nextLine();
				
				if(option.equals("y")) {
					option = "";
					System.out.println(mainMenu);
					option = in.nextLine();
					i = 0;
					continue;
				}
				
				else if (option.equals("n")) {
					option ="";
					System.out.println("Thanks for using the System. Godspeed.");
					option = "q";
					break;
				}
				
				option = "";
				i = 0;
				continue;
			
			case "10":
				
				//Same block as Case 1.
				System.out.println("Return to main menu? (y/n)");
				option = in.nextLine();
				
				if(option.equals("y")) {
					option = "";
					System.out.println(mainMenu);
					option = in.nextLine();
					i = 0;
					continue;
				}
				
				else if (option.equals("n")) {
					option ="";
					System.out.println("Thanks for using the System. Godspeed.");
					option = "q";
					break;
				}
				
				option = "";
				i = 0;
				continue;
			//This case shuts do the system.
			case "q":
				System.out.println("Thanks for using the System. Godspeed.");
				option = "q";
		}
		}
	}
	
	/**
	 * 
	 * @param aName The name of a new student.
	 * @param anId The ID of a new student.
	 * @param aMajor The major of a new Student.
	 * @return This function will return a new Student object.
	 * This method is used for generating a new student on demand. (i.e., without hard-coding a student.)
	 */
	public Student createStudent(String aName, String anId, String aMajor) {
		Student student = new Student(aName, anId, aMajor);
		return student;
	}
	
	/**
	 * 
	 * @param aName The name of a new course.
	 * @param anId The ID of a new course.
	 * @param anInstructor The instructor of a new course.
	 * @return This function will return a new Course object.
	 * This method is used for generating a new course on demand.
	 */
	public Course createCourse(String aName, String anId, String anInstructor) {
		Course course = new Course(aName, anId, anInstructor);
		return course;
	}
	
	public Student findStudentById(String id) {
		
		System.out.println(studentRoster[0].getId());
		//This is a novelty reverse while loop. Thanks, Internet.
		int i = studentRoster.length - 1;
		
		while(i > -1) {
			
			if(id != studentRoster[i].getId()) {
				i--;
				continue;
			}
			
			else if(id.equals(studentRoster[i].getId())) {
				 targetStudent = studentRoster[i]; 
				 break;
			}
			
			else {
				System.out.println("Student not found.");
				break;
			}
		}
		return targetStudent;
	}
	
	public void findCourseById(String id) {
		
		int i = 0;
		
		while (i < courseList.length) {
			
			if(courseList[i] != null && id != courseList[i].getId()) {
				i++;
				continue;
			}
			
			else if(courseList[i] != null && id.equals(courseList[i].getId())) {
				targetCourse = courseList[i];
				break;
			}
			
			else {
				System.out.println("Course not found.");
				break;
			}
		}
	}
	
	public static String mainMenu = ("1. List Students \n" 
	+ "2. List Available Courses\n"  
	+ "3. Add Student to University\n" 
	+ "4. Add Course to University\n" 
	+ "5. Enroll Student in Course\n"
	+ "6. Select Course Profile (Will display course information w/ Students enrolled)\n" 
	+ "7. Select Student Profile (Will display student information w/courses enrolled)\n"  
	+ "8. Drop Student from Course\n" 
	+ "9. Remove Course from University\n" 
	+ "10. Remove Student from University\n" 
	+ "\n" 
	+ "Option: ");
	
	public String universityGreeter() {
		return "Welcome to the Course Registration System for University College. Please select one of the following options, or enter ‘q’ to quit: \n";
	}
	
	
	
}
