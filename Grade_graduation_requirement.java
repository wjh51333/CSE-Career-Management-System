package software_design;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Grade_graduation_requirement 
{
	private int total_grade_point; // 총 이수학점
	private int id_range; // 학번 범위
	private int major_grade_point; // 전공 학점
	private int liberalart_grade_point; // 교양 학점
	
	public int getTotal_grade_point() {
		return total_grade_point;
	}
	public void setTotal_grade_point(int total_grade_point) {
		this.total_grade_point = total_grade_point;
	}
	public int getId_range() {
		return id_range;
	}
	public void setId_range(int id_range) {
		this.id_range = id_range;
	}
	public int getMajor_grade_point() {
		return major_grade_point;
	}
	public void setMajor_grade_point(int major_grade_point) {
		this.major_grade_point = major_grade_point;
	}
	public int getLiberalart_grade_point() {
		return liberalart_grade_point;
	}
	public void setLiberalart_grade_point(int liberalart_grade_point) {
		this.liberalart_grade_point = liberalart_grade_point;
	}
	
	public void select_id_range(int id) 
	{
		if(id <= 2009) // 학번이 2009학번보다 높으면
			id_range = 1;
		else if(id >= 2010 && id <= 2011) // 학번이 2010, 2011학번이라면
			id_range = 2;
		else // 학번이 2012학번보다 낮으면
			id_range = 3;
	}
	
	
	public void getRequirements(String Filename) // ABEEK졸업요건 가져오기
	{	
		try {
			FileReader fr = new FileReader(Filename);
			BufferedReader br = new BufferedReader(fr);
			total_grade_point = Integer.getInteger(br.readLine());
			major_grade_point = Integer.getInteger(br.readLine());
			liberalart_grade_point = Integer.getInteger(br.readLine());
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
	
	public void store_ABEEK_graduation_requirement(String Filename) // ABEEK졸업요건 수정하기
	{
		try {
			File file = new File(Filename);
			file.delete();
			FileWriter fw = new FileWriter(Filename);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(total_grade_point + "\n");
			bw.write(major_grade_point + "\n");
			bw.write(liberalart_grade_point + "\n");
			fw.close();
			bw.close();
		} catch (IOException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}
	
	public void modified_ABEEK_graduation_requirement(int selection, int new_grade_point) // ABEEK졸업요건 수정하기
	{
		if(selection == 1)
			total_grade_point = new_grade_point;
		else if(selection == 2)
			major_grade_point = new_grade_point;
		else
			liberalart_grade_point = new_grade_point;
	}
}
