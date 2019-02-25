CREATE TABLE person(
id INT NOT NULL AUTO_INCREMENT,
person_name VARCHAR(20) NOT NULL comment '员工姓名',
card_type enum('0','1') default '0' comment '员工证件类型0身份证1护照',
card_num VARCHAR(11) NOT NULL comment '证件号码',
person_picture varchar(200) comment '员工头像',
phone_num VARCHAR(15) comment '员工电话',
person_status enum('0','1') default '0' comment '0在职，1 离职', 
create_person VARCHAR(20) comment '员工信息创建人',
create_time DATETIME comment '员工信息创建时间',
edit_person VARCHAR(20) comment '员工信息修改人',
edit_time DATETIME comment '员工信息修改时间',
delete_person VARCHAR(20) comment '员工信息删除人',
delete_time DATETIME comment '员工信息删除时间',
delete_flag BOOLEAN comment '删除标记',
PRIMARY KEY (id)
)