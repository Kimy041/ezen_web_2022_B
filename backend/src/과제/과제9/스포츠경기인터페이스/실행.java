package 과제.과제9.스포츠경기인터페이스;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		경기 key = null;
		
		while(true) {
			System.out.println("--------- 스포츠 ---------");
			System.out.println("1.축구 2.수영 3.야구 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				key = new 축구();
				System.out.println("축구를 선택했습니다.");
			}
			else if( ch == 2 ) {
				key = new 수영();
				System.out.println("수영을 선택했습니다.");
			}
			else if( ch == 3 ) {
				key = new 야구();
				System.out.println("야구를 선택했습니다.");
			}
			else { System.out.println("알수 없는 번호입니다."); }
			
			while(true) {
				System.out.println("1.경기시작 2.경기종료 3.나가기 : ");
				int ch2 = scanner.nextInt();
				if( ch2 == 1 ) {
					key.시작();
				}
				else if( ch2 == 2 ) {
					key.종료();
				}
				else if( ch2 == 3 ) {
					break;
				}
				else { System.out.println("알수 없는 번호입니다."); }
			}
		}
		
	}
}
