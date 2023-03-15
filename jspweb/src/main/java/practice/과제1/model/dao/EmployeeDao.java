package practice.과제1.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import practice.과제1.model.dto.DepartmentDto;
import practice.과제1.model.dto.EmployeeDto;

public class EmployeeDao {

	private static EmployeeDao dao = new EmployeeDao();
	public static EmployeeDao getInstanc() { return dao; }
	
	// DB 연동
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public EmployeeDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsphomewrok1" , "root" , "1234");
			System.out.println("연동성공");
		}catch(Exception e) { System.out.println(e); }
	}
	
	// 입력받은 부서 -> 객체반환 
	public DepartmentDto departmentDto(String departName) {
	      String sql = "select * from department  where departname = ?";
	      
	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, departName);
	         
	         rs = ps.executeQuery();
	         
	         if(rs.next()) {
	            DepartmentDto dto = new DepartmentDto(
	                  rs.getInt(1), 
	                  rs.getString(2), 
	                  rs.getString(3));
	            
	            return dto;
	         }
	         
	      }catch(Exception e) {
	         System.out.println(e.getMessage());
	      }
	      return null;
	   }
	
	// 사원등록
	public boolean signup( EmployeeDto dto ) {
		String sql = "insert into employee ( emimg , emname , emrank , emtype , emdepartno , emindate , emoutdate , emoutreason) values( ? , ? , ? , ? ,? , ? , ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getEmimg() );
			ps.setString(2, dto.getEmname() );
			ps.setString(3, dto.getEmrank() );
			ps.setString(4, dto.getEmtype() );
			ps.setInt(5, dto.getEmdepartno() );
			ps.setString(6, dto.getEmindate() );
			ps.setString(7, dto.getEmoutdate() );
			ps.setString(8, dto.getEmoutreason() );
			
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
		
	// 사원 출력
	public ArrayList<EmployeeDto> emlist(){
		ArrayList<EmployeeDto> list = new ArrayList<>();
		String sql = "select * from employee";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				EmployeeDto dto = new EmployeeDto( 
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9));
				
				list.add(dto);
			}
		}catch (Exception e) { System.out.println(e); }
		return list;
	}
}
