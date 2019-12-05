package account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Data {
   private String Apath = "./account/account";
   private String Ppath = "./participant/";
   
   public String getPpath() { return Ppath;}
   public String getApath() { return Apath;}
   
   public int findId(String Id) { //���̵� ã�� (���̵� ���翩�� Ȯ��) : ���� 1 / ���� 0
      File accountFile = new File(getApath());
      String []stringArray;
      String str;
      File makefolder = new File(getPpath());
      File makefolder2 = new File("./account/");
      if(!makefolder.exists()) {
         try {
            makefolder.mkdir();
            makefolder2.mkdir();
         } catch(Exception e){
            e.getStackTrace();
         }
      }
      
      if(accountFile.exists() == false) { //���� ���� ���� Ȯ�� �� �ʱ�ȭ
         try{
            BufferedWriter accountfile = new BufferedWriter(new FileWriter(getApath(),true));
            accountfile.write("");
            accountfile.close();
         } catch(IOException e){
            System.out.println("오류발생! 관리자에게 문의하세요.");
            e.printStackTrace();
         }
      }
      try { //account���Ͽ��� Id�� �����ϴ��� Ȯ��
         FileReader fr = new FileReader(getApath());
         BufferedReader br = new BufferedReader(fr);
         while((str = br.readLine()) != null) {
            stringArray = str.split(" ");
            if(stringArray[0].equals(Id)) {
               fr.close();
               br.close();
               return 1;
            }
         }
         fr.close();
         br.close();
      }catch(IOException e) {
         System.out.println("오류발생! 관리자에게 문의하세요.");
         e.printStackTrace();
      }
      return 0;
   }

   public int equalIdPw(String Id, String Password) { //���̵� ��й�ȣ ��ġ Ȯ�� : ��ġ 1/ ����ġ 0
      String []stringArray;
      String str;
      try {
         BufferedReader bf = new BufferedReader(new FileReader(getApath()));
         while((str = bf.readLine())!=null) {
            stringArray = str.split(" ");
            if((stringArray[0].equals(Id))&& (stringArray[1].equals(Password))) {
               bf.close();
               return 1; // �α��� ������
            }
         }
         bf.close();
      }catch(IOException e) {
         System.out.println("오류발생! 관리자에게 문의하세요.");
         e.printStackTrace();
      }
      return 0;
   }
   public void joinAccount(String Id, String Password, String job) { //ȸ������
      BufferedWriter accountFile;
      File makefolder = new File(getPpath());
      File makefolder2 = new File("./account/");
      if(!makefolder.exists()) {
         try {
            makefolder.mkdir();
            makefolder2.mkdir();
         } catch(Exception e){
            e.getStackTrace();
         }
      }
      try {
         accountFile = new BufferedWriter(new FileWriter(getApath(),true));
         accountFile.write(Id+" "+Password+" "+job+"\n");
         accountFile.close();
      } catch(IOException e) {
         System.out.println("오류발생! 관리자에게 문의하세요.");
         e.printStackTrace();
      }
   }
   public void joinStudent(String Id, String name, String number, String major, String track, int country) {
      BufferedWriter studentFile;
      try {
         File Folder = new File(getPpath()+Id);
         Folder.mkdir();
         studentFile = new BufferedWriter(new FileWriter(getPpath()+Id+"/"+Id,true));
         studentFile.write(name+"\n"+number+"\n"+major+"\n"+track+"\n"+country);
         studentFile.close();
         
      } catch(IOException e) {
         System.out.println("오류발생! 관리자에게 문의하세요.");
         e.printStackTrace();
      }
   }
   public void joinAdmin(String Id,String name, String number) {
      BufferedWriter adminFile;
      try {
         adminFile = new BufferedWriter(new FileWriter(getApath()+Id+"/"+Id,true));
         adminFile.write(name+"\n"+number);
         adminFile.close();
      } catch(IOException e) {
         System.out.println("오류발생! 관리자에게 문의하세요.");
         e.printStackTrace();
      }
   }
   public String getJob(String Id) {
      String []stringArray;
      String str;
      String job = null;
      try { //account���Ͽ��� Id�� �����ϴ��� Ȯ��
         FileReader fr = new FileReader(getApath());
         BufferedReader br = new BufferedReader(fr);
         while((str = br.readLine()) != null) {
            stringArray = str.split(" ");
            if(stringArray[0].equals(Id)) {
               fr.close();
               br.close();
               job = stringArray[2];
               return job;
            }
         }
         fr.close();
         br.close();
      }catch(IOException e) {
         System.out.println("오류발생! 관리자에게 문의하세요.");
         e.printStackTrace();
      }
      
      return job;
   }
   public String findUserId(String name, String number) {
      File participantDir = new File(Ppath);
      String[] fileList = participantDir.list();
      BufferedReader bf;

      String searchName = null;
      String partiNum = null;
      
      for(int i=0; i < fileList.length; i++) { //
         try {
            bf = new BufferedReader(new FileReader(Ppath+fileList[i]+"/"+fileList[i]));
            if((searchName = bf.readLine()).equals(name)) {
               if((partiNum = bf.readLine()).equals(number)) {
                  searchName = fileList[i];
                  break; 
               }
            }
         } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("오류발생! 관리자에게 문의하세요.");
         } catch(IOException e) {
            e.printStackTrace();
            System.out.println("오류발생! 관리자에게 문의하세요.");
         }
      }
      return searchName;
   }
   public String findUserPw(String Id, String name, String number) {
      File participantDir = new File(Ppath);
      String[] fileList = participantDir.list();
      BufferedReader bf;

      String partiNum = null;
      
      for(int i=0; i < fileList.length; i++) { //
         try {
            bf = new BufferedReader(new FileReader(Ppath+fileList[i]+"/"+fileList[i]));
            if(bf.readLine().equals(name)) {
               if((partiNum = bf.readLine()).equals(number)) {
                  break; 
               }
            }
         } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("오류발생! 관리자에게 문의하세요.");
         } catch(IOException e) {
            e.printStackTrace();
            System.out.println("오류발생! 관리자에게 문의하세요.");
         }
      }
      return partiNum;
   }
   
   public String[] getUserData(String Id) 
   {
      String []stringArray = new String[6];
      int i=0;
      
      try 
      { //account���Ͽ��� Id�� �����ϴ��� Ȯ��
         FileReader fr = new FileReader(getPpath()+Id+"/"+Id);
         BufferedReader br = new BufferedReader(fr);
         
         while((stringArray[i] = br.readLine()) != null) 
             i++;
         
         fr.close();
         br.close();
      }catch(IOException e) {
         System.out.println("오류발생! 관리자에게 문의하세요.");
         e.printStackTrace();
      }
      i=0;
      
      return stringArray;
      
   }

	public void Store_userspace(String Id) {

		String filepath = "./세부졸업요건.txt";
		String userpath = getPpath() + Id + "/세부졸업요건.txt";

		File oriFile = new File(filepath);
		File copyFile = new File(userpath);

		try {
			FileInputStream fis = new FileInputStream(oriFile); // 읽을파일
			InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
			BufferedReader in = new BufferedReader(reader);
			FileOutputStream fos = new FileOutputStream(copyFile); // 복사할파일

			int fileByte = 0;

			while ((fileByte = fis.read()) != -1) {
				fos.write(fileByte);
			}

			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("오류발생! 관리자에게 문의하세요.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("오류발생! 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}
}