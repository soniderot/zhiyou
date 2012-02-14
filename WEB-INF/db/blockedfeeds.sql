DROP TABLE IF EXISTS `zy`.`zy_blockedfeeds`;
CREATE TABLE  `zy`.`zy_blockedfeeds` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `userid` int(10) unsigned NOT NULL,
  `feedid` int(10) unsigned NOT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `BLOCKEDFEEDS_USERID` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;