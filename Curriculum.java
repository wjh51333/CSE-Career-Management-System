package software_design;
/*
 * 심화컴퓨터 전공의 경우, 1
 * 글솦의 경우, 2
 * 연계/융햡전공의 경우, 3
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Curriculum 
{
	private ArrayList <Subject> course = new ArrayList();
	
	public ArrayList<Subject> getCourse() {
		return course;
	}
	public void setCourse(ArrayList<Subject> course) {
		this.course = course;
	}

	public void addCurriculum(Subject subject) // subject를 얻어와서 list를 만든다.
	{
		course.add(subject);
	}
	
	public void deleteCurriculum(Subject subject) // 해당 subject를 제거한다.
	{
		course.remove(subject);
	}
	
	public void getRequiredCourses(String Filename)
	{
		String str;
		String [] stringarr;
		Subject new_subject = new Subject();
		
		try {
			FileReader fr = new FileReader(Filename);
			BufferedReader br = new BufferedReader(fr);
			while((str = br.readLine()) != null)
			{
				stringarr = str.split(" ");
				
				new_subject.setSemester(Integer.getInteger(stringarr[0]));
				new_subject.setSchool_year(Integer.getInteger(stringarr[1]));
				new_subject.setSubject_name(stringarr[2]);
				new_subject.setSubject_code(stringarr[3]);
				new_subject.setGrade_point(Integer.getInteger(stringarr[4]));
				new_subject.setEssential(Integer.getInteger(stringarr[5]));
				
				course.add(new_subject);
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		}	
	}
	
	public void store_curriculum(String Filename) // ABEEK졸업요건 저장하기
	{
		try {
			FileWriter fw = new FileWriter(Filename);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Subject s : course)
			{
				bw.write(s.getSemester() + " " + s.getSchool_year() + " " + s.getSubject_name() + " " + s.getSubject_code() + " " + s.getGrade_point() + " " + s.getEssential());
			}
			fw.close();
			bw.close();
		} catch (IOException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}
}
