CREATE DATABASE mybatis;

CREATE TABLE t_user(
  user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(40) NOT NULL ,
  password VARCHAR(40) NOT NULL ,
  mobile VARCHAR(20) NOT NULL,
  email VARCHAR(20)
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;