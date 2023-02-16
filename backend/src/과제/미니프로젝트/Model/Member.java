package 과제.미니프로젝트.Model;

import 과제.미니프로젝트.Controller.Controller;

public class Member {
	public String name;
	public String pw;
	public String phone;
	public String snumber;
	public int 좌석번호;
	
	
	public Member() { }
	public Member(String name, String pw, String phone) {
		super();
		this.name = name;
		this.pw = pw;
		this.phone = phone;
	}
	public Member(String name, String pw, String phone, String snumber) {
		this.name = name;
		this.pw = pw;
		this.phone = phone;
		this.snumber = snumber;
	}
	
	
	//등록함수 
	public int signup(Member m) {
	Controller.getInstance().memberDb.add(m);
		
			return 1;//회원가입성공
		}
	
	
	
	
	
	
	
	
}//class e
