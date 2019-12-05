package track.requirement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ABEEK_Data 
{
	ArrayList <Integer> abeeklist = new ArrayList <Integer> ();
	
	public ArrayList <Integer> getRequire(String Filename)
	{
		try {
			FileReader fr = new FileReader(Filename);
			BufferedReader br = new BufferedReader(fr);
			abeeklist.add(0, Integer.parseInt(br.readLine()));
			abeeklist.add(1, Integer.parseInt(br.readLine()));
			abeeklist.add(2, Integer.parseInt(br.readLine()));
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
		
		return abeeklist;
	}
	
	public void store_abeek_data(ArrayList <Integer> newthing, String Filename)
	{
		try {
			File file = new File(Filename);
			file.delete();
			FileWriter fw = new FileWriter(Filename);
			BufferedWriter bw = new BufferedWriter(fw);
			fw.write(newthing.get(0) + "\n");
			fw.write(newthing.get(1) + "\n");
			fw.write(newthing.get(2) + "\n");
			fw.close();
			bw.close();
		} catch (IOException e) {
			System.out.println("오류 발생. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}
}
