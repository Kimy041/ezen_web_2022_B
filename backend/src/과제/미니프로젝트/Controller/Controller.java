package 과제.미니프로젝트.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.미니프로젝트.Model.Computer;
import 과제.미니프로젝트.Model.Member;
import 과제.미니프로젝트.Model.영화방;
import 과제.미니프로젝트.Model.일반실;
import 과제.미니프로젝트.Model.회의실;

public class Controller {
	
	
	public ArrayList<Member>memberDb=new ArrayList<>();
	private static Controller c=new Controller();
	private Controller() {}
	public static Controller getInstance() {
		return c;
	}
	
	public int signup(String id,String pw,String phone,int ch) {
		
		String snumber = "0"+ch;
		
		if(ch==1) {
			Computer computer = new Computer(id, pw, phone, snumber);//자식객체생성
			
			좌석반복 : for( int 좌석확인 = 1 ; 좌석확인<=20; 좌석확인++ ) { // 1. 컴퓨터실의 20좌석 현황 확인 반복 
				
				for( int i = 0 ; i<memberDb.size(); i++ ) { // 2. 좌석 번째 자리의 동일한 회원리스트에서 좌석과 같은 값 찾기
					
					if( memberDb.get(i) instanceof Computer ) { // 3.회원리스트에서 컴퓨터 자식이면 
						Computer temp = (Computer)memberDb.get(i);	// 4. 멤버객체를 -> 컴퓨터객체 
						if( temp.좌석번호 == 좌석확인 ) {						// 5. 컴퓨터객체의 자리가 현재 확인하고 있는 좌석과 같으면 
							System.out.print(" ["+temp.name+"]");			// 6. 앉아 있는 자리 
							if( 좌석확인 % 5 == 0 ) System.out.println();			
							continue 좌석반복; 								
						}
					}
					
				}
				
				System.out.print("[\t]");
				
				if( 좌석확인 % 5 == 0 ) System.out.println();
			}
			
			System.out.print(" 좌석선택 : ");
			Scanner scanner=new Scanner(System.in);
			int 선택좌석 = scanner.nextInt();
			
			computer.좌석번호 = 선택좌석;
			
			
			return computer.signup(computer);
		}else if(ch==2) {
			회의실 회의실 = new 회의실(id, pw, phone,snumber);
			

			좌석반복 : for( int 좌석확인 = 1 ; 좌석확인<=20; 좌석확인++ ) { // 1. 컴퓨터실의 20좌석 현황 확인 반복 
				
				for( int i = 0 ; i<memberDb.size(); i++ ) { // 2. 좌석 번째 자리의 동일한 회원리스트에서 좌석과 같은 값 찾기
					
					if( memberDb.get(i) instanceof 회의실 ) { // 3.회원리스트에서 컴퓨터 자식이면 
						회의실 temp = (회의실)memberDb.get(i);	// 4. 멤버객체를 -> 컴퓨터객체 
						if( temp.좌석번호 == 좌석확인 ) {						// 5. 컴퓨터객체의 자리가 현재 확인하고 있는 좌석과 같으면 
							System.out.print(" ["+temp.name+"]");			// 6. 앉아 있는 자리 
							if( 좌석확인 % 5 == 0 ) System.out.println();			
							continue 좌석반복; 								
						}
					}
					
				}
				
				System.out.print("[\t]");
				
				if( 좌석확인 % 5 == 0 ) System.out.println();
			}
			
			System.out.print(" 좌석선택 : ");
			Scanner scanner=new Scanner(System.in);
			int 선택좌석 = scanner.nextInt();
			
			회의실.좌석번호 = 선택좌석;
			
			
			
			
			return 회의실.signup(회의실);
		}else if(ch==3) {
			일반실 일반실 = new 일반실(id, pw, phone, snumber);

			좌석반복 : for( int 좌석확인 = 1 ; 좌석확인<=20; 좌석확인++ ) { // 1. 컴퓨터실의 20좌석 현황 확인 반복 
				
				for( int i = 0 ; i<memberDb.size(); i++ ) { // 2. 좌석 번째 자리의 동일한 회원리스트에서 좌석과 같은 값 찾기
					
					if( memberDb.get(i) instanceof 일반실 ) { // 3.회원리스트에서 컴퓨터 자식이면 
						일반실 temp = (일반실)memberDb.get(i);	// 4. 멤버객체를 -> 컴퓨터객체 
						if( temp.좌석번호 == 좌석확인 ) {						// 5. 컴퓨터객체의 자리가 현재 확인하고 있는 좌석과 같으면 
							System.out.print(" ["+temp.name+"]");			// 6. 앉아 있는 자리 
							if( 좌석확인 % 5 == 0 ) System.out.println();			
							continue 좌석반복; 								
						}
					}
					
				}
				
				System.out.print("[\t]");
				
				if( 좌석확인 % 5 == 0 ) System.out.println();
			}
			
			System.out.print(" 좌석선택 : ");
			Scanner scanner=new Scanner(System.in);
			int 선택좌석 = scanner.nextInt();
			
			일반실.좌석번호 = 선택좌석;
			
			
			
			return 일반실.signup(일반실);
		}else {
			영화방 영화방 =new 영화방(id, pw, phone, snumber);
			
			좌석반복 : for( int 좌석확인 = 1 ; 좌석확인<=20; 좌석확인++ ) { // 1. 컴퓨터실의 20좌석 현황 확인 반복 
				
				for( int i = 0 ; i<memberDb.size(); i++ ) { // 2. 좌석 번째 자리의 동일한 회원리스트에서 좌석과 같은 값 찾기
					
					if( memberDb.get(i) instanceof 영화방 ) { // 3.회원리스트에서 컴퓨터 자식이면 
						영화방 temp = (영화방)memberDb.get(i);	// 4. 멤버객체를 -> 컴퓨터객체 
							if( temp.좌석번호 == 좌석확인 ) {						// 5. 컴퓨터객체의 자리가 현재 확인하고 있는 좌석과 같으면 
								System.out.print(" ["+temp.name+"]");			// 6. 앉아 있는 자리 
								if( 좌석확인 % 5 == 0 ) System.out.println();			
								continue 좌석반복; 
							}
						
						
					}
					
				}
				
				System.out.print("[\t]");
				
				if( 좌석확인 % 5 == 0 ) System.out.println();
			}
	
			
			System.out.print(" 좌석선택 : ");
			Scanner scanner=new Scanner(System.in);
			int 선택좌석 = scanner.nextInt();
//			if( )
			영화방.좌석번호 = 선택좌석;
			
			
			
			return 영화방.signup(영화방);
			
		}
		
	}
	
	
	
	
	
}