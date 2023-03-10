package model.dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MemberDto {

	private int mno;
	private String mid;
	private String mpw;
	private String mimg;
	private String memail;
	
	// 1. 이메일 전송 메소드 [ 받는사람이메일 , 받는내용 HTML ]
	public boolean sendEmail( String toEmail , String contentHTML ) {
		
		// 1. 보내는 사람의 정보
		String fromEmail = "네이버아이디@naver.com";
		String emailpwd = "네이버계정비밀번호";
		// 2. 호스팅 설정 [ 네이버 기준 ]
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.naver.com");		// gmail일 경우 : smtp.gmail.com
		properties.put("mail.smtp.port", 587 );					// 동일
		properties.put("mail.smtp.auth", true );				// 동일
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");	// 동일
		
		// 3. 인증처리 
			// [ Session : import javax.mail.Session; ]
			// Session.getDefaultInstance(properties , new Authenticator() {});
			// [ Authenticator : import javax.mail ]
		Session session = Session.getDefaultInstance(properties , new Authenticator() {
			// 패스워드인증 함수를 오버라이딩
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, emailpwd);
			}
		});
		// 4. 메일 보내기
		try {
			// Mime프로토콜 : smtp가 보낼수 있는 표준 형시[포멧]
			MimeMessage message = new MimeMessage(session);	// 인증된 세션 대입해서 포멧
			message.setFrom( new InternetAddress( fromEmail ) );	// 보내는 사람
			message.addRecipient( Message.RecipientType.TO, new InternetAddress( toEmail ) ); 	// 받는사람
			// 내용 구성
			message.setSubject("Ezen Community 회원가입 메일 인증코드"); 	// 메일 제목
			message.setText(contentHTML);	// 메일 내용
			// 전송
			Transport.send(message);
			
			
			return true; // 메일전송 성공 
		}catch (Exception e) { System.out.println(e);}
		return false; // 메일전송 실패
	}
	
	
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int mno, String mid, String mpw, String mimg, String memai) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mimg = mimg;
		this.memail = memai;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mimg=" + mimg + ", memai=" + memail + "]";
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemai(String memai) {
		this.memail = memail;
	}
	
}
