package 과제.중고거래.controller;

import java.util.ArrayList;

import 과제.중고거래.model.Member;
import 과제.중고거래.model.Memo;
import 과제.중고거래.model.Product;

public class Mcontroller {
	
	// 싱글톤
	private static Mcontroller mcontroller = new Mcontroller();
	private Mcontroller() {}
	public static Mcontroller getInstance() { return mcontroller; }
	
	
	
	// 회원 저장
	private ArrayList<Member> memberDB = new ArrayList<>();
	// 상품 저장
	private ArrayList<Product> productList = new ArrayList<>();
	// 메모 저장
	private ArrayList<Memo> memoList = new ArrayList<>();
	
	
	// 회원가입
	public boolean signup( String id , String pw , String comfirmpw , String name , String phone ) {
		if( !pw.equals(comfirmpw)) { return false; }
		
		int i = 0;
		i++;
		Member m = new Member(i, id, comfirmpw, name, phone);
		
		memberDB.add(m);
		return true;
	}
	// 로그인
	public boolean login( String id , String pw ) {
		for( int i = 0 ; i<memberDB.size() ; i++ ) {
			if( memberDB.get(i).getId().equals(id) ) {
				if( memberDB.get(i).getPw().equals(pw) ) {
					return true;
				}
			}
		}
		return false;
	}
	
	// 제품목록
	public ArrayList<Product> getProducts(){
		return productList;
	}
	
	// 쪽지목록
	public ArrayList<Memo> getMemos(){
		return memoList;
	}
}
