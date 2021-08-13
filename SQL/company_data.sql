--dept_info insert[직무정보]
insert into dept_info values(10, '경영/사무', 500);
insert into dept_info values(20, '연구계발/설계', 700);
insert into dept_info values(30, '엔지니어', null);
insert into dept_info values(40, 'IT/인터넷', null);

--wanted_info insert[채용정보]
insert into wanted_info values(01, '쿠팡', 4000, 30, '서울시 송파구', '학사');
insert into wanted_info values(02, '엘지화학', 5177, 30, '서울시 영등포구', '석사');
insert into wanted_info values(03, '삼성전자', 4800, 20, '경기도 수원시 영통구', '학사');
insert into wanted_info values(04, '카카오', 4200, 40, '경기도 성남시 분당구', '학사');

--member_info insert[회원정보]
insert into member_info values('seeun90', '박세은', '19900804', '경영학과', 'seeun@gmail.com', 10);
insert into member_info values('hanna99', '김한나', '19991223', '화학과', 'hanna99@gmail.com', 20);
insert into member_info values('woosong92', '임우송', '19920702', '전자공학과', 'woosong92@gmail.com', 30);
insert into member_info values('jiwon95', '방지원', '19951102', '컴퓨터공학과', 'jiwon95@gmail.com', 40);

--apply_info insert[지원정보]
insert into apply_info values(01, 'seeun90', 01, '2021-08-02');
insert into apply_info values(02, 'hanna99', 02, '2021-07-12');
insert into apply_info values(03, 'woosong92', 03, '2021-08-06');
insert into apply_info values(04, 'jiwon95', 04, '2021-07-23');

commit;
