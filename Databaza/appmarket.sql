-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2022 at 12:34 AM
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
-- Table structure for table `katprod`
--

CREATE TABLE `katprod` (
  `id` int(11) NOT NULL,
  `emrkat` varchar(20) NOT NULL,
  `pershkrimi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `katprod`
--

INSERT INTO `katprod` (`id`, `emrkat`, `pershkrimi`) VALUES
(1, 'PijeteNgrohta', 'Ketu bejne pjese Kafet, Qajrat dhe gjithqka ne lidhje me pijet e nxehta.'),
(5, 'Pije', 'Ketu bejne pjes pijet si uji, pije te gazuara, pije energjike, te gjitha pijet jo alkoholije dhe jo te ngrohta.'),
(6, 'Embelsira', 'Ketu bejne pjese te gjitha llojet e embelsirave.'),
(7, 'PijeAlkolike', 'Ketu bejne pjese te gjitha pijet alkolike si birra, raki ,verea apo qdo lloj pije tjeter qe permban alkol.'),
(8, 'Snacks', 'Ketu bejne pjese ushqimet e shpejta.');

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
  `u_address` varchar(50) NOT NULL,
  `u_access` VARCHAR(50) NOT NULL DEFAULT "1 - Admin"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loginandreg`
--

INSERT INTO `loginandreg` (`ID`, `u_fname`, `u_lname`, `u_uname`, `u_pass`, `u_bdate`, `u_address`) VALUES
(1, 'Rilind', 'Kycyku', 'admin', 'admin', '', '');

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
(1, 'Amerikane', 'PijeteNgrohta', '1.0', 1),
(2, 'Espreso', 'PijeteNgrohta', '0.7', 1),
(3, 'Turke', 'PijeteNgrohta', '0.5', 1),
(4, 'NesCaffe', 'PijeteNgrohta', '1.0', 1),
(5, 'Qaj Frutash/Bimeve', 'PijeteNgrohta', '0.5', 1),
(6, 'Hot Chocolate', 'PijeteNgrohta', '1.5', 1),
(7, 'Uje Natyral & Mineral', 'Pije', '0.5', 1),
(8, 'Pije Te Gazuara', 'Pije', '1.0', 1),
(9, 'Red Bull', 'Pije', '2.0', 1),
(10, 'Ice Tea', 'Pije', '1.0', 1),
(11, 'Fructal', 'Pije', '1.0', 1),
(12, 'Lengje ne Gote', 'Pije', '0.7', 1),
(13, 'Trileqe', 'Embelsira', '1.5', 1),
(14, 'Tiramisu', 'Embelsira', '2.0', 1),
(15, 'Snickers', 'Embelsira', '2.0', 1),
(16, 'Birra Peja', 'PijeAlkolike', '1.2', 1),
(17, 'Birra Corona', 'PijeAlkolike', '3.0', 1),
(18, 'Birra Lasko', 'PijeAlkolike', '1.2', 1),
(19, 'Birra Heineken', 'PijeAlkolike', '3.0', 1),
(20, 'Birra Tuborg', 'PijeAlkolike', '2.5', 1),
(21, 'Tequila', 'PijeAlkolike', '3.0', 1),
(22, 'Gin Tonic', 'PijeAlkolike', '2.5', 1),
(23, 'Vodka Red Bull', 'PijeAlkolike', '4.5', 1),
(24, 'Jack Daniel', 'Pije Alkolike', '3.5', 1),
(25, 'Chicken Fingers', 'Snacks', '4.5', 1),
(26, 'Chicken Nuggets', 'Snacks', '3.5', 1),
(27, 'Pomfrita', 'Snacks', '2.5', 1),
(28, 'Meze e Ftoht', 'Snacks', '4.2', 1),
(29, 'Milka', 'Embelsira', '2.0', 1),
(30, 'Vere e Ngrohte', 'PijeAlkolike', '3.5', 1);

-- --------------------------------------------------------

--
-- Table structure for table `programi_shitjes`
--

CREATE TABLE `programi_shitjes` (
  `ID` int(11) NOT NULL,
  `user` varchar(50) NOT NULL,
  `shuma` varchar(50) NOT NULL,
  `pagesa` varchar(50) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `katprod`
--
ALTER TABLE `katprod`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT for table `katprod`
--
ALTER TABLE `katprod`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

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
