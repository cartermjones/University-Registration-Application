public class Student {
 
	private String studentName;
	private String studentId;
	private String major;
	
	public Student (String aName, String anId, String aMajor) {
		studentName = aName;
		studentId = anId;
		major = aMajor;
	}
	
	public String getName() {
		return studentName;
	}
	
	public String getId() {
		return studentId;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setName(String aName) {
		studentName = aName;
	}
	
	public void setId(String anId) {
		studentId = anId;
	}
	
	public void setMajor(String aMajor) {
		major = aMajor;
	}
	
	public String studentProfile(Student aStudent) {
		return "Name: " + aStudent.getName() + " ID: " + aStudent.getId() + " Major: " + aStudent.getMajor();  
	}
}
