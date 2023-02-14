package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;

import 과제.과제4_싱글톤.model.Board;

public class Bcontroller {
	
	// *싱글톤
	private static Bcontroller bc = new Bcontroller();
	private Bcontroller() {}
	public static Bcontroller getInstance() { return bc; }
	
	
	// 필드
	private ArrayList<Board> boarDB = new ArrayList<>();
	
	// 1. 글쓰기
	public boolean write( String title , String content ) {
		// 1. 유효성검사한다.[ 로그인이 안되어 있는경우 false ]
		if( Mcontroller.getInstance().getLogSession() == null ) {
			return false;
		}
		// 2. DB 저장
			// 1. 객체화 [ 글작성 : 입력받은 데이터2개 , 초기값 0 , 로그인한 회원 객체 = 글쓴이 ]
		Board board = new Board(title , content, 0, Mcontroller.getInstance().getLogSession() );
			// 2. db에 저장
		boarDB.add(board);
			// 3. 멤버객체에 내가 쓴글 등록
		Mcontroller.getInstance().getLogSession().getBoardList().add(board);
		return true;
	}
	// 2. 글출력
	public ArrayList<Board> getList(){
		// 추후에 검색처리 , 페이징처리 등등 로직이 들어갈 예정
		return boarDB;
	}
	// 3. 글상세
	public Board getBoard( int bno ) {
		boarDB.get(bno).setView(boarDB.get(bno).getView()+1);
		return boarDB.get(bno);		// 인수로 전달받은 인덱스[게시물의번호]의 게시물을 반환
	}
	// 4. 글삭제
	public boolean delete( int bno ) {
		boarDB.remove(bno); // 인수로 전달받은 인덱스[게시물번호]의 게시물을 삭제
		return true;
	}
	// 5. 글수정
	public boolean update( int bno , String title , String content ) {
		boarDB.get(bno).setTitle(title); // 인수로 전달받은 인덱스[게시물번호]의 게시물 제목 수정
		boarDB.get(bno).setContent(content); // 인수로 전달받은 인덱스[게시물번호]의 게시물 내용 수정
		return true;
	}
}
