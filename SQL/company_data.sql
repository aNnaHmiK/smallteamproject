-- recipient insert[�濵 ���� ����]
insert into management_info values('�Ｚ����','465��','78500','������');
insert into management_info values('��������','465��','155500','������');
insert into management_info values('����','465��','145.6$','������');
insert into management_info values('īī��','465��','144500','īī����');

-- probono insert[��ǰ ���� ����]
insert into product_info values('������','�Ｚ����','5900��');
insert into product_info values('������','��������','1000��');
insert into product_info values('������','����','6400��');
insert into product_info values('īī����','īī��','4000��');

-- probono_project insert[���� �ڰ� ����]
insert into qualification_info values('�Ｚ����','���б���','��ǻ�Ͱ���','�ѱ���');
insert into qualification_info values('��������','���б���','��ǻ�Ͱ���','�ѱ���');
insert into qualification_info values('����','���п���','�������','����');
insert into qualification_info values('īī��','����б���','����Ʈ�������','�ѱ���');

-- probono_project insert[������ ���� ����]
insert into founder_info values('�̺�ö','1910~1987','���ѹα�');
insert into founder_info values('����ȸ','1907~1969','���ѹα�');
insert into founder_info values('��Ƽ���⽺','1955~2011','�̱�');
insert into founder_info values('�����','1966~ ','���ѹα�');

-- probono_project insert[���� ���� ����]
insert into country_info values('���ѹα�','�ѱ���',11);
insert into country_info values('�̱�','����',1);
insert into country_info values('�Ϻ�','�Ϻ���',3);
insert into country_info values('�߱�','�߱���',2);

-- probono_project insert[ȸ�� ���� ����]
insert into member values('a01','�ڼ���','19900804','�濵�а�');
insert into member values('b02','���ѳ�','19991223','ȭ�а�');
insert into member values('c03','�ӿ��','19920702','�����а�');
insert into member values('d04','������','19951102','��ǻ�Ͱ��а�');

-- activist insert[ȸ�� ���� ����]
insert into company_info values('�Ｚ����', '�̺�ö', '1969', '���ѹα�',5000);
insert into company_info values('��������', '����ȸ', '1958','���ѹα�',4800);
insert into company_info values('����', '��Ƽ���⽺', '1976','�̱�',5500);
insert into company_info values('īī��', '�����', '1938','���ѹα�',5300);

-- probono_project insert[���� ���� ����]
insert into apply_info values(11,'a01','�Ｚ����','2021-08-02');
insert into apply_info values(12,'b02','��������','2021-07-12');
insert into apply_info values(13,'c03','����','2021-08-06');
insert into apply_info values(14,'d04','īī��','2021-07-23');




commit;


select * from company_info;
select * from management_info;
select * from product_info;
select * from qualification_info;
select * from founder_info;
select * from country_info;
select * from member;
select * from apply_info;