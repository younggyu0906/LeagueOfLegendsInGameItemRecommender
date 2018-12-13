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
  UNIQUE KEY `id_UNIQUE` (`id`))
ENGINE=InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT='riot league of legends champion information';

LOCK TABLES `champions` WRITE;
UNLOCK TABLES;

CREATE TABLE `leagueoflegends`.`items` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `health` INT NULL,
  `mana` INT NULL,
  `armor` INT NULL,
  `spellBlock` INT NULL,
  `attackSpeed` DOUBLE NULL,
  `physicalDamage` INT NULL,
  `critChance` DOUBLE NULL,
  `magicDamage` INT NULL,
  `finished` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'riot league of legends item information';

LOCK TABLES `items` WRITE;
UNLOCK TABLES;

CREATE TABLE `leagueoflegends`.`finishedmatch` (
  `id` BIGINT NOT NULL,
  `championId` INT NULL,
  `item0Id` INT NULL,
  `item1Id` INT NULL,
  `item2Id` INT NULL,
  `item3Id` INT NULL,
  `item4Id` INT NULL,
  `item5Id` INT NULL,
  `item6Id` INT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`championId`) REFERENCES `champions`(`id`),
  FOREIGN KEY (`item0Id`) REFERENCES `items`(`id`),
  FOREIGN KEY (`item1Id`) REFERENCES `items`(`id`),
  FOREIGN KEY (`item2Id`) REFERENCES `items`(`id`),
  FOREIGN KEY (`item3Id`) REFERENCES `items`(`id`),
  FOREIGN KEY (`item4Id`) REFERENCES `items`(`id`),
  FOREIGN KEY (`item5Id`) REFERENCES `items`(`id`),
  FOREIGN KEY (`item6Id`) REFERENCES `items`(`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'riot league of legends finished match information';

LOCK TABLES `finishedmatch` WRITE;
UNLOCK TABLES;


-- 테이블 초기화 후  아이템에 0넣어놓는 것
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `finishedmatch`;
TRUNCATE `champions`;
TRUNCATE `items`;
SET FOREIGN_KEY_CHECKS = 1;

insert into items (ID, NAME, HEALTH, MANA, ARMOR, SPELLBLOCK, ATTACKSPEED, PHYSICALDAMAGE, CRITCHANCE, MAGICDAMAGE, FINISHED)
 VALUES (0, "None", 0, 0, 0, 0, 0, 0, 0, 0, 0);
