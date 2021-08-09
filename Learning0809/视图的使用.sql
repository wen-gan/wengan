-- 查看所有的存储引擎
SHOW ENGINES;

-- 视图的使用
-- 创建视图
CREATE VIEW users_view01 AS SELECT user_age,user_hobby,user_id,user_name FROM users;

-- 查看视图
DESC users_view01;

SELECT * FROM users_view01;

-- 查看创建视图的指令
SHOW CREATE VIEW users_view01;
-- 删除视图
DROP users_view01;

-- 修改视图
UPDATE users_view01 SET user_name = 'mikes' WHERE user_id = 1;