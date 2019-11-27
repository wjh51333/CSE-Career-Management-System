package Account;

public class Student {
	private String name; //성명
	private String studentNum; //학번
	private String major; //학과
	private String track; //트랙
	private int country; //국적 1한국, 0다른나라
	private String job = "Student";
	
	//get set
	
	public String getJob() {
		return job;
	}
	
	public void getStudentInfo() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentnum) {
		this.studentNum = studentnum;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getTrack(){
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	
	//get set 
}