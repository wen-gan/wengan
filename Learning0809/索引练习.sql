CREATE TABLE tbl_01 (
id INT NOT NULL,
order_name VARCHAR(100) NOT NULL,
order_pel VARCHAR(100) NOT NULL,
order_num INT NOT NULL
);

INSERT INTO tbl_01
VALUES
(1,'薯片','jack','100'),
(2,'汽水','tom','50'),
(3,'辣条','smith','60');

-- 添加主键索引
ALTER TABLE tbl_01 ADD PRIMARY KEY (id);

SHOW INDEX FROM tbl_01;

CREATE UNIQUE INDEX id_index on tbl_01 (id);

-- 删除索引
DROP INDEX id_index on tbl_01;
