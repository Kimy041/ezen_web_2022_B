package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;

public class Bcontroller {
	// *DB 대신할 [데이터 저장소]
	public ArrayList<Board> boardDb = new ArrayList<>();
	
	
	
	// 글쓰기 로직
	public String write(String id ,String title, String content ) {
		Board board = new Board();
		board.title = title; board.content = content; board.writer = id;
		boardDb.add(board);
		return boardDb.toString();
		
	}
	
	
}
