-- phpMyAdmin SQL Dump
-- version 2.7.0-pl2
-- http://www.phpmyadmin.net
-- 
-- Servidor: oraclepr.uco.es
-- Version del servidor: 5.1.73
-- Version de PHP: 5.3.3
-- 
-- Base de datos: `i92rigam`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `User`
-- 
DROP TABLE IF EXISTS `User` ;
DROP TABLE IF EXISTS `Spectacle`;
DROP TABLE IF EXISTS `Review`;
DROP TABLE IF EXISTS `Sesion`;
DROP TABLE IF EXISTS `User-Review`;

CREATE TABLE IF NOT EXISTS `User` (
  `name` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `surname` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nick` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerDate` DATETIME NULL,
  `lastLogin` DATETIME NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `Spectacle` (
  `spectacleId` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `places` INT NOT NULL,
  PRIMARY KEY (`spectacleId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `Review` (
  `reviewId` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `spectacleId` INT NOT NULL,
  `title` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `score` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `likes` INT NOT NULL,
  `dislikes` INT NOT NULL,
  PRIMARY KEY (`reviewId`),
  FOREIGN KEY (`email`) REFERENCES User(email),
  FOREIGN KEY (`spectacleId`) REFERENCES Spectacle(spectacleId)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `Sesion` (
  `sesionId` INT NOT NULL AUTO_INCREMENT,
  `spectacleId` INT NOT NULL,
  `placesLeft` INT NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`sesionId`),
  FOREIGN KEY (`spectacleId`) REFERENCES Spectacle(spectacleId)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `User-Review` (
  `email` VARCHAR(255) NOT NULL,
  `reviewId` INT NOT NULL,
  PRIMARY KEY (`reviewId`,`email`),
  FOREIGN KEY (`email`) REFERENCES User(email),
  FOREIGN KEY (`reviewId`) REFERENCES Review(reviewId)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 
-- Volcar la base de datos para la tabla `User`
-- 

INSERT INTO `User` VALUES ('Marcos','Admin','Rivera Gavilán','i92rigam','i92rigam@uco.es','1234', '2021-11-11 17:07:09', '2021-11-11 17:07:09');
INSERT INTO `User` VALUES ('David','Admin','Pérez Dueñas','i92pedud','i92pedud@uco.es','1234', '2021-11-11 17:07:09', '2021-11-11 17:07:09');
INSERT INTO `User` VALUES ('Antonio','Admin','Moruno Gracia','i92mogra','i92mogra@uco.es','1234', '2021-11-11 17:07:09', '2021-11-11 17:07:09');
INSERT INTO `User` VALUES ('Javier','Spectator','de Santiago Palomino','i92sanpj','i92sanpj@uco.es','1234', '2021-11-11 17:07:09', '2021-11-11 17:07:09');
INSERT INTO `User` VALUES ('Marcos','Spectator','Rodriguez Moreno','i92romom','i92romom@uco.es','1234', '2021-11-11 17:07:09', '2021-11-11 17:07:09');

INSERT INTO `Spectacle` VALUES (NULL,'Cars','Single','Coches','obra',50);
INSERT INTO `Spectacle` VALUES (NULL,'Cars 2','Multiple','Más coches','obra',60);

INSERT INTO `Sesion` VALUES (NULL,1,50,'2021-11-10 16:00:00');
INSERT INTO `Sesion` VALUES (NULL,2,60,'2021-11-11 15:00:00');
INSERT INTO `Sesion` VALUES (NULL,2,0,'2021-11-12 16:00:00');
INSERT INTO `Sesion` VALUES (NULL,2,60,'2021-11-13 17:00:00');

INSERT INTO `Review` VALUES (NULL,'i92rigam@uco.es',1,'Cars',5,'Peliculon',1,0);
INSERT INTO `Review` VALUES (NULL,'i92pedud@uco.es',2,'Cars2',5,'Peliculon',1,0);
INSERT INTO `Review` VALUES (NULL,'i92rigam@uco.es',1,'Muy Buena',5,'Buenisima',0,0);

INSERT INTO `User-Review` VALUES ('i92rigam@uco.es',1);
INSERT INTO `User-Review` VALUES ('i92rigam@uco.es',2);

