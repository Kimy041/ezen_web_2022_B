package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;

public class Bcontroller {
	// *DB 대신할 [데이터 저장소]
	public ArrayList<Board> boardDb = new ArrayList<>();
	
	
	
	
	// 글쓰기 로직
	public void write( String id ,String title, String content ) {
		Board board = new Board();
		board.title = title; board.content = content; board.writer = id;
		boardDb.add(board);
		
	}
	
	// 글삭제 로직
	public boolean wrdelete( int inno , String confirmid ) {
		if( boardDb.get(inno).writer.equals(confirmid) ) {
			boardDb.remove(inno);
			return true;
		}
		return false;
	}
	// 글수정 로직
		public boolean wrupdate( int inno , String confirmid ) {
			if( boardDb.get(inno).writer.equals(confirmid) ) {
				return true;
			}
			return false;
		}
	// 글수정페이지 로직
		public void update(int inno , String upwrite) {
				boardDb.get(inno).content = upwrite;
			
			
		}
		
	
}
