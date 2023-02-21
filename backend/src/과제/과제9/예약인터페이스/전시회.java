package 과제.과제9.예약인터페이스;

public class 전시회 implements 예약 {
	@Override
	public void 예약() {
		System.out.println("'최우람_작은방주' 예약되었습니다.");
	}
	@Override
	public void 예약취소() {
		System.out.println("'최우람_작은방주' 예약이 취소되었습니다.");
	}
}
