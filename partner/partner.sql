create table partner(
id number(8) primary key not null,
name varchar2(100) not null,
ceo varchar2(20),
contact varchar2(20),
address varchar2(50),
registered date default sysdate,
unregistered date
);

create sequence partner_seq;

select * from partner;