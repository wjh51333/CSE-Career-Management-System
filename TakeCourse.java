package TakeCourse;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//수강 강의
//재이수 판단, 정보 가져오기
public class TakeCourse {


	private String array[][]=new String[1000000][6];
	public String[][] getArray() {
		return array;
	}

	public void setArray(String[][] array) {
		this.array = array;
	}

	public TakeCourse getTc() {
		return tc;
	}

	public void setTc(TakeCourse tc) {
		this.tc = tc;
	}

	TakeCourse tc= new TakeCourse();



	
	public void getCourseinfo() {
	
        Scanner scan;
		try {
			scan = new Scanner(new FileReader(new File("inputcourse.txt")));
		       StringBuffer buffer = new StringBuffer();
		        while(scan.hasNext()){
		            buffer.append(scan.nextLine() + ",");
		        }
		        
		        // 마지막 쉼표를 제거한다.
		        String input = buffer.toString()
		                .substring(0, buffer.toString().length()-1);
		        
		        int row = input.split(",").length;
		        
		        String[][] array = new String[row][6];
		        
		        // 구분자를 기준으로 2차원 배열 넣음
		        for (int i = 0; i < input.split(",").length; i++) {
		            array[i] =input.split(",")[i].split("\\s");
		        }
		        
		        tc.secondjudg(array);

		    
		} catch (FileNotFoundException e) {
			System.out.println("오류 발생! 관리자에게 문의해주세요");
			System.exit(0);
		}
 

     
	}
	
	public void secondjudg(String[][] array) {
	
		try {
			PrintWriter outputStream = new PrintWriter(new FileWriter("recourse.txt", true));
			for(String[] arr : array){
		            	if (arr[2].equals("C+")|| arr[2].equals("C") || arr[2].equals("C-")|| arr[2].equals("D+")|| arr[2].equals("D")|| arr[2].equals("D-") || arr[2].equals("F")) {
		            		outputStream.print(arr[0] +" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" "+arr[5]);
		            		outputStream.println("");
		            	}
		            System.out.println();
		        }
			outputStream.close();
		} catch (IOException e) {
			System.out.println("오류 발생! 관리자에게 문의해주세요");
			System.exit(0);
		}
        

	}
}
	
