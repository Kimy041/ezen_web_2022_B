package 과제.과제9.접수인터페이스;

public class 병원 implements 접수{
	@Override
	public void 접수() {
		System.out.println("진료가 접수되었습니다.");
		
	}
	@Override
	public void 접수취소() {
		System.out.println("진료 접수가 취소되었습니다.");
	}

}