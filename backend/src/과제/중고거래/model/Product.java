package 과제.중고거래.model;

public class Product {
   // 관계 필드 = 참조 필드 [ FK ]
	private int mNo;
	// 관계 필드 = 식별용 [ PK ]
   private int pNo;	// 제품번호
   // 일반 필드
   private String pName;
   private int price;
   private String pContent;
   
   
 //생성자
   public Product() {}

   public Product(int pNo, String pName, int price, String pContent, int mNo) {
      super();
      this.pNo = pNo;
      this.pName = pName;
      this.price = price;
      this.pContent = pContent;
      this.mNo = mNo;
   }

   @Override
   public String toString() {
      return "Product [pNo=" + pNo + ", pName=" + pName + ", price=" + price + ", pContent=" + pContent + ", mNo="
            + mNo + "]";
   }

   public int getpNo() {
      return pNo;
   }

   public void setpNo(int pNo) {
      this.pNo = pNo;
   }

   public String getpName() {
      return pName;
   }

   public void setpName(String pName) {
      this.pName = pName;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getpContent() {
      return pContent;
   }

   public void setpContent(String pContent) {
      this.pContent = pContent;
   }

   public int getmNo() {
      return mNo;
   }

   public void setmNo(int mNo) {
      this.mNo = mNo;
   }

   
   
}