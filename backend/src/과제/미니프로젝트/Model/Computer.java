package 과제.미니프로젝트.Model;


import java.util.ArrayList;
import java.util.Scanner;

public class Computer extends Member {
	ArrayList<C_member>c_memberDb=new ArrayList<>();
	Scanner scanner=new Scanner(System.in);

	public Computer(String name, String pw, String phone, String snumber) {
		super(name, pw, phone, snumber);
	
	}
	
	
	@Override
	public int signup(Member m) {
		System.out.println("컴퓨터실입니다");
				while(true) {
				System.out.println("무엇을도와드릴까요~? [1.컴퓨터실 예약하기 2.컴퓨터실 나가기  ");
				int chMenu=scanner.nextInt();
				
				if(chMenu==1) {//컴튜터실 예약하기
							System.out.println("=====================컴퓨터실 예약하기=====================");
							System.out.println("사용자이름입력;;;;");
							String c_name=scanner.next();
							System.out.println("사용자 비번 입력;;;");
							String c_pwd=scanner.next();
							System.out.println("시간 입력;;;");
							String time=scanner.next();
							boolean state=false;
							
							//새로운 자료형으로 저장함 
							C_member c_member=new C_member();
							c_member.c_name=c_name;
							c_member.c_pwd=c_pwd;
							c_member.time=time;
							c_member.state=state;
							c_memberDb.add(c_member);
							
					
					for(int i=0; i< c_memberDb.size(); i++) {
						if(c_memberDb.get(i).c_name.equals(c_name) && c_memberDb.get(i).c_pwd.equals(c_pwd) ) {
							System.out.println("=======================이젠 컴퓨터실 접속완료======================");
							System.out.println("번호\t\t컴퓨터실대여여부\t\t사용자\t\t이용시간");
							System.out.println("=============================================================");
							
							System.out.println(i+"\t\t"+ (c_memberDb.get(i).state ? "사용가능" : "사용중" )+"\t\t\t"+ c_memberDb.get(i).c_name+"\t\t"+c_memberDb.get(i).time );
						
						}
						
						
						
					}
					
						System.out.println();
					
				
						return super.signup(m);
				
				
				}//컴퓨터실 예약관력 if 1끝
				else if(chMenu==2) {
					
						System.out.println("로그아웃 하시겠습니다? 회원정보를 입력하세요 ");
						System.out.println("사용자이름입력;;;;");
						String c_name=scanner.next();
						System.out.println("사용자 비번 입력;;;");
						String c_pwd=scanner.next();
						
						if(c_memberDb.get(chMenu).state=true) {
							System.out.println("컴퓨터 사용가능합니다");
							c_memberDb.get(chMenu).state=false;
							System.out.println("컴퓨터 사용가능여부:"+ ( c_memberDb.get(chMenu).state ?"사용가능":"사용중")+ c_memberDb.get(chMenu).c_name+"님 수고하셨습니다" );
						}else {
							System.out.println("이미 사용중인자리입니다");
						}
						
						

		
						
							
					}
				}//while e
				
			}//signup e
		
	}//class e
