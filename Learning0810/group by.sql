SELECT COALESCE(user_hobby, '总数') FROM users GROUP BY user_hobby WITH ROLLUP