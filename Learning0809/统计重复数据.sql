SELECT COUNT(*) as repetitions, user_hobby
FROM users
GROUP BY user_hobby
HAVING repetitions > 1;