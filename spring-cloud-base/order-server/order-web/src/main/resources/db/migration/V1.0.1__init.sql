CREATE TABLE IF NOT EXISTS `t_order` (
    `id`         bigint(11) NOT NULL AUTO_INCREMENT,
    `user_id`    bigint(11) DEFAULT NULL COMMENT '用户id',
    `product_id` bigint(11) DEFAULT NULL COMMENT '产品id',
    `count`      int(11) DEFAULT NULL COMMENT '数量',
    `money`      decimal(11, 0) DEFAULT NULL COMMENT '金额',
    `status` int(1) DEFAULT NULL COMMENT '订单状态：0：创建中；1：已完结',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;