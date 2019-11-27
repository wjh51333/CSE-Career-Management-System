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
	
	public void getRequiredCourses(String Filename)
	{
		String str;
		String [] stringarr;
		
		try {
			FileReader fr = new FileReader(Filename);
			BufferedReader br = new BufferedReader(fr);
			while((str = br.readLine()) != null)
			{
				Subject new_subject = new Subject();
				
				stringarr = str.split(" ");
				
				new_subject.setSemester(Integer.parseInt(stringarr[0]));
				new_subject.setSchool_year(Integer.parseInt(stringarr[1]));
				new_subject.setSubject_name(stringarr[2]);
				new_subject.setSubject_code(stringarr[3]);
				new_subject.setGrade_point(Integer.parseInt(stringarr[4]));
				new_subject.setEssential(Integer.parseInt(stringarr[5]));
				
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
				fw.write(s.toString() + "\n");
			}
			fw.close();
			bw.close();
		} catch (IOException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}
}
