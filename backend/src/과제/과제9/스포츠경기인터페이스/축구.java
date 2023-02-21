package 과제.과제9.스포츠경기인터페이스;

public class 축구 implements 경기 {

	@Override
	public void 시작() {
		System.out.println("킥오프 휘슬이 울렸습니다.");
	}
	@Override
	public void 종료() {
		System.out.println("종료 휘슬이 울렸습니다.");
	}
}
