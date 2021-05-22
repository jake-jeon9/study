create table score( --주로 id 전화번호 email을 구분함 
        numberOfStudent varchar2(30) primary key,
        name varchar2(30) not null,
        kor number,
        eng number,
        mat number,
        total number,
        avg number
             );

             --데이터 입력
insert into score values(20090701, '일길이', 91,50,80,270,90);
insert into score values(20090702, '이길이', 92,50,80,270,90);
insert into score values(20090703, '삼길이', 93,50,94,270,90);
insert into score values(20090704, '사길이', 94,50,44,270,90);
insert into score values(20090705, '오길이', 95,60,99,270,90);
insert into score values(20090706, '육길이', 96,60,68,270,90);
insert into score values(20090707, '칠길이', 97,70,80,270,90);
insert into score values(20090708, '팔길이', 98,70,80,270,90);

--전체 리스트
select * from score;

--페이징 리ㅡ트
select * from
(select rownum rn, tt.*from
(select * from score order by numberOfStudent desc)tt) 
where rn>=1 and rn<=5;

--카운트 
select count(*) as cnt from score;

--수정
update score set name='만식이' where total=240;

--삭제
delete score where numberofstudent=20090808;

commit;