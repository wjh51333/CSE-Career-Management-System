package Take_Course;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	

	
	private int yearsemester;
	private String checktake;
	private String score;
	private String coursename;
	private String coursecode;
	private String grade;

	public void addcourse() {
		
		CourseGrade cg= new CourseGrade();
		CourseInfo ci=new CourseInfo();
		
		System.out.println("년도/학기");
		Scanner keyboard = new Scanner(System.in);
		yearsemester=cg.yearsemester;
		yearsemester = keyboard.nextInt();


		Scanner keyboard2 = new Scanner(System.in);
		System.out.println("교과구분");			
		checktake=cg.checktake;
		checktake = keyboard2.nextLine();

		System.out.println("과목명");
		coursename=ci.coursename;
		coursename = keyboard.nextLine();
		
		System.out.println("과목코드");
		coursecode=ci.coursecode;
		coursecode = keyboard.nextLine();
		
		System.out.println("학점");
		grade=ci.grade;
		grade = keyboard.nextLine();
		
		System.out.println("점수");
		Scanner keyboard3=new Scanner(System.in);
		score=cg.score;
		score = keyboard3.nextLine();
		


        try  {
        	PrintWriter outputStream = new PrintWriter(new FileWriter("inputcourse.txt", true));
        	outputStream.print(yearsemester+" "+ checktake+" "+score+" "+coursename + " " + coursecode + " " + grade);
        	outputStream.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Error opening the file " + "inputcourse");
            System.exit(0);
        }
        catch (IOException e) {
        	System.out.println("Error opening the file " + "inputcourse");
            System.exit(0);
		}
	}
	
	public void delcourse() {
		
		
	}

}
