
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID，自增列',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `age` int(11) NOT NULL COMMENT '用户年龄',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态：-1-删除；1-正常；',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint not default 0 comment '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;