DROP TABLE IF EXISTS `zy`.`zy_interest`;
CREATE TABLE  `zy`.`zy_interest` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `tag` varchar(32) NOT NULL,
  `userid` int(10) unsigned NOT NULL,
  `flag` smallint(6) default '0',
  `hot` int(10) unsigned default '0',
  `createtime` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `interest_tag` (`tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;