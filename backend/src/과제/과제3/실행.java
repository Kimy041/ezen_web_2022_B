package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 { // class s
	public static void main(String[] args) { // main s
		Scanner scanner = new Scanner(System.in);
		ArrayList<Book> bookList = new ArrayList<>();
		ArrayList<Member> memberList = new ArrayList<>();
		
		
		while(true) { // while s [ 종료조건 : 없음 ]
			System.out.println("--------------- 이젠 도서관 ---------------");
			System.out.println("번호\t대여여부\t도서장르\t도서명");
			for(int i = 0 ; i<bookList.size() ; i++) { 
				System.out.printf("%d \t %s \t %s \t %s \n" , i , bookList.get(i).state? "가능" : "불가능" , bookList.get(i).genre , bookList.get(i).name);
			};
			
			System.out.print("메뉴 > 1.도서대여 2.도서반납 3.도서등록[관리자]");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				System.out.println("대여할 번호 입력 : ");	int no = scanner.nextInt();
				if( bookList.get(no).state == true ) {
					System.err.println("대여되었습니다.");
					bookList.get(no).state = false;
				}else { System.err.println("대여가 불가능한 도서입니다."); }
				
			}
			else if( ch == 2 ) {
				System.out.println("반납할 번호 입력 : ");	int no = scanner.nextInt();
				if( bookList.get(no).state == false ) {
					System.err.println("반납되었습니다.");
					bookList.get(no).state = true;
				}else { System.err.println("반납이 불가능한 도서입니다."); }
			}
			else if( ch == 3 ) {
				System.out.print("도서명 : ");	String name = scanner.next();
				System.out.print("도서 장르 : ");	String genre = scanner.next();
				boolean state = true;
				 Book bookadd = new Book();
				 bookadd.name = name; bookadd.genre = genre; bookadd.state = state;
				 bookList.add(bookadd);
				 
			}
			else {
				System.out.println("[알림] 알수 없는 행동 입니다.");
			}
		
		} // while e
		
	} // main e
} // class e
