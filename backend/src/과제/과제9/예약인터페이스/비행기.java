package 과제.과제9.예약인터페이스;

public class 비행기 implements 예약 {
	@Override
	public void 예약() {
		System.out.println("항공권이 예약되었습니다.");
	}
	@Override
	public void 예약취소() {
		System.out.println("항공권 예약이 취소되었습니다.");
	}
}
