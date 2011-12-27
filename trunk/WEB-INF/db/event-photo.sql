DROP TABLE IF EXISTS `zy`.`zy_album`;
CREATE TABLE  `zy`.`zy_album` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `albumname` varchar(45) NOT NULL,
  `createtime` datetime NOT NULL,
  `userid` int(10) unsigned NOT NULL,
  `logo` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `zy`.`zy_event`;
CREATE TABLE  `zy`.`zy_event` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EVENTNAME` varchar(150) NOT NULL,
  `BEGINTIME` datetime NOT NULL,
  `ENDTIME` datetime NOT NULL,
  `ADDRESS` varchar(150) NOT NULL,
  `CITYID` int(10) unsigned NOT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` int(10) unsigned NOT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `DETAIL` varchar(150) DEFAULT NULL,
  `LOGO` varchar(150) DEFAULT NULL,
  `DISTRICTID` int(10) unsigned DEFAULT NULL,
  `SUBCATEGORYID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `zy`.`zy_photo`;
CREATE TABLE  `zy`.`zy_photo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `albumno` int(10) unsigned NOT NULL DEFAULT '0',
  `createtime` datetime NOT NULL,
  `filename` varchar(150) NOT NULL,
  `summary` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;