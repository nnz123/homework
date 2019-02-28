ALTER TABLE person MODIFY card_type INT(2) DEFAULT 0 comment '员工证件类型0身份证1护照';
ALTER TABLE person MODIFY person_status INT(2) default 0 comment '0在职，1 离职' ;