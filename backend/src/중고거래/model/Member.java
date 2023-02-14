package 중고거래.model;


public class Member {
	// 관계 필드 [ 식별용 = PK ]
	private int mNo; // 회원번호 = 식별자 필드 PK
	// 일반 필드
	private String id;
	private String pw;
	private String name;
	private String phone;
	
	
	// 생성자
	public Member() {}

	public Member(int mNo, String id, String pw, String name, String phone) {
		this.mNo = mNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}

	// 메소드
	@Override
	public String toString() {
		return "Member [mNo=" + mNo + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + "]";
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
   
   
   
}