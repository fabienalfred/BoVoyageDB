-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 03 Août 2015 à 08:46
-- Version du serveur: 5.5.44-0ubuntu0.14.04.1
-- Version de PHP: 5.5.9-1ubuntu4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `bovoyage`
--
CREATE DATABASE IF NOT EXISTS `bovoyage` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bovoyage`;

-- --------------------------------------------------------

--
-- Structure de la table `dates_voyages`
--

CREATE TABLE IF NOT EXISTS `dates_voyages` (
  `kp_date_voyage` int(11) NOT NULL DEFAULT '0',
  `date_depart` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `date_retour` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `prixHT` double NOT NULL DEFAULT '0',
  `ke_destination` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `dates_voyages`
--

INSERT INTO `dates_voyages` (`kp_date_voyage`, `date_depart`, `date_retour`, `prixHT`, `ke_destination`) VALUES
(1, '2016-06-12 00:00:00', '2016-06-24 00:00:00', 1359, 1),
(2, '2016-08-01 00:00:00', '2016-08-15 00:00:00', 2450, 1),
(3, '2016-09-03 00:00:00', '2016-09-15 00:00:00', 2420, 1),
(4, '2016-06-03 00:00:00', '2016-06-15 00:00:00', 2250, 2),
(5, '2016-07-08 00:00:00', '2016-07-18 00:00:00', 2300, 2),
(6, '2016-07-02 00:00:00', '2016-07-15 00:00:00', 2700, 3),
(7, '2016-11-12 00:00:00', '2016-11-25 00:00:00', 2890, 3),
(8, '2016-12-27 00:00:00', '2017-01-03 00:00:00', 3200, 4);

-- --------------------------------------------------------

--
-- Structure de la table `destinations`
--

CREATE TABLE IF NOT EXISTS `destinations` (
  `kp_destination` int(11) NOT NULL DEFAULT '0',
  `region` varchar(50) NOT NULL DEFAULT '',
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `destinations`
--

INSERT INTO `destinations` (`kp_destination`, `region`, `description`) VALUES
(1, 'Guadeloupe', 'Dans un site exceptionnel,en bordure d''un petit lagon turquoise, tout est réuni pour un séjour paradisiaque à la découverte des merveilles de la terre et de la mer'),
(2, 'Saint-Barthélémy', 'Imaginez une île où il fait 26 à 28 °C toute l''année, et où la température de la mer est la même que celle de l''air'),
(3, 'Birmanie', 'La Birmanie est un pays passionnant pour tous ceux qui s''interessent à l''art, aux civilisations, à l''hindouisme. Ce pays s''ouvre et a conservé toute la richesse de son patrimoine culturel'),
(4, 'Canada', 'Découvrez la nature généreuse et les grandes villes du Canada en toute saison, grâce aux nombreux circuits que nous avons élaborés.');

-- --------------------------------------------------------

--
-- Structure de la table `images`
--

CREATE TABLE IF NOT EXISTS `images` (
  `image` varchar(50) NOT NULL DEFAULT '',
  `ke_destination` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `images`
--

INSERT INTO `images` (`image`, `ke_destination`) VALUES
('guadeloupe_1.jpg', 1),
('saint-barth_1.jpg', 2),
('saint-barth_2.jpg', 2),
('myanmar_1.jpg', 3),
('myanmar_2.jpg', 3),
('myanmar_3.jpg', 3),
('canada_1.jpg', 4),
('canada_2.jpg', 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
