package 과제.과제11;

public class ProductDto {
	// 1. 필드
	private int pno;
	private String pname;
	private int pprice;
	private int pcount;
	
	// 2. 생성자
	public ProductDto() { }
	public ProductDto(int pno, String pname, int pprice, int pcount) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.pcount = pcount;
	}
	
	
	// 3.
	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", pcount=" + pcount + "]";
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	
	
	

}
