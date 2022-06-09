-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3333
-- Generation Time: Jun 09, 2022 at 01:52 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_login_registerr`
--

-- --------------------------------------------------------

--
-- Table structure for table `katakses`
--

CREATE TABLE `katakses` (
  `ID` int(50) NOT NULL,
  `llojiAk` varchar(50) NOT NULL,
  `pershkrimi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `katakses`
--

INSERT INTO `katakses` (`ID`, `llojiAk`, `pershkrimi`) VALUES
(1, '1 - Admin', 'Administratori i Programit'),
(2, '2 - Kamarier', 'Aksesi i Kamariet, te gjitha funksionet e Adminit ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `katakses`
--
ALTER TABLE `katakses`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `katakses`
--
ALTER TABLE `katakses`
  MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
