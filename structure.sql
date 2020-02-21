-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 17 fév. 2020 à 16:23
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `agile`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `ID_Categorie` INT NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_Categorie`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`ID_Categorie`, `Nom`) VALUES
('1', 'testhamza'),
('2', 'aussiMOI');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `ID_Compte` INT NOT NULL AUTO_INCREMENT,
  `Pseudo` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_Compte`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `ID_Personne` INT NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `DateNais` date DEFAULT NULL,
  `ID_Compte` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Personne`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `solde`
--

DROP TABLE IF EXISTS `solde`;
CREATE TABLE IF NOT EXISTS `solde` (
  `ID_Solde` INT NOT NULL AUTO_INCREMENT,
  `DateSolde` date DEFAULT NULL,
  `SoldeActuel` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`ID_Solde`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
CREATE TABLE IF NOT EXISTS `transactions` (
  `ID_Transaction` INT NOT NULL AUTO_INCREMENT,
  `Type` varchar(50) DEFAULT NULL,
  `DateTransact` date DEFAULT NULL,
  `Montant` decimal(15,2) DEFAULT NULL,
  `Libelle` varchar(50) DEFAULT NULL,
  `ID_Personne` int(11) DEFAULT NULL,
  'ID_Categorie' int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Transaction`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
