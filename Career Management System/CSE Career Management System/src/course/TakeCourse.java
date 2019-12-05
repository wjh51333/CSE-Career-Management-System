package course;

import java.util.Arrays;
import java.util.Scanner;

import course.Data;
import course.TakeCourse;

//수강 강의
//재이수 판단, 정보 가져오기
public class TakeCourse {


	String str1[][]=new String[150][6];
	private int len;
	
	public String[][] getCourseinfo(String filename) {
		Data d=new Data();
		TakeCourse tc=new TakeCourse();
		int i=0;
		String str=d.getfile(filename);
		int row = str.split(",").length;
		String[][] array = new String[row][6];
		for (i = 0; i < str.split(",").length; i++) {
			array[i] =str.split(",")[i].split("\\s");
		};
		len=i;
		return array;
	}
	
	public void secondjudg(String filename, String[][] array) {
	
		String output[]=new String[150];
		int i=0, j, k=0;
		

		for (i=0; i<len; i++) {
	        	if (array[i][2].equals("C+")|| array[i][2].equals("C") || array[i][2].equals("C-")|| array[i][2].equals("D+")|| array[i][2].equals("D")|| array[i][2].equals("D-") || array[i][2].equals("F")) {
	        		output[k]=(array[i][0] +" "+array[i][1]+" "+array[i][2]+" "+array[i][3]+" "+array[i][4]+" "+array[i][5]);
	        		k++;
	        	}
		}
		
		
		Data d=new Data();
		String filename2=filename.split(".txt")[0];
        d.mdfile(filename2+"재이수가능.txt"); 
        for (i=0; i<k; i++)
        	d.setfile(filename2+"재이수가능.txt", output[i]);
	}
}
		

