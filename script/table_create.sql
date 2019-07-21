CREATE TABLE `activate_info` (
  `activate_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `title` varchar(100) NOT NULL COMMENT '活动标题',
  `act_time` datetime NOT NULL COMMENT '活动时间',
  `end_time` datetime NOT NULL COMMENT '报名截止时间',
  `act_creator` varchar(20) NOT NULL COMMENT '活动发起人',
  `content` varchar(300) NOT NULL COMMENT '活动内容',
  `participate_num` int(11) NOT NULL DEFAULT '0' COMMENT '参加人数',
  `cost` double NOT NULL COMMENT '活动费用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`activate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `activate_personnel_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activate_id` int(11) NOT NULL COMMENT '活动id',
  `user_id` int(11) NOT NULL COMMENT '参与活动人id',
  `user_name` varchar(20) NOT NULL COMMENT '参与人名称',
  `is_drive` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否开车',
  `is_family` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否携带家属',
  `is_manned` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否可以载人',
  `is_participate` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否参加活动',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `activate_review_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activate_id` int(11) NOT NULL COMMENT '活动id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `user_name` varchar(20) NOT NULL COMMENT '用户名称',
  `comment` text NOT NULL COMMENT '用户评论',
  `create_time` datetime NOT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authentication_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `certified_user_id` int(11) NOT NULL COMMENT '被认证人id',
  `authenticator_id` int(11) NOT NULL COMMENT '认证人id',
  `certifie_time` datetime NOT NULL COMMENT '认证时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `company_authenticate` (
  `id` int(11) NOT NULL COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `company_name` varchar(200) NOT NULL COMMENT '企业名称',
  `industry` varchar(200) NOT NULL COMMENT '所属行业',
  `logo` varchar(200) NOT NULL,
  `brief_introduction` text NOT NULL COMMENT '企业简介',
  `other_info` text COMMENT '其他自由发挥字段',
  `auth_status` tinyint(4) NOT NULL COMMENT '认证状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `operation_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `operation_time` datetime NOT NULL COMMENT '操作时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `action` varchar(50) NOT NULL COMMENT '动作行为',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pro_jurisdiction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `jurisdiction_name` varchar(50) NOT NULL COMMENT '权限名称',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目权限';

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `college` varchar(50) NOT NULL COMMENT '学院名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `curr_location` varchar(100) NOT NULL COMMENT '当前所在地',
  `entrance_time` datetime NOT NULL COMMENT '入学时间',
  `graduation_time` datetime NOT NULL COMMENT '毕业时间',
  `hobby` varchar(200) DEFAULT NULL COMMENT '兴趣爱好',
  `industry_skill` varchar(200) DEFAULT NULL COMMENT '行业技能',
  `major` varchar(50) NOT NULL COMMENT '专业名称',
  `open_id` varchar(100) NOT NULL COMMENT 'open id',
  `personal_profile` text COMMENT '个人说明',
  `phone_num` bigint(11) unsigned NOT NULL COMMENT '手机号',
  `real_name` varchar(50) NOT NULL COMMENT '真实姓名',
  `score` double NOT NULL COMMENT '用户积分',
  `sex` tinyint(1) NOT NULL COMMENT '性别',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `user_status` tinyint(1) NOT NULL COMMENT '用户状态',
  `wechat_image` varchar(200) NOT NULL COMMENT '微信头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';

CREATE TABLE `user_right` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_user_id` int(11) NOT NULL COMMENT '审核人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `jur_status` tinyint(1) NOT NULL COMMENT '权限状态',
  `jurisdiction_id` int(11) NOT NULL COMMENT '权限id',
  `jurisdiction_name` varchar(50) NOT NULL COMMENT '权限名称',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限';