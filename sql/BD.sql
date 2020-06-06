-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 06 juin 2020 à 14:25
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
(52, 'et1@gmail.com', '123456789', 2, 'et1', 0),
(53, 'en1@gmail.com', '123456789', 4, 'en1', 0),
(54, 'et2@gmail.com', '123456789', 2, 'et2', 0),
(55, 'et3@gmail.com', '123456789', 2, 'et3', 0);

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
(54, 2, '2020-05-04', '2020-06-01', 3);

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
(53, 'STIN');

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
(52, 'c41455', 'dfqsdfsq', 'G2E'),
(54, 'gb9859459', 'sdfqsfqsf', 'ISIC'),
(55, 'd15144', 'sqdf', 'G2E');

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
(1, 'bon état', 1),
(2, 'bon état', 2),
(3, 'mauvais état', 1);

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
(1, 'livre1', 'editeur1', 'auteur1'),
(2, 'titre2', 'editeur2', 'auteur2');

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
(52, 1, '2020-06-01');

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
(1, 'revue1', 'quotidienne', '2020-06-01'),
(2, 'revue2', 'hebdomadaire', '2020-06-02');

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
  MODIFY `numLecteur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT pour la table `bibliothecaire`
--
ALTER TABLE `bibliothecaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  MODIFY `cote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `livre`
--
ALTER TABLE `livre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `revue`
--
ALTER TABLE `revue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
  ADD CONSTRAINT `FK_reserv2` FOREIGN KEY (`cote`) REFERENCES `exemplaire` (`cote`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
