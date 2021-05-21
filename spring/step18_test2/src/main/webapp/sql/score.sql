create table score (
	studNo varchar2(30) primary key,   
	name varchar2(30) not null,
	kor number, 
	eng number, 
	mat number, 
	tot number,
	avg number(4, 1),
	logtime date
);
-- 테이블 삭제
drop table score purge;
-- 테이블 확인
select * from tab;

-- 데이터 저장
insert into score values ('2020001','홍길동',90,80,70,240,80,sysdate);
-- 데이터 검색
select * from score;
select * from score where studno='2020001';
-- 데이터 수정
update score set kor=91,eng=81,mat=71,tot=243,avg=81
where studno='2020001';
-- 데이터 삭제
delete score where studno='2020001';
-- DB 저장
commit;
