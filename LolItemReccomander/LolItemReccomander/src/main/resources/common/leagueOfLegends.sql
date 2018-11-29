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
  `id` INT NOT NULL AUTO_INCREMENT,
  `championId` INT NULL,
  `itemId` INT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`championId`) REFERENCES `champions`(`id`),
  FOREIGN KEY (`itemId`) REFERENCES `items`(`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'riot league of legends finished match information';

LOCK TABLES `finishedmatch` WRITE;
UNLOCK TABLES;