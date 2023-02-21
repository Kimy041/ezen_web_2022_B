package 과제.과제9.예약인터페이스;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		예약 key = null;
		
		while(true) {
			System.out.println("--------- 예약처 ---------");
			System.out.println("1.비행기 2.호텔 3.전시회 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				key = new 비행기();
				System.out.println("항공권 예약 페이지입니다.");
			}
			else if( ch == 2 ) {
				key = new 호텔();
				System.out.println("스탠다드룸 예약 페이지입니다.");
			}
			else if( ch == 3 ) {
				key = new 전시회();
				System.out.println("'최우람_작은방주' 예약 페이지입니다.");
			}
			else { System.out.println(" 알수 없는 번호입니다. "); }
			
			while(true) {
				System.out.println("1.예약 2.예약취소 3.나가기 : ");
				int ch2 = scanner.nextInt();
				if( ch2 == 1 ) {
					key.예약();
				}
				else if( ch2 == 2 ) {
					key.예약취소();
				}
				else if( ch2 == 3 ) {
					break;
				}
				else { System.out.println(" 알수 없는 번호입니다. "); }
			}
		}
	}
}
