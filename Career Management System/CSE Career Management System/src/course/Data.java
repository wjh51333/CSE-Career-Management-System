package course;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Data {

	private int count=0;
	String [] arr=new String[150];
	String array[][]=new String[150][6];


	public void mdfile2(String filename) {
		File file=new File(filename);
		try {
			FileWriter fw = new FileWriter(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void mdfile(String filename) {
		File file=new File(filename);
		file.delete();
	}
	public String getfile(String filename) {
		StringBuffer buffer = new StringBuffer();
		try {	
			Scanner scan = new Scanner(new FileReader(new File(filename)));
			while(scan.hasNext()){
				buffer.append(scan.nextLine() + ",");
			}
			scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("오류 발생! 관리자에게 문의해주세요");
			System.exit(0);
		}
			
		String input = buffer.toString().substring(0, buffer.toString().length()-1);
		return input;
	}
	
	public String[] getfile2(String filename) {

		try {
			Scanner scan = new Scanner(new FileReader(new File(filename)));
			while(scan.hasNext()){
	        	arr[count]=scan.next();
	        	count++;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("오류! 관리자에게 문의하세요.");
			System.exit(0);
		}
		
		return arr;
	}

	public int getfile3(String filename) {
		Scanner inputStream=null;
		int next, result=0;
        try {
            inputStream = new Scanner(new FileInputStream(filename));
    		while (inputStream.hasNextInt()) {
    			next = inputStream.nextInt( );
    			result+=next;
    	    }
    		inputStream.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("오류 발생3! 관리자에게 문의해주세요");
            System.exit(0);
        }
        return result;
	}
	
	public void setfile(String filename, String str) {
    	PrintWriter outputStream;
		try {
			outputStream = new PrintWriter(new FileWriter(filename, true));
	    	outputStream.println(str);
	    	outputStream.close();
		} catch (IOException e) {
			System.out.println("오류 발생4! 관리자에게 문의하세요.");
			System.exit(0);
		}
	}

	
	private int yearsemester;
	private String checktake;
	private String score;
	private String coursename;
	private String coursecode;
	private String grade;


	public void addcourse(String filename) {
		
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
		coursename = keyboard2.nextLine();
		
		System.out.println("과목코드");
		coursecode=ci.coursecode;
		coursecode = keyboard2.nextLine();
		
		System.out.println("학점");
		grade=ci.grade;
		grade = keyboard2.nextLine();
		
		System.out.println("점수");
		Scanner keyboard3=new Scanner(System.in);
		score=cg.score;
		score = keyboard3.nextLine();


        try  {
        	PrintWriter outputStream = new PrintWriter(new FileWriter(filename, true));
        	outputStream.print(yearsemester+" "+ checktake+" "+score+" "+coursename + " " + coursecode + " " + grade);
        	outputStream.println(" ");
        	outputStream.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("오류 발생5! 관리자에게 문의해주세요");
            System.exit(0);
        }
        catch (IOException e) {
        	System.out.println("오류 발생6! 관리자에게 문의해주세요");
            System.exit(0);
		}
	}
	

	public void delcourse(String filename) {
		
		String line=null;
		String []arr=new String[1000000];
		int count=0;
		int del_line;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filename));
			while((line=br.readLine())!=null) {
				arr[count]=line;
				count++;
			}
			
			br.close();
			
		} catch (FileNotFoundException e1) {
			System.out.println("오류 발생7! 관리자에게 문의해주세요");
			System.exit(0);
		} catch (IOException e) {
            System.out.println("오류 발생8! 관리자에게 문의해주세요");
            System.exit(0);
        }
		
		
		File file=new File(filename);
		file.delete();
		
		int i;

		Scanner sc=new Scanner(System.in);
		System.out.println("삭제할 행 번호는? ");
		del_line=sc.nextInt();
		
		try  {
        	PrintWriter outputStream = new PrintWriter(new FileWriter(filename, true));
        	for (i=0; i<del_line; i++) {
        		outputStream.println(arr[i]);
        	}
        	for(i=del_line+1; i<count; i++) {
        		outputStream.println(arr[i]);
        	}
        	outputStream.close();
        }
		
		catch(FileNotFoundException e) {
            System.out.println("오류 발생9! 관리자에게 문의해주세요");
            System.exit(0);
        } catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
