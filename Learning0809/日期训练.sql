CREATE TABLE news(
id INT NOT NULL,
content VARCHAR(100) NOT NULL,
send_time DATETIME
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO news(id,content,send_time)
VALUES
(1,'红星新闻',CURRENT_TIMESTAMP()),
(2,'四川新闻',NOW()),
(3,'北京新闻',NOW()),
(4,'澎湃新闻',NOW());

-- 显示所有新闻信息，发布日期只显示日期 不显式时间
SELECT id,content,DATE(send_time) FROM news;

-- 查询10分钟以内发布的新闻
SELECT * FROM news WHERE DATE_ADD(send_time,INTERVAL 10 MINUTE) >= NOW();

-- 求出2011-11-11 和 1990-01-01 差多少天
SELECT DATEDIFF('2021-08-06','1999-03-04') FROM DUAL;

