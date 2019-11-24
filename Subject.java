package software_design;

import java.util.ArrayList;

public class Subject 
{
	private int semester; // 학기
	private int school_year; // 학년
	private String subject_name; // 과목명
	private String subject_code; // 과목 코드
	private int grade_point; // 학점
	private int essential; // 필수여부

	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getSchool_year() {
		return school_year;
	}
	public void setSchool_year(int school_year) {
		this.school_year = school_year;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_code() {
		return subject_code;
	}
	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}
	public int getGrade_point() {
		return grade_point;
	}
	public void setGrade_point(int grade_point) {
		this.grade_point = grade_point;
	}
	public int getEssential() {
		return essential;
	}
	public void setEssential(int essential) {
		this.essential = essential;
	}
	
	public int checkIfRequired()
	{
		if(essential == 1)
			return 1;
		else
			return 0;
	}
}
