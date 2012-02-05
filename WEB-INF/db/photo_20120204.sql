alter table zy_photo add column bigfilename VARCHAR(150) DEFAULT NULL AFTER deleted;
alter table zy_photo add column width INTEGER DEFAULT NULL AFTER bigfilename;
alter table zy_photo add column height INTEGER DEFAULT NULL AFTER width;