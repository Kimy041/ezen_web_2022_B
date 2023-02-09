package Day07.Ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex6_회원시스템_컬렉션프레임워크 { // class s
	public static void main(String[] args) { // main s
		
		Scanner scanner = new Scanner(System.in);
		// 배열 대신 컬렉션 프레임워크
		ArrayList<Member> memberList = new ArrayList<>(); // 가변길이
			// ArrayList : 리스트 선언 사용되는 클래스 // <클래스명> : 리스트 안에 들어갈 항목의 클래스
		
		while(true) {
			// 배열명.length : 배열내 길이			 [ 고정길이 ]
			// 리스트명.size() : 리스트내 요소들의 개수 [ 가변길이 ]
			System.out.println("번호\t회원명\t전화번호");
			for( int i = 0 ; i<memberList.size() ; i++) {
				System.out.println(i+"\t"+memberList.get(0).name +"\t"+memberList.get(i).phone );
			}
			// js : (인수)=>{실행문} 익명화살표 vs -> java : (인수)->{실행문;}
			System.out.println(" 1.회원등록 2.회원삭제 : ");
			int ch = scanner.nextInt();
			if( ch ==1 ) {
				System.out.println("회원명 : ");		String name = scanner.next();
				System.out.println("전화번호 : ");	String phone = scanner.next();
				// "," 대신 객체
				Member member = new Member();
				member.name = name; member.phone = phone;
				memberList.add(member); // 리스트에 객체 추가 // js : push()
				
			}
			else if( ch == 2 ) {
				System.out.println(" 삭제할 번호/인덱스 : ");
				int no = scanner.nextInt();
				memberList.remove( no );
			}
			else { }
		}
	} // main e
} // class e
