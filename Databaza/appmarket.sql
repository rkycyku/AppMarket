-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2022 at 08:56 PM
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
-- Database: `appmarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `loginandreg`
--

CREATE TABLE `loginandreg` (
  `ID` int(11) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_uname` varchar(50) NOT NULL,
  `u_pass` varchar(50) NOT NULL,
  `u_bdate` varchar(50) NOT NULL,
  `u_address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loginandreg`
--

INSERT INTO `loginandreg` (`ID`, `u_fname`, `u_lname`, `u_uname`, `u_pass`, `u_bdate`, `u_address`) VALUES
(1, 'Rilind', 'Kyçyku', 'admin', 'admin', '2003-02-27', 'Komandant zefi');

-- --------------------------------------------------------

--
-- Table structure for table `produktet`
--

CREATE TABLE `produktet` (
  `id` int(4) NOT NULL,
  `emrprod` varchar(225) NOT NULL,
  `katprod` varchar(225) NOT NULL,
  `qmimi` varchar(5) NOT NULL,
  `sasia` int(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produktet`
--

INSERT INTO `produktet` (`id`, `emrprod`, `katprod`, `qmimi`, `sasia`) VALUES
(1, 'Amerikane', 'Kafe', '1.0', 1),
(2, 'Espreso', 'Kafe', '0.7', 1),
(3, 'Turke', 'Kafe', '0.5', 1),
(4, 'NesCaffe', 'Kafe', '1.0', 1),
(5, 'Qaj Frutash/Bimeve', 'Pije te Ngrohta', '0.5', 1),
(6, 'Hot Chocolate', 'Pije te Ngrohta', '1.5', 1),
(7, 'Uje Natyral & Mineral', 'Pije', '0.5', 1),
(8, 'Pije Te Gazuara', 'Pije - CC/Fanta/Schweeps', '1.0', 1),
(9, 'Red Bull', 'Pije', '2.0', 1),
(10, 'Ice Tea', 'Pije', '1.0', 1),
(11, 'Fructal', 'Pije', '1.0', 1),
(12, 'Lengje ne Gote', 'Pije', '0.7', 1),
(13, 'Trileqe', 'Embelsira', '1.5', 1),
(14, 'Tiramisu', 'Embelsira', '2.0', 1),
(15, 'Snickers', 'Embelsira', '2.0', 1),
(16, 'Birra Peja', 'Birre', '1.2', 1),
(17, 'Birra Corona', 'Birre', '3.0', 1),
(18, 'Birra Lasko', 'Birre', '1.2', 1),
(19, 'Birra Heineken', 'Birre', '3.0', 1),
(20, 'Birra Tuborg', 'Birre', '2.5', 1),
(21, 'Tequila', 'Raki', '3.0', 1),
(22, 'Gin Tonic', 'Raki', '2.5', 1),
(23, 'Vodka Red Bull', 'Raki', '4.5', 1),
(24, 'Jack Daniel', 'Raki', '3.5', 1),
(25, 'Chicken Fingers', 'Snacks', '4.5', 1),
(26, 'Chicken Nuggets', 'Snacks', '3.5', 1),
(27, 'Pomfrita', 'Snacks', '2.5', 1),
(28, 'Meze e Ftoht', 'Snacks', '4.2', 1),
(29, 'Milka', 'Embelsira', '2.0', 1);

-- --------------------------------------------------------

--
-- Table structure for table `programi_shitjes`
--

CREATE TABLE `programi_shitjes` (
  `ID` int(11) NOT NULL,
  `user` varchar(50) NOT NULL,
  `shuma` varchar(50) NOT NULL,
  `data` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `loginandreg`
--
ALTER TABLE `loginandreg`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `produktet`
--
ALTER TABLE `produktet`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `programi_shitjes`
--
ALTER TABLE `programi_shitjes`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `loginandreg`
--
ALTER TABLE `loginandreg`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `produktet`
--
ALTER TABLE `produktet`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `programi_shitjes`
--
ALTER TABLE `programi_shitjes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
