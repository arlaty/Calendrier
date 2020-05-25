-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 25 mai 2020 à 15:49
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `calendrier`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`id`, `nom`) VALUES
(1, 'Mathématiques'),
(2, 'Thermodynamiques'),
(3, 'Java POO'),
(4, 'Web Dynamique'),
(5, 'Anthropologie');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `Id_utilisateur` int(11) DEFAULT NULL,
  `Id_cours` int(11) DEFAULT NULL,
  KEY `Id_utilisateur` (`Id_utilisateur`),
  KEY `Id_cours` (`Id_cours`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`Id_utilisateur`, `Id_cours`) VALUES
(3, 1),
(3, 2),
(16, 3),
(16, 4),
(17, 4),
(17, 5);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `Id_utilisateur` int(11) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `Id_groupe` int(11) DEFAULT NULL,
  KEY `Id_utilisateur` (`Id_utilisateur`),
  KEY `Id_groupe` (`Id_groupe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`Id_utilisateur`, `numero`, `Id_groupe`) VALUES
(4, 0, 1),
(5, 1, 1),
(6, 2, 2),
(7, 3, 2),
(8, 4, 3),
(9, 5, 3),
(10, 6, 4),
(11, 7, 4),
(12, 8, 5),
(13, 9, 5),
(14, 10, 6),
(15, 11, 6);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `Id_promotion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Id_promotion` (`Id_promotion`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`id`, `nom`, `Id_promotion`) VALUES
(1, 'TD1', 1),
(2, 'TD2', 1),
(3, 'TD1', 2),
(4, 'TD2', 2),
(5, 'TD1', 3),
(6, 'TD2', 3);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`id`, `nom`) VALUES
(1, 'ING1'),
(2, 'ING2'),
(3, 'ING3');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `capacite` int(11) DEFAULT NULL,
  `Id_site` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Id_site` (`Id_site`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `nom`, `capacite`, `Id_site`) VALUES
(1, 'EM009', 150, 1),
(2, 'EM010', 150, 1),
(3, 'P445', 150, 2),
(4, 'P304', 75, 2),
(5, 'C102', 100, 3),
(6, 'C335', 37, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `semaine` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `heure_debut` time DEFAULT NULL,
  `heure_fin` time DEFAULT NULL,
  `etat` enum('en_cours_de_validation','validee','annulee') DEFAULT NULL,
  `Id_type` int(11) DEFAULT NULL,
  `Id_cours` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Id_type` (`Id_type`),
  KEY `Id_cours` (`Id_cours`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`id`, `semaine`, `date`, `heure_debut`, `heure_fin`, `etat`, `Id_type`, `Id_cours`) VALUES
(1, 23, '2020-06-02', '08:30:00', '10:00:00', 'validee', NULL, 1),
(2, 23, '2020-06-02', '15:30:00', '17:00:00', 'annulee', NULL, 3),
(3, 23, '2020-06-03', '10:15:00', '11:45:00', 'validee', NULL, 2),
(4, 23, '2020-06-03', '19:00:00', '20:30:00', 'en_cours_de_validation', NULL, 5),
(5, 23, '2020-06-04', '12:00:00', '13:30:00', 'validee', NULL, 4),
(6, 23, '2020-06-05', '17:15:00', '18:45:00', 'validee', NULL, 4);

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `Id_seance` int(11) DEFAULT NULL,
  `Id_enseignant` int(11) DEFAULT NULL,
  KEY `Id_seance` (`Id_seance`),
  KEY `Id_enseignant` (`Id_enseignant`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seance_enseignants`
--

INSERT INTO `seance_enseignants` (`Id_seance`, `Id_enseignant`) VALUES
(1, 3),
(2, 16),
(3, 3),
(4, 17),
(5, 17),
(6, 16),
(5, 16);

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `Id_seance` int(11) DEFAULT NULL,
  `Id_groupe` int(11) DEFAULT NULL,
  KEY `Id_seance` (`Id_seance`),
  KEY `Id_groupe` (`Id_groupe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seance_groupes`
--

INSERT INTO `seance_groupes` (`Id_seance`, `Id_groupe`) VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(5, 6),
(6, 6);

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `Id_seance` int(11) DEFAULT NULL,
  `Id_salles` int(11) DEFAULT NULL,
  KEY `Id_seance` (`Id_seance`),
  KEY `Id_salles` (`Id_salles`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seance_salles`
--

INSERT INTO `seance_salles` (`Id_seance`, `Id_salles`) VALUES
(1, 2),
(2, 2),
(3, 4),
(4, 6),
(5, 5),
(6, 1);

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`id`, `nom`) VALUES
(1, 'Eiffel 1'),
(2, 'Eiffel 2'),
(3, 'Eiffel 3');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`id`, `nom`) VALUES
(1, 'Intéractif'),
(2, 'Magistral'),
(3, 'TD'),
(4, 'TP'),
(5, 'Projet'),
(6, 'Soutien');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `droit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `password`, `nom`, `prenom`, `droit`) VALUES
(1, 'toto@ece.fr', 'tc', 'Chef', 'toto', 1),
(2, 'jps@ece.fr', 'jps', 'Segado', 'JP', 2),
(3, 'laura@ece.fr', 'lt', 'test', 'laura', 3),
(4, 'clement@ece.fr', 'cj', 'Janot', 'Clement', 4),
(5, 'alexis@ece.fr', 'af', 'Freidel', 'Alexis', 4),
(6, 'lizzie@ece.fr', 'ld', 'Delaisser', 'Lizzie', 4),
(7, 'arian@ece.fr', 'ac', 'Chafa', 'Arian', 4),
(8, 'arristide@ece.fr', 'ab', 'Bentz', 'Arristide', 4),
(9, 'charlotte@ece.fr', 'cs', 'Sirot', 'Charlotte', 4),
(10, 'cynthia@ece.fr', 'cw', 'Wang', 'Cynthia', 4),
(11, 'baptiste@ece.fr', 'bb', 'Boyer', 'Baptiste', 4),
(12, 'amandine@ece.fr', 'az', 'Ziegler', 'Amandine', 4),
(13, 'alex@ece.fr', 'ag', 'Guenot', 'Alex', 4),
(14, 'adrien@ece.fr', 'ac', 'Claw', 'Adrien', 4),
(15, 'melodie@ece.Fr', 'md', 'Damas', 'Melodie', 4),
(16, 'yanis@ece.fr', 'yt', 'Touati', 'Yanis', 3),
(17, 'robin@ece.fr', 'rt', 'Fercoq', 'Robin', 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
