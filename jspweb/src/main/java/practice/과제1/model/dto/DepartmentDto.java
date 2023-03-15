package practice.과제1.model.dto;

public class DepartmentDto {
   
	// 필드
   private int departno; 			//부서 코드
   private String departname; 		//부서명
   private String departdirectoer; 	//부서 담당자
    
    
   // 생성자
   public DepartmentDto() {
      super();
   }
       
   public DepartmentDto(int departno, String departname, String departdirectoer) {
      super();
      this.departno = departno;
      this.departname = departname;
      this.departdirectoer = departdirectoer;
   }
   
   //메소드
   public int getDepartno() {
      return departno;
   }

   public void setDepartno(int departno) {
      this.departno = departno;
   }

   public String getDepartname() {
      return departname;
   }

   public void setDepartname(String departname) {
      this.departname = departname;
   }

   public String getDepartdirectoer() {
      return departdirectoer;
   }

   public void setDepartdirectoer(String departdirectoer) {
      this.departdirectoer = departdirectoer;
   }
   
}