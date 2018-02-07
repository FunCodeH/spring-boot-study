CREATE DATABASE shiro;

CREATE TABLE IF NOT EXISTS user(
  user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(40) NOT NULL ,
  password VARCHAR(40) NOT NULL ,
  isdelete int(1) DEFAULT 0,
  createTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
