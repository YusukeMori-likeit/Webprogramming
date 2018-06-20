CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `login_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `birth_date` date NOT NULL,
  `password` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `login_id` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8

insert 
into user ( 
  login_id,
  name, 
  birth_date
  , password
  , create_date
  , update_date
) 
values ( 
  'admin'
  , 'ä«óùé“'
  , '2018-6-20'
  , 'admin'
  , '2018-6-20 12:00:00'
  , '2018-6-20 12:00:01'
) 


