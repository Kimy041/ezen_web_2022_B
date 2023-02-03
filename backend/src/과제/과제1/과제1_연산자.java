package 과제.과제1;

import java.util.Scanner; // Scanner 클래스 호출

public class 과제1_연산자 {
	public static void main(String[] args) {
		
		// * { } 마다 입력객체
		Scanner scanner = new Scanner( System.in );
		
		// 문제1
		// System.out.println("문제1\n |\\_/|\n |q p|   /}\n ( 0 )\"\"\"\\\n |\"^\"`    |\n ||_/=\\\\__|");
		
		// 문제2
		/*
		System.out.print("작성자 : "); String 작성자 = scanner.next();
		System.out.print("내용 : "); String 내용 = scanner.next();
		System.out.print("날짜 : "); String 날짜 = scanner.next();
		System.out.printf("--------------방문록--------------------\n");
		System.out.printf("| %-4s | %-4s | %-15s | %-8s |\n" , "순번" , "작성자" , "내용" , "날짜");
		System.out.printf("| %-5d | %-4s | %-13s | %-9s |\n" , 1 , 작성자 , 내용 , 날짜 );
		System.out.printf("---------------------------------------\n");
		*/
		
		// 문제3
		/*
		System.out.print("기본급 : "); int 기본급 = scanner.nextInt(); 
		System.out.print("수당 : "); int 수당 = scanner.nextInt();
		int 실수령액 = 기본급 + 수당 - (int)( 기본급*0.1 );
		System.out.println("실수령액 : "+ 실수령액 );
		*/
		
		// 문제4
		/*
		System.out.print("금액 : "); int 금액 = scanner.nextInt();
		System.out.println("- 십만원 : "+ (금액/100000)+"장" );
		금액 -= (금액/100000)*100000;
		System.out.println("- 만원 : "+ (금액/10000)+"장" );
		금액 -= (금액/10000)*10000;
		System.out.println("- 천원 : "+ (금액/1000)+"장" );
		금액 -= (금액/1000)*1000;
		System.out.println("- 백원 : "+ (금액/100)+"개" );
		*/
		
		// 문제5
		/*
		System.out.println("정수1 : "); int 정수1 = scanner.nextInt();
		String 배수확인 = (정수1%7 == 0) ? "O" : "X";
		System.out.println("7배수 : "+ 배수확인 );
		*/
		
		// 문제6
		/*
		System.out.println("정수2 : "); int 정수2 = scanner.nextInt();
		String 홀수확인 = (정수2%2 == 1) ? "O" : "X";
		System.out.println("홀수 : "+ 홀수확인 );
		*/
		
		// 문제7
		/*
		System.out.println("정수3 : "); int 정수3 = scanner.nextInt();
		String 짝수확인7 = (정수3%2 == 0 && 정수3%7 == 0 ) ? "O" : "X";
		System.out.println("7의 배수 이면서 짝수 : "+ 짝수확인7 );
		*/
		
		// 문제8
		/*
		System.out.println("정수4 : "); int 정수4 = scanner.nextInt();
		String 홀수확인7 = (정수4%2 == 1 || 정수4%7 == 0 ) ? "O" : "X";
		System.out.println("7의 배수 이거나 홀수 : "+ 홀수확인7 );
		*/
		
		// 문제9
		/*
		System.out.println("정수5 : "); int 정수5 = scanner.nextInt();
		System.out.println("정수6 : "); int 정수6 = scanner.nextInt();
		System.out.println(정수5+"과 "+정수6+"중 더 큰수는 : " + ((정수5>정수6) ? 정수5 : (정수5<정수6) ? 정수6 : "두 수는 같다") );
		*/
		
		// 문제10
		/*
		System.out.println("반지름 : "); double 반지름 = scanner.nextDouble();
		double 원넓이 = 반지름 * 반지름 * ( 3.14 );
		System.out.println("원 넓이 : "+ 원넓이 );
		*/
		
		// 문제11
		/*
		System.out.println("실수1 : "); double 실수1 = scanner.nextDouble();
		System.out.println("실수2 : "); double 실수2 = scanner.nextDouble();
		System.out.println("실수2의 실수1 백분율 : "+ (실수1/실수2)*100 + "%" );
		*/
		
		// 문제12
		/*
		System.out.println("윗변 : "); int 윗변 = scanner.nextInt();
		System.out.println("밑변 : "); int 밑변 = scanner.nextInt();
		System.out.println("높이 : "); int 높이 = scanner.nextInt();
		System.out.println("사다리꼴 넓이 : "+ ((윗변*밑변)*높이)/2 );
		*/
		
		// 문제13
		/*
		System.out.println("키 : "); int 키 = scanner.nextInt();
		System.out.println("표준체중 : "+ (키 - 100)*0.9 );
		*/
		
		// 문제14
		/*
		System.out.println("키 : "); int 키 = scanner.nextInt();
		System.out.println("몸무게 : "); int 몸무게 = scanner.nextInt();
		System.out.println("BMI : "+ 몸무게/((키 / 100) * (키 / 100)) );
		*/
		
		// 문제15
		/*
		System.out.println("inch : "); int inch = scanner.nextInt();
		System.out.println( inch*2.54 + "cm" );
		*/
		
		// 문제16
		System.out.println("중간고사 : "); int 중간고사 = scanner.nextInt();
		System.out.println("기말고사 : "); int 기말고사 = scanner.nextInt();
		System.out.println("수향평가 : "); int 수행평가 = scanner.nextInt();
		double 중간반영 = 중간고사*0.3;
		double 기말반영 = 기말고사*0.3;
		double 수행반영 = 수행평가*0.4;
		System.out.printf( "점수 : %3.2f "+ (중간반영 + 기말반영 + 수행반영) );
		
		
		
		
		
		
		
		
		
		
		
	}
}
