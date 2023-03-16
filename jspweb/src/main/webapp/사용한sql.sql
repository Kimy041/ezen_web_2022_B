use jspweb;
-- 회원테이블
drop table if exists member;
create table member(
	mno 	int auto_increment primary key ,
    mid 	varchar(30) not null unique , -- 회원 아이디 [ 공백불가 , 중복불가 ]
    mpw 	varchar(20) not null , -- 회원 비밀번호 [ 공백불가 ]
    mimg	longtext ,	-- 웹서버에 저장된 사진 경로 [ 공백가능 ]
    memail	varchar(100) not null unique -- 회원 이메일 [ 공백불가 , 중복불가 ]
);
-- 친구 테이블
drop table if exists friend;
create table friend(
	fno		int auto_increment primary key , -- 식별번호
    ffrom 	int ,		-- 친구 신청한 회원 fk
    fto 	int ,		-- 친구 신청 받은 회원 fkk
    foreign key ( ffrom ) references member ( mno ) on delete set null ,
    foreign key( fto ) references member ( mno ) on delete set null -- 친구가 탈퇴하면 null
);
-- 포인트 테이블
drop table if exists mpoint;
create table mpoint(
	mpno		int auto_increment primary key ,	-- 포인트내역 식별번호
    mpcomment	varchar(1000) not null ,	-- 포인트내역 내용
    mpamount	int default 0 ,				-- 포인트 수량
    mdate		datetime default now(),		-- 포인트 내역 날짜
    mno			int ,						-- 포인트 변경된 회원번호
    foreign key ( mno ) references member ( mno ) on delete set null	-- 탈퇴하면 포인트 null
);
-- 카테고리 테이블[ 카테고리번호 , 카테고리 이름 ( 공지사항, 커뮤니티 , OnA , 노하우 등등 ) ]
drop table if exists category;
create table category(
	cno	int auto_increment primary key ,
    cname varchar(100) not null
);
-- 게시물 테이블 [ 번호 , 제목 , 내용 , 첨부파일 , 작성일 , 조회수 , 좋아요수 , 싫어요수 , 작성자 , 카테고리번호  ]
drop table if exists board;
create table board(
	bno int auto_increment primary key ,
    btitle varchar(1000) not null,
    bcontent longtext not null,
    bfile	longtext ,
    bdate	datetime default now(),
    bview	int default 0,
    bup		int default 0,
    bdown	int default 0,
    mno		int , -- 회원번호 fk
    cno		int , -- 카테고리번호 fk
    foreign key ( mno ) references member( mno ) on delete set null, -- [회원]pk가 삭제되면 게시물fk는 null 변경
    foreign key ( cno ) references category( cno ) on delete cascade -- [카테고리]pk가 삭제되면 게시물 같이 삭제 
);
-- on delete cascade 	: pk가 삭제되면 fk 같이 삭제
-- on delete set null 	: pk가 삭제되면 fk는 null 로 변경 
-- 생략 					: fk에 존재하는 식별키[pk] 는 삭제 불가능 

-- 1. 
insert into category(cname) values( '공지사항');
insert into category(cname) values( '커뮤니티');
insert into category(cname) values( 'QnA');
insert into category(cname) values( '노하우');
select * from category;

select * from member;


/*
	테이블 설계 주의점
		1. 서로 다른 테이블간의 중복필드 x
        2. 예외) 서로 다른 테이블간의 관계[연결 PK-FK] : 무결성 유지
			- 테이블당 pk 1개 이상 권장
*/

-- 아이디에 해당 하는 회원정보[레코드] 호출
select * from member where mid = 'qwe';
-- 아이디에 해당 하는 회원정보[레코드]+보유포인트 호출

-- 1. 특정 회원 포인트 내역
select * from mpoint where mno = 1;
-- 2. 특정 회원 보유 포인트
select sum(mpamount) from mpoint where mno = 1;
-- 3. 아이디에 해당 하는 회원의 보유 포인트 [ 조인 -- 교집합	1.pk---fk ]
select * from member m, mpoint p where m.mno = p.mno;	-- 다른 조건과 헷갈리수 있다
select * from member m join mpoint;						-- 암묵적으로 pk와fk 찾아서 조인
-- 4. 조인후 필요한 필드만 출력
select m.mno, m.mid, m.mimg, m.memail
from member m , mpoint p
where m.mno = p.mno;
-- 4. (회원별 보유포인트)조인후 필요한 필드와 통계[ 두개 이상 필드를 출력시 그룹필수~ ]
select m.mno, m.mid, m.mimg, m.memail, sum(p.mpamount) as 보유포인트
from member m , mpoint p
where m.mno = p.mno
group by mno;	-- 집계할 기준 [~별]
-- 5. (특정1명 회원정보+보유포인트)
select m.mno, m.mid, m.mimg, m.memail, sum(p.mpamount) as mpoint
from member m , mpoint p
where m.mno = p.mno and m.mid = 'qwe';
-- * 포인트지급
insert into mpoint( mpcomment , mpamount , mno ) value( '회원가입축하' , 100 , 1 );
select * from mpoint;
-- * 포인트 결제
insert into mpoint( mpcomment , mpamount , mno ) value( '포인트결제구매' , 5000 , 1 );
-- * 포인트 사용
insert into mpoint( mpcomment , mpamount , mno ) value( '제품구매' , -3000 , 1 );
insert into mpoint( mpcomment , mpamount , mno ) value( '회원가입축하' , 100 , 3 );

