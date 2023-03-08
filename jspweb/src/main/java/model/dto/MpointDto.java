package model.dto;

public class MpointDto {

	private int mpno;
	private String mpcomment;
	private int mpamount;
	private String mdate;
	private int mno;
	
	public MpointDto() {
		// TODO Auto-generated constructor stub
	}

	public MpointDto(int mpno, String mpcomment, int mpamount, String mdate, int mno) {
		super();
		this.mpno = mpno;
		this.mpcomment = mpcomment;
		this.mpamount = mpamount;
		this.mdate = mdate;
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "MpointDto [mpno=" + mpno + ", mpcomment=" + mpcomment + ", mpamount=" + mpamount + ", mdate=" + mdate
				+ ", mno=" + mno + "]";
	}

	public int getMpno() {
		return mpno;
	}

	public void setMpno(int mpno) {
		this.mpno = mpno;
	}

	public String getMpcomment() {
		return mpcomment;
	}

	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}

	public int getMpamount() {
		return mpamount;
	}

	public void setMpamount(int mpamount) {
		this.mpamount = mpamount;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}
	
}
