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
-- ���̺� ����
drop table score purge;
-- ���̺� Ȯ��
select * from tab;

-- ������ ����
insert into score values ('2020001','ȫ�浿',90,80,70,240,80,sysdate);
-- ������ �˻�
select * from score;
select * from score where studno='2020001';
-- ������ ����
update score set kor=91,eng=81,mat=71,tot=243,avg=81
where studno='2020001';
-- ������ ����
delete score where studno='2020001';
-- DB ����
commit;
