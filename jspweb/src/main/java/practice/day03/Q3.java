package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Q3
 */
@WebServlet("/Q3/Product")
public class Q3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Q3() {
        super();
    }
    // 1. 등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pname = request.getParameter("pname");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		
		ProductDto productDto = new ProductDto(0, pname, pprice);
		
		boolean result = BoardDao.getInstance().onsignup(productDto);
		response.getWriter().print(result);
	}
	// 2. 테이블
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		ArrayList<ProductDto> result = BoardDao.getInstance().plist();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
		
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	// 3. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		boolean result = BoardDao.getInstance().pdelete(pno);
		
		response.getWriter().print(result);
	}
	// 4. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		String newpname = request.getParameter("newpname");
		int newpprice = Integer.parseInt(request.getParameter("newpprice"));
		
		boolean result = BoardDao.getInstance().pupdate(pno, newpname, newpprice);
		
		response.getWriter().print(result);
	}

	

}
