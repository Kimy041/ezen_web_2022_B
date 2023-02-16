package 과제.미니프로젝트.Model;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.미니프로젝트.View.Front;



public class 회의실 extends Member {
	   Scanner scanner = new Scanner(System.in);
	   ArrayList<회의실Model> officeDb = new ArrayList<>();

	public 회의실(String name, String pw, String phone, String snumber) {
	      super(name, pw, phone, snumber);
	      // TODO Auto-generated constructor stub
	   }

	@Override
	   public int signup(Member m) {
	      System.out.println("회의실입니다");
	      while(true) {
	      System.out.println("방명록을 입력하시겠습니까? \n 1.글쓰기 2.취소");
	      int office_Ch = scanner.nextInt();
	      if(office_Ch==1) {
	      System.out.println("------------방명록 입력 페이지------------");
	      System.out.println("작성자 : ");   String name = scanner.next();
	      System.out.println("방명록 내용 : ");   String content = scanner.next();
	      
	      회의실Model model = new 회의실Model();
	      model.name = name;
	      model.content = content;
	      officeDb.add(model);
	      System.out.println(model);
	   
	      }
	      else if(office_Ch==2) {
	         Front.index();
	      }
	      
	      return super.signup(m);
	   }
	   
	 }
	}
