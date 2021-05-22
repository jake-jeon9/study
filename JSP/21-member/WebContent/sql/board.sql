-- 테이블 생성
create table board (
    seq number not null,        --글번호
    id varchar2(20) not null,    --아이디
    name varchar2(40) not null,  --이름
    subject varchar2(255) not null,  --제목
    content varchar2(4000) not null,  --내용
    hit number default 0,            -- 조회수
    logtime date default sysdate     -- 작성일
);
--테이블 삭제
drop table board purge;

-- 테이블 구조 확인
desc board;

-- 테이블 목록 
select * from tab;

create sequence test increment by 2 minvalue 1 maxvalue 9 nocache cycle;
select test.nextval from board;
drop sequence test;

-- 시퀀스 객체 생성
create sequence seq_board nocache nocycle;

-- 시퀀스 객체 삭제
drop sequence seq_board;

-- 전체내용 확인
select * from board;

-- 특정 글번호로 확인
select * from board where seq=1;

-- 데이터 저장
insert into board values (seq_board.nextval, 'num1','홍길동', '내일은','웃으리...',0, sysdate);

-- 데이터 삭제
delete board where seq=1;

-- DB저장
commit;