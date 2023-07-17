CREATE TABLE IF NOT EXISTS `t_person` (
    `pk_person_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(64) DEFAULT NULL,
    `age` tinyint(3) unsigned DEFAULT NULL,
    `birthday` date DEFAULT NULL,
    `account` decimal(16,2) NOT NULL DEFAULT '0.00',
    `is_deleted` tinyint(1) unsigned DEFAULT '0',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`pk_person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;