
CREATE TABLE `approve_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id，主键',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除,0否1是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `record_name` varchar(200) not null default '' comment '单据名称',
  `approve_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '审核人id',
  `approve_time` datetime not null comment '审核时间',
  PRIMARY KEY (`id`),
  KEY `idx_createTime` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='审核记录';

