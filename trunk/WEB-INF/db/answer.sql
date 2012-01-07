ALTER TABLE zy_answer MODIFY COLUMN ANSWER VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci;
alter table zy_answer add column USERID INT(10) UNSIGNED AFTER OPTIONANSWER;
alter table zy_answer add column CREATETIME datetime default null;