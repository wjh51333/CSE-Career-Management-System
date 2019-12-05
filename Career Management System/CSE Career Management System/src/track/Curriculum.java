package track;

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
	
	public void getRequiredCourses(String Filename) // 교과과정 불러오기
	{
		CurriculumData d = new CurriculumData();
		course = d.Getdata(Filename);
		
		/*String str;
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
		}*/	
	}
	
	public void delete_curriculum(int index) // 교과과정 삭제하기
	{
		course.remove(index);
	}
	
	public void add_curriclum(int semester, int school_year, String subject_name, String subject_code, int grade_point, int essential)
	{
		Subject s = new Subject(semester, school_year, subject_name, subject_code, grade_point, essential);
		course.add(s);
	}
	
	public void store_curriculum(String Filename) // 교과과정 저장하기
	{
		CurriculumData d = new CurriculumData();
		d.Storedata(course, Filename);
		/*try {
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
		}*/
	}
	
	public void store_user(account.Account a)
	{
		CurriculumData d = new CurriculumData();
		d.Store_userspace(a);
	}
}
