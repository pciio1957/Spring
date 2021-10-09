
CREATE TABLE calendar (
	id NUMBER, 
	title varchar2(100),
	start1 varchar2(50),
	end1 varchar2(50),
	content varchar2(500), --추가할 내용 처리
	borderColor varchar2(20),
	backgroundColor varchar2(20),
	textColor varchar2(20),
	allDay number(1) -- 종일 여부 TRUE/FALSE
);


CREATE SEQUENCE cal_seq
	START WITH 1000
	MINVALUE 1000
	MAXVALUE 9999;

DROP TABLE calendar;
DROP SEQUENCE cal_seq;

INSERT INTO calendar values(cal_seq.nextval, '일정 첫 등록', 
	'2021-10-07', '2021-10-08', '일정등록입니다', 
	'navy', 'blue', 'yellow', 1);


SELECT * FROM calendar;