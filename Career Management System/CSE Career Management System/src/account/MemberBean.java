package account;

public class MemberBean {
	// 아이디, 비밀번호, 사용자 구분, 교직원번호/학번을 담을 프로퍼티(유저변수)
	private String id;
	private String pw;
	private String type;
	private String name;
	private String major;
	private String track;
	private String idNum;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setTrack(String track) {
		this.track = track;
	}
	
	public String getTrack() {
		return track;
	}
	
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	
	public String getIdNum() {
		return idNum;
	}
}
