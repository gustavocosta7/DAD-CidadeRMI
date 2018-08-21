create database dad;

use dad;

create table estado(
	estid int not null auto_increment,
    estnome varchar(15) not null,
    estsigla varchar(5),
    estibge int,
    
    primary key(estid)

);


drop table cidade;
create table cidade(
	cidid int not null auto_increment,
    cidestid int not null,
    cidnome varchar(60),
    cidpopulacao long not null,
    cidfundacao date,
    cidibge int not null,
    
    primary key(cidid),
    foreign key(cidestid) references estado(estid)
    
);
select*from cidade;

insert into estado value(1,"Amazonas","AM",123);
insert into estado value(2,"Rio","RJ",234);
insert into estado value(3,"Santa Catarina","SC",567);

