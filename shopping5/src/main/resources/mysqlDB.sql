#创建数据库
CREATE DATABASE IF NOT EXISTS test;
#选中刚刚创建的数据库
use test;
#创建users表
CREATE TABLE IF NOT EXISTS users(
	userName VARCHAR(20) PRIMARY KEY,
	password VARCHAR(20),
	gender CHAR(1),
	emailAddr VARCHAR(20)
);
