package participant;

public class Student {
	private String name; //����
	private String studentNum; //�й�
	private String major; //�а�
	private String track; //Ʈ��
	private int country; //���� 1�ѱ�, 0�ٸ�����
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
