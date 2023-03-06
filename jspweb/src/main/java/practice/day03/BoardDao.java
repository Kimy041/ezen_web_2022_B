package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
	
	private static BoardDao dao = new BoardDao();
	public static BoardDao getInstance() { return dao; }
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb" , "root" , "1234");
		}catch (Exception e) { System.out.println(e);}
	}
	
	// 1. 등록
	public boolean onwrite( BoardDto dto ) {
		String sql = "insert into ex3 ( bcontent , bwriter ) values( ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBcontent() );
			ps.setString(2, dto.getBwriter());
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println(e);}
		return false;
	}
	// 2. 모든 방문록 출력 [ 인수 : x / 반환 : 여러개[list 의 dto ]
	public ArrayList<BoardDto> onlist(){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select * from ex3";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// 레코드1개 = if / 레코드여러개 = while
			while( rs.next() ) {
				BoardDto dto = new BoardDto( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(dto);
			}
		}catch (Exception e) { System.out.println(e); }
		return list;
	}
	// 3. 삭제
	public boolean ondelete( int bno ) {
		String sql = "delete from ex3 where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	// 4. 수정
	public boolean onupdate( int bno , String newContent) {
		String sql = "update ex3 set bcontent = ? where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newContent);
			ps.setInt(2, bno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	/*--------------------------------------------------------------------*/
	// 1. 등록
	public boolean onsignup( ProductDto dto ) {
		String sql = "insert into q3 (pname , pprice) values( ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPprice());
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	// 2. 테이블
	public ArrayList<ProductDto> plist(){
		ArrayList<ProductDto> onplist = new ArrayList<>();
		String sql = "select * from q3";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				ProductDto dto = new ProductDto( rs.getInt(1), rs.getString(2), rs.getInt(3));
				onplist.add(dto);
			}
		}catch (Exception e) { System.out.println(e); }
		return onplist;
	}
	// 3. 삭제
	public boolean pdelete( int pno ) {
		String sql = "delete from q3 where pno =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	// 4. 수정
	public boolean pupdate( int pno , String pname , int pprice ) {
		String sql = "update q3 set pname = ? , pprice = ? where pno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, pprice);
			ps.setInt(3, pno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println(e); }
		return false;
	}

}
