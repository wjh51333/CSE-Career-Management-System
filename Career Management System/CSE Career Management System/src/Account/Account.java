package account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import account.MemberBean;
import participant.Administrator;
import participant.Student;

public class Account {
   private String userName;
   private int login_status=0; // �α��� ����
   private participant.Student student = new participant.Student();
   private participant.Administrator Administrator = new participant.Administrator();
   
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
   
   public int logIn(String Id, String Password) {
      int exist=0;
      int login_job =2;
      
      Data data = new Data();
      exist = data.findId(Id);
      String job=null;
      
      if(exist == 1) {
         setLogin_status(data.equalIdPw(Id, Password));
         if(getLogin_status() == 1) {
            job = data.getJob(Id);
            if(job.equals("student"))
               login_job = 0;
            else {
               login_job = 1;
            }
            setUserName(Id);
            
            System.out.println("로그인 성공!");   
         }
         else
            System.out.println("아이디와 비밀번호가 일치하지 않습니다!");
      }
      else {
         System.out.println("존재하지 않는 아이디입니다!");
      }
      return login_job;
      
   }
   public void makeAccount(MemberBean mBean) {
      Data data = new Data();
      int exist = data.findId(mBean.getId());
      String chooseJob =null;
      if(exist == 1) {
         System.out.print("아이디가 이미 존재합니다.");
      }
      else {
    	  String id = mBean.getId();
    	  String password = mBean.getPw();
    	  String type = mBean.getType();
    	  String name = mBean.getName();
    	  String idNum = mBean.getIdNum();
    	  
    	  data.joinAccount(id, password, type);
    	  //chooseJob = data.getJob(id);
    	  //Scanner scanner = new Scanner(System.in);
    	  if(type.equals("student")) { // 
    		  String major = mBean.getMajor();
    		  String track = mBean.getTrack();
    		  int country = 1;
    		  
    		  System.out.println("이름 학번 학과 트랙 국적(한국:1 / 한국X:0)");
    		  Student stu = new Student();
    		  /*stu.setName(scanner.next());
    		  stu.setStudentNum(scanner.next());
    		  stu.setMajor(scanner.next());
    		  stu.setTrack(scanner.next());
    		  stu.setCountry(scanner.nextInt());*/
    		  
    		  stu.setName(name);
    		  stu.setStudentNum(idNum);
    		  stu.setMajor(major);
    		  stu.setTrack(track);
    		  stu.setCountry(country);
    		  
    		  data.joinStudent(id, name, idNum, major, track, country);
    		  data.Store_userspace(id);
         }
         else {
        	 System.out.println("이름 교직원번호");
        	 Administrator admin = new Administrator();
 
        	 //admin.setName(scanner.next());
        	 //admin.setAdminNum(scanner.next());
        	 admin.setName(name);
        	 admin.setAdminNum(idNum);
        	 
        	 data.joinAdmin(id, name, idNum);
         }
      }
   }
   public int confirmLogin() {
      return getLogin_status();
   }
   public void logOut() {
      setLogin_status(0);
      setUserName("");
   }
   public void findUsername(String name, String number) {
 
      Data data = new Data();
      String searchName = null;
      
      searchName = data.findUserId(name, number);
      if(searchName.equals(null)) {
         System.out.println("이름과 번호에 맞는 아이디가 없습니다!");
      }
      else {
         System.out.println("id : " + searchName);
      }
   }
   public void findPassword(String Id, String name,String num) { //���̵�, �̸�,�й� 

      Data data = new Data();
      
      int exist_id = 0;
      
      exist_id = data.findId(Id);
      
      if(exist_id != 1) {
         System.out.println("id가 존재하지 않습니다!");
      }
      else if((exist_id ==1) && (data.findUserId(name, num)!=null) 
            &&(data.findUserPw(Id, name, num)!=null)) {
         System.out.println("Id : "+data.findUserId(name, num)+
               " Pw : "+data.findUserPw(Id, name, num));
      }
      else if(((data.findUserId(name, num)==null) |(data.findUserPw(Id, name, num)==null))){
         System.out.println("이름과 학번이 일치하지 않습니다.");
      }
   }
   public String[] getUserInfo(String Id) { //array 2�а� 3Ʈ��
      Data data = new Data();   
      
      return data.getUserData(Id);
   }
}