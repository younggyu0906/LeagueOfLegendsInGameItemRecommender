CREATE DATABASE  IF NOT EXISTS `leagueOfLegends`;
USE `leagueOfLegends`;

DROP TABLE IF EXISTS `champions`;

CREATE TABLE `champions` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `attack` int(11) DEFAULT NULL,
  `magic` int(11) DEFAULT NULL,
  `defense` int(11) DEFAULT NULL,
  `difficulty` int(11) DEFAULT NULL,
  `assassin` tinyint(4) DEFAULT NULL,
  `fighter` tinyint(4) DEFAULT NULL,
  `mage` tinyint(4) DEFAULT NULL,
  `support` tinyint(4) DEFAULT NULL,
  `tank` tinyint(4) DEFAULT NULL,
  `marksman` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='riot league of legends champion information'

LOCK TABLES `champions` WRITE;
UNLOCK TABLES;