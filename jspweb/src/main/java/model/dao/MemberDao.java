package model.dao;

import java.sql.Statement;
import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {

	private static MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() { return dao; }
	
	// 1. 회원가입 
	public boolean signup( MemberDto dto ) {
		String sql = "insert into member ( mid , mpw , memail , mimg) values( ? , ? , ? , ? )";
		try {
			ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS );
			ps.setString(1, dto.getMid() );
			ps.setString(2, dto.getMpw() );
			ps.setString(3, dto.getMemail() );
			ps.setString(4, dto.getMimg() );
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();	// pk겂을 rs로 받기
			if( rs.next() ) { 	// 결과에서 첫번째 필드( pk-방금생성된 회원번호 )
				int pk = rs.getInt(1); 
				setPoint( "회원가입축하", 100, pk );
			}
				// 포인트 지급 [ 내용 , 개수 , 방금회원가입한 회원번호(pk) ]
				/*
					- insert 이후레 자동으로 생성된 auto key 찾기 =>  pk 호출
					con.prepareStatement(sql)
					1. 아래로 변경
					con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS );
					2. 생성된 pk 결과 담기
					rs = ps.getGeneratedKeys();	
					3. 검색된 레코드 결과 에서 pk 호출 
					rs.next() ---> rs.getInt(1);
				 */
				
			return true;
			
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 2-2. 회원게시물/레코드 수 구하기
	public int gettotalsize( String key , String keyword ) {
		String sql = "";
		if( key.equals("") && keyword.equals("") ) { // 검색 X
			sql = "select count(*) from member";
		}else { // 검색 O
			sql = "select count(*) from member where "+key+" like '%"+keyword+"%'";
		}
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() )
				return rs.getInt(1);
		}catch (Exception e) { System.out.println(e); }
		return 0;
	}
	
	
	
	// 2. 모든 회원 호출 [ 관리자기준  인수:x 반환:모든회원들의 dto ]
	public ArrayList<MemberDto> getMemberList( int startrow , int listsize , String key , String keyword){
		ArrayList<MemberDto> list = new  ArrayList<>(); // 모든 회원들의 리스트 선언 
		String sql="";
		if( key.equals("") && keyword.equals("") ) { // 검색 X
			sql = "select * from member order by mno asc limit ? , ?";			// 1.SQL 명령어 작성 
		}else { // 검색 O
			sql = "select * from member where "+key+" like '%"+keyword+"%' order by mno asc limit ? , ?";
		}
		try {
			ps = con.prepareStatement(sql);				// 2. 연결된 con 에 SQL 대입해서 ps 
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			rs = ps.executeQuery();						// 3. SQL 실행후 결과 RS 담고 
			while( rs.next() ) {						// 4. rs.next() : 다음레코드 [ t / f ]
				MemberDto dto = new MemberDto(			// 5. 레코드1개 --> dto 1개 생성 
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)); // 5-2 rs.get타입( 필드순서번호 )
				list.add(dto); 							// 6. dto ---> 리스트 담기 
			}
		}catch (Exception e) { System.out.println(e); }
		return list;									// 7. 리스트 반환
	}
	
	// 3. 아이디 중복검사
	public boolean idcheck( String mid ) {
													// 문자열 ' ' vs 정수/실수 '' 생략
		String sql = "select * from member where mid = '"+mid+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// 만약에 검색 결과 레고드가 존재하면 중복 아이디 입니다.
			if( rs.next() ) { return true; }
		}catch (Exception e) { System.out.println(e); }
		return false;	// 없으면 중복 아이디 아닙니다.
	}
	
	// 4. 아이디, 비밀번호 검증	[로그인]
	public boolean login( String mid , String mpwd) {
		String sql = "select * from member where mid = ? and mpw = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs = ps.executeQuery();
			if( rs.next() ) { return true; } // 만약에 조건에 충족한 레코드가 존재하면
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	
	// 5. 특정 회원1명 찾기 [ + 보유포인트 ]
	public MemberDto getMember( String mid ) {
		String sql = "select m.mno, m.mid, m.mimg, m.memail, sum(p.mpamount) as mpoint"
				+ " from member m , mpoint p"
				+ " where m.mno = p.mno and m.mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs =ps.executeQuery();
			if( rs.next() ) { // 비밀번호 제외한 검색된 레코드1개를 dto 1개 만들기
				// 결과레코드 : mno[1], mid[2], mimg[3], memail[4], mpoint[5]
				MemberDto dto = new MemberDto( rs.getInt(1), rs.getString(2), null, rs.getString(3), rs.getString(4));
				dto.setMpoint( rs.getInt(5));
				return dto; // 레코드1개 --> 회원1명 --> 회원dto 반환
			}
		}catch (Exception e) { System.out.println(e); }
		return null;
	}
	// 6. 아이디찾기
	public String findid( String memail ) {
		String sql = "select mid from member where memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			rs = ps.executeQuery();
			if( rs.next() ) {
				return rs.getString(1);	// 찾은 아이디 반환
			}
		}catch (Exception e) { System.out.println(e); }
		return "false"; // 없으면 false
	}
	// 7. 비밀번호 찾기
	public String findpwd( String mid , String memail , String updatePwd ) {
		String sql ="select mno from member where mid = ? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			if( rs.next() ) { // 만약에 동일한 아이디와 이메일 일치한 레코드가 있으면 
				sql = "update member set mpw = ? where mno = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, updatePwd );
				ps.setInt(2, rs.getInt(1));
				int result = ps.executeUpdate();	// 업데이트한 레코드 개수 반환
				if( result == 1 ) { // 업데이트한 레코드가 1개 이면
					// -- 이메일 테스트 되는경우 만 -- //
					// new MemberDto().sendEmail(memail, updatePwd); // 임시비밀번호를 이메일로 보내기
					// return "true";
					// -- 이메일전송 테스트 안되는 경우 -- //
					return updatePwd;
				}
			}
		}catch (Exception e) { System.out.println(e); }
		return "false";
	}
	
	// 8. 포인트 함수 [ 1.지급내용 2.지급개수 3.대상 ]
	public boolean setPoint( String content , int point , int mno ) {
		String sql = "insert into mpoint( mpcomment , mpamount , mno ) values( ? , ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, point);
			ps.setInt(3, mno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	
	// 9. 회원탈퇴 [ 인수 : mid		 반환 : 성공실패 ]
	public boolean delete( String mid , String mpw ) {
		String sql = "delete from member where mid = ? and mpw = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			int count = ps.executeUpdate(); 	// 삭제된 레코드 수 반환
			if( count == 1 ) { return true; }	// 레코드 1개 삭제 성공시 true
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	
	
	// 10. 회원수정 [ 인수 : mid, mpw , memail , newmpw , newmimg	 반환 : 성공실패 ]
	public boolean update( String mid , String mpw , String newmpw , String memail , String newmimg ) {
		String sql = "update member set mpw = ? , memail = ? , mimg = ? where  mid =? and mpw = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newmpw);
			ps.setString(2, memail);
			ps.setString(3, newmimg );
			ps.setString(4, mid);
			ps.setString(5, mpw);
			int count = ps.executeUpdate();	// 수정된 레코드 수 반환
			if( count == 1 ) { return true; }	// 레코드 1개 수정 성공시 true
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	
	// 11. 회원id --> 회원mno 반환
	public int getMno ( String mid ) {
		String sql = "select mno from member where mid = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if( rs.next() )
				return rs.getInt(1);
		}catch (Exception e) { System.out.println(e); }
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
