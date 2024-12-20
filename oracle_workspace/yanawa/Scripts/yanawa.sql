CREATE TABLE TBL_SPORTS_KIND_RADIO(
ID NUMBER PRIMARY KEY,
SPORTS_KIND_VALUE NUMBER NOT NULL-- 사용자가 선택한 값 (1~5)
);

CREATE TABLE TBL_USER(
   ID NUMBER PRIMARY KEY,
   USER_NAME VARCHAR2(255) NOT NULL,
   USER_EMAIL VARCHAR2(255) NOT NULL,
   USER_NICKNAME VARCHAR2(255) NOT NULL,
   USER_PHONE VARCHAR2(255) NOT NULL,
   USER_PASSWORD VARCHAR2(255) NOT NULL,
   USER_GENDER VARCHAR2(255) NOT NULL,
   USER_POINT NUMBER NOT NULL,
   USER_INTRODUCE VARCHAR2(255),
   USER_SPORT_KIND VARCHAR2(255),
   USER_POSITION_KIND VARCHAR2(255),
   USER_SPORT_HISTORY VARCHAR2(255),
   USER_BIRTH DATE NOT NULL,
   CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
   UPDATED_DATE DATE NOT NULL
);
CREATE TABLE TBL_CITY(
   ID NUMBER PRIMARY KEY,
   CITY_NAME VARCHAR2(255) NOT NULL
);

CREATE TABLE TBL_LOCAL_CITY(
   ID NUMBER PRIMARY KEY,
   LOCAL_CITY_NAME VARCHAR2(255) NOT NULL,
   CITY_ID NUMBER,
   CONSTRAINT FK_LOCAL_CITY_CITY FOREIGN KEY(CITY_ID)
   REFERENCES TBL_CITY(ID)
);

CREATE TABLE TBL_PROFILE_IMG(
   ID NUMBER PRIMARY KEY,
   PROFILE_PATH VARCHAR2(255) NOT NULL,
   PROFILE_SIZE NUMBER DEFAULT 0,
   STATUS NUMBER DEFAULT 0,
   CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
   UPDATED_DATE DATE NOT NULL,
   USER_ID NUMBER NOT NULL,
   CONSTRAINT FK_PROFILE_USER FOREIGN KEY (USER_ID)
   REFERENCES TBL_USER(ID)
);

CREATE TABLE TBL_POST(
   ID NUMBER PRIMARY KEY,
   POST_TITLE VARCHAR2(255) NOT NULL,
   POST_CONTENT VARCHAR2(255) NOT NULL,
   CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
   UPDATED_DATE DATE NOT NULL,
   TYPE NUMBER NOT NULL
);

CREATE TABLE TBL_ATTACHMENT (
   ID NUMBER PRIMARY KEY,
   ATTACHMENT_PATH VARCHAR2(255) NOT NULL,
   ATTACHMENT_SIZE NUMBER DEFAULT 0,
   POST_ID NUMBER NOT NULL,
   CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
   UPDATED_DATE DATE NOT NULL,
   CONSTRAINT FK_ATTACHMENT_POST FOREIGN KEY(POST_ID)
   REFERENCES TBL_POST(ID)
);

CREATE TABLE TBL_FREEWRITE (
    POST_ID NUMBER PRIMARY KEY,
    VIEWS NUMBER DEFAULT 0,
    REPLY_COUNT NUMBER DEFAULT 0,
    USER_ID NUMBER NOT NULL,
    CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
    UPDATED_DATE DATE NOT NULL,
    CONSTRAINT FK_FREEWRITE_POST FOREIGN KEY(POST_ID)
    REFERENCES TBL_POST(ID),
    CONSTRAINT FK_FREEWRITE_USER FOREIGN KEY (USER_ID) 
    REFERENCES TBL_USER(ID)
);

CREATE TABLE TBL_REPLY (
    ID NUMBER PRIMARY KEY,
    REPLY_CONTENT VARCHAR2(255) NOT NULL,
    USER_ID NUMBER,
    POST_ID NUMBER,
    CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
    UPDATED_DATE DATE NOT NULL,
    CONSTRAINT FK_REPLY_USER FOREIGN KEY(USER_ID)
    REFERENCES TBL_USER(ID),
    CONSTRAINT FK_REPLY_POST FOREIGN KEY (POST_ID)
    REFERENCES TBL_FREEWRITE(POST_ID)
);

CREATE TABLE TBL_MEMBER(
   ID NUMBER PRIMARY KEY,
   USER_ID NUMBER,
   CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
   UPDATED_DATE DATE NOT NULL,
   CONSTRAINT FK_MEMBER_USER FOREIGN KEY(USER_ID)
   REFERENCES TBL_USER(ID)
);

