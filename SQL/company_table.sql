-- 구인 정보
DROP TABLE wanted_info cascade constraint;

-- 지원자 정보
DROP TABLE member_info cascade constraint;

-- 지원 정보
DROP TABLE apply_info cascade constraint;

-- 직무 정보
DROP TABLE dept_info cascade constraint;

CREATE TABLE dept_info (
       dept_num      	      NUMBER(10) PRIMARY KEY,
       dept_name              VARCHAR2(30) NOT NULL,
       incentive              NUMBER(30) 
);

CREATE TABLE wanted_info ( 
	   wanted_num   		 NUMBER(10) NOT NULL PRIMARY KEY,
       company_name          VARCHAR2(30) NOT NULL,
       salary                NUMBER(20) NOT NULL,
       dept_num      	     NUMBER(10) NOT NULL,
       location				 VARCHAR2(50) NOT NULL,
       qualification         VARCHAR2(100) NOT NULL
);

CREATE TABLE member_info (
       member_id            VARCHAR2(30) PRIMARY KEY,
       member_name          VARCHAR2(30) NOT NULL,
       birth_date         	VARCHAR2(30) NOT NULL,
       major             	VARCHAR2(30) NOT NULL,
       email            	VARCHAR2(50) NOT NULL,
       dept_hope      	    NUMBER(10) NOT NULL
);

CREATE TABLE apply_info (
       applicant_num          NUMBER(10) PRIMARY KEY,
       member_id              VARCHAR2(30) NOT NULL,
       wanted_num          	  NUMBER(10) NOT NULL,
       apply_date             VARCHAR2(30) NOT NULL
);

ALTER TABLE wanted_info ADD FOREIGN KEY (dept_num) REFERENCES dept_info (dept_num);
ALTER TABLE member_info ADD FOREIGN KEY (dept_hope)  REFERENCES dept_info (dept_num);
ALTER TABLE apply_info  ADD FOREIGN KEY (member_id) REFERENCES member_info (member_id);
ALTER TABLE apply_info  ADD FOREIGN KEY (wanted_num) REFERENCES wanted_info (wanted_num);

commit;


