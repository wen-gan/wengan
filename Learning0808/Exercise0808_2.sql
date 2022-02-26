CREATE TABLE dept(
deptno INT NOT NULL,
dname VARCHAR(100) NOT NULL,
loc VARCHAR(100) NOT NULL
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO dept(deptno,dname,loc)
VALUES
(10,'ACCOUNTING','NEW_YORK'),
(20,'RESEARCH','DALLAS'),
(30,'SALES','CHICAGO'),
(40,'OPERATIONS','BOSTON');

SELECT * FROM dept;

SELECT LCASE(SUBSTR(std_name , 1 , 1)) FROM student;

SELECT CURRENT_TIME FROM DUAL;