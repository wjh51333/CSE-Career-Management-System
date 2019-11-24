//package Teamproj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Account {
	private String userName;
	private String passWord;
	private int login_status=0; // �α��� ����
	
	public void setLogin_status(int status){
		this.login_status = status;
	}
	public int getLogin_status() {
		return login_status;
	}
	
	public static void main(String[] args) {
		//makeAccount("test","test1");
		findUsername("���");
	}
	
	public void logIn(String Id, String Password) {
		String path = "./account/";
		File accountDir = new File(path);
		String[] fileList = accountDir.list();
		int exist=0;
		
		for(int i=0; i < fileList.length; i++) { //�̸� �ߺ� Ȯ��
			if(fileList[i].equals(Id)) {
				exist=1;
				break;
			}
		}
		
		if(exist == 1) { // id�� �����Ҷ�
			BufferedReader bf;
			try {
				bf = new BufferedReader(new FileReader("./account/"+Id));
				String rightpw = bf.readLine();
				if(Password == rightpw) {
					// id == ps
					login_status =1;
				}
				else {
					// id != ps
					System.out.println("id != pw");
				}
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		else {
			//id�� �������� ���� ��
			System.out.println("no id exist");
		}
		
	}
	public static void makeAccount(String id, String password) {
		String path = "./account/";
		File accountDir = new File(path);
		String[] fileList = accountDir.list();
		
		String participantpath = "./participant/";
		
		String pName; //����
		String pNumber; //�й� or ��������ȣ
		String pMajor; //�а�
		String pTrack; //Ʈ��
		int pCountry; //����
		
		int exist=0;
		
		for(int i=0; i < fileList.length; i++) { //�̸� �ߺ� Ȯ��
			if(fileList[i].equals(id)) {
				exist=1;
				break;
			}
		}
		
		if(exist == 1) { //id�� �ߺ� �����Ҷ�
			System.out.print("Already exist name");
		}
		else { //id ���簡 ������
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
					Student stu = new Student();
					stu.setName(pName);
					stu.setStudentNum(pNumber);
					stu.setMajor(pMajor);
					stu.setTrack(pTrack);
					stu.setCountry(pCountry);
					
					BufferedWriter stufile;
					stufile = new BufferedWriter(new FileWriter(participantpath+id,true));
					stufile.write(pName);
					stufile.write("\n");
					stufile.write(pNumber);
					stufile.write("\n");
					stufile.write(pMajor);
					stufile.write("\n");
					stufile.write(pTrack);
					stufile.write("\n");
					stufile.write(stu.getCountry());
					
					scanner.close();
					stufile.close();
					job.close();
					
				}
				else { //false�� ������
					System.out.println("name number");
					Scanner scanner = new Scanner(System.in);
					pName = scanner.nextLine();
					pNumber = scanner.nextLine();
					Administrator admin = new Administrator();
					
					admin.setName(pName);
					admin.setAdminNum(pNumber);
					
					BufferedWriter adminfile;
					adminfile = new BufferedWriter(new FileWriter(participantpath+id,true));
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
			}
		}
	}
	public int confirmLogin() {
		return getLogin_status();
	}
	public void logOut() {
		setLogin_status(0);
	}
	public static void findUsername(String name) {
		/* �̸��� ���� �˻��ؼ�
		 * id�� ������
		*/
		String path = "./participant/";
		File participantDir = new File(path);
		String[] fileList = participantDir.list();
		BufferedReader bf;
		String searchName = null;
		int exist = 0;
		
		
		
		for(int i=0; i < fileList.length; i++) { //
			try {
				bf = new BufferedReader(new FileReader("./participant/"+fileList[i]));
				if((searchName = bf.readLine()).equals(name)) {
					searchName = fileList[i];
					exist =1;
					break; 
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(exist == 1) {
			System.out.println("id : " + searchName);
		}
		else {
			System.out.println("no id in System.");
		}
	}
	public void findPassword(String name) {
		/* ���� ���̵� ���ؼ�
		 * pw �� ������
		 */
	}
	

}
