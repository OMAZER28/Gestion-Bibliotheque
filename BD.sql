-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 09 juin 2020 à 20:15
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestionbibliotheque`
--
DROP DATABASE IF EXISTS `gestionbibliotheque`;
CREATE DATABASE IF NOT EXISTS `gestionbibliotheque` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gestionbibliotheque`;

-- --------------------------------------------------------

--
-- Structure de la table `adherant`
--

CREATE TABLE `adherant` (
  `numLecteur` int(11) NOT NULL,
  `login` varchar(55) NOT NULL,
  `mdp` varchar(55) NOT NULL,
  `nbMax` int(11) NOT NULL,
  `nom` varchar(55) NOT NULL,
  `isVerified` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adherant`
--

INSERT INTO `adherant` (`numLecteur`, `login`, `mdp`, `nbMax`, `nom`, `isVerified`) VALUES
(63, 'etudiant1@gmail.com', '123456789', 2, 'Etudiant1', 1),
(70, 'Enseignant1@gmail.com', '123456789', 4, 'Enseignant1', 0),
(71, 'etudiant2@gmail.com', '123456789', 2, 'Etudiant2', 0);

-- --------------------------------------------------------

--
-- Structure de la table `bibliothecaire`
--

CREATE TABLE `bibliothecaire` (
  `id` int(11) NOT NULL,
  `login` varchar(55) NOT NULL,
  `mdp` varchar(55) NOT NULL,
  `nom` varchar(55) NOT NULL,
  `dateNaissance` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bibliothecaire`
--

INSERT INTO `bibliothecaire` (`id`, `login`, `mdp`, `nom`, `dateNaissance`) VALUES
(3, 'bib1@gmail.com', '123456789', 'bib1', '1998-05-17');

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

CREATE TABLE `emprunt` (
  `numLecteur` int(11) NOT NULL,
  `cote` int(11) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `idBibliothecaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `emprunt`
--

INSERT INTO `emprunt` (`numLecteur`, `cote`, `dateDebut`, `dateFin`, `idBibliothecaire`) VALUES
(63, 40, '2020-06-10', '2020-06-25', 3);

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `numLecteur` int(11) NOT NULL,
  `departement` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`numLecteur`, `departement`) VALUES
(70, 'TRI');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `numLecteur` int(11) NOT NULL,
  `cne` varchar(55) NOT NULL,
  `adresse` varchar(120) NOT NULL,
  `filliere` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`numLecteur`, `cne`, `adresse`, `filliere`) VALUES
(63, 'CN125134', 'Rue de Madrid 123 Casablanca', 'ISIC'),
(71, 'BR45512', 'Rabat , Maroc', 'G2E');

-- --------------------------------------------------------

--
-- Structure de la table `exemplaire`
--

CREATE TABLE `exemplaire` (
  `cote` int(11) NOT NULL,
  `etat` varchar(55) NOT NULL,
  `idLivre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `exemplaire`
--

INSERT INTO `exemplaire` (`cote`, `etat`, `idLivre`) VALUES
(37, 'Bon état', 5),
(38, 'Mauvais état', 5),
(40, 'Bon état', 6),
(41, 'Bon état', 7),
(43, 'Mauvais état', 9);

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `id` int(11) NOT NULL,
  `titre` varchar(55) NOT NULL,
  `nomEditeur` varchar(55) NOT NULL,
  `auteur` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id`, `titre`, `nomEditeur`, `auteur`) VALUES
(5, 'Millénium', 'Actes noirs', 'David Lagerkrantz'),
(6, 'De pierre et os', 'Le Tripode', 'Bérengère Cournut'),
(7, 'La tentation', 'Stock', 'Luc Lang'),
(8, 'Livre1', 'edi1', 'auteur1'),
(9, 'Livre2', 'editeur2', 'auteur2');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `numLecteur` int(11) NOT NULL,
  `cote` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`numLecteur`, `cote`, `date`) VALUES
(63, 37, '2020-06-09'),
(63, 38, '2020-06-09');

-- --------------------------------------------------------

--
-- Structure de la table `revue`
--

CREATE TABLE `revue` (
  `id` int(11) NOT NULL,
  `titre` varchar(55) NOT NULL,
  `periodicite` varchar(55) NOT NULL,
  `dateParution` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `revue`
--

INSERT INTO `revue` (`id`, `titre`, `periodicite`, `dateParution`) VALUES
(6, 'Algorithmic Research', 'Mensuel', '2020-05-06'),
(8, 'Antropologie et Sociétés', 'Mensuel', '2020-01-06'),
(9, 'Arborescences', 'Mensuel', '2020-04-18'),
(10, 'Archives', 'Quotidienne', '2020-04-28'),
(12, 'Revue1', 'Hebdomadaire', '2020-06-01'),
(13, 'Revue2', 'Mensuel', '2020-06-04');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adherant`
--
ALTER TABLE `adherant`
  ADD PRIMARY KEY (`numLecteur`);

--
-- Index pour la table `bibliothecaire`
--
ALTER TABLE `bibliothecaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`numLecteur`,`cote`),
  ADD UNIQUE KEY `FK_empr` (`numLecteur`,`cote`),
  ADD KEY `FK_emp2` (`cote`),
  ADD KEY `FK_bibliothecaire` (`idBibliothecaire`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`numLecteur`),
  ADD UNIQUE KEY `FK_ens` (`numLecteur`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`numLecteur`),
  ADD UNIQUE KEY `FK_etud` (`numLecteur`);

--
-- Index pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  ADD PRIMARY KEY (`cote`),
  ADD KEY `FK_livre` (`idLivre`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`numLecteur`,`cote`),
  ADD UNIQUE KEY `FK_reserv` (`numLecteur`,`cote`) USING BTREE,
  ADD KEY `FK_reserv2` (`cote`);

--
-- Index pour la table `revue`
--
ALTER TABLE `revue`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adherant`
--
ALTER TABLE `adherant`
  MODIFY `numLecteur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- AUTO_INCREMENT pour la table `bibliothecaire`
--
ALTER TABLE `bibliothecaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  MODIFY `cote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT pour la table `livre`
--
ALTER TABLE `livre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `revue`
--
ALTER TABLE `revue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `FK_bibliothecaire` FOREIGN KEY (`idBibliothecaire`) REFERENCES `bibliothecaire` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_emp1` FOREIGN KEY (`numLecteur`) REFERENCES `adherant` (`numLecteur`),
  ADD CONSTRAINT `FK_emp2` FOREIGN KEY (`cote`) REFERENCES `exemplaire` (`cote`);

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `FK_ense` FOREIGN KEY (`numLecteur`) REFERENCES `adherant` (`numLecteur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `FK_etud` FOREIGN KEY (`numLecteur`) REFERENCES `adherant` (`numLecteur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  ADD CONSTRAINT `FK_livre` FOREIGN KEY (`idLivre`) REFERENCES `livre` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK_reserv1` FOREIGN KEY (`numLecteur`) REFERENCES `adherant` (`numLecteur`),
  ADD CONSTRAINT `FK_reserv2` FOREIGN KEY (`cote`) REFERENCES `exemplaire` (`cote`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
