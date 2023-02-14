package 중고거래.controller;

import java.util.ArrayList;

import 중고거래.model.Member;

public class Mcontroller {
	
	private ArrayList<Member> memberDB = new ArrayList<>();
	
	// 회원가입
	public boolean signup( String id , String pw , String comfirmpw , String name , String phone ) {
		if( !pw.equals(comfirmpw)) { return false; }
		
		
		Member m = new Member(0, id, comfirmpw, name, phone);
		
		memberDB.add(m);
		return true;
	}
	// 로그인
	
	// 마이페이지- 상품목록
	
	// 마이페이지- 쪽지목록
}
