package 과제.과제11;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() { return view; }
	
	// 필드
	Scanner scanner = new Scanner(System.in);
	// 컨트롤 리스트 저장
	ArrayList<ProductDto> result = Controller.getInstance().list();
	// 장바구니 리스트
	ArrayList<ProductDto> cartlist = new ArrayList<>();
	
	// 메인화면
	public void index() {
		while(true) {
			try {
				System.out.println("------------- 메인 페이지 -------------");
				System.out.print("1.관리자  2.시용자 : ");
				int ch = scanner.nextInt();
				if( ch == 1 ) { manager(); }
				else if( ch ==2 ) { use(); }
			}catch( InputMismatchException e ) {
				System.out.println("잘못된 입력입니다.");
				Scanner scanner = new Scanner(System.in);
			}catch( Exception e ) {
				System.out.println("프로그램내 오류 발생 : 관리자 문의");
			}
		}
	}
	
	
	// 관리자화면
	public void manager() {
		while(true) {
			try {
				System.out.println("------------- 관리자 페이지 -------------");
				System.out.print("1.등록[C] 2.출력[R] 3.수정[U] 4.재고수정[D] 5.삭제[D] 6.나가기 : ");
				int ch = scanner.nextInt();
				if( ch == 1 ) { signup(); }
				else if( ch ==2 ) { list(); }
				else if( ch == 3 ) { update(); }
				else if( ch == 4 ) { Cupdate(); }
				else if( ch == 5 ) { delete(); }
				else if( ch == 6 ) { break; }
			}catch( InputMismatchException e ) { 
				System.out.println("잘못된 입력입니다."); 
				Scanner scanner = new Scanner(System.in);
			}catch( Exception e ) {
				System.out.println("프로그램내 오류 발생 : 관리자 문의");
			}
		}
	}
	
	// 1. 제품등록 
	public void signup() {
		System.out.println("-------- 제품 등록 --------");
		System.out.println(" 제품명 : ");
		String pname = scanner.next();
		System.out.println(" 제품 가격 : ");
		int pprice = scanner.nextInt();
		System.out.println(" 제품 재고 : ");
		int pcount = scanner.nextInt();
		
		// 데이터 전달
		boolean result = Controller.getInstance().signup(pname, pprice, pcount);
		
		// 결과
		if( result ) { System.out.println(" [ 제품 등록 ] "); return; }
		else { System.out.println(" [ 제품 등록 실패 ] "); return; }
	}
	
	// 2. 모든제품 출력
	public void list() {
		System.out.println("----------------- 제품 리스트 -----------------");
		System.out.printf("%2s \t %7s \t %7s \t %5s \n" , "no" , "제품명" , "제품가격" , "재고" );
		for( int i = 0 ; i<result.size(); i++ ) {
			System.out.printf("%2d \t %7s \t %7d \t %5d \n" , result.get(i).getPno() , result.get(i).getPname() , result.get(i).getPprice() , result.get(i).getPcount() );
		}
	}
	
	// 3. 제품 수정 [ 이름 , 가격 ] [ 인수 : pno , pname , pprice  반환 : 성공 실패 ]
	public void update() {
		System.out.println("-------- 제품명, 제품 가격 수정 --------");
		System.out.println("수정할 제품 번호 : ");
		int pno = scanner.nextInt();
		System.out.println("새로운 제품명 : ");
		String pnmae = scanner.next();
		System.out.println("수정 가격 : ");
		int pprice = scanner.nextInt();
		
		// 데이터 전달
		boolean result = Controller.getInstance().update(pno, pnmae, pprice);
		
		// 결과
		if( result ) { System.out.println(" [ 수정 성공 ] "); return; }
		else { System.out.println(" [ 수정 실패 ] "); return; }
	}
	
	// 4. 제품 재고 수정 [ 인수 : pno , pcount  반환 : 성공 실패 ]
	public void Cupdate() {
		System.out.println("-------- 제품 재고 수정 --------");
		System.out.println("수정할 제품 번호 : ");
		int pno = scanner.nextInt();
		System.out.println("새로운 재고 수량 : ");
		int pcount = scanner.nextInt();
		
		// 데이터 전달
		boolean result = Controller.getInstance().Cupdate(pno, pcount);
		
		// 결과
		if( result ) { System.out.println(" [ 수정 성공 ] "); return; }
		else { System.out.println(" [ 수정 실패 ] "); return; }
	}
	
	// 5. 제품 삭제 
	public void delete() {
		System.out.println("-------- 제품 삭제 --------");
		System.out.println("삭제할 제품 번호 : ");
		int pno = scanner.nextInt();
		
		// 데이터 전달
		boolean result = Controller.getInstance().delete(pno);
		
		// 결과
		if( result ) { System.out.println(" [ 제품 삭제 ] "); return; }
		else { System.out.println(" [ 제품 삭제 실패 ] "); return; }
		
	}
