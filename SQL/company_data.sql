--dept_info insert[��������]
insert into dept_info values(10, '�濵/�繫', 500);
insert into dept_info values(20, '�������/����', 700);
insert into dept_info values(30, '�����Ͼ�', null);
insert into dept_info values(40, 'IT/���ͳ�', null);

--wanted_info insert[ä������]
insert into wanted_info values(01, '����', 4000, 30, '����� ���ı�', '�л�');
insert into wanted_info values(02, '����ȭ��', 5177, 30, '����� ��������', '����');
insert into wanted_info values(03, '�Ｚ����', 4800, 20, '��⵵ ������ ���뱸', '�л�');
insert into wanted_info values(04, 'īī��', 4200, 40, '��⵵ ������ �д籸', '�л�');

--member_info insert[ȸ������]
insert into member_info values('seeun90', '�ڼ���', '19900804', '�濵�а�', 'seeun@gmail.com', 10);
insert into member_info values('hanna99', '���ѳ�', '19991223', 'ȭ�а�', 'hanna99@gmail.com', 20);
insert into member_info values('woosong92', '�ӿ��', '19920702', '���ڰ��а�', 'woosong92@gmail.com', 30);
insert into member_info values('jiwon95', '������', '19951102', '��ǻ�Ͱ��а�', 'jiwon95@gmail.com', 40);

--apply_info insert[��������]
insert into apply_info values(01, 'seeun90', 01, '2021-08-02');
insert into apply_info values(02, 'hanna99', 02, '2021-07-12');
insert into apply_info values(03, 'woosong92', 03, '2021-08-06');
insert into apply_info values(04, 'jiwon95', 04, '2021-07-23');

commit;
