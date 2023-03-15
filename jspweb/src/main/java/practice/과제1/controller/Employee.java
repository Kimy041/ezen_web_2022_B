package practice.과제1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import practice.과제1.model.dao.EmployeeDao;
import practice.과제1.model.dto.EmployeeDto;


@WebServlet("/employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Employee() {
        super();
        
    }

	// 모든 게시물 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		ArrayList<EmployeeDto> list = EmployeeDao.getInstanc().emlist();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(list);
		
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
		
	}

	// 사원등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 업로드 코드 구현
		String path = request.getSession().getServletContext().getRealPath("/member/pimg");
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*10, "UTF-8" , new DefaultFileRenamePolicy());
		// 
		String emimg = multi.getFilesystemName("changeemimg");
		String emname = multi.getParameter("emname");
		String emrank = multi.getParameter("emrank");
		String emtype = multi.getParameter("emtype");
		String emdepartno = multi.getParameter("emdepartno");
		String emindate = multi.getParameter("emindate");
		String emoutdate = multi.getParameter("emoutdate");
		String emoutreason = multi.getParameter("emoutreason");
		
		
		 int Departno = EmployeeDao.getInstanc().departmentDto(emdepartno).getDepartno();
		 
		
		  if( emoutdate.equals("") ) { emoutdate = null; }
		  if( emoutreason.equals("") ) { emoutreason = null; }
		  
		EmployeeDto dto = new EmployeeDto(0, emimg, emname, emrank, Departno,  emtype, emindate, emoutdate, emoutreason);
		
		boolean result = EmployeeDao.getInstanc().signup(dto);
		response.getWriter().print(result);
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
