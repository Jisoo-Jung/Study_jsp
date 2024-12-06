
CREATE SEQUENCE SEQ_MEMBER;

CREATE TABLE TBL_MEMBER (
	ID NUMBER CONSTRAINT PK_MEMBER PRIMARY KEY,
   	MEMBER_NAME VARCHAR2(255) NOT NULL,
   	MEMBER_AGE NUMBER NOT NULL
);

SELECT ID, MEMBER_NAME, MEMBER_AGE
FROM TBL_MEMBER;

INSERT INTO TBL_MEMBER
(ID, MEMBER_NAME, MEMBER_AGE)
VALUES(SEQ_MEMBER.NEXTVAL, '정지수', 10);