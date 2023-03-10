/*
	- 출력
		1. 콘솔출력 : console.log( )
		2. 알람메시지출력 : alert( )
		3. html출력 :
			1. document.write( )
			2. document.querySelector( ).innerHTML
	- 입력
		1. 알람메시지입력 : prompt( )
		2. html입력 : document.querySelector( ).value		
*/
let output = '' // 출력 변수
// 예시1) 입력받은 수 만큼 * 출력
let s1 = Number( prompt(' 예시1 별 개수 ') )
for( let i = 1 ; i <=s1 ; i++){ // for s
	// i는 1부터 입력받은 수까지 1씩증가 반복
	output += '*' // = 대입[기존데이터 없어짐] vs += 누적대입[기존데이터에 추가]
} //for e
console.log( output )
/*
	만약에 5를 입력했을때 s1 = 5
	output =''
	for( let i = 1 ; i<=s1 ; i++ )
	
		i			조건[i<=s1]		실행문				[output]			증감식
	i = 1일때			1<=5		T	output += '*'	output = '*'		i++
	i = 2일때			2<=5		T	output += '*'	output = '**'		i++
	i = 3일때			3<=5		T	output += '*'	output = '***'		i++
	i = 4일때			4<=5		T	output += '*'	output = '****' 	i++
	i = 5일때			5<=5		T	output += '*'	output = '*****' 	i++
	i = 6일때			6<=5		F	실행X
	
*/

 
// 예시2) 입력받은 수만큼 *출력 [ 3줄마다 줄바꿈 ]
output = '' // 앞전에 사용한 output 변수를 다시 ''[공백]으로 변경
let s2 = Number( prompt(' 예시2 별 개수 ') )
for( let i = 1 ; i <= s2 ; i++ ){ // for s
	// 1. 별출력
	output += '*'
	// 2. 줄바꿈출력
	if( i%3 == 0 ){ output += '\n'}
} //for e
console.log( output )
/*
	만약에  5를 입력했을때 s2 = 5
	output = ''
	for( let i = 1 ; i<=s2 ; i++ )
	
		i			조건[i<=s1]	  		실행문			조건1[i%3==0]  		[output]			 		
	i = 1일때			1<=5		T	output += '*'		1%3 == 1			output = '*'				
	i = 2일때			2<=5		T	output += '*'		2%3 == 2			output = '**'				
	i = 3일때			3<=5		T	output += '*'		3%3 == 0			output = '***\n'			
	i = 4일때			4<=5		T	output += '*'		4%3 == 1			output = '***\n*' 			
	i = 5일때			5<=5		T	output += '*'		5%3 == 2			output = '***\n**' 			
	i = 6일때			6<=5		F	실행X
*/

