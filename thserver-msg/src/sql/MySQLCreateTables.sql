-- phpMyAdmin SQL Dump
-- version 3.3.9.2deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-07-2011 a las 20:36:15
-- Versión del servidor: 5.1.49
-- Versión de PHP: 5.3.3-7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `memoria2-msg`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Message`
--

CREATE TABLE IF NOT EXISTS `Message` (
  `messageId` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `messageBody` varchar(255) DEFAULT NULL,
  `readed` bit(1) NOT NULL,
  `type` int(11) NOT NULL,
  `senderId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`messageId`),
  KEY `FK9C2397E7E4F27E8D` (`senderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Message_User`
--

CREATE TABLE IF NOT EXISTS `Message_User` (
  `messages_messageId` bigint(20) NOT NULL,
  `receivers_userId` bigint(20) NOT NULL,
  PRIMARY KEY (`messages_messageId`,`receivers_userId`),
  KEY `FKBD155943E4D93A44` (`messages_messageId`),
  KEY `FKBD1559433E08F2DE` (`receivers_userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `Message`
--
ALTER TABLE `Message`
  ADD CONSTRAINT `FK9C2397E7E4F27E8D` FOREIGN KEY (`senderId`) REFERENCES `User` (`userId`);

--
-- Filtros para la tabla `Message_User`
--
ALTER TABLE `Message_User`
  ADD CONSTRAINT `FKBD1559433E08F2DE` FOREIGN KEY (`receivers_userId`) REFERENCES `User` (`userId`),
  ADD CONSTRAINT `FKBD155943E4D93A44` FOREIGN KEY (`messages_messageId`) REFERENCES `Message` (`messageId`);
