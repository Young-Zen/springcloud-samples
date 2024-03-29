CREATE TABLE `t_stock`
(
    `id`         bigint(11) NOT NULL AUTO_INCREMENT,
    `product_id` bigint(11) DEFAULT NULL COMMENT '产品id',
    `total`      int(11) DEFAULT NULL COMMENT '总库存',
    `used`       int(11) DEFAULT NULL COMMENT '已用库存',
    `residue`    int(11) DEFAULT NULL COMMENT '剩余库存',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_stock` (`product_id`, `total`, `used`, `residue`) VALUES ('1', '100', '0', '100');