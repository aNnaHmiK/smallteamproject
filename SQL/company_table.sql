-- 회사 정보
DROP TABLE company_info cascade constraint;

-- 경영 정보
DROP TABLE management_info cascade constraint;

-- 상품 정보
DROP TABLE product_info cascade constraint;

-- 계열사 정보
DROP TABLE qualification_info cascade constraint;

-- 설립자 정보
DROP TABLE founder_info cascade constraint;

-- 국가 정보
DROP TABLE country_info cascade constraint;

-- 지원자 정보
DROP TABLE member cascade constraint;

-- 지원 정보
DROP TABLE apply_info cascade constraint;


CREATE TABLE company_info (
       company_name          VARCHAR2(20)  PRIMARY KEY,
       founder_name          	VARCHAR2(20) NOT NULL,
       found_date         	VARCHAR2(20) NOT NULL,
       head_country        	VARCHAR2(20) NOT NULL,
       salary                  NUMBER(10) NOT NULL
);

CREATE TABLE management_info (
       company_name        		VARCHAR2(20) PRIMARY KEY,
       market_cap          		VARCHAR2(50) NOT NULL,
       stock_price             VARCHAR2(50) NOT NULL,
       product_main            VARCHAR2(50) NOT NULL
);

CREATE TABLE product_info (
       product_name          	VARCHAR2(20)  PRIMARY KEY,
       company_name            VARCHAR2(20) NOT NULL,
       sales_rate               VARCHAR2(20) NOT NULL
       );

CREATE TABLE qualification_info(
        company_name     		VARCHAR2(20)  PRIMARY KEY,
        education               VARCHAR2(20)  NOT NULL,
        major                   VARCHAR2(30)  NOT NULL,
        lang                    VARCHAR2(20)  NOT NULL
);

CREATE TABLE founder_info (
       founder_name           	VARCHAR2(50) PRIMARY KEY,
       birth_death              VARCHAR2(50) NOT NULL,
       birth_country        	VARCHAR2(40) NOT NULL
);

CREATE TABLE country_info (
	   country_name     		VARCHAR2(30) PRIMARY KEY,
	   lang      	        	VARCHAR2(30) NOT NULL,
       gdp_rank           		NUMBER(5) NOT NULL
);

CREATE TABLE member (
       member_id         VARCHAR2(20)  PRIMARY KEY,
       member_name          VARCHAR2(20)  NOT NULL,
       birth_date         	VARCHAR2(20) NOT NULL,
       major      		VARCHAR2(20) NOT NULL
);

CREATE TABLE  apply_info (
       applicant_num         	NUMBER(5) PRIMARY KEY,
       member_id          VARCHAR2(20)  NOT NULL,
       company_name          	VARCHAR2(20) NOT NULL,
       apply_date         	VARCHAR2(20) NOT NULL
);

ALTER TABLE apply_info  ADD FOREIGN KEY (member_id) REFERENCES member  (member_id);
ALTER TABLE apply_info ADD FOREIGN KEY (company_name)  REFERENCES company_info  (company_name);
ALTER TABLE company_info  ADD FOREIGN KEY (head_country) REFERENCES country_info  (country_name);
ALTER TABLE company_info  ADD FOREIGN KEY (founder_name ) REFERENCES founder_info  (founder_name );
commit;