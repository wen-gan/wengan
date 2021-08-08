CREATE TABLE `student`(
std_id INT NOT NULL AUTO_INCREMENT,
std_name VARCHAR(100) NOT NULL,
chinese FLOAT NOT NULL DEFAULT 0.0,
english FLOAT NOT NULL DEFAULT 0.0,
math FLOAT NOT NULL DEFAULT 0.0,
PRIMARY KEY (`std_id`)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO student(std_name,chinese,english,math)
VALUES
('张飞',67,98,56),
('宋江',87,78,77),
('关羽',88,98,90),
('赵云',82,84,67),
('欧阳',55,85,45),
('黄蓉',75,65,30);

SELECT std_name,english from student;

-- 过滤重复数据
SELECT DISTINCT english FROM student;

-- 统计学生的总分
SELECT std_name,(chinese+english+math) as '总分' FROM student;

SELECT * FROM student WHERE std_name = '赵云';

SELECT * FROM student WHERE english > 90;

SELECT * FROM student WHERE (chinese+english+math)>200;

-- 查询math 大于60且id大于4的学生成绩
SELECT * FROM student WHERE math>60 AND std_id >4;
-- 查询英语成绩大于语文成绩的同学
SELECT * FROM student WHERE english>chinese;
-- 查询总分大于200且数学成绩小于语文成绩的学生
SELECT * FROM student WHERE (chinese+english+math)>200 and math<chinese;

SELECT * FROM student WHERE english>80 AND english <90;
-- 按照数学成绩降序排列
SELECT * FROM student ORDER BY math DESC;

-- 统计数学成绩大于90 的学生数量
SELECT COUNT(*) from student;

-- 统计 总分大于250的人数有多少
SELECT COUNT(*) FROM student WHERE (math+english+math) > 250;

-- 统计数学总成绩
SELECT SUM(math) FROM student;

SELECT SUM(math),SUM(english),SUM(chinese) FROM student;

SELECT SUM(math+chinese+english) FROM student;
-- 统计数学平均分
SELECT SUM(math)/6 FROM student;
SELECT AVG(math) from student;

-- 最大值
SELECT MAX(math+chinese+english) ,MIN(math+chinese+english) FROM student;