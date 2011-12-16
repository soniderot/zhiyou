ALTER TABLE zy_profile ADD COLUMN OBJECTGENDER tinyint(4) unsigned default 0 AFTER GENDER;
ALTER TABLE zy_profile ADD COLUMN HOMETOWNID int(10) unsigned default NULL AFTER CITYID;