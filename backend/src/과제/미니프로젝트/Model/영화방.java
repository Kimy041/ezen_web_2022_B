package 과제.미니프로젝트.Model;

public class 영화방 extends Member{

	
	public 영화방(String name, String pw, String phone, String snumber) {
		super(name, pw, phone, snumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int signup(Member m) {
		System.out.println("영화실입니다");
		
		
		
		
		return super.signup(m);
	}
	
	
	
}
