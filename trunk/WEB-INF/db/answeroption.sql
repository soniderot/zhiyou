ALTER TABLE zy_answeroption MODIFY COLUMN QUESTIONID INT(10) UNSIGNED NOT NULL;
alter table zy_answeroption add column HOT int(10) default 0;