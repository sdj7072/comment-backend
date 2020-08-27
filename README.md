# command-backend

mysql.server start
mysql
    show databases;
    create database comment;
	
	use mysql;
	select host, user, password from user;
	create user 'comment'@'localhost'identified by '!test1234';
	create all privileges on comment.* to 'comment'@'localhost'
	flush privileges;
	
	use comment;

CREATE TABLE COMMENT (
    COMMENT_ID BIGINT NOT NULL,
    POST_ID VARCHAR(10) NOT NULL,
    MEMBER_ID VARCHAR(50) NOT NULL,
    POST_TYPE CHAR(2),
    COMMENT_CONTENT VARCHAR(2000),
    DISPLAY_YN CHAR(1),
    REGISTER_TIME DATETIME,
    UPDATE_TIME DATETIME
);

ALTER TABLE COMMENT ADD CONSTRAINT COMMENT_ID_PK PRIMARY KEY (COMMENT_ID);

ALTER TABLE COMMENT MODIFY COLUMN COMMENT_ID BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE COMMENT AUTO_INCREMENT = 1;

DESCRIBE COMMENT;

DROP TABLE COMMNET;


java -jar axonserver.jar
