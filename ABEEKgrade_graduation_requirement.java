package software_design;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ABEEKgrade_graduation_requirement 
{
	private int basic_literacy_point; // 기본 소양 학점(1)
	private int major_base_point; // 전공 기반 학점(2)
	private int engineering_major_point; // 공학 전공 학점(3)
	private int abeek_point; // 기본소양+전공기반+공학전공
	private int id_range; // 학번 범위
	
	public int getBasic_literacy_point() {
		return basic_literacy_point;
	}
	public void setBasic_literacy_point(int basic_literacy_point) {
		this.basic_literacy_point = basic_literacy_point;
	}
	public int getMajor_base_point() {
		return major_base_point;
	}
	public void setMajor_base_point(int major_base_point) {
		this.major_base_point = major_base_point;
	}
	public int getEngineering_major_point() {
		return engineering_major_point;
	}
	public void setEngineering_major_point(int engineering_major_point) {
		this.engineering_major_point = engineering_major_point;
	}
	public int getAbeek_point() {
		return abeek_point;
	}
	public void setAbeek_point(int abeek_point) {
		this.abeek_point = basic_literacy_point + major_base_point + engineering_major_point;
	}
	public int getId_range() {
		return id_range;
	}
	public void setId_range(int id_range) {
		this.id_range = id_range;
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
			basic_literacy_point = Integer.getInteger(br.readLine());
			major_base_point = Integer.getInteger(br.readLine());
			engineering_major_point = Integer.getInteger(br.readLine());
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
			bw.write(basic_literacy_point + "\n");
			bw.write(major_base_point + "\n");
			bw.write(engineering_major_point + "\n");
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
			basic_literacy_point = new_grade_point;
		else if(selection == 2)
			major_base_point = new_grade_point;
		else
			engineering_major_point = new_grade_point;
	}
}
