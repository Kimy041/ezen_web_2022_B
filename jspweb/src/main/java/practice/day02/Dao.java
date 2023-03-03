package practice.day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	
	private static Dao dao = new Dao();
	public static Dao getInstance() { return dao; }

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb" , "root" , "1234");
			
		}catch(Exception e) { System.out.println(e); }
	}
	
	// 1. DTO 없는 인수 메소드
	public boolean setData( String data1 , String data2 , Double data3 , int data4 , String data5 ,
							String data6 , String data7 , Boolean data8 , String data9 , String data10 ) {
		String sql = "insert into ex2 values( ?,?,?,?,?,?,?,?,?,? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data1);
			ps.setString(2, data2);
			ps.setDouble(3, data3);
			ps.setInt(4, data4);
			ps.setString(5, data5);
			ps.setString(6, data6);
			ps.setString(7, data7);
			ps.setBoolean(8, data8);
			ps.setString(9, data9);
			ps.setString(10, data10);
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println(e); return false; }
		
	}
	// 1-2 DTO 있는 인수 메소드
	public boolean setData2( Dto dto ) {
		String sql = "insert into ex2 values( ?,?,?,?,?,?,?,?,?,? )";
		try {
			ps =con.prepareStatement(sql);
			ps.setString( 1, dto.getData1() );
			ps.setString( 2, dto.getData2() );
			ps.setDouble( 3, dto.getData3() );
			ps.setInt( 4, dto.getData4() );
			ps.setString( 5, dto.getData5() );
			ps.setString( 6, dto.getData6() );
			ps.setString( 7, dto.getData7() );
			ps.setBoolean( 8, dto.isData8() ); // boolean -> get~~ [x ] is~~[o]
			ps.setString( 9, dto.getData9() );
			ps.setString( 10, dto.getData10() );
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e); return false;}
	}
	
	
	// 2.
	public ArrayList<Object> getData(){
		ArrayList<Object> list = new ArrayList<>();
		String sql = "select * from ex2";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				// 레코드 별로 필드1~필드10를 리스트에 담기
				list.add( rs.getString(1) );
				list.add( rs.getString(2) );
				list.add( rs.getDouble(3) );
				list.add( rs.getInt(4) );
				list.add( rs.getString(5) );
				list.add( rs.getString(6) );
				list.add( rs.getString(7) );
				list.add( rs.getBoolean(8) );
				list.add( rs.getString(9) );
				list.add( rs.getString(10) );
			}
		}catch (Exception e) { System.out.println(e);}
		return list;
	}
	// 2-1. DTO 있는 출력
	public ArrayList<Dto> getData2(){
		ArrayList<Dto> list = new ArrayList<>();
		String sql = "select * from ex2";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // 레코드 1개 ---> Dto 1개 ---> 리스트 답기 ( DTO 여러개 )
				Dto dto = new Dto( rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getString(9), rs.getString(10));
				list.add(dto);
			}
		}catch (Exception e) { System.out.println(e); }
		return list;
	}
	
	// 과제
	public boolean setStudent( Q2_Dto q2_Dto ) {
		String sql = "insert into q2 values( ?,?,?,?,?,?,?,?,? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, q2_Dto.get이름() );
			ps.setString(2, q2_Dto.get전화번호() );
			ps.setDouble(3, q2_Dto.get키() );
			ps.setInt(4, q2_Dto.get나이() );
			ps.setString(5, q2_Dto.get등록일() );
			ps.setString(6, q2_Dto.get성별() );
			ps.setBoolean(7, q2_Dto.is개인정보동의() );
			ps.setString(8, q2_Dto.get지역() );
			ps.setString(9, q2_Dto.get자기소개() );
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println(e); return false; }
		
	}
	
	public ArrayList<Q2_Dto> student(){
		ArrayList<Q2_Dto> studentList = new ArrayList<>();
		String sql = "select * from q2";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				Q2_Dto q2_Dto = new Q2_Dto( rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(8), rs.getString(9) );
				studentList.add(q2_Dto);
			}
		}catch (Exception e) { System.out.println(e); }
		return studentList;
	}


}
/*
	여러개 자료형 ---> 하나의 자료형 [ 클래스 ]
	동일한 자료형 ---> 하나의 자료형 [ 리스트 혹은 배열]
 */




