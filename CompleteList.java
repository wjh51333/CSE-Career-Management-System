package Take_Course;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
//이수 목록
//재이수 가능 판단, 점수 계산, 필수과목수강확인, 강의추가, 강의 삭제
public class CompleteList {

	private int totalgrade;
	private int majorgrade;
	private int refinegrade;
	private int basicrefine;
	private int majorbase;
	private int enginmajor;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void checkrepeat() {
		
		
	}
	

	public void calgrade() {
		
		
	}
	

	
	Scanner inputStream=null;
	String coursename=null;
	String curriclassification=null;
	String coursecode = null, grade = null;
	String [][]ci =new String[10000000][4];
	int cicount=0;
	

	public void addcourse() {
		try {
			
            inputStream = new Scanner(new FileReader ("curriculum.txt"));
			while (inputStream.hasNext()) {
				curriclassification = inputStream.next();
				coursename = inputStream.next();
				coursecode = inputStream.next();
				grade = inputStream.next();
				ci[cicount][0]=curriclassification;
				ci[cicount][1]=coursecode;
				ci[cicount][2]=grade;
				cicount+=1;
			}			
			inputStream.close();
					
		} catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + "curriculum.txt");
            System.exit(0);
		}
	}
	
	public void delcourse() {
		
		
	}

}
