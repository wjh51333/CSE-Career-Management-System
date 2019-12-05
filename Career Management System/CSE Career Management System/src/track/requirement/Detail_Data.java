package track.requirement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Detail_Data 
{
	HashMap <String, Integer> detail_data_list = new HashMap <String, Integer> ();
	
	public HashMap <String, Integer> open_detail_graduation(String Filename)
	{
		String [] stringarray;
		String str;
		try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Filename), "utf-8"));
				while((str = br.readLine()) != null)
				{
					stringarray = str.split(" ");
					detail_data_list.put(stringarray[0], Integer.parseInt(stringarray[1]));
				}
				br.close();
		} catch (FileNotFoundException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
		
		return detail_data_list;
	}
	
	public void store_detail_graduation(account.Account a, HashMap <String, Integer> newthing, String Filename)
	{
		detail_data_list = newthing;
		
		try {
			File file = new File(Filename);
			file.delete();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Filename), "utf-8"));
			for(String key : detail_data_list.keySet())
			{
				bw.write(key + " " + detail_data_list.get(key));
				bw.write("\n");
			}
			bw.close();
			detail_data_list.clear();
		} catch (IOException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}
	
	/*public void Store_userspace(Account.account a)
	{
		String filepath;
		String userpath;
		
		filepath = "./세부졸업요건.txt";
		userpath = "./participant/" + a.getUserName() + "/세부졸업요건.txt";
		
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
	}*/
}