// 문제1
output = '' 
let line1 = Number( prompt('문제1 줄수 ') )
for( let i = 1 ; i <= line1 ; i++ ){ // for s
	// 1. 별출력
	for(let s = 1 ; s <= i ; s++ ){ // for s
		output += '*' 
		} //for e
	// 2. 줄바꿈출력
	output += '\n'
} //for e
console.log( output )
/*
1. 입력받은 줄수[line] 만큼 출력 예시) 5 
				i[line]		s[star]
	*			i=1			s = 1
	**			i=2			s = 1 2 
	***			i=3			s = 1 2 3 
	****		i=4			s = 1 2 3 4 
	*****		i=5			s = 1 2 3 4 5 
				- i는 1부터 입력받은 수까지 1씩증가 	= for( let i = 1 ; i<=line ; i++ )
					- s는 1부터 1까지 - s는 1부터 2까지 - s는 1부터 3까지 - s는 1부터 4까지 - s는 1부터 5까지
				- 결론  s는 1부터 i까지				= for( let s = 1 ; s<=i ; s++ )
*/
// 문제2
output = ''
let line2 = Number( prompt('문제2 줄수 ') )
for( let i = 1 ; i <= line2 ; i++ ){ // for s : 줄마다 별/줄바꿈 출력
	// 1. 별출력
	for(let s = 1 ; s <= line2-i+1 ; s++ ){ // for s
		output += '*' 
		} //for e
	// 2. 줄바꿈출력
	output += '\n'
} //for e
console.log( output )
/*
				i[line2]	s[star]			[예시]
	*****		i=1			s = 1 2 3 4 5	입력받은 줄수 - 현재줄수+1 : 5 - 1+1 5
	****		i=2			s = 1 2 3 4		입력받은 줄수 - 현재줄수+1 : 5 - 2+1 4
	***			i=3			s = 1 2 3 		입력받은 줄수 - 현재줄수+1 : 5 - 3+1 3
	**			i=4			s = 1 2 		입력받은 줄수 - 현재줄수+1 : 5 - 4+1 2
	*			i=5			s = 1 			입력받은 줄수 - 현재줄수+1 : 5 - 5+1 1
				- i는 1부터 입력받은 줄까지 1씩증가 = for( let i = 1 ; i <= line2 ; i++)
				- s는 1부터 (입력받은 줄수- 현재줄수+1)까지 = for( let s = 1 ; s <= line2-i+1 ; s++)
				 - s는 1부터 5까지 - s는 1부터 4까지 - s는 1부터 3까지 - s는 1부터 2까지 - s는 1부터 1까지 
*/
// 문제3
output = ''
let line3 = Number( prompt('문제3 줄수 ') )
for( let i = 1 ; i <= line3 ; i++ ){// for s
	// 1. 공백출력		
	for( let b = 1 ; b <= line3-i ; b++){// for s
		output +=' '
	}//for e
	// 2. 별출력
	for( let s = 1 ; s <= i ; s++ ){// for s
		output += '*'
	}//for e
	// 3, 줄바꿈
	output += '\n'
}//for e
console.log( output )
/*		
			i[line3]	b[공백]			s[star]			
	    *	i=1			b = 1 2 3 4 	s = 1		
	   **	i=2			b = 1 2 3 		s = 1 2	
	  ***	i=3			b = 1 2 		s = 1 2 3		
	 ****	i=4			b = 1 			s = 1 2 3 4		
	*****	i=5			b = 			s = 1 2 3 4 5	
	    - i는 1부터 입력받은 줄까지 1씩증가 			= for( let i = 1 ; i <= line3 ; i++)
	    - b는 1부터 (입력받은줄-현재줄수)까지 1씩증가 	= for( let b = 1 ; b <= line3-i ; b++)
	    - s는 1부터 현재줄수 까지 1씩증가 			= for( let s = 1 ; s <= i ; s++ )
	    !!! 줄마다 공백과 별과 줄바꿈 출력
	    
	    for( let i = 1 ; i <= line3 ; i++ ){
			for( let b = 1 ; b <= line3-i ; b++){}
				for( let s = 1 ; s <= i ; , s++ ){}	
			}
*/
// 문제4
output = ''
let line4 = Number( prompt('문제4 줄수 ') )
for( let i = 1 ; i <= line4 ; i++ ){// for s
	// 1. 공백출력		
	for( let b = 0 ; b <= i-1 ; b++ ){// for s
		output +=' '
	}//for e
	// 2. 별출력
	for( let s = 1 ; s <= line4-i+1 ; s++ ){// for s
		output += '*'
	}//for e
	// 3, 줄바꿈
	output += '\n'
}//for e
console.log( output )
/*		
			i[line4]	b[공백]			s[star]			
	*****	i=1			b =  			s = 1 2 3 4 5		
	 ****	i=2			b = 1  			s = 1 2	3 4
	  ***	i=3			b = 1 2 		s = 1 2 3		
	   **	i=4			b = 1 2 3		s = 1 2 		
	    *	i=5			b = 1 2 3 4		s = 1 
	  - i는 1부터 입력받은 줄까지 1씩증가 			= for( let i = 1 ; i <= line4 ; i++ )
	  - b는 1부터 (현재줄수-1)까지 1씩증가		= for( let b = 1 ; b <= i ; b++ ) 
	  - s는 1부터 (입력받은 줄수-현재줄수+1)까지 	= for( let s = 1 ; s <= line4-i+1 ; s++ )  	    	
*/
// 문제5
output = ''
let line5 = Number( prompt('문제5 줄수 ') )
for( let i = 1 ; i <= line5 ; i++ ){// for s
	// 1. 공백출력		
	for( let b = 1 ; b <= line5-i ; b++ ){// for s
		output +=' '
	}//for e
	// 2. 별출력
	for( let s = 1 ; s <= i*2-1 ; s++ ){// for s
		output += '*'
	}//for e
	// 3, 줄바꿈
	output += '\n'
}//for e
console.log( output )
/*		
			i[line4]	b[공백]			s[star]			
    *		i=1			b = 1 2 3 4 	s = 1		
   ***		i=2			b = 1 2 3 		s = 1 2	3  
  *****		i=3			b = 1 2 		s = 1 2 3 4 5		
 *******	i=4			b = 1 			s = 1 2 3 4 5 6 7	
*********	i=5			b = 			s = 1 2 3 4 5 6 7 8 9
	  - i는 1부터 입력받은 줄까지 1씩증가 			= for( let i = 1 ; i <= line5 ; i++ )
	  - b는 1부터 (입력받은줄-현재줄수)까지 1씩증가 	= for( let b = 1 ; b <= line5-i ; b++) 
	  - s는 1부터 까지 	= for( let s = 1 ; s <= i*2-1 ; s++ )
	  			   1부터 i까지	1부터 i*2까지 	1부터 i*2-1까지
	  	1부터 1까지  1부터 1까지	1부터 2까지		1부터 1까지
	  	1부터 3까지  1부터 2까지	1부터 4까지		1부터 3까지
	  	1부터 5까지  1부터 3까지	1부터 6까지		1부터 5까지
	  	1부터 7까지  1부터 4까지	1부터 8까지		1부터 7까지
	  	1부터 9까지  1부터 5까지	1부터 10까지  	1부터 9까지    	
*/
  	
