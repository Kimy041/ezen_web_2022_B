package 과제.과제9.예약인터페이스;

public class 호텔 implements 예약 {
	@Override
	public void 예약() {
		System.out.println("스탠다드룸이 예약되었습니다.");
	}
	@Override
	public void 예약취소() {
		System.out.println("스탠다드룸 예약이 취소되었습니다.");
	}
}
