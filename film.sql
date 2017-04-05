/*
Navicat MySQL Data Transfer

Source Server         : tps
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : film

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-04-02 10:11:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `area`
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `Aid` int(11) NOT NULL AUTO_INCREMENT,
  `Azone` varchar(24) NOT NULL,
  PRIMARY KEY (`Aid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('1', '大陆');
INSERT INTO `area` VALUES ('2', '港台');
INSERT INTO `area` VALUES ('3', '欧美');
INSERT INTO `area` VALUES ('4', '日韩');

-- ----------------------------
-- Table structure for `film`
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `FID` int(11) NOT NULL AUTO_INCREMENT,
  `FSortID` int(11) DEFAULT NULL,
  `FAid` int(11) DEFAULT NULL,
  `FFilmName` varchar(48) NOT NULL,
  `FDiretor` varchar(24) NOT NULL,
  `FPlay` varchar(128) NOT NULL,
  `FIntro` varchar(500) NOT NULL,
  `FLanguage` varchar(20) NOT NULL,
  `FLong` int(11) NOT NULL,
  `FDate` varchar(20) NOT NULL,
  `FType` varchar(2) NOT NULL,
  `FPhoto` varchar(128) DEFAULT NULL,
  `FVideo` varchar(128) DEFAULT NULL,
  `FPrice` double DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES ('5', '1', '1', '暮光之城：破晓（上）', '比尔．康顿', '克里斯汀．斯图尔特 罗伯特．帕丁森 泰勒．洛特纳', '贝拉和爱德华终于要结婚了！这是贝拉有生以来最幸福的一刻，见证婚礼的宾客也都期待着这一暮而情绪高涨。两人飞到巴西的艾思蜜岛上渡蜜月。不久贝拉发现她竟然怀孕了。于是，看似有情人终成眷属的梦幻情节下，一场即将撼动吸血鬼、狼人和人类世界的暗涛汹涌对决，正悄悄来袭……贝拉怀了人类和吸血鬼的混血胎儿，竟以异常的速度在她体内成形，令贝拉吃足苦头，甚至危及她的健康。爱德华怕胎儿夺去贝拉性命，希望她能放弃孩子，但贝 拉却甘为生下孩子而冒生命危险。另一厢的狼族获悉后，担心胎儿将来会对族人构成威胁，决定千方百计除掉它，即使连带杀了贝拉也在所不惜。雅各布为了保护心爱的贝拉，决定离开狼族，连夜奔向库伦家警告这场狼族的猎杀行动。贝拉即将分娩，腹中勐烈成长的胎儿令她断掉肋骨并大量失血，在她命悬一线之际，爱德华为了救她只有一个办法…他把装有自己吸血毒液的针管插进贝拉心脏，贝拉陷进蜕变的痛苦中，到底，她会变成吸血鬼吗？　　', '国语', '118', '2017-03-23', '2D', '/upload/images/7dce26e3-6240-4d2e-9d58-7ed97bd45583.jpg', '/assert/video/ftcs.mp4', '100');
INSERT INTO `film` VALUES ('6', '8', '3', '谍影重重4', '托尼．吉尔罗伊', '亚伦．艾克哈特 黎安娜．里伯拉托 欧嘉．柯瑞兰', '继杰森．伯恩后，另一美国中情局特工艾伦．克劳斯Aaron Cross（杰瑞米．雷纳饰）亦将身陷险境。因为“杰森．伯恩事件”，令中情局的特工行动“绊脚石Treadstone”被公开，为了隐瞒其它特工行动，以拜亚ret. Colonel Eric Byer（爱德华．诺顿 饰）为首的美国中情局，正计划铲除过去数十年来发展的特工行动，包括“结果Outcome”行动当中，体能和智能更“先进”的“5号”特工艾 伦．克劳斯，展开横跨全球的逃杀。而艾伦．克劳斯剩下的唯一希望，竟然就是过去四年来，不断在背后监控和研究其活动的科学研究员玛泰博士Dr. Marta Shearing（蕾切尔．薇姿饰）……', '外语', '135', '2012-10-16', '2D', '/assert/images/6.jpg', null, null);
INSERT INTO `film` VALUES ('8', '2', '1', '一九四二', '冯小刚', '张国立 张涵予 徐帆', '一九四二年，因为一场旱灾，我的故乡河南，发生了吃的问题。与此同时，世界上还发生着这样一些事：斯大林格勒战役、甘地绝食、宋美龄访美和丘吉尔感冒。老东家叫范殿元。大灾之年，战争逼近，他赶着马车，马车上拉着粮食，粮食上坐着他一家人，也加入往陕西逃荒的人流。三个月后，到了潼关，车没了，马没了，车上的人也没了。这时老东家特别纠结，他带一家人出来逃荒是为了让人活，为什么到了陕西，人全没了？于是他决定不逃荒了， 开始逆着逃荒的人流往回走。人流中喊：“大哥，怎么往回走哇？往回走就是个死。”老东家：“没想活着，就想死得离家近些。” 转过山坡，碰到一个同样失去亲人的小姑娘，正爬在死去的爹的身上哭。老东家上去劝小姑娘：“妮儿，别哭了，身子都凉了。”小姑娘说，她并不是哭她爹死，而是她认识的人都死了，剩下的人她都不认识了。一句话让老东家百感交集，老东家：“妮儿，叫我一声爷，咱爷俩就算认识了。”小姑娘仰起脸，喊了一声“爷”。老东家拉起小姑娘的手，往山坡下走去。漫山遍野，开满了桃花。十五年后，这个小姑娘成了俺娘。', '国语', '120', '2012-12-31', '2D', '/assert/images/8.jpg', null, null);
INSERT INTO `film` VALUES ('9', '9', '2', '寒战', '陆剑青 梁乐民', '郭富城 梁家辉 刘德华', '午夜的警队，报案中心接到匿名电话，一辆前线冲锋车被胁持。车内五位警员及武器装备成为贼人谈判筹码。事件惊动警队，冲锋车内其中被劫持的警员，竟为现任行动副处长李文彬独子（彭于晏 饰）！适逢警队一哥外访未返，下任处长选举的两大热门：鹰派人物李文彬（梁家辉 饰）与年轻的警长刘杰辉（郭富城 饰）都开始大施拳脚。李立即指挥营救，并将此次行动代号为（寒战）。可贼人竟对警队内部一切了如指掌、洞悉先机，警队精英尽出 ，行动依然无功而返，处处受制，众同袍均开始怀疑他的决策，推举刘杰辉接手整个行动，危急时刻，二虎相争，刘杰辉毫不示弱，不同与李的激进手法，他选择主动与贼人沟通，并答应交予贼人赎金。整个交收赎金过程中，刘设法令赎金留下线索，以便追查贼人位置。可道高一尺，魔高一丈，刘非但找不着贼人踪迹，还将巨额赎金失却，跟刘出生入死的同袍徐永基（钱嘉乐 饰）更在交收赎金过程中殉职，刘内疚不已。事件不但惊动了政府内部，也惊动了廉政公署，因为廉署收到匿名人士举报，怀疑两位副处长，其中一人在此危急关头以权谋私……香港的安全瞬时沦陷，警队及香港的管治漏洞被抖出，威胁直逼警队内部，矛头直指警队高层。', '国语', '120', '2012-12-28', '2D', '/assert/images/9.jpg', null, null);
INSERT INTO `film` VALUES ('10', '1', '3', '全面回忆', '伦．怀斯曼', '柯林．法瑞尔 凯特．贝金赛尔 杰西卡．贝尔', '主人公道格拉斯．奎德（柯林．法瑞尔 Colin Farrell 饰）是一名普通的工厂工人，不普通在于他拥有一位漂亮的妻子（凯特．贝金赛尔 Kate Beckinsale 饰），两人看似十分恩爱。但道格拉斯内心却似乎有某种不满足，在夜晚时常怪梦连连，梦见自己身处火星，而在工作中也总是恍惚走神。在朋友的劝说下，他决定自己该度个假，于是来到了Rekall公司，希望植入火星间谍的记忆以满足自己的大脑对于冒 险的渴望。可是就在植入记忆的过程中，意想不到的事情发生了。奎德突然成了“政府”追杀的逃犯，而他发现自己竟然有着过人的身手。逃离Rekall之后，奎德遇到了一名叛军的女战士（杰西卡．贝尔 Jessica Biel 饰），两人并肩作战但彼此却并不信任。就连奎德深爱的妻子Lori，现在也变成了追杀他的超级女特工。究竟什么是真实，什么是虚幻，哪些是梦境，哪些才是真实发生过的记忆，这一切让奎德根本无法分辨，他必须寻找到自己真实的身份、爱人和命运。', '外语', '118', '2012-10-20', '2D', '/assert/images/10.jpg', null, null);
INSERT INTO `film` VALUES ('11', '5', '3', '大海啸之鲨口逃生', '金波．兰道', '沙维尔．塞缪尔 沙妮．文森 菲比．托金', '宁静的澳洲海滩上，宿醉的救生员乔许让女友蒂娜的哥哥罗利替他去海上例行检查防鲨网的设置，结果罗利遭到了鲨鱼的袭击，罗利的死对乔许和蒂娜造成了很大的心理阴影，乔许为此对女友充满了歉疚，乔许为此放弃了救生员的工作去超市做了理货员，蒂娜也远赴中国学习舞蹈。一年后，当蒂娜重新返回澳洲后，和乔许在超市不期而遇，与此同时，超市里风起云涌，偷窃、抢劫……就在这起突发事件白炽化的时候，地动天摇，海啸铺天盖地而来，超 市立刻沦为孤岛，大鲨鱼随之而来，一场人鲨大战瞬间展开……', '外语', '93', '2012-10-12', '3D', '/assert/images/11.jpg', null, null);
INSERT INTO `film` VALUES ('12', '5', '3', '普罗旺斯惊魂记', '朱利安．拉孔布 帕斯卡尔．西德', '蕾蒂莎．科斯塔 蒂埃里．钮维 罗杰．杜马斯', '1922的法国，没有战争的侵扰，显得静谧而美好。苏珊娜，一个年轻、著名的小说家因为缺少灵感而异常苦恼。为了寻找到自己心中的“缪斯”，她跑到了祥和的乡下，咬把自己孤立起来。在这里，她住在一栋巨大的房子里，准备静心写自己的小说。这栋房子大而诡秘，到处都是形形色色的房间。在打开了一个被封起来的房间之后，苏珊娜把自己的“创作基地”放在了这里。说来奇怪，本来文思枯竭的苏珊娜只要一坐在这个房间的桌子前便会文如 泉涌。伴着打字机噼里啪啦的声响，苏珊娜的小说进展得很顺利，可是小说写得越好，苏珊娜的精神状况就越差。她开始不断地出现幻听和幻视。而且在午夜时分，她还会做噩梦。似乎那本正在被顺利创作的小说已经成为了她的梦魇。事情不止于此，村庄里接连失踪了几个小女孩，村民开始恐慌，而发生在苏珊娜和她周围的怪事也越来越多。', '外语', '87', '2012-10-30', '3D', '/assert/images/12.jpg', null, null);
INSERT INTO `film` VALUES ('13', '7', '3', '无敌破坏王', '里奇．摩尔', '约翰．C．赖利 萨拉．丝沃曼 简．林奇', '主角破坏王拉尔夫是80年代早期电玩中的人物，他的角色设定是个坏蛋，却梦想和同款游戏中的好人“菲力（Fix-It Felix）”一样受到大众的喜爱，于是他潜入现代电玩游戏，在这里他看能让自己成为英雄的机会，一心想要证明自己可以当个好人，因而展开一场大冒险。', '外语', '100', '2012-12-27', '3D', '/assert/images/13.jpg', null, null);
INSERT INTO `film` VALUES ('14', '6', '1', '2012世界末日', '罗兰．艾默里奇', '约翰．库萨克 桑迪．牛顿 阿曼达．皮特', '太阳活动异常，地球内部的能量平衡系统面临崩溃，玛雅人的预言即将实现，人类将遭遇灭顶之灾。各国政府已经联手开始秘密制造方舟，希望能躲过这一浩劫。以写科幻小说谋生的杰克逊（约翰．库萨克 饰）在带孩子们到黄石公园渡周末时发生一连串怪事，而且遇到了神经兮兮的查理（伍迪．哈里森 饰)，查理告诉他世界末日即将来临。伴随着火山爆发，强烈地震以及海啸，杰克逊带领自己的家人驾驶一架临时租来的飞机冲出被死神阴霾瞬间笼 罩的城市上空，开始寻找查理口中各国政府正在联合秘密制造的方舟。在生死攸关的时刻，一些伟大的鬼魂将脱颖而出，而一些自私的心灵将无所遁形，当千千万万个生灵通过各种方法来到方舟制造基地之时，方舟有限的容纳数量引发前所未有的恐慌。最终，仅存的人们用互爱和对生命的尊重渡过了难关。', '外语', '158', '2012-12-28', '3D', '/assert/images/14.jpg', null, null);
INSERT INTO `film` VALUES ('15', '1', '1', '横山号', '周伟', '萨日娜 吴健 徐囡楠', '影片讲述石国梁（杜雨露饰）为解决边远地区群众看病难的问题，身先士卒，坚定地投身于“流动医院”的事业当中。斯日（徐囡楠饰）大学毕业后，热切地回到生养她的内蒙古大草原，希望成为牧民的贴心医生和健康使者。然而，在医疗实践中，她发现自己无法面对病人。在母亲萨日娜（萨日娜饰）的鼓励下，徘徊在人生的十字路口的她选择加入“流动医院”，追随石国梁救死扶伤。医疗车行走在茫茫的内蒙大草原上，一路艰辛坎坷，但终没能阻挡 他们积极救助当地牧民的步伐，斯日也在一次次救助中真正成长起来。一场突如其来的鼠疫让石国梁的儿子石蒙生（吴健饰）看清自己内心深处对父亲、对女友斯日的爱，他毅然放弃出国的机会，加入了流动医院，成为大草原上又一名白衣天使。', '国语', '90', '2012-12-17', '2D', '/assert/images/15.jpg', null, null);

-- ----------------------------
-- Table structure for `filmcomment`
-- ----------------------------
DROP TABLE IF EXISTS `filmcomment`;
CREATE TABLE `filmcomment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `cfid` int(11) NOT NULL,
  `ctime` datetime NOT NULL,
  `comments` varchar(512) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filmcomment
-- ----------------------------
INSERT INTO `filmcomment` VALUES ('2', '2', '5', '2017-03-28 17:11:54', '123');
INSERT INTO `filmcomment` VALUES ('3', '2', '5', '2017-03-28 17:16:40', 'adgd gd ');
INSERT INTO `filmcomment` VALUES ('4', '4', '5', '2017-03-28 17:16:48', '这部电影不错！');
INSERT INTO `filmcomment` VALUES ('5', '4', '5', '2017-03-29 11:46:29', '123');
INSERT INTO `filmcomment` VALUES ('6', '4', '5', '2017-03-29 11:46:59', '123456');

-- ----------------------------
-- Table structure for `hall`
-- ----------------------------
DROP TABLE IF EXISTS `hall`;
CREATE TABLE `hall` (
  `Hid` int(11) NOT NULL AUTO_INCREMENT,
  `HHall` varchar(24) NOT NULL,
  `HNum` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Hid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hall
-- ----------------------------
INSERT INTO `hall` VALUES ('1', '1号大厅', '260');
INSERT INTO `hall` VALUES ('2', '2号大厅', '260');
INSERT INTO `hall` VALUES ('3', '3号大厅', '260');
INSERT INTO `hall` VALUES ('4', '4号大厅', '260');

-- ----------------------------
-- Table structure for `order_seat`
-- ----------------------------
DROP TABLE IF EXISTS `order_seat`;
CREATE TABLE `order_seat` (
  `osid` int(11) NOT NULL AUTO_INCREMENT,
  `Seid` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  `status` varchar(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`osid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_seat
-- ----------------------------
INSERT INTO `order_seat` VALUES ('1', '1', '1', '0');
INSERT INTO `order_seat` VALUES ('2', '2', '1', '0');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `Oid` int(11) NOT NULL AUTO_INCREMENT,
  `OUid` int(11) DEFAULT NULL,
  `Odate` datetime NOT NULL,
  `OState` varchar(48) NOT NULL,
  `OTid` int(11) DEFAULT NULL,
  `OPrice` double DEFAULT NULL,
  `seat_count` int(11) DEFAULT NULL,
  `ticket_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Oid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '4', '2017-03-14 16:20:41', '1', '1', '12', '2', '123');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `display_name` varchar(32) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `access_level` int(8) NOT NULL DEFAULT '1',
  PRIMARY KEY (`roleid`),
  UNIQUE KEY `role_name_pk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_USER', '个人用户', null, '1');
INSERT INTO `role` VALUES ('2', 'ROLE_ANONYMOUS', '游客', null, '0');
INSERT INTO `role` VALUES ('3', 'ROLE_ADMIN_GENERAL', '系统管理员', null, '4096');
INSERT INTO `role` VALUES ('4', 'ROLE_DEVELOPER', '开发人员', null, '16384');
INSERT INTO `role` VALUES ('5', 'ROLE_SUPERVISOR', '超级管理员', null, '32768');

-- ----------------------------
-- Table structure for `seat`
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `Seid` int(11) NOT NULL AUTO_INCREMENT,
  `SeHallID` int(11) DEFAULT NULL,
  `Serow` varchar(5) NOT NULL,
  `Senum` varchar(5) NOT NULL,
  PRIMARY KEY (`Seid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES ('1', '1', '1', '1');
INSERT INTO `seat` VALUES ('2', '1', '1', '2');

-- ----------------------------
-- Table structure for `sort`
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `Sid` int(11) NOT NULL AUTO_INCREMENT,
  `SSort` varchar(24) NOT NULL,
  PRIMARY KEY (`Sid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES ('1', '动作片');
INSERT INTO `sort` VALUES ('2', '剧情片');
INSERT INTO `sort` VALUES ('3', '喜剧片');
INSERT INTO `sort` VALUES ('4', '爱情片');
INSERT INTO `sort` VALUES ('5', '惊悚片');
INSERT INTO `sort` VALUES ('6', '科幻片');
INSERT INTO `sort` VALUES ('7', '动画片');
INSERT INTO `sort` VALUES ('8', '悬疑片');
INSERT INTO `sort` VALUES ('9', '犯罪片');
INSERT INTO `sort` VALUES ('10', '冒险片');
INSERT INTO `sort` VALUES ('11', '记录片');
INSERT INTO `sort` VALUES ('12', '战争片');
INSERT INTO `sort` VALUES ('13', '恐怖片');

-- ----------------------------
-- Table structure for `timetable`
-- ----------------------------
DROP TABLE IF EXISTS `timetable`;
CREATE TABLE `timetable` (
  `Tid` int(11) NOT NULL AUTO_INCREMENT,
  `TFid` int(11) DEFAULT NULL,
  `THallID` int(11) DEFAULT NULL,
  `TDate` date NOT NULL,
  `TTime` time NOT NULL,
  PRIMARY KEY (`Tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of timetable
-- ----------------------------
INSERT INTO `timetable` VALUES ('1', '5', '1', '2017-03-31', '14:00:00');
INSERT INTO `timetable` VALUES ('2', '5', '2', '2017-03-31', '14:00:00');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `URealName` varchar(128) DEFAULT NULL,
  `USex` varchar(4) DEFAULT NULL,
  `UPhone` varchar(14) DEFAULT NULL,
  `UEmail` varchar(64) DEFAULT NULL,
  `Uqq` varchar(14) DEFAULT NULL,
  `UBirth` varchar(10) DEFAULT NULL,
  `roleid` int(11) NOT NULL,
  `UIDCard` varchar(18) DEFAULT NULL,
  `UPhoto` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('2', 'a', '4297f44b13955235245b2497399d7a93', null, null, '13131313131', '766167161@qq.com', null, null, '5', null, '/assert/image/material/user_avatar.png');
INSERT INTO `users` VALUES ('4', 'x', '4297f44b13955235245b2497399d7a93', '21', '女', '13113123124', '764996686@qq.com', '123123', '2016-02-10', '5', '2123123', '/assert/image/material/user_avatar.png');
