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

drop table score purge;

insert into score values ('2020001' , '¿Ã¿Œ¡¶', 100, 100, 100 , 300, 100, sysdate);
update score set kor = 100 , eng = 100, mat = 90 where studNo = '2020001';

select * from score order by desc 'studNo';