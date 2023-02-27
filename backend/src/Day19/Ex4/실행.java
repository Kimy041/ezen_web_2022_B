package Day19.Ex4;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 계산기 객체 생성
		Calculator calculator = new Calculator(); // calculator객체 32번지
		
		// 2. 유저1 객체 생성
		User1Thread use1thread = new User1Thread();
		use1thread.setCalculator(calculator); // calculator객체 32번지
		use1thread.start();
		// 3. 유저3 객체 생성
		User2Thread use2thread = new User2Thread();
		use2thread.setCalculator(calculator); // calculator객체 32번지
		use2thread.start();
	}

}
