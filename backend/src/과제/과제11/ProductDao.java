package 과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
	
	// DAO 싱글톤
	private static ProductDao dao = new ProductDao();
	public static ProductDao getInstance() { return dao; }
	
	// 1 필드
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 2. 생성자 연동
	private ProductDao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/과제11" , "root" , "kimy172418" );
		}catch ( Exception e ) { System.out.println( e.getMessage() ); }
	}
	
	// 3. SQL 처리 메소드
	// 1. 제품등록 [ 인수 : Dto( pname , pprice , pcount )  반환 : 성공 실패 ]
	public boolean signup( ProductDto dto ) {
		// 1. SQl 작성한다.
		String sql = "insert into product ( pname , pprice , pcount ) values ( ? , ? , ? )";
		// 2. 연동 DB에 SQL 대입한다. [ ps -> 매개변수 조작 가능 ]
		try {
			ps = conn.prepareStatement(sql);
		// 3. ps는 매개변수에 대한 조작 가능
			ps.setString( 1, dto.getPname() );
			ps.setInt( 2, dto.getPprice() );
			ps.setInt( 3, dto.getPcount() );
		// 4. ps가 sql 실행
			ps.executeUpdate();
		// 5. 결과 반환
			return true;
		}catch(Exception e) { System.out.println("DB 오류 : "+ e); }
		return false;
	}
	
	// 2. 모든제품 출력 [ 인수 : X  반환 : ArrayList ]
	public ArrayList<ProductDto> list(){
		// 리스트 선언
		ArrayList<ProductDto> list = new ArrayList<>();
		// 1. SQl 작성한다.
		String sql = "select * from product";
		// 2. 연동 DB에 SQL 대입한다.
		try {
				ps = conn.prepareStatement(sql);
				// 3. ps는 매개변수에 대한 조작 가능[x]
				// 4. ps가 sql 실행 [ SQL 결과를 rs 인터페이스에 저장 ]
				rs = ps.executeQuery();
				// 5. 결과 반환 [ 제품리스트 담기 ]
				while( rs.next() ) {
					ProductDto dto = new ProductDto( rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
					list.add(dto);
				}
				return list;
		}catch(Exception e) { System.out.println("DB 오류 : "+ e); }
		return null;
	}
	
	// 3. 제품 수정 [ 이름 , 가격 ] [ 인수 : pno , pname , pprice  반환 : 성공 실패 ]
	public boolean update( int pno , String pname , int pprice ) {
		// 1. SQl 작성한다.
		String sql = "update product set pname = ? , pprice = ?  where pno = ?";
		// 2. 연동 DB에 SQL 대입한다.
		try {
			ps = conn.prepareStatement(sql);
			// 3. ps는 매개변수에 대한 조작 가능
			ps.setString(1, pname);
			ps.setInt(2, pprice);
			ps.setInt(3, pno);
			// 4. ps가 sql 실행
			ps.executeUpdate();
			// 5. 결과 반환 
			return true;
		}catch(Exception e) { System.out.println("DB 오류 : "+ e); }
		return false;
	}
	
	// 4. 제품 재고 수정 [ 인수 : pno , pcount  반환 : 성공 실패 ]
	public boolean Cupdate( int pno , int pcount ) {
		// 1. SQl 작성한다.
		String sql = "update product set pcount = ?  where pno = ?";
		// 2. 연동 DB에 SQL 대입한다.
		try {
			ps = conn.prepareStatement(sql);
			// 3. ps는 매개변수에 대한 조작 가능
			ps.setInt(1, pcount);
			ps.setInt(2, pno);
			// 4. ps가 sql 실행
			ps.executeUpdate();
			// 5. 결과 반환 
			return true;
		}catch(Exception e) { System.out.println("DB 오류 : "+ e); }
		return false;
	}
	
	// 5. 제품 삭제 [ 인수 : pno  반환 : 성공 실패 ]
	public boolean delete( int pno ) {
		// 1. SQl 작성한다.
		String sql = "delete from product where pno = ?";
		// 2. 연동 DB에 SQL 대입한다.
		try {
			ps = conn.prepareStatement(sql);
			// 3. ps는 매개변수에 대한 조작 가능
			ps.setInt(1, pno);
			// 4. ps가 sql 실행
			ps.executeUpdate();
			// 5. 결과 반환 
			return true;
		}catch(Exception e) { System.out.println("DB 오류 : "+ e); }
		return false;
	}
	
	
	// 결제 [ 인수 : pno , pcount  반환 : 성공 실패 ]
	public boolean pay( int pno , int pcount , int cart ) {
		// 1. SQl 작성한다.
		String sql = "update product set pcount = ?  where pno = ?";
		// 2. 연동 DB에 SQL 대입한다.
		try {
			ps = conn.prepareStatement(sql);
			// 3. ps는 매개변수에 대한 조작 가능
			ps.setInt(1, pcount -= cart);
			ps.setInt(2, pno);
			// 4. ps가 sql 실행
			ps.executeUpdate();
			// 5. 결과 반환 
			return true;
		}catch(Exception e) { System.out.println("DB 오류 : "+ e); }
		return false;
	}
	
	
	

}
