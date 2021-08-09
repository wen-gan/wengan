CREATE TABLE tbl02(
id INT,
`name` VARCHAR(32)
);

-- 开启事务
START TRANSACTION
-- 设置保存点
SAVEPOINT a
-- 执行dml操作
INSERT into tbl02 VALUES(100,'tom');

SELECT * FROM tbl02;

SAVEPOINT b;

-- 执行dml操作
INSERT into tbl02 VALUES(200,'jack');

-- 回退到 b 保存点
ROLLBACK TO b;

-- 只写一个rollback就会直接回到原始状态