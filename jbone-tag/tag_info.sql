CREATE TABLE IF NOT EXISTS `jbone_tag`.`tag_info` (
`id` INT NOT NULL auto_increment,
`tag_id` VARCHAR(100) not null,
`name` VARCHAR(100) CHARACTER SET `utf8mb4` not NULL,
`target` int not null,
`status` int not null,
`show` int not null,
`icon` VARCHAR(200) null,
`icon_type` int null,
`click_target` VARCHAR(200) not null,
`time_validity` int not null ,
`start_time` TIMESTAMP null,
`end_time` TIMESTAMP null,
`extend` VARCHAR(2048) null,
`applier` VARCHAR(100) null,
`apply_reason` VARCHAR(200) null,
`add_time` TIMESTAMP null,
`update_time` TIMESTAMP null,
`version`	BIGINT null,
PRIMARY key(`id`),
UNIQUE INDEX `tag_id_unique` (`tag_id` ASC)
)
ENGINE=INNODB