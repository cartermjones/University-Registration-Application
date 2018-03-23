public class Course {
	
	private String courseName;
	private String courseId;
	private String instructor;
	
	public Course(String aName, String anId, String anInstructor) {
		courseName = aName;
		courseId = anId;
		instructor = anInstructor;
	}
	
	public String getName() {
		return courseName;
	}
	
	public String getId() {
		return courseId;
	}
	
	public String getInstructor() {
		return instructor;
	}
	
	public void setName(String aName) {
		courseName = aName;
	}
	
	public void setId(String anId) {
		courseId = anId;
	}
	
	public void setMajor(String anInstructor) {
		instructor = anInstructor;
	}
	
	public String courseProfile(Course aCourse) {
		return "Name: " + aCourse.getName() + ", ID: " + aCourse.getId() + ", Instructor: " + aCourse.getInstructor();	}
}
