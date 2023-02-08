package Day06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;


public class Ex6_비회원게시판 { // class s
	public static void main(String[] args) throws Exception { // main s
		
		// step1 : 필요한 데이터를 입력받아 저장
		// step2 : 쓰기 페이지 실행되는 조건
		// step3 : 입력된 데이터를 파일처리 [ 영구저장 ]
		// step4 : 파일에 있는 문자열 가지고 오기
		// step5 : 문자열 분리[split]해서 출력하기
		
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
		
		while ( true ) { // *무한루프 [ 종료조건 : -2 입력시 ]
			/* 게시물들이 출력되는 위치 */
			System.out.println(" 메뉴 > 쓰기[-1] 나가기[-2] : ");
			int ch = scanner.nextInt();
			if( ch == -1 ) {
				// *각 변수별로 입력받아 저장
				System.out.println("-------------- 게시물 작성 --------------");
				System.out.println(" 제목 : "); String title = scanner.next();
				System.out.println(" 내용 : "); String content = scanner.next();
				System.out.println(" 작성자 : ");String writer = scanner.next();
				System.out.println(" 비밀번호 : "); String password = scanner.next();
				
				// , : 열 구분선[데이터구분]		\n : 행 구분선[게시물구분]
				String outStr = title+","+content+","+writer+","+password+"\n";
				
				// *파일처리 객체 생성 ("파일경로" , true);
				FileOutputStream fout = new FileOutputStream("c:/java/board.txt",true);
				fout.write( outStr.getBytes() );
			}
			else if( ch == -2){ break; }
			// 현재 파일에 존재하는 모든 문자열 호출
			// *파일 입력 클래스 객체 생성 ( 파일경로 )
			FileInputStream fin = new FileInputStream("c:/java/board.txt");
			// *읽어온 바이트를 저장하기 위해 바이트배열 100바이트 미리 생성
			byte[] inbytes = new byte[1000]; // 영문 1바이트, 한글 3바이트
			// *.read( ) 메소드를 이용한 파일 읽기 [ * 읽은 바이트응 바이트배열 저장 ]
				// inbytes : 읽어온 바이트를 배열에 저장
				// bytecount : 읽어온 바이트의 개수를 변수에 저장
			int bytecount = fin.read( inbytes );		// 스트림 : 바이트단위 
			// *바이트배열 ---> 문자열
				// new String("유재석");
				// new String( 바이트배열 );	new String( 바이트배열 , 시작인덱스 , 마지막인덱스 );
			String fStr = new String( inbytes , 0 , bytecount ); // 바이트 배열 --> 문자열 변환
			
			
			// *행 기준 자르기
			String[] boards = fStr.split("\n");	// 행 기준으로 분리 [ 만약에 게시물 2개일때 2조각 ]
			
			System.out.println("-------------- 게시물 목록 --------------");
			System.out.printf("%2s %10s%5s\n" , "번호" , "제목" , "작성자");
			// *[행마다] 열 기준 자르기
			for( int i = 0 ; i<boards.length ; i++) {
				// * 게시물 마다 열 자르기
				String[] cols = boards[i].split(","); // 4조각
				String title = cols[0];		String content = cols[1];
				String writer = cols[2];		String password = cols[3];
				System.out.printf("%2d %10s%5s\n" , i , title , writer);
			}
			System.out.println("-----------------------------------------");
			
		
		} //while e	
	} // main e
} // class e
