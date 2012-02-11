ALTER TABLE zy_newsfeed add column atuserid INTEGER AFTER REFERENCEID;
ALTER TABLE zy_newsfeed add column atread CHAR(1) AFTER atuserid;