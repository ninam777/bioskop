-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 19, 2016 at 12:28 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bioskop`
--
CREATE DATABASE IF NOT EXISTS `bioskop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bioskop`;

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE IF NOT EXISTS `film` (
  `FilmID` int(7) NOT NULL,
  `NazivFilma` varchar(50) NOT NULL,
  `Zanr` varchar(50) NOT NULL,
  `Trajanje` int(7) NOT NULL,
  `Reziser` varchar(50) NOT NULL,
  `Glumci` varchar(50) NOT NULL,
  `Opis` varchar(240) NOT NULL,
  `PeriodPrikazivanja` varchar(30) NOT NULL,
  `RadnikID` int(7) NOT NULL,
  PRIMARY KEY (`FilmID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`FilmID`, `NazivFilma`, `Zanr`, `Trajanje`, `Reziser`, `Glumci`, `Opis`, `PeriodPrikazivanja`, `RadnikID`) VALUES
(111, 'Prestiz', 'Triler, Drama', 130, 'Kristofer Nolan', 'Kristijan Bejl, Dju Dzekmen', 'Prica o madjionicarima', '03.10.2016 - 03.01.2017', 112),
(118, 'The Secret Life of Pets', 'animirani, komedija', 85, 'Chris Renaud', 'Marko Markovi?, Milan ?u?ilovi?, Milena Živanovi?', 'komediju o životima naših ku?nih ljubimaca koje vode kad mi odemo na posao ili u školu svakog dana', '10.10.2016 - 10.03.2017', 111),
(119, 'War Dogs', 'komedija', 114, 'Todd Phillips', 'Jonah Hill, Miles Teller', 'neverovatnoj istinitoj pri?i o dvojici dvadesetogodišnjaka', '18.9.2016 - 18.12.2016', 112),
(120, 'Jason Bourne', 'akcija', 123, 'Paul Greengrass', 'Matt Damon, Julia Stiles', 'nekadašnji najsmrtonosniji operativac CIA iza?i iz senke', '10.10.2016 - 10.12.2016', 112);

-- --------------------------------------------------------

--
-- Table structure for table `karta`
--

