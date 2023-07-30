CREATE DATABASE IF NOT EXISTS qiyun_blog CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci';
USE qiyun_blog;

SET NAMES utf8mb4;
-- 取消外键约束
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `qiyun_blog_user`;
DROP TABLE IF EXISTS `qiyun_blog_user_and`;
DROP TABLE IF EXISTS `qiyun_blog_user_token`;
DROP TABLE IF EXISTS `qiyun_blog_article_category`;
DROP TABLE IF EXISTS `qiyun_blog_article`;
DROP TABLE IF EXISTS `qiyun_blog_article_content`;
DROP TABLE IF EXISTS `qiyun_blog_article_comments`;
DROP TABLE IF EXISTS `qiyun_blog_article_comments_content`;

-- 设置外键约束
SET FOREIGN_KEY_CHECKS = 1;

-- 用户表
CREATE TABLE `qiyun_blog_user`(
                                  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                                  `user_username` VARCHAR(50) UNIQUE NOT NULL COMMENT '用户账号',
                                  `user_password` VARCHAR(60) NOT NULL COMMENT '用户密码',
                                  `user_nick_name` VARCHAR(50) NOT NULL COMMENT '用户显示昵称',
                                  `user_email` VARCHAR(80) NOT NULL COMMENT '邮箱',
                                  `user_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `user_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                  `user_locked` TINYINT(4) DEFAULT '1' COMMENT '是否锁定 0未锁定 1已锁定无法登陆',
                                  PRIMARY KEY (`user_id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户表';

-- 用户其他信息表
CREATE TABLE `qiyun_blog_user_and`(
                                      `and_user_id` BIGINT(20) COMMENT '用户id',
                                      `and_user_admin` TINYINT DEFAULT '0' COMMENT '管理权限 0是普通用户',
                                      PRIMARY KEY (`and_user_id`) USING BTREE,
                                      FOREIGN KEY(`and_user_id`) REFERENCES qiyun_blog_user(`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户表其他信息';

-- token表
CREATE TABLE `qiyun_blog_user_token` (
                                         `token_user_id` BIGINT(20) NOT NULL COMMENT '用户主键id',
                                         `token` VARCHAR(200) NOT NULL COMMENT 'token值',
                                         `token_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                         PRIMARY KEY (`token_user_id`),
                                         UNIQUE KEY `uq_token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'token表';

-- 分类表
CREATE TABLE `qiyun_blog_article_category`(
                                              `category_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '分类id',
                                              `category_name` TEXT NOT NULL COMMENT '分类名称(展示名词)',
                                              `category_nickname` TEXT NOT NULL COMMENT '分类别名(英文名)',
                                              PRIMARY KEY (`category_id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '分类表';

-- 文章表
CREATE TABLE `qiyun_blog_article`(
                                     `article_user_id` BIGINT(20) NOT NULL COMMENT '文章用户id',
                                     `article_blog_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '文章id',
                                     `article_blog_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
                                     `article_num` INT DEFAULT '0' COMMENT '评论数 默认0评论',
                                     PRIMARY KEY (`article_blog_id`) USING BTREE,
                                     FOREIGN KEY(`article_user_id`) REFERENCES qiyun_blog_user(`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '文章表';

-- 文章内容表
CREATE TABLE `qiyun_blog_article_content`(
                                             `content_article_blog_id` BIGINT(20) NOT NULL COMMENT '文章id',
                                             `content_article_blog_article_id` BIGINT(20) NOT NULL DEFAULT '1' COMMENT '分类id',
                                             `content_article_blog_name` VARCHAR(200) NOT NULL COMMENT '文章标题',
                                             `content_article_blog_boy` TEXT NOT NULL COMMENT '文章内容html',
                                             `content_article_blog_keyword` TEXT COMMENT '文章关键词 可为空 以逗号分割关键词标签',
                                             `content_article_recommend` TINYINT DEFAULT '0' COMMENT '文章精选 默认0不精选',
                                             PRIMARY KEY (`content_article_blog_id`) USING BTREE,
                                             FOREIGN KEY(`content_article_blog_id`) REFERENCES qiyun_blog_article(`article_user_id`),
                                             FOREIGN KEY(`content_article_blog_article_id`) REFERENCES qiyun_blog_article_category(`category_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '文章内容表';

-- 评论表
CREATE TABLE `qiyun_blog_article_comments`(
                                              `comments_blog_id` BIGINT(20) NOT NULL COMMENT '文章id',
                                              `comments_user_id` BIGINT(20) NOT NULL UNIQUE AUTO_INCREMENT COMMENT '评论id',
                                              `comments_nick_name` VARCHAR(50) NOT NULL COMMENT '用户显示昵称',
                                              `comments_blog_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
                                              FOREIGN KEY(`comments_blog_id`) REFERENCES qiyun_blog_article(`article_user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '评论表';

-- 评论内容表
CREATE TABLE `qiyun_blog_article_comments_content`(
                                                      `content_comments_blog_id` BIGINT(20) UNIQUE NOT NULL COMMENT '评论id',
                                                      `content_comments_blog_boy` TEXT NOT NULL COMMENT '评论内容',
                                                      `content_comments_recommend` TINYINT DEFAULT '0' COMMENT '评论精选 默认0不精选',
                                                      FOREIGN KEY(`content_comments_blog_id`) REFERENCES qiyun_blog_article_comments(`comments_user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '评论内容表';

-- 密码 123456
INSERT INTO `qiyun_blog_user` (`user_id`,`user_username`,`user_password`,`user_nick_name`,`user_email`,`user_date`,`user_update_date`,`user_locked`) VALUES ('1001','shanhe','9d50eb043fde4f56647ecb7d27f71e91','山河开发','demo@qq.com','2023-07-16 00:15:05',DEFAULT,'0');

INSERT INTO `qiyun_blog_user` (`user_username`,`user_password`,`user_nick_name`,`user_email`,`user_date`,`user_update_date`,`user_locked`) VALUES ('test','9d50eb043fde4f56647ecb7d27f71e91','山河测试','demo@126.com','2023-07-16 00:15:05',DEFAULT,'0');

-- 默认分类
INSERT INTO `qiyun_blog_article_category` (`category_id`,`category_name`,`category_nickname`) VALUES (1,'默认分类','default category');

-- 默认用户权限
INSERT INTO `qiyun_blog_user_and` (`and_user_id`,`and_user_admin`) VALUES ('1001',1);
INSERT INTO `qiyun_blog_user_and` (`and_user_id`,`and_user_admin`) VALUES ('1002',DEFAULT);




