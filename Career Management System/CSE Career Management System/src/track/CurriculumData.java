package track;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CurriculumData 
{
	ArrayList <Subject> course_data = new ArrayList();
	
	public ArrayList <Subject> Getdata(String Filename) // 교과과정 가져오기
	{
		String str;
		String [] stringarr;
		
		try {
			FileReader fr = new FileReader(Filename);
			BufferedReader br = new BufferedReader(fr);
			while((str = br.readLine()) != null)
			{
				stringarr = str.split(" ");
				Subject new_subject = new Subject(Integer.parseInt(stringarr[0]), Integer.parseInt(stringarr[1]), stringarr[2], stringarr[3], Integer.parseInt(stringarr[4]), Integer.parseInt(stringarr[5]));
				course_data.add(new_subject);
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
		
		return course_data;
	}
	
	public void Storedata(ArrayList <Subject> new_thing, String Filename) // 교과과정 저장하기
	{
		course_data = new_thing;
		
		try {
			FileWriter fw = new FileWriter(Filename);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Subject s : course_data)
			{
				fw.write(s.toString() + "\n");
			}
			fw.close();
			bw.close();
		} catch (IOException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}
	
	public void Store_userspace(account.Account a)
	{
		String [] str = new String[6];
		String filepath;
		String userpath;
		
		str = a.getUserInfo(a.getUserName());
		
		filepath = "./" + str[3] + " 교과과정.txt";
		userpath = "./participant/" + a.getUserName() + "/교과과정.txt";
		
		File oriFile = new File(filepath);
		File copyFile = new File(userpath);
		
		try 
		{
			FileInputStream fis = new FileInputStream(oriFile); //읽을파일
			FileOutputStream fos = new FileOutputStream(copyFile); //복사할파일
	            
			int fileByte = 0; 
	            
	        while((fileByte = fis.read()) != -1) 
	        {
	        	fos.write(fileByte);
	        }
	        
	        fis.close();
	        fos.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("오류발생! 관리자에게 문의하세요.");
	        e.printStackTrace();
	    } 
		catch (IOException e) 
		{
	    	System.out.println("오류발생! 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}
}
