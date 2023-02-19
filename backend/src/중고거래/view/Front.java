package 중고거래.view;

import java.util.Scanner;

import 중고거래.controller.Mcontroller;
import 중고거래.model.Product;

public class Front {
	
	// 싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() { return front; }
	
	// 입력객체
	Scanner scanner = new Scanner(System.in);

	// 메인페이지
	public void index() {
		
		while(true) {
			System.out.println("--------- 이젠중고나라 ---------");
			System.out.print("1.회원가입 2.로그인 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { singup(); }
			else if( ch == 2 ) { login(); }
		}
	}
	
	// 회원가입
	public void singup() {
		System.out.print("아이디 : ");		String id = scanner.next();
		System.out.print("비밀번호 : ");		String pw = scanner.next();
		System.out.print("비밀번호 확인 : ");	String confirmpw = scanner.next();
		System.out.print("이름 : ");			String name = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		
		boolean result = Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		if( result ) { System.out.println(" [알림] 회원가입 되었습니다. "); }
		else { System.out.println(" [알림] 회원가입 실패. 다시 시도해주시길 바랍니다. "); }
		
	}
	// 로그인
	public void login() {
		System.out.print("아이디 : ");		String id = scanner.next();
		System.out.print("비밀번호 : ");		String pw = scanner.next();
		
		boolean result = Mcontroller.getInstance().login(id, pw);
		if( result ) { System.out.println(" [알림] 로그인 성공 "); }
		else { System.out.println(" [알림] 로그인 실패 "); }
	}
	
	// 로그인 후 전체 제품목록
	public void productList() {
		System.out.println("---------- 전체 제품 ----------");
		System.out.println("번호\t제품\t가격\t작성자");
		
		
		
		System.out.print("1.제품 2.제품등록 3.마이페이지 : ");
		int ch = scanner.nextInt();
		if( ch == 1 ) {  }
		else if( ch == 2 ) { }
		else if( ch == 3 ) { }
		
	}
}
