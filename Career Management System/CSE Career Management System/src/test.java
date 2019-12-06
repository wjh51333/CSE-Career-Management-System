import java.util.Scanner;

import account.Account;
import track.Track;
import track.requirement.Detail_Graduation;

public class test 
{
	static Scanner scanner;
	
	public static void main(String[] args) 
	{
		account.Account a = new account.Account();
		
		int number;
		scanner = new Scanner(System.in, "UTF-8");
		
		while(true)
		{
			System.out.print("번호를 입력하세요.(1.회원가입  2.로그인  3.이수성적조회  4.학점충족현황확인  5.교과과정확인 6.세부졸업요건관리  7.로그아웃) => ");
			number = scanner.nextInt();
			
			switch(number)  
			{
				case 1 :
				{
					a = sign_in();
					break;//회원가입
				}
				case 2 : 
				{
						log_in(a);
						break;//로그인
				}
				case 3 :
				{
					if(a.getLogin_status() == 1)
					{
						take_course("./participant/" + a.getUserName()+"/이수학점.txt");
					}
					else
					{
						System.out.println("로그인을 실행하세요!");
					}
					break;//이수성적조회
				}
				case 4 : 
				{
					if(a.getLogin_status() == 1)
					{
						complete_list("./participant/" + a.getUserName()+"/이수학점.txt");
					}
					else
					{
						System.out.println("로그인을 실행하세요!");
					}
					break;//학점충족현황확인
				}
				case 5 :
				{
					if(a.getLogin_status() == 1)
					{
						manage_g(a, "./participant/" + a.getUserName() + "/교과과정.txt");
					}
					else
					{
						System.out.println("로그인을 실행하세요!");
					}
					break;//학점충족현황확인
				}
				case 6 : 
				{
					if(a.getLogin_status() == 1)
					{
						detail_gr(a, "./participant/" + a.getUserName() + "/세부졸업요건.txt");
					}
					else
					{
						System.out.println("로그인을 실행하세요!");
					}
					break;//세부졸업요건
				}
				case 7 :
				{
					String name = a.getUserName();
					a.logOut();
					System.out.println(name + " 이(가) 로그아웃하였습다.");
					break;
				}
			}
		}
	}

	private static void detail_gr(Account a, String filename) 
	{
		Detail_Graduation g = new Detail_Graduation();
		Track t = new Track();
		
		System.out.print("1.세부졸업요건확인  2.세부졸업요건추가 3.세부졸업요건수정 4.세부졸업요건삭제 => ");
		int select;
		scanner = new Scanner(System.in);
		select = scanner.nextInt();
		
		switch(select)
		{
			case 1 :
			{				
				t.print_detailed_graduation_requirement(a, filename);
				break;
			}
			case 2 :
			{
				System.out.print("추가할 항목 : ");
				String str = scanner.next();
				System.out.print("해당 과목 응시 여부(0:미응시/1:응시) : ");
				int newone = scanner.nextInt();
				
				g.open_detailed_graduation_requirement(filename);
				g.add_detailed_graduation_requirement(str, newone);
				g.store_detailed_graduation_requirement(a, filename);
				t.print_detailed_graduation_requirement(a, filename);
				break;
			}
			case 3 : 
			{
				System.out.print("수정할 항목 : ");
				String str = scanner.next();
				System.out.print("해당 과목 응시 여부(0:미응시/1:응시) : ");
				int newone = scanner.nextInt();
				
				g.open_detailed_graduation_requirement(filename);
				g.modified_detailed_graduation_requirement(str, newone);
				g.store_detailed_graduation_requirement(a, filename);
				t.print_detailed_graduation_requirement(a, filename);
				break;
			}
			case 4 :
			{
				System.out.print("삭제할 항목 : ");
				String str = scanner.next();
				
				g.open_detailed_graduation_requirement(filename);
				g.delete_detailed_graduation_requirement(str);
				g.store_detailed_graduation_requirement(a, filename);
				t.print_detailed_graduation_requirement(a, filename);
				break;
			}
		}
	}

	private static void manage_g(Account a, String filename) 
	{
		Track t = new Track();
		t.print_curriculum(a, filename);
	}

	 private static void take_course(String filename) 
	 {
	      scanner = new Scanner(System.in);
	      int number;
	      String [][] a = new String[150][6];
	      System.out.print("옵션을 선택하세요.(추가 : 0, 삭제 : 1, 전체보기 : 2) => ");
	      number = scanner.nextInt();
	      
	      course.Data d = new course.Data();
	      course.TakeCourse t = new course.TakeCourse();
	      
	      // 이수 목록 추가
	      if(number == 0)
	         d.addcourse(filename);
	      // 이수 목록 삭제
	      else if(number == 1)
	         d.delcourse(filename);
	      else if(number == 2)
	      {
	         // 재이수목록과 이수 목록을 display
	    	  System.out.println("이수 목록");
	    	  a = t.getCourseinfo(filename);
	    	  for (int i=0; i<a.length; i++)
	    	  {
	    		  for(int j=0; j<6; j++)
	    		  {
	    			  System.out.print(a[i][j] + " ");
	    		  }
	    		  System.out.println("");
            }

    	 String filename2=filename.split(".txt")[0];
         System.out.println("재이수 가능 목록");
         t.secondjudg(filename, a);
         String[][] b = t.getCourseinfo(filename2+"재이수가능.txt");
         for (int i=0; i<b.length; i++)
        	for (int j=0; j<6; j++)
        		 System.out.print(b[i][j]+" ");
         	System.out.println("");
	      }
	 }

	private static void complete_list(String filename) 
	{
		course.CompleteList c = new course.CompleteList();
		c.calgrade(filename);
		
		System.out.println("교양 : " + c.getRefinegrade());
		System.out.println("기본소양 : " + c.getBasicrefine());
		System.out.println("전공기반 : " + c.getMajorbase());
		System.out.println("공학전공 : " + c.getEnginmajor());
	}

	private static void log_in(Account a) 
	{
		scanner = new Scanner(System.in);
		
		String id, password;
		
		System.out.print("id : ");
		id = scanner.next();
		System.out.print("password : ");
		password = scanner.next();
		a.logIn(id, password);
	}

	private static Account sign_in() 
	{
		scanner = new Scanner(System.in);
		String id, passwd, job;
		
		System.out.print("id : ");
		id = scanner.next();
		System.out.print("password : ");
		passwd = scanner.next();
		System.out.print("job(student/administrator) : ");
		job = scanner.next();
		
		Account a = new Account();
		
		//a.makeAccount(id, passwd, job);
		
		return a;
	}
}
