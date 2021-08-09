-- 查询当前用户登录IP
SELECT USER() FROM DUAL;

-- 查询当前使用的数据库名称
SELECT DATABASE();

-- 多列查询 和宋江各科成绩相同的同学
SELECT * FROM student WHERE (math,english,chinese) = (
SELECT math,english,chinese
FROM student
WHERE `std_name`='宋江'
);

-- 将带有重复数据的表中的重复数据进行清理后得到没有重复数据的新表
-- 创建临时表
CREATE TEMPORARY TABLE tem_stu LIKE student;

SELECT * FROM tem_stu;
-- 将筛选过后没有重复数据的数据导入临时表
INSERT INTO tem_stu SELECT DISTINCT * FROM student;
-- 清空原来表 student
DELETE FROM student;
-- 再把临时表的数据复制到原来的表
INSERT INTO student SELECT * FROM tem_stu;

SELECT * FROM student;
-- 删除临时表
DROP TABLE tem_stu;