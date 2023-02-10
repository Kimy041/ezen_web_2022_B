package 과제.과제4.view;
// * 입출력 :  print , scanner

import java.util.Scanner;

import 과제.과제4.controller.Mcontroller;

public class Front {
	
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	
	// 1. 메인페이지
	public void index() {
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { signup(); }
			else if( ch == 2 ) { login(); }
			else if( ch == 3 ) { findId(); }
			else if( ch == 4 ) { findPassword(); }
			else { }
		}
	}
	
	// 2. 회원가입 페이지
	void signup() { 
		System.out.print("아이디 : ");		String id = scanner.next();
		System.out.print("비밀번호 : ");		String pwd = scanner.next();
		System.out.print("비밀번호 확인 : ");	String confirmpwd = scanner.next();
		System.out.print("이름 : ");			String name = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		int result = mc.signup( id , pwd , confirmpwd , name , phone );
		if( result == 1 ) {
			System.out.println(" [회원가입 실패] ");
		}else if( result == 0 ) {
			System.out.println(" [회원가입 성공] ");
		}
	}
	// 3. 로그인 페이지
	void login() {
		System.out.print("아이디 : ");		String id = scanner.next();
		System.out.print("비밀번호 : ");		String pwd = scanner.next();
		int result = mc.login(id, pwd);
		if( result >= 0 ) { 
			System.out.println(" [로그인 성공] ");
			success();
			System.out.print("작성자 : "+ id +"\n");
			success();
		}else if( result == -2 ) {
			System.out.println(" [아이디 없음] ");
		}else if(  result == -1 ) {
			System.out.println(" [비밀번호 틀림] ");
		}
	}
	// 4. 아이디 찾기 페이지
	void findId() {
		System.out.print("이름 : ");		String name = scanner.next();
		System.out.print("전화번호 : ");	String phone = scanner.next();
		String result = mc.findId(name, phone);
		if( result == null ) { 
			System.out.println(" [알림] 일치하는 아이디가 없습니다. ");
		}else {
			System.out.println("[아이디 ]"+ result );
		}
	}
	// 5. 비밀번호 찾기 페이지
	void findPassword() {
		System.out.print("아이디 : ");	String id = scanner.next();
		System.out.print("전화번호 : ");	String phone = scanner.next();
		String result = mc.findPassword(id, phone);
		if( result == null ) { 
			System.out.println(" [알림] 일치하는 비밀번호가 없습니다. ");
		}else {
			System.out.println("[비밀번호 ]"+ result );
		}
	}
//------------------------------------------------------------------------------//
	// 로그인 성공 화면
	void success() {
		System.out.print("---------- 커뮤니티 ---------------\n");
		System.out.print("번호\t 조회수 \t 작성자 \t 제목\n");
		
		System.out.print("메뉴 > 1.글쓰기 2.글보기 3.로그아웃 : ");
		int ch = scanner.nextInt();
		if( ch == 1 ) { write(); }
		else if( ch == 2 ) { review(); }
		else if( ch == 3 ) { index(); }
		else { }
	}
	
	// 글쓰기
	void write() {
		System.out.print("---------- 글 쓰기 ---------------\n");
		System.out.print("제목 : ");	String title = scanner.next();
		System.out.print("내용 : ");	String content = scanner.next();
		
	}
	// 글보기
	void review() { }
}