CREATE TABLE IF NOT EXISTS `karta` (
  `ProjekcijaID` int(7) NOT NULL,
  `KartaID` int(7) NOT NULL,
  `Cena` double NOT NULL,
  `RadnikID` int(7) NOT NULL,
  `SalaID` int(7) NOT NULL,
  `Red` int(7) NOT NULL,
  `BrojSedista` int(7) NOT NULL,
  PRIMARY KEY (`ProjekcijaID`,`KartaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karta`
--

INSERT INTO `karta` (`ProjekcijaID`, `KartaID`, `Cena`, `RadnikID`, `SalaID`, `Red`, `BrojSedista`) VALUES
(1, 3, 750, 111, 111, 3, 1),
(1, 4, 750, 111, 111, 3, 2),
(1, 5, 750, 111, 111, 3, 3),
(2, 9, 250, 112, 112, 4, 5),
(8, 6, 750, 112, 113, 4, 1),
(8, 7, 750, 112, 113, 4, 2),
(8, 8, 750, 112, 113, 4, 3),
(10, 1, 500, 111, 111, 1, 2),
(10, 2, 500, 111, 111, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `kartazarezervisanosediste`
--

CREATE TABLE IF NOT EXISTS `kartazarezervisanosediste` (
  `ProjekcijaID` int(7) NOT NULL,
  `RezervacijaID` int(7) NOT NULL,
  `SalaID` int(7) NOT NULL,
  `Red` int(7) NOT NULL,
  `BrojSedista` int(7) NOT NULL,
  `KartaID` int(7) NOT NULL,
  PRIMARY KEY (`ProjekcijaID`,`RezervacijaID`,`SalaID`,`Red`,`BrojSedista`,`KartaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kartazarezervisanosediste`
--

INSERT INTO `kartazarezervisanosediste` (`ProjekcijaID`, `RezervacijaID`, `SalaID`, `Red`, `BrojSedista`, `KartaID`) VALUES
(8, 4, 113, 4, 1, 6),
(8, 4, 113, 4, 2, 7),
(8, 4, 113, 4, 3, 8),
(10, 2, 111, 1, 2, 1),
(10, 2, 111, 1, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `projekcija`
--

CREATE TABLE IF NOT EXISTS `projekcija` (
  `ProjekcijaID` int(7) NOT NULL AUTO_INCREMENT,
  `Datum` date NOT NULL,
  `Vreme` time NOT NULL,
  `FilmID` int(7) NOT NULL,
  `SalaID` int(7) NOT NULL,
  PRIMARY KEY (`ProjekcijaID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `projekcija`
--

INSERT INTO `projekcija` (`ProjekcijaID`, `Datum`, `Vreme`, `FilmID`, `SalaID`) VALUES
(1, '2016-09-23', '19:10:00', 111, 111),
(2, '2016-09-24', '20:00:00', 111, 112),
(6, '2016-10-16', '17:00:00', 118, 113),
(7, '2016-10-20', '18:30:00', 118, 114),
(8, '2016-11-03', '20:00:00', 119, 113),
(9, '2016-11-17', '21:30:00', 119, 112),
(10, '2016-11-10', '22:00:00', 120, 111),
(11, '2016-11-11', '21:00:00', 120, 113),
(12, '2016-11-12', '20:00:00', 120, 112);

-- --------------------------------------------------------

--
-- Table structure for table `radnik`
--

CREATE TABLE IF NOT EXISTS `radnik` (
  `RadnikID` int(7) NOT NULL,
  `Ime` varchar(20) NOT NULL,
  `Prezime` varchar(20) NOT NULL,
  `KorisnickoIme` varchar(20) NOT NULL,
  `KorisnickaSifra` varchar(20) NOT NULL,
  PRIMARY KEY (`RadnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `radnik`
--

INSERT INTO `radnik` (`RadnikID`, `Ime`, `Prezime`, `KorisnickoIme`, `KorisnickaSifra`) VALUES
(111, 'Milica', 'Milosavljevic', 'milicam', 'milicam'),
(112, 'Nikolina', 'Momcilovic', 'ninam', 'ninam');

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE IF NOT EXISTS `rezervacija` (
  `ProjekcijaID` int(7) NOT NULL,
  `RezervacijaID` int(7) NOT NULL,
  `NazivRezervacije` varchar(20) NOT NULL,
  `RadnikID` int(7) NOT NULL,
  PRIMARY KEY (`ProjekcijaID`,`RezervacijaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`ProjekcijaID`, `RezervacijaID`, `NazivRezervacije`, `RadnikID`) VALUES
(6, 3, 'Srdjan', 111),
(10, 1, 'Marija', 111),
(10, 2, 'Ivana', 111);

-- --------------------------------------------------------

--
-- Table structure for table `rezervisanosediste`
--

CREATE TABLE IF NOT EXISTS `rezervisanosediste` (
  `ProjekcijaID` int(7) NOT NULL,
  `RezervacijaID` int(7) NOT NULL,
  `SalaID` int(7) NOT NULL,
  `Red` int(7) NOT NULL,
  `BrojSedista` int(7) NOT NULL,
  `TrajanjeRezervacije` int(7) NOT NULL,
  PRIMARY KEY (`ProjekcijaID`,`RezervacijaID`,`SalaID`,`Red`,`BrojSedista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervisanosediste`
--

INSERT INTO `rezervisanosediste` (`ProjekcijaID`, `RezervacijaID`, `SalaID`, `Red`, `BrojSedista`, `TrajanjeRezervacije`) VALUES
(6, 3, 113, 2, 5, 30),
(6, 3, 113, 2, 6, 30),
(10, 1, 111, 1, 1, 30),
(10, 2, 111, 1, 2, 30),
(10, 2, 111, 1, 3, 30);

-- --------------------------------------------------------

--
-- Table structure for table `sala`
--

CREATE TABLE IF NOT EXISTS `sala` (
  `SalaID` int(7) NOT NULL,
  `NazivSale` varchar(20) NOT NULL,
  `Kapacitet` int(7) NOT NULL,
  PRIMARY KEY (`SalaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sala`
--

INSERT INTO `sala` (`SalaID`, `NazivSale`, `Kapacitet`) VALUES
(111, 'Sala 1', 50),
(112, 'Sala 2', 50),
(113, 'Sala 3', 100),
(114, 'Sala 4', 100);

-- --------------------------------------------------------

--
-- Table structure for table `sediste`
--

CREATE TABLE IF NOT EXISTS `sediste` (
  `SalaID` int(7) NOT NULL,
  `Red` int(7) NOT NULL,
  `BrojSedista` int(7) NOT NULL,
  PRIMARY KEY (`SalaID`,`Red`,`BrojSedista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sediste`
--

INSERT INTO `sediste` (`SalaID`, `Red`, `BrojSedista`) VALUES
(111, 1, 1),
(111, 1, 2),
(111, 1, 3),
(111, 1, 4),
(111, 1, 5),
(111, 1, 6),
(111, 1, 7),
(111, 1, 8),
(111, 1, 9),
(111, 1, 10),
(111, 2, 1),
(111, 2, 2),
(111, 2, 3),
(111, 2, 4),
(111, 2, 5),
(111, 2, 6),
(111, 2, 7),
(111, 2, 8),
(111, 2, 9),
(111, 2, 10),
(111, 3, 1),
(111, 3, 2),
(111, 3, 3),
(111, 3, 4),
(111, 3, 5),
(111, 3, 6),
(111, 3, 7),
(111, 3, 8),
(111, 3, 9),
(111, 3, 10),
(111, 4, 1),
(111, 4, 2),
(111, 4, 3),
(111, 4, 4),
(111, 4, 5),
(111, 4, 6),
(111, 4, 7),
(111, 4, 8),
(111, 4, 9),
(111, 4, 10),
(111, 5, 1),
(111, 5, 2),
(111, 5, 3),
(111, 5, 4),
(111, 5, 5),
(111, 5, 6),
(111, 5, 7),
(111, 5, 8),
(111, 5, 9),
(111, 5, 10),
(112, 1, 1),
(112, 1, 2),
(112, 1, 3),
(112, 1, 4),
(112, 1, 5),
(112, 1, 6),
(112, 1, 7),
(112, 1, 8),
(112, 1, 9),
(112, 1, 10),
(112, 2, 1),
(112, 2, 2),
(112, 2, 3),
(112, 2, 4),
(112, 2, 5),
(112, 2, 6),
(112, 2, 7),
(112, 2, 8),
(112, 2, 9),
(112, 2, 10),
(112, 3, 1),
(112, 3, 2),
(112, 3, 3),
(112, 3, 4),
(112, 3, 5),
(112, 3, 6),
(112, 3, 7),
(112, 3, 8),
(112, 3, 9),
(112, 3, 10),
(112, 4, 1),
(112, 4, 2),
(112, 4, 3),
(112, 4, 4),
(112, 4, 5),
(112, 4, 6),
(112, 4, 7),
(112, 4, 8),
(112, 4, 9),
(112, 4, 10),
(112, 5, 1),
(112, 5, 2),
(112, 5, 3),
(112, 5, 4),
(112, 5, 5),
(112, 5, 6),
(112, 5, 7),
(112, 5, 8),
(112, 5, 9),
(112, 5, 10),
(113, 1, 1),
(113, 1, 2),
(113, 1, 3),
(113, 1, 4),
(113, 1, 5),
(113, 1, 6),
(113, 1, 7),
(113, 1, 8),
(113, 1, 9),
(113, 1, 10),
(113, 2, 1),
(113, 2, 2),
(113, 2, 3),
(113, 2, 4),
(113, 2, 5),
(113, 2, 6),
(113, 2, 7),
(113, 2, 8),
(113, 2, 9),
(113, 2, 10),
(113, 3, 1),
(113, 3, 2),
(113, 3, 3),
(113, 3, 4),
(113, 3, 5),
(113, 3, 6),
(113, 3, 7),
(113, 3, 8),
(113, 3, 9),
(113, 3, 10),
(113, 4, 1),
(113, 4, 2),
(113, 4, 3),
(113, 4, 4),
(113, 4, 5),
(113, 4, 6),
(113, 4, 7),
(113, 4, 8),
(113, 4, 9),
(113, 4, 10),
(113, 5, 1),
(113, 5, 2),
(113, 5, 3),
(113, 5, 4),
(113, 5, 5),
(113, 5, 6),
(113, 5, 7),
(113, 5, 8),
(113, 5, 9),
(113, 5, 10),
(113, 6, 1),
(113, 6, 2),
(113, 6, 3),
(113, 6, 4),
(113, 6, 5),
(113, 6, 6),
(113, 6, 7),
(113, 6, 8),
(113, 6, 9),
(113, 6, 10),
(113, 7, 1),
(113, 7, 2),
(113, 7, 3),
(113, 7, 4),
(113, 7, 5),
(113, 7, 6),
(113, 7, 7),
(113, 7, 8),
(113, 7, 9),
(113, 7, 10),
(113, 8, 1),
(113, 8, 2),
(113, 8, 3),
(113, 8, 4),
(113, 8, 5),
(113, 8, 6),
(113, 8, 7),
(113, 8, 8),
(113, 8, 9),
(113, 8, 10),
(113, 9, 1),
(113, 9, 2),
(113, 9, 3),
(113, 9, 4),
(113, 9, 5),
(113, 9, 6),
(113, 9, 7),
(113, 9, 8),
(113, 9, 9),
(113, 9, 10),
(113, 10, 1),
(113, 10, 2),
(113, 10, 3),
(113, 10, 4),
(113, 10, 5),
(113, 10, 6),
(113, 10, 7),
(113, 10, 8),
(113, 10, 9),
(113, 10, 10),
(114, 1, 1),
(114, 1, 2),
(114, 1, 3),
(114, 1, 4),
(114, 1, 5),
(114, 1, 6),
(114, 1, 7),
(114, 1, 8),
(114, 1, 9),
(114, 1, 10),
(114, 2, 1),
(114, 2, 2),
(114, 2, 3),
(114, 2, 4),
(114, 2, 5),
(114, 2, 6),
(114, 2, 7),
(114, 2, 8),
(114, 2, 9),
(114, 2, 10),
(114, 3, 1),
(114, 3, 2),
(114, 3, 3),
(114, 3, 4),
(114, 3, 5),
(114, 3, 6),
(114, 3, 7),
(114, 3, 8),
(114, 3, 9),
(114, 3, 10),
(114, 4, 1),
(114, 4, 2),
(114, 4, 3),
(114, 4, 4),
(114, 4, 5),
(114, 4, 6),
(114, 4, 7),
(114, 4, 8),
(114, 4, 9),
(114, 4, 10),
(114, 5, 1),
(114, 5, 2),
(114, 5, 3),
(114, 5, 4),
(114, 5, 5),
(114, 5, 6),
(114, 5, 7),
(114, 5, 8),
(114, 5, 9),
(114, 5, 10),
(114, 6, 1),
(114, 6, 2),
(114, 6, 3),
(114, 6, 4),
(114, 6, 5),
(114, 6, 6),
(114, 6, 7),
(114, 6, 8),
(114, 6, 9),
(114, 6, 10),
(114, 7, 1),
(114, 7, 2),
(114, 7, 3),
(114, 7, 4),
(114, 7, 5),
(114, 7, 6),
(114, 7, 7),
(114, 7, 8),
(114, 7, 9),
(114, 7, 10),
(114, 8, 1),
(114, 8, 2),
(114, 8, 3),
(114, 8, 4),
(114, 8, 5),
(114, 8, 6),
(114, 8, 7),
(114, 8, 8),
(114, 8, 9),
(114, 8, 10),
(114, 9, 1),
(114, 9, 2),
(114, 9, 3),
(114, 9, 4),
(114, 9, 5),
(114, 9, 6),
(114, 9, 7),
(114, 9, 8),
(114, 9, 9),
(114, 9, 10),
(114, 10, 1),
(114, 10, 2),
(114, 10, 3),
(114, 10, 4),
(114, 10, 5),
(114, 10, 6),
(114, 10, 7),
(114, 10, 8),
(114, 10, 9),
(114, 10, 10);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
