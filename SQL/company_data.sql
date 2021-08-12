-- recipient insert[경영 정보 저장]
insert into management_info values('삼성전자','465조','78500','갤럭시');
insert into management_info values('엘지전자','465조','155500','엘지폰');
insert into management_info values('애플','465조','145.6$','아이폰');
insert into management_info values('카카오','465조','144500','카카오톡');

-- probono insert[상품 정보 저장]
insert into product_info values('갤럭시','삼성전자','5900만');
insert into product_info values('엘지폰','엘지전자','1000만');
insert into product_info values('아이폰','애플','6400만');
insert into product_info values('카카오톡','카카오','4000만');

-- probono_project insert[지원 자격 저장]
insert into qualification_info values('삼성전자','대학교졸','컴퓨터공학','한국어');
insert into qualification_info values('엘지전자','대학교졸','컴퓨터공학','한국어');
insert into qualification_info values('애플','대학원졸','영어영문학','영어');
insert into qualification_info values('카카오','고등학교졸','소프트웨어공학','한국어');

-- probono_project insert[설립자 정보 저장]
insert into founder_info values('이병철','1910~1987','대한민국');
insert into founder_info values('구인회','1907~1969','대한민국');
insert into founder_info values('스티브잡스','1955~2011','미국');
insert into founder_info values('김범수','1966~ ','대한민국');

-- probono_project insert[국가 정보 저장]
insert into country_info values('대한민국','한국어',11);
insert into country_info values('미국','영어',1);
insert into country_info values('일본','일본어',3);
insert into country_info values('중국','중국어',2);

-- probono_project insert[회원 정보 저장]
insert into member values('a01','박세은','19900804','경영학과');
insert into member values('b02','김한나','19991223','화학과');
insert into member values('c03','임우송','19920702','물리학과');
insert into member values('d04','방지원','19951102','컴퓨터공학과');

-- activist insert[회사 정보 저장]
insert into company_info values('삼성전자', '이병철', '1969', '대한민국',5000);
insert into company_info values('엘지전자', '구인회', '1958','대한민국',4800);
insert into company_info values('애플', '스티브잡스', '1976','미국',5500);
insert into company_info values('카카오', '김범수', '1938','대한민국',5300);

-- probono_project insert[지원 정보 저장]
insert into apply_info values(11,'a01','삼성전자','2021-08-02');
insert into apply_info values(12,'b02','엘지전자','2021-07-12');
insert into apply_info values(13,'c03','애플','2021-08-06');
insert into apply_info values(14,'d04','카카오','2021-07-23');




commit;


select * from company_info;
select * from management_info;
select * from product_info;
select * from qualification_info;
select * from founder_info;
select * from country_info;
select * from member;
select * from apply_info;