//------------------------------------------------------------------------------------------------------------------//
	
	// 사용자화면
	public void use() {
		while(true) {
			try {
				System.out.println("------------- 사용자 페이지 -------------");
				System.out.printf("%2s \t %7s \t %7s \t %5s \n" , "no" , "제품명" , "제품가격" , "상태" );
				for( int i = 0 ; i<result.size(); i++ ) {
					System.out.printf("%2d \t %7s \t %7d \t %5s \n" , result.get(i).getPno() , result.get(i).getPname() , result.get(i).getPprice() , result.get(i).getPcount() == 0 ? "재고부족" : "판매중" );
				}
				System.out.print("0.결제 1.제품선택 : ");
				int ch = scanner.nextInt();
				if( ch == 0 ) { pay(); }
				else { cart( ch );  }
			}catch( InputMismatchException e ) { 
				System.out.println("잘못된 입력입니다."); 
				Scanner scanner = new Scanner(System.in);
			}catch( Exception e ) {
				System.out.println("프로그램내 오류 발생 : 관리자 문의");
			}
		}
	}
		
	// 결제
	public void pay() {
		System.out.println("------------- 장바구니 -------------");
		System.out.printf("%2s \t %7s \t %7s \t %5s \n" , "no" , "제품명" , "제품가격" , "개수" );
		for( int i = 0 ; i<cartlist.size(); i++ ) {
			System.out.printf("%2d \t %7s \t %7d \t %5s \n" , cartlist.get(i).getPno() , cartlist.get(i).getPname() , cartlist.get(i).getPprice() , cartlist.get(i).getPcount() );
		}
		System.out.print("0.결제 1.결제취소 : ");
		int ch = scanner.nextInt();
		if( ch == 0 ) { 
			for( int i = 0 ; i<cartlist.size(); i++ ) {
				Controller.getInstance().pay(cartlist.get(i).getPno(), result.get(i).getPcount(), cartlist.get(i).getPcount());
				}
			System.out.println(" [ 결제 성공 ] "); 
			cartlist.clear();
			}
		
		else if( ch == 1 ) { 
			System.out.println(" [ 결제 취소 ] 장바구니가 리셋되었습니다. "); 
			cartlist.clear();
		}
		
	}
	
	// 제품 선택
	public void cart( int pno ) {
		System.out.println("개수를 입력해주세요.");
		int ea = scanner.nextInt();
		int cart = 0;
		for( int i = 0 ; i <= pno; i++ ) {
			if( result.get(i).getPno() == pno ) {
				if( result.get(i).getPcount() > 0 && ea <= result.get(i).getPcount() ) {
					cart += ea;
					System.out.println( result.get(i).getPname()+"가 장바구니에 담겼습니다." );
					ProductDto cartdto = new ProductDto(pno, result.get(i).getPname(), result.get(i).getPprice(), cart);
					cartlist.add(cartdto);
					break;
				}
				else {System.out.println(" 재고가 부족합니다."); }
				break;
			}
			
		}
		
	}
	

}