CREATE TABLE TBL_TEAM(
   ID NUMBER PRIMARY KEY,
   MEMBER_ID NUMBER,
   TEAM_NAME VARCHAR2(255) NOT NULL,
   MEMBER_COUNT NUMBER(3) DEFAULT 0 NOT NULL,
   VOLUNTEER_NUMBER NUMBER(3),
   SPORTS_KIND_RADIO_ID NUMBER,
   LOCAL_CITY_ID NUMBER,
   DETAILED_AREA VARCHAR(255) NOT NULL,
   AGE_RANGE VARCHAR(255) NOT NULL,
   INFORMATION VARCHAR(255), 
   CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
   UPDATED_DATE DATE NOT NULL,
   CONSTRAINT FK_TEAM_SPORTS_KIND_RADIO FOREIGN KEY(SPORTS_KIND_RADIO_ID)
   REFERENCES TBL_SPORTS_KIND_RADIO(ID),
   CONSTRAINT FK_TEAM_MEMBER FOREIGN KEY(MEMBER_ID)
   REFERENCES TBL_MEMBER(ID),
   CONSTRAINT FK_TEAM_LOCAL_CITY FOREIGN KEY(LOCAL_CITY_ID)
   REFERENCES TBL_LOCAL_CITY(ID)
);

CREATE TABLE TBL_TEAMPOST(
   POST_ID NUMBER PRIMARY KEY,
   TEAM_ID NUMBER,
   CONSTRAINT FK_TEAMPOST_POST FOREIGN KEY(POST_ID)
   REFERENCES TBL_POST(ID),
   CONSTRAINT FK_TEAMPOST_TEAM FOREIGN KEY(TEAM_ID)
   REFERENCES TBL_TEAM(ID)
);

CREATE TABLE TBL_TEAM_MEMBER(
   ID NUMBER PRIMARY KEY,
   MEMBER_ID NUMBER,
   TEAM_ID NUMBER,
   CONSTRAINT FK_TEAM_MEMBER_TEAM FOREIGN KEY(TEAM_ID)
      REFERENCES TBL_TEAM(ID),
      CONSTRAINT FK_TEAM_MEMBER_MEMBER FOREIGN KEY(MEMBER_ID)
      REFERENCES TBL_MEMBER(ID)
);


CREATE TABLE TBL_APPLICANT(
   ID NUMBER PRIMARY KEY,
   USER_ID NUMBER,
   TEAMPOST_ID NUMBER,
   INTRODUCE VARCHAR2(255) NOT NULL,
   CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
   UPDATED_DATE DATE NOT NULL,
   CONSTRAINT FK_VOLUNTEER_USER FOREIGN KEY(USER_ID)
   REFERENCES TBL_USER(ID),
   CONSTRAINT FK_VOLUNTEER_TEAM FOREIGN KEY(TEAMPOST_ID)
   REFERENCES TBL_TEAMPOST(POST_ID)
);

CREATE TABLE TBL_MATCHING_TIME(
   ID NUMBER PRIMARY KEY,
   MATCH_TIME VARCHAR2(255) NOT NULL,
   RUN_TIME VARCHAR2(255) NOT NULL
);

CREATE TABLE TBL_MATCHING(
   POST_ID NUMBER PRIMARY KEY,
   MATCHING_STATUS VARCHAR2(255) NOT NULL,
   TIME_ID NUMBER,
   TEAM_ID NUMBER,
   TIME_CORDINATE NUMBER DEFAULT 0 NOT NULL,
   DATE_CORDINATE NUMBER DEFAULT 0 NOT NULL, 
   LOCAL_CITY_ID NUMBER, 
   LOCAL_CITY_DETAIL VARCHAR2(255) NOT NULL,
   CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
   UPDATED_DATE DATE NOT NULL,
   CONSTRAINT FK_MATCHING_POST FOREIGN KEY(POST_ID)
   REFERENCES TBL_POST(ID),
   CONSTRAINT FK_MATCHING_TIME FOREIGN KEY(TIME_ID)
   REFERENCES TBL_MATCHING_TIME(ID),
   CONSTRAINT FK_MATCHING_TEAM FOREIGN KEY(TEAM_ID)
   REFERENCES TBL_TEAM(ID),
   CONSTRAINT FK_MATCHING_LOCAL_CITY FOREIGN KEY(LOCAL_CITY_ID)
   REFERENCES TBL_LOCAL_CITY(ID)
 );

CREATE TABLE TBL_TEAM_MATCHING(
   ID NUMBER PRIMARY KEY,
   TRYTEAM_ID NUMBER,
   MATCHING_ID NUMBER,
   CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
   UPDATED_DATE DATE NOT NULL,
   CONSTRAINT FK_TEAM_MATCHING_MATCHING FOREIGN KEY(MATCHING_ID)
   REFERENCES TBL_MATCHING(POST_ID),
   CONSTRAINT FK_TEAM_MATCHING_TEAM FOREIGN KEY(TRYTEAM_ID)
   REFERENCES TBL_TEAM(ID)
);





