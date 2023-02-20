package 과제.과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB과제1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		
		while(true) {
			try {
				System.out.println("1.DB연결 2.SQL구문 작성 3.매개변수 입력 : ");
				int ch = scanner.nextInt();
				if( ch == 1 ) {
					System.out.println("-- 연동할 DB 입력 : ");
					String dbname = scanner.next();
					System.out.println( dbname +"에 연결합니다.");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname , "root" , "1234" );
					System.out.println(" ** 연결 성공 **");
				}
				else if( ch == 2 ) {
					System.out.println("-- SQL구문 작성 : ");
					scanner.nextLine();
					String sql = scanner.nextLine();
					PreparedStatement ps = con.prepareStatement(sql);
					ps.execute();
				}
				else if( ch == 3 ) {
					 System.out.print("제품번호 : ");	int 제품번호 = scanner.nextInt();
					 System.out.print("제품명 : ");	String 제품명 = scanner.next();
					 scanner.nextLine();
					 System.out.print("제품설명 : ");	String 제품설명 = scanner.nextLine();
					 System.out.print("제품가격 : ");	int 제품가격 = scanner.nextInt();
					 
					 String sql = "insert into product values( ? , ? , ? , ? );";
					 PreparedStatement ps = con.prepareStatement(sql);
					 
					 ps.setInt(1, 제품번호);
					 ps.setString(2, 제품명);
					 ps.setString(3, 제품설명);
					 ps.setInt(4, 제품가격);
					
					 ps.executeUpdate();
				}
			}catch( InputMismatchException e ) {
				System.out.println("알 수 없는 입력입니다.");
				scanner = new Scanner(System.in);
			}catch( SQLException e ) {
				System.out.println(" SQL 오류 : "+ e);
			}catch( Exception e ) {
				System.out.println(" DB연동 실패 ");
			}
			
			
		}
		
	}
}