-- 2. 조인 테스트 

-- 1. 조건[where] 조인[합집합]
drop table ex4;
create table ex4(
	mno int 
);
insert into ex4 values( 1 ) , ( 2 ) , ( 3 ) , ( 4 ) , ( 5 );	-- 5레코드 추가 
select * from ex4;

drop table ex5;
create table ex5(
	mno	int
);
insert into ex5 values( 3 ) , ( 4 ) , ( 5 ) , ( 6 ) , ( 7 );	-- 5레코드 추가 
select * from ex5;
-- ------------------------------------
select * from ex4 , ex5	; -- 25레코드 검색 [ 합 집합 레코드개수 * 레코드개수 ]
select * from ex4 , ex5 where ex4.mno = ex5.mno; -- 3레코드[ 교 집합의  두 레코드의 일치값 [ pk-fk ] ]

select * from ex4 natural join ex5;	-- natural join 자연조인 [ 교집합 ( 암묵적으로 동일한 레코드의 일치값 ) ]
-- board 테이블에는 mno 있다. 원한건 mno[fk] ---> member테이블의 mno[pk] 외 다른 필드에 접근 
select * from member , board; 
	-- 1. where 이용한 조인 [ * 다른 조건과 가독성 떨어짐 ]
    select * from member , board where member.mno = board.mno;
    -- 2. 테이블명 별칭[별명]
    select * from member m , board b where m.mno = b.mno; 
	-- 3. A테이블 natural join B테이블 		:  자연조인 [ * pk와fk 필드가 1개씩 존재하는 테이블에서 자주 사용 ]
    select * from member natural join board;
    -- 4. A테이블 join B테이블 on 조인조건  	:  조인 [ * on 키워드를 사용해서 교집합조건 사용하면 다른 where 구분 ]
    select * from member m join board b on m.mno = b.mno;
-- 결론 
select board.* , member.mid from member natural join board;




------------------------------------ 3/16 페이징처리 / 검색처리 연습 sql ----------------------------------
-- 1. 출력 
select board.* , member.mid from member natural join board;

-- 2. 특정 개수 만 출력 [ 페이징 조건 ] limit 시작인덱스[0~] , 개수 
select b.* , m.mid from member m natural join board b limit 0 , 3; -- 1페이지
select b.* , m.mid from member m natural join board b limit 3 , 3; -- 2페이지
select b.* , m.mid from member m natural join board b limit 6 , 3; -- 3페이지

select b.* , m.mid from member m natural join board b limit ? , ? ;

-- 3. 레코드 수 구하기 count(*)
select count(*) from member m natural join board b;

-- 4. 조건식 [ = 같다 ]
select * from board where btitle = '123123';
-- 4. 조건식 [ like 포함된 패턴검색 ]	필드명 like %데이터%
select * from board where btitle = 'asd';		-- asd인 제목의 레코드 찾기 
select * from board where btitle like '%asd%';	-- asd가 포함된 제목의 레코드 찾기
select * from board where btitle like '_asd_';	-- asd가 2번째 글자에 있는 5글자 제목의 레코드 찾기 
	-- % : 모든 문자 대응 [ 문자개수 무시 ]	/	_ : _개수만큼 대응 [ 문자개수 중요 ]
/*
	1asd2		like '_asd_'	--> true	/	like '%asd%' --> true
    1asd23		like '_asd_'	--> false	/	liket '%asd%' --> true
*/

-- 결론 
	-- 1. 검색이 없을때 레코드수 구하기 
    select count(*) from member m natural join board b;
    -- 2. 검색이 있을때 레코드수 구하기 [ 검색[조건]된 레코드수 ]
    select count(*) from member m natural join board b where b.btitle like '%asd%';
    -- 3. 자바에서 사용할경우
	-- "select count(*) from member m natural join board b where "+key+" like '%"+keyword+"%'" ;

	-- 1. 검색이 없을때 레코드 출력 
		select b.* , m.mid from member m natural join board b order by b.bno desc limit ? , ? ;
	-- 2. 검색이 있을때 레코드 출력 
		select b.* , m.mid from member m natural join board b where b.btitle like '%asd%' order by b.bno desc limit 0 , 3 
	-- 3. 자바에서 사용할 경우 
	--	"select b.* , m.mid from member m natural join board b where "+key+" like '%"+keyword+"%' order by b.bdate desc limit ? , ?" 












