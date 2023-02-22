-- 1. DB 생성 
create database 과제11;
-- 2. DB 선택 
use 과제11;
-- 3. 테이블 생성 
create table product(
	pno int auto_increment primary key ,
    pname varchar(20) ,
    pprice int ,
    pcount int
);
-- SQL 처리 구문 
-- 제품 등록  
String sql = "insert into product ( pname , pprice , pcount ) values ( ? , ? , ? )";
-- 제품 목록 출력
String sql = "select * from product";
-- 제품 이름, 가격 수정
String sql = "update product set pname = ? , pprice = ?  where pno = ?";
-- 제품 수량 수정
String sql = "update product set pcount = ?  where pno = ?";
-- 제품 삭제
String sql = "delete from product where pno = ?";