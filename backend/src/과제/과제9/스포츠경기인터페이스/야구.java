package 과제.과제9.스포츠경기인터페이스;

public class 야구 implements 경기 {
	@Override
	public void 시작() {
		System.out.println("플레이가 시작되었습니다.");
	}
	@Override
	public void 종료() {
		System.out.println("플레이가 종료되었습니다.");
	}
}
