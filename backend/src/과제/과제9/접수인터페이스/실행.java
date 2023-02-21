package 과제.과제9.접수인터페이스;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		접수 key = null;
		
		while(true) {
			System.out.println("------- 접수 신청 기관 -------");
			System.out.print("1.병원 2.학원 3.우체국 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { 
				key = new 병원(); 
				System.out.println("병원 접수처입니다.");
			}
			else if( ch == 2 ) { 
				key = new 학원(); 
				System.out.println("학원 접수처입니다.");
			}
			else if( ch == 3 ) { 
				key = new 우체국(); 
				System.out.println("우체국 접수처입니다.");
		
			}
			else {System.out.println("알수 없는 입력 번호입니다.");}
			
			while(true) {
				System.out.print("1.접수 2.접수취소 3.나가기 : ");
				int ch2 = scanner.nextInt();
				if( ch2 == 1 ) {
					key.접수();
				}
				else if( ch2 == 2 ) {
					key.접수취소();
				}
				else if( ch2 == 3 ) {
					break;
				}
				else {System.out.println("알수 없는 입력 번호입니다.");}
			}
		}
	}
}
