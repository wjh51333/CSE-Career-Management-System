package software_design;
/*
 * 심화컴퓨터 전공의 경우, 1
 * 글솦의 경우, 2
 * 연계/융햡전공의 경우, 3
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Detail_Graduation 
{
	private int topcit; // TOPCIT 응시 여부
	private int English_test; // 공인 영어 시험 응시 여부
	private int professor_consulting; // 지도 교수 상담 횟수
	private int graduation_interview; // 졸업 인터뷰 여부
	private int field_practice; // 현장 실습 여부
	private int portfolio_submit; // 포트폴리오 제출 여부
	private int entrepreneurship_course; // 창업교과목 이수 여부
	private int another_major; // 다른 전공 선택
	private int career_consulting; // 진로 설계 상담 여부
	private int id_range; // 학범 범위(~09 : 1번, 10,11 : 2번, 12~ : 3번)
	private HashMap <String, Integer> detailList = new HashMap <String, Integer> ();
	
	public HashMap<String, Integer> getDetailList() {
		return detailList;
	}
	public void setDetailList(HashMap<String, Integer> detailList) {
		this.detailList = detailList;
	}
	public int getTopcit() {
		return topcit;
	}
	public void setTopcit(int topcit) {
		this.topcit = topcit;
	}
	public int getEnglish_test() {
		return English_test;
	}
	public void setEnglish_test(int english_test) {
		English_test = english_test;
	}
	public int getProfessor_consulting() {
		return professor_consulting;
	}
	public void setProfessor_consulting(int professor_consulting) {
		this.professor_consulting = professor_consulting;
	}
	public int getGraduation_interview() {
		return graduation_interview;
	}
	public void setGraduation_interview(int graduation_interview) {
		this.graduation_interview = graduation_interview;
	}
	public int getField_practice() {
		return field_practice;
	}
	public void setField_practice(int field_practice) {
		this.field_practice = field_practice;
	}
	public int getPortfolio_submit() {
		return portfolio_submit;
	}
	public void setPortfolio_submit(int portfolio_submit) {
		this.portfolio_submit = portfolio_submit;
	}
	public int getEntrepreneurship_course() {
		return entrepreneurship_course;
	}
	public void setEntrepreneurship_course(int entrepreneurship_course) {
		this.entrepreneurship_course = entrepreneurship_course;
	}
	public int getAnother_major() {
		return another_major;
	}
	public void setAnother_major(int another_major) {
		this.another_major = another_major;
	}
	public int getCareer_consulting() {
		return career_consulting;
	}
	public void setCareer_consulting(int career_consulting) {
		this.career_consulting = career_consulting;
	}
	public int getId_range() {
		return id_range;
	}
	public void setId_range(int id_range) {
		this.id_range = id_range;
	}
	
	public void open_detailed_graduation_requirement(String Filename) // 세부졸업요건 읽어오기
	{
		String [] stringarray;
		String str;
		try {
				FileReader fr = new FileReader(Filename);
				BufferedReader br = new BufferedReader(fr);
				while((str = br.readLine()) != null)
				{
					stringarray = str.split(" ");
					detailList.put(stringarray[0], Integer.parseInt(stringarray[1]));
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
	
	public void modified_detailed_graduation_requirement(String something, int new_one) // 세부졸업요건 값 수정하기
	{
		detailList.put(something, new_one);
	}
	
	public void store_detailed_graduation_requirement(String Filename) // 세부졸업요건 저장하기
	{
		try {
			File file = new File(Filename);
			file.delete();
			FileWriter fw = new FileWriter(Filename);
			BufferedWriter bw = new BufferedWriter(fw);
			for(String key : detailList.keySet())
			{
				bw.write(key + " " + detailList.get(key));
				bw.write("\n");
			}
			bw.close();
			detailList.clear();
		} catch (IOException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}
	
	public void print_detailed_graduation_requirement(String Filename)
	{
		for(String key : detailList.keySet())
		{
			System.out.println(key + " " + detailList.get(key));
		}
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
	
	public void add_detailed_graduation_requirement(String new_attribute, int new_key) // 세부졸업요건 추가하기
	{
		detailList.put(new_attribute, new_key);
	}
	
	public void delete_detailed_graduation_requirement(String attribute) // 세부졸업요건 삭제하기
	{
		detailList.remove(attribute);
	}
}
