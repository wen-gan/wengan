-- 1
SELECT * FROM emp WHERE deptno = 30;

-- 2
SELECT ename,empno,mgr
			FROM emp
			WHERE job = 'CLERK';

-- 3
SELECT * FROM emp WHERE IFNULL(comm,0) > sal;

-- 4
SELECT * FROM emp WHERE IFNULL(comm,0) > (sal * 0.6);

-- 5
SELECT * 
		FROM emp 
		WHERE (deptno=10 AND job='MANAGER') OR (deptno=20 AND job='CLERK');

-- 6
SELECT * 
		FROM emp 
		WHERE (deptno=10 AND job='MANAGER') OR (deptno=20 AND job='CLERK') 
		OR (job!='MANAGER' AND job!='CLERK' AND sal>=2000);

-- 7
SELECT job FROM emp WHERE comm is not NULL;

-- 8
SELECT * FROM emp WHERE comm is not NULL OR comm < 100;

-- 9
SELECT * FROM emp WHERE LAST_DAY(hiredate) - 2;

-- 13
SELECT * FROM emp WHERE ename NOT LIKE '%R%';
-- 14
SELECT left(ename,3) FROM emp;
-- 15
SELECT REPLACE(ename,'A','a') FROM emp;
-- 16
SELECT ename,hiredate FROM emp WHERE DATE_ADD(hiredate,INTERVAL 10 YEAR) <= NOW();
-- 17
SELECT * FROM emp ORDER BY ename;
-- 18
SELECT ename,hiredate FROM emp ORDER BY hiredate;
-- 19
SELECT ename,job,sal FROM emp ORDER BY job , sal DESC;
-- 20
SELECT ename,CONCAT(YEAR(hiredate),'-',MONTH(hiredate)) 
			FROM emp 
			ORDER BY MONTH(hiredate) , YEAR(hiredate) ASC;
-- 21
SELECT ename,FLOOR(sal/30),sal/30 FROM emp;
-- 22
SELECT * FROM emp WHERE MONTH(hiredate) = 2;
-- 23
SELECT ename,DATEDIFF(NOW(), hiredate) FROM emp;
-- 24
SELECT * FROM emp WHERE ename LIKE '%A%';
-- 25
SELECT ename,FLOOR(DATEDIFF(NOW(), hiredate)/365) AS "工作年",
				FLOOR(DATEDIFF(NOW(), hiredate)%31) AS "工作月",
				DATEDIFF(NOW(), hiredate) % 31 AS "工作天数"
			FROM emp;