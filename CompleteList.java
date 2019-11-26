package TakeCourse;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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
	
	
	public int getTotalgrade() {
		return totalgrade;
	}



	public void setTotalgrade(int totalgrade) {
		this.totalgrade = totalgrade;
	}



	public int getMajorgrade() {
		return majorgrade;
	}



	public void setMajorgrade(int majorgrade) {
		this.majorgrade = majorgrade;
	}



	public int getRefinegrade() {
		return refinegrade;
	}



	public void setRefinegrade(int refinegrade) {
		this.refinegrade = refinegrade;
	}



	public int getBasicrefine() {
		return basicrefine;
	}



	public void setBasicrefine(int basicrefine) {
		this.basicrefine = basicrefine;
	}



	public int getMajorbase() {
		return majorbase;
	}



	public void setMajorbase(int majorbase) {
		this.majorbase = majorbase;
	}



	public int getEnginmajor() {
		return enginmajor;
	}



	public void setEnginmajor(int enginmajor) {
		this.enginmajor = enginmajor;
	}



	public int getYearsemester() {
		return yearsemester;
	}



	public void setYearsemester(int yearsemester) {
		this.yearsemester = yearsemester;
	}



	public String getChecktake() {
		return checktake;
	}



	public void setChecktake(String checktake) {
		this.checktake = checktake;
	}



	public String getScore() {
		return score;
	}



	public void setScore(String score) {
		this.score = score;
	}



	public String getCoursename() {
		return coursename;
	}



	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}



	public String getCoursecode() {
		return coursecode;
	}



	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}




	public void calgrade() {
		
		 
        int count=0, i;
        String arr[]=new String[6000000];
		try {
			Scanner scan = new Scanner(new FileReader(new File("inputcourse.txt")));
		        while(scan.hasNext()){
		        	arr[count]=scan.next();
		            count++;
		            
		        }
		        
		        for(i=0; i<count; i++) {
		        		if (arr[i].equals("공학전공")) {
		        			try {
		        				PrintWriter outputStream = new PrintWriter(new FileWriter("공학전공.txt", true));
		        				outputStream.println(arr[i+4]);
		        				outputStream.close();
		        			} catch (IOException e) {
		        				System.out.println("오류 발생! 관리자에게 문의해주세요");
		        				System.exit(0);
		        			}
		        		}
		        		if (arr[i].equals("기본소양")) {
		        			try {
		        				PrintWriter outputStream = new PrintWriter(new FileWriter("기본소양.txt", true));
		        				outputStream.println(arr[i+4]);
		        				outputStream.close();
		        			} catch (IOException e) {
		        				System.out.println("오류 발생! 관리자에게 문의해주세요");
		        				System.exit(0);
		        			}
		        		}
		        		if (arr[i].equals("전공기반")) {
		        			try {
		        				PrintWriter outputStream = new PrintWriter(new FileWriter("전공기반.txt", true));
		        				outputStream.println(arr[i+4]);
		        				outputStream.close();
		        			} catch (IOException e) {
		        				System.out.println("오류 발생! 관리자에게 문의해주세요");
		        				System.exit(0);
		        			}
		        		}
		        		if (arr[i].equals("교양")) {
		        			try {
		        				PrintWriter outputStream = new PrintWriter(new FileWriter("교양.txt", true));
		        				outputStream.println(arr[i+4]);
		        				outputStream.close();
		        			} catch (IOException e) {
		        				System.out.println("오류 발생! 관리자에게 문의해주세요");
		        				System.exit(0);
		        			}
		        		}
		        		
		        	}
		        
		        scan.close();

		    
		} catch (FileNotFoundException e) {
			System.out.println("오류 발생! 관리자에게 문의해주세요");
			System.exit(0);
		}
		
		
		Scanner inputStream=null;
        try {
            inputStream = new Scanner(new FileInputStream("공학전공.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("오류 발생! 관리자에게 문의해주세요");
            System.exit(0);
        }
		
	
		int next;
		int sum=0;
		
		while (inputStream.hasNextInt()) {
			next = inputStream.nextInt( );
			enginmajor+=next;
	    }
		
		inputStream.close();
		
		try {
            inputStream = new Scanner(new FileInputStream("전공기반.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("오류 발생! 관리자에게 문의해주세요");
            System.exit(0);
        }
		
		sum=0;
		
		while (inputStream.hasNextInt()) {
			next = inputStream.nextInt( );
			majorbase+=next;
	    }
		
		inputStream.close();
		
		try {
            inputStream = new Scanner(new FileInputStream("기본소양.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("오류 발생! 관리자에게 문의해주세요");
            System.exit(0);
        }
		
		sum=0;
		
		while (inputStream.hasNextInt()) {
			next = inputStream.nextInt( );
			basicrefine+=next;
	    }
		
		inputStream.close();
		
		try {
            inputStream = new Scanner(new FileInputStream("교양.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("오류 발생! 관리자에게 문의해주세요");
            System.exit(0);
        }

		sum=0;
		
		while (inputStream.hasNextInt()) {
			next = inputStream.nextInt( );
			refinegrade+=next;
	    }
		
		inputStream.close();
		
		majorgrade=basicrefine+majorbase+enginmajor;
		totalgrade=majorgrade+refinegrade;
		
		
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
            System.out.println("오류 발생! 관리자에게 문의해주세요");
            System.exit(0);
        }
        catch (IOException e) {
        	System.out.println("오류 발생! 관리자에게 문의해주세요");
            System.exit(0);
		}
	}
	



	public void delcourse() throws IOException {
		
		
		BufferedReader br = new BufferedReader(new FileReader("inputcourse.txt"));
		String line=null;
		String []arr=new String[1000000];
		int count=0;
		int del_line;
		while((line=br.readLine())!=null) {
			arr[count]=line;
			count++;
		}
		
		
		
		br.close();
		
		File file=new File("inputcourse.txt");
		file.delete();
		
		int i;

		Scanner sc=new Scanner(System.in);
		System.out.println("삭제할 행 번호는? ");
		del_line=sc.nextInt();
		
		try  {
        	PrintWriter outputStream = new PrintWriter(new FileWriter("inputcourse.txt", true));
        	for (i=0; i<del_line; i++) {
        		outputStream.println(arr[i]);
        	}
        	for(i=del_line+1; i<count; i++) {
        		outputStream.println(arr[i]);
        	}
        	outputStream.close();
        }
		
		catch(FileNotFoundException e) {
            System.out.println("오류 발생! 관리자에게 문의해주세요");
            System.exit(0);
        }
		

	}
	

}
