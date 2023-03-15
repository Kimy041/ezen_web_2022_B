package practice.과제1.model.dto;

public class EmployeeDto {

   //필드
   private int emno;        	 // 사원번호
   private String emimg;    	// 사원사진
   private String emname;      	// 사원이름
   private String emtype;    	//고용 형태
   private String emrank;      	// 사원직급
   private int emdepartno;      // 사원 부서 코드
   private String emindate;   	// 입사일
   private String emoutdate;   	// 퇴사일
   private String emoutreason;  // 퇴사 사유
    
   // 생성자
   public EmployeeDto() {
      // TODO Auto-generated constructor stub
   }

   public EmployeeDto(int emno, String emimg, String emname,  String emrank, int emdepartno, String emtype, String emindate,
      String emoutdate, String emoutreason) {
      super();
      this.emno = emno;
      this.emimg = emimg;
      this.emname = emname;
      this.emtype = emtype;
      this.emrank = emrank;
      this.emdepartno = emdepartno;
      this.emindate = emindate;
      this.emoutdate = emoutdate;
      this.emoutreason = emoutreason;
   }   




   // 메소드
   @Override
   public String toString() {
      return "EmployeeDto [emno=" + emno + ", emimg=" + emimg + ", emname=" + emname + ", emtype=" + emtype + ", emrank="
            + emrank + ", emdepartno=" + emdepartno + ", emindate=" + emindate + ", emoutdate=" + emoutdate
            + ", emoutreason=" + emoutreason + "]";
   }
   
   public int getEmno() {
         return emno;
   }

   public void setEmno(int emno) {
         this.emno = emno;
   }

   public String getEmimg() {
      return emimg;
   }

   public void setEmimg(String emimg) {
      this.emimg = emimg;
   }

   public String getEmname() {
      return emname;
   }

   public void setEmname(String emname) {
      this.emname = emname;
   }

   public String getEmrank() {
      return emrank;
   }

   public void setEmrank(String emrank) {
      this.emrank = emrank;
   }

   public int getEmdepartno() {
      return emdepartno;
   }

   public void setEmdepartno(int emdepartno) {
      this.emdepartno = emdepartno;
   }

   public String getEmindate() {
      return emindate;
   }

   public void setEmindate(String emindate) {
      this.emindate = emindate;
   }

   public String getEmoutdate() {
      return emoutdate;
   }

   public void setEmoutdate(String emoutdate) {
      this.emoutdate = emoutdate;
   }

   public String getEmoutreason() {
      return emoutreason;
   }

   public void setEmoutreason(String emoutreason) {
      this.emoutreason = emoutreason;
   }

   public String getEmtype() {
      return emtype;
   }
   
   public void setEmtype(String emtype) {
      this.emtype = emtype;
   }  
      
   
}