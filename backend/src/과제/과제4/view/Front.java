package 과제.과제4.view;
// * 입출력 :  print , scanner

import java.util.Scanner;

import 과제.과제4.controller.Bcontroller;
import 과제.과제4.controller.Mcontroller;

public class Front {
	
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	Bcontroller bc = new Bcontroller();
	
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
			success(id);
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
	void success(String id) {
		while(true) {
			System.out.print("---------- 커뮤니티 ---------------\n");
			System.out.print("번호\t 조회수 \t 작성자 \t 제목\n");
			for(int i = 0 ; i<bc.boardDb.size() ; i++) { 
				System.out.printf("%d \t %s \t %s \t %s \n" ,i , bc.boardDb.get(i).no , bc.boardDb.get(i).writer , bc.boardDb.get(i).title+"\n");
			};
			
			System.out.print("메뉴 > 1.글쓰기 2.글보기 3.로그아웃 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { write(id); }
			else if( ch == 2 ) { view(id); }
			else if( ch == 3 ) { index(); }
			else { System.err.print("[알림] 입력하신 번호를 다시 확인해주세요."); }
		}
	}

	// 글쓰기
	void write(String id) {
		System.out.print("---------- 글 쓰기 ---------------\n");
		System.out.print("제목 : ");	String title = scanner.next();
		System.out.print("내용 : ");	String content = scanner.next();
		System.out.print("작성자 : "+ id +"\n");
		bc.write(id ,title, content);
		
	}
	// 글보기
	void view(String id) { 
		System.out.print("원하시는 게시물 번호를 입력해주세요.");
		int inno = scanner.nextInt();
		if( inno >= 0 ) {
			bc.boardDb.get(inno).no += 1;
			System.out.print("---------- 글 상세페이지 ------------\n");
			System.out.print("제목 : "+bc.boardDb.get(inno).title+"\n");
			System.out.print("작성자 : "+bc.boardDb.get(inno).writer+"\t조회수 : "+bc.boardDb.get(inno).no+"\n");
			System.out.print("내용 : "+bc.boardDb.get(inno).content+"\n");
			
			System.out.print("메뉴 > 1.글삭제 2.글수정 3.뒤로가기 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { wrdelete(); }
			else if( ch == 2 ) { wrupdate(); }
			else if( ch == 3 ) { success(id); }
			else { System.err.print("[알림] 입력하신 번호를 다시 확인해주세요."); }
		}else {
			System.err.print("[알림] 입력하신 번호를 다시 확인해주세요.");
		}
	}
	
	void wrdelete() {
		
	}
	
	void wrupdate() {
		
	}
}
