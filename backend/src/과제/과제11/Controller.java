package 과제.과제11;

import java.util.ArrayList;

public class Controller {
	// 싱글톤
	private static Controller con = new Controller();
	private Controller() {}
	public static Controller getInstance() { return con; }
	
	// 1. 제품등록 [ 인수 :  pname , pprice , pcount  반환 : 성공 실패 ]
	public boolean signup( String pname , int pprice , int pcount  ) {
		// 객체화
		ProductDto dto = new ProductDto(0, pname, pprice, pcount);
		// DB저장 후 반환
		return ProductDao.getInstance().signup( dto );
	}
	
	// 2. 모든제품 출력 [ 인수 : X  반환 : ArrayList ]
	public ArrayList<ProductDto> list(){
		return ProductDao.getInstance().list();
	}
	
	// 3. 제품 수정 [ 이름 , 가격 ] [ 인수 : pno , pname , pprice  반환 : 성공 실패 ]
	public boolean update( int pno , String pname , int pprice ) {
		return ProductDao.getInstance().update(pno, pname, pprice);
	}
	
	// 4. 제품 재고 수정 [ 인수 : pno , pcount  반환 : 성공 실패 ]
	public boolean Cupdate( int pno , int pcount ) {
		return ProductDao.getInstance().Cupdate(pno, pcount);
	}
	
	
	// 5. 제품 삭제 [ 인수 : pno  반환 : 성공 실패 ]
	public boolean delete( int pno ) {
		return ProductDao.getInstance().delete(pno);
	}
	
	// 결제
	public boolean pay( int pno , int pcount ) {
		return ProductDao.getInstance().Cupdate(pno, pcount);
	}
	
	// 장바구니
	public void cart() {
		
	}
}