/*		
			i[line6]	b[공백]			s[star]			
    *		i=1			b = 1 2 3 4 	s = 1		
   ***		i=2			b = 1 2 3 		s = 1 2	3  
  *****		i=3			b = 1 2 		s = 1 2 3 4 5		
 *******	i=4			b = 1 			s = 1 2 3 4 5 6 7	
*********	i=5			b = 			s = 1 2 3 4 5 6 7 8 9
	  - i는 1부터 입력받은 줄까지 1씩증가 			= for( let i = 1 ; i <= line6 ; i++ )
	  - b는 1부터 (입력받은줄-현재줄수)까지 1씩증가	= for( let b = 1 ; b <= line6 - i ; b++ ) 
	  - s는 1부터 까지 						= for( let s = 1 ; s <= i*2-1 ; s++ )
	  			   1부터 i까지	1부터 i*2까지 	1부터 i*2-1까지
	  	1부터 1까지  1부터 1까지	1부터 2까지		1부터 1까지
	  	1부터 3까지  1부터 2까지	1부터 4까지		1부터 3까지
	  	1부터 5까지  1부터 3까지	1부터 6까지		1부터 5까지
	  	1부터 7까지  1부터 4까지	1부터 8까지		1부터 7까지
	  	1부터 9까지  1부터 5까지	1부터 10까지  	1부터 9까지

*********	i=1			b = 			s = 1 2 3 4 5 6 7 8 9  
 *******	i=2			b = 1  			s = 1 2 3 4 5 6 7  
  *****	  	i=3			b = 1 2 		s = 1 2 3 4 5
   ***	  	i=4			b = 1 2 3  		s = 1 2	3
    *	  	i=5			b = 1 2 3 4	 	s = 1
    	- i는 1부터 입력받은 줄까지 1씩증가 		= for( let i = 1 ; i <= line6 ; i++ )
    	- b는 1부터 (현재줄수-1)까지 1씩증가		= for( let b = 1 ; b <= i-1 ; b++ )
    	- s는 1부터 						= for( let s = 1 ; s <= line6*2-i*2+1 ; s++ )
	    			 	[line6]예5 -	1부터 i*2까지		+1
		  	1부터 9까지	5*2=10	-	1부터 2까지	= 8	+1	= 9
		  	1부터 7까지	5*2=10	-	1부터 4까지	= 6	+1	= 7
		  	1부터 5까지	5*2=10	-	1부터 6까지	= 4	+1	= 5
		  	1부터 3까지	5*2=10	-	1부터 8까지	= 2	+1	= 3
		  	1부터 1까지	5*2=10	-	1부터 10까지	= 0	+1	= 1 			 	 	    	
*/
output = ''
let line6 = Number( prompt('줄수 ') )
for( let i = 1 ; i <= line6 ; i++ ){// for s
	// 1. 공백출력		
	for( let b = 1 ; b <= line6-i ; b++ ){// for s
		output +=' '
	}//for e
	// 2. 별출력
	for( let s = 1 ; s <= i*2-1 ; s++ ){// for s
		output += '*'
	}//for e
	// 3, 줄바꿈
	output += '\n'
}//for e
for( let i = 1 ; i <= line6 ; i++ ){// for s
	// 1. 공백출력		
	for( let b = 1 ; b <= i-1 ; b++ ){// for s
		output +=' '
	}//for e
	// 2. 별출력
	for( let s = 1 ; s <= line6*2-i*2+1 ; s++ ){// for s
		output += '*'
	}//for e
	// 3, 줄바꿈
	output += '\n'
}//for e
console.log( output )

/* 줄예시 7			
*          *		
  *      *			
    *  *			
      *				
    *  *			
  *      *			
*          *		

*/

