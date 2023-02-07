package 과제.과제2;

import java.util.Scanner;

public class 과제2_키오스크 { // class s
	public static void main(String[] args) { // main s
		// 입력
		Scanner scanner = new Scanner(System.in);
		
		// 1. 제품 변수
		int 콜라 = 10;	int 사이다 = 8;	int 환타 = 15; 
		int 콜라가격 = 300;	int 사이다가격 = 400;		int 환타가격 = 500;
		int 콜라바구니 = 0;	int 사이다바구니 = 0;	int 환타바구니 = 0;
		
		while ( true ) { // while s
			System.out.println("-------키오스크 메뉴-------");
			System.out.println("1.콜라(300원) 2.사이다(400원) 3.환타(500원) 4.결재 ");
			System.out.println("------------------------");
			System.out.println(" >>> 선택 : ");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) {
				if( 콜라 > 0 && 콜라 <=10 ) {
					System.out.println("콜라를 선택했습니다.");
					System.out.println("개수를 입력해주세요.");
					int s = scanner.nextInt();
					if(s >= 0 && s <= 콜라 ) { 콜라 -= s; 콜라바구니 += s; }
					else if(s > 콜라 ) { System.out.println("재고부족"); 
					}else { System.err.println("알 수 없는 번호입니다."); }
				}else {
					System.out.println("재고부족");
				}
			}
			else if( ch == 2 ) {
				if( 사이다 > 0 && 사이다 <=8 ) {
					System.out.println("사이다를 선택했습니다.");
					System.out.println("개수를 입력해주세요.");
					int s = scanner.nextInt();
					if(s >= 0 && s <= 사이다 ) { 사이다 -= s; 사이다바구니 += s; }
					else if(s > 사이다 ) { System.out.println("재고부족"); 
					}else { System.err.println("알 수 없는 번호입니다."); }
				}else {
					System.out.println("재고부족");
				}
			}
			else if( ch == 3 ) {
				if( 환타 > 0 && 환타 <=15 ) {
					System.out.println("환타를 선택했습니다.");
					System.out.println("개수를 입력해주세요.");
					int s = scanner.nextInt();
					if(s >= 0 && s <= 환타 ) { 환타 -= s; 환타바구니 += s; }
					else if(s > 환타 ) { System.out.println("재고부족"); 
					}else { System.err.println("알 수 없는 번호입니다."); }
				}else {
					System.out.println("재고부족");
				}
			}
			else if( ch == 4 ) {
				if( 콜라바구니 > 0 || 사이다바구니 > 0 || 환타바구니 > 0) {
					System.out.println("--------------------------");
					System.out.println("제품명\t수량\t가격 ");
					if(콜라바구니 > 0) { System.out.printf("콜라\t%d\t%d\n", 콜라바구니, (콜라바구니*콜라가격)); }
					if(사이다바구니 > 0) { System.out.printf("사이다\t%d\t%d\n", 사이다바구니, (사이다바구니*사이다가격)); }
					if(환타바구니 > 0) { System.out.printf("환타\t%d\t%d\n", 환타바구니 , (환타바구니*환타가격)); }
					System.out.println("총가격 : " + ((콜라바구니*콜라가격) + (사이다바구니*사이다가격) + (환타바구니*환타가격)) );
					System.out.println("--------------------------");
					
					System.out.println("결제를 진행하시겠습니까?\n 1.결재	2.취소");
					int ch1 = scanner.nextInt();
					if( ch1 == 1 ) {
						System.out.println("금액을 입력해주세요."); int money = scanner.nextInt();
						
						if( ((콜라바구니*콜라가격) + (사이다바구니*사이다가격) + (환타바구니*환타가격)) <= money ) {
							System.out.println("결제되었습니다.");
							System.out.println("잔액 : "+ ( money - ((콜라바구니*콜라가격) + (사이다바구니*사이다가격) + (환타바구니*환타가격))) );
						}else {
							System.err.println("금액이 부족하여 취소되었습니다.");
							콜라 += 콜라바구니; 사이다 += 사이다바구니; 환타 += 환타바구니;
						}
						콜라바구니 = 0; 사이다바구니 = 0; 환타바구니 = 0;
						
					}else if ( ch1 == 2 ) {
						System.err.println("취소되었습니다.");
						콜라바구니 = 0; 사이다바구니 = 0; 환타바구니 = 0;
						콜라 += 콜라바구니; 사이다 += 사이다바구니; 환타 += 환타바구니;
						
					}else { System.err.println("알 수 없는 번호입니다.");}
					
				}else {
					System.err.println("결제 금액이 없습니다.");
				}
			
			}else {
				System.err.println("알 수 없는 번호입니다.");
			}
		
			
		} // while e
		
	} // main e
} // class e


/*
	*중요
		1. 변수/메모리 선택
		2. if 제어문 중첩[ 흐름 제어 ]
*/