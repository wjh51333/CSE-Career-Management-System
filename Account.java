package Account;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import participant.Administrator;
import participant.Student;


public class account {
	private String userName;
	private int login_status=0; // 로그인 상태
	
	public void setLogin_status(int status){
		this.login_status = status;
	}
	public int getLogin_status() {
		return login_status;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	
	public static void main(String[] args) {
		account a = new account();
		//a.logIn("tes231", "test2");
		//a.makeAccount("testtest","test2");
		//a.findUsername("유대용");
		a.findPassword("testtest","유대용","2015");
	}
	
	public void logIn(String Id, String Password) {
		String path = "./account/";
		File accountDir = new File(path);
		String[] fileList = accountDir.list();
		int exist=0;
		
		for(int i=0; i < fileList.length; i++) { //id존재여부 확인
			if(fileList[i].equals(Id)) {
				exist=1;
				break;
			}
		}
		
		if(exist == 1) { // id가 존재할때
			BufferedReader bf;
			try {
				bf = new BufferedReader(new FileReader("./account/"+Id));
				String rightpw = bf.readLine();
				if(Password.equals(rightpw)) {
					// id == ps
					login_status =1;
					account a = new account();
					a.setUserName(Id);
					System.out.println("로그인 성공!");
				}
				else {
					// id != ps
					System.out.println("아이디 패스워드 불일치!");
				}
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("오류 발생! 관리자에게 문의해주세요");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("오류 발생! 관리자에게 문의해주세요");
			}
			
			
		}
		else {
			//id가 존재하지 않을 때
			System.out.println("존재하지 않는 아이디입니다!");
		}
		
	}
	public void makeAccount(String id, String password) {
		String path = "./account/";
		File accountDir = new File(path);
		String[] fileList = accountDir.list();
		
		String participantpath = "./participant/";
		
		String pName; //성명
		String pNumber; //학번 or 교직원번호
		String pMajor; //학과
		String pTrack; //트랙
		int pCountry; //국적
		
		int exist=0;
		
		for(int i=0; i < fileList.length; i++) { //이름 중복 확인
			if(fileList[i].equals(id)) {
				exist=1;
				break;
			}
		}
		
		if(exist == 1) { //id가 중복 존재할때
			System.out.print("Already exist name");
		}
		else { //id 존재가 없을때
			BufferedWriter accountfile;
			try {
				accountfile = new 
						BufferedWriter(new FileWriter(path+id,true));
				accountfile.write(password);
				accountfile.close();
				System.out.println("student or admin");
				Scanner job = new Scanner(System.in);
				String jobname = job.nextLine();
				if(jobname.equals("student")) { // 
					System.out.println("name number major track country(1:korea /0:not korea)");
					Scanner scanner = new Scanner(System.in);
					pName = scanner.next();
					pNumber = scanner.next();
					pMajor = scanner.next();
					pTrack = scanner.next();
					pCountry = scanner.nextInt();
					
					File Folder = new File(participantpath + id);
					Folder.mkdir();
					BufferedWriter stufile;
					stufile = new BufferedWriter(new FileWriter(participantpath+id+"/"+id,true));
					stufile.write(pName);
					stufile.write("\n");
					stufile.write(pNumber);
					stufile.write("\n");
					stufile.write(pMajor);
					stufile.write("\n");
					stufile.write(pTrack);
					stufile.write("\n");
					stufile.write(pCountry);
					
					scanner.close();
					stufile.close();
					job.close();
					
				}
				else { //false는 교직원
					System.out.println("이름 관리자번호");
					Scanner scanner = new Scanner(System.in);
					pName = scanner.nextLine();
					pNumber = scanner.nextLine();
					Administrator admin = new Administrator();
					
					admin.setName(pName);
					admin.setAdminNum(pNumber);
					
					BufferedWriter adminfile;
					File Folder = new File(participantpath + id);
					Folder.mkdir();
					adminfile = new BufferedWriter(new FileWriter(participantpath+id+"/"+id,true));
					adminfile.write(pName);
					adminfile.write("\n");
					adminfile.write(pNumber);
					
					adminfile.close();
					scanner.close();
					job.close();
				}		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("오류 발생! 관리자에게 문의해주세요");
			}
		}
	}
	public int confirmLogin() {
		return getLogin_status();
	}
	public void logOut() {
		setLogin_status(0);
	}
	public void findUsername(String name) {
		/* 이름을 통해 검색해서
		 * id를 보여줌
		*/
		String path = "./participant/";
		File participantDir = new File(path);
		String[] fileList = participantDir.list();
		BufferedReader bf;
		String searchName = null;
		int exist = 0;
		
		
		
		for(int i=0; i < fileList.length; i++) { //
			try {
				bf = new BufferedReader(new FileReader(path+fileList[i]+"/"+fileList[i]));
				if((searchName = bf.readLine()).equals(name)) {
					searchName = fileList[i];
					exist =1;
					break; 
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("오류 발생! 관리자에게 문의해주세요");
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("오류 발생! 관리자에게 문의해주세요");
			}
		}
		if(exist == 1) {
			System.out.println("id : " + searchName);
		}
		else {
			System.out.println("no id in System.");
		}
	}
	public void findPassword(String Id, String name,String num) { //아이디, 이름,학번 
		/* 유저 이름, 학번을 통해서
		 * pw 를 보여줌
		 */
		String Ppath = "./participant/";
		File participantDir = new File(Ppath);
		String[] PartiList = participantDir.list();
		
		String Apath = "./account/";
		File accountDir = new File(Apath);
		String[] AccList = accountDir.list();
		
		BufferedReader partiBf;
		BufferedReader accBf;
		
		String searchName = null;
		String searchNum = null;
		String findNum = null;
		int exist_id = 0;
		int exist_name = 0;
		int exist_num = 0;
		
		for(int i=0; i < AccList.length;i++) {
			try { 
				accBf = new BufferedReader(new FileReader(Apath+AccList[i]));
				if(AccList[i].equals(Id)) {
					findNum = accBf.readLine();
					exist_id = 1; //아이디를 찾았다.
					searchName = Id;
					break;
				}
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("오류 발생! 관리자에게 문의해주세요");
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("오류 발생! 관리자에게 문의해주세요");
			}
			
		}
		
		for(int i=0; i < PartiList.length; i++) { //
			try {
				partiBf = new BufferedReader(new FileReader(Ppath+PartiList[i]+"/"+PartiList[i]));
				if((searchName = partiBf.readLine()).equals(name)) {
					searchName = PartiList[i];
					exist_name =1;
					if((searchNum = partiBf.readLine()).equals(num)) {
						exist_num =1;
						break;
					}
					break; 
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("오류 발생! 관리자에게 문의해주세요");
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("오류 발생! 관리자에게 문의해주세요");
			}
		}
		if(exist_id != 1) {
			System.out.println("id가 존재하지 않습니다!");
		}
		else if((exist_id == 1) && (exist_name == 1) && (exist_num == 1)) {
			System.out.println("Id : "+ Id + " Pw : "+findNum);
		}
		else if((exist_name & exist_num) == 0){
			System.out.println("이름과 학번이 일치하지 않습니다.");
		}
	}
}
