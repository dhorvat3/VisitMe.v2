-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2015 at 04:08 PM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `visitme2`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id_address` int(11) NOT NULL,
  `lat` decimal(10,6) NOT NULL,
  `lng` decimal(10,6) NOT NULL,
  `address` text CHARACTER SET ucs2 COLLATE ucs2_croatian_ci NOT NULL,
  `id_town` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id_address`, `lat`, `lng`, `address`, `id_town`) VALUES
(1, '44.134995', '15.217369', 'Put Dikla 77', 1),
(2, '43.702869', '15.873634', 'Ul. Braće Nakić 43', 3);

-- --------------------------------------------------------

--
-- Table structure for table `apartment`
--

CREATE TABLE `apartment` (
  `id_apartment` int(11) NOT NULL,
  `ap_name` text CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `beds` int(11) NOT NULL,
  `description` text NOT NULL,
  `free` tinyint(1) NOT NULL,
  `price` float NOT NULL,
  `id_address` int(11) NOT NULL,
  `id_owner` int(11) NOT NULL,
  `id_town` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `apartment`
--

INSERT INTO `apartment` (`id_apartment`, `ap_name`, `beds`, `description`, `free`, `price`, `id_address`, `id_owner`, `id_town`) VALUES
(2, 'Apartman Jeličić', 5, 'Apartmani za najam po povoljnim cijenama', 1, 50, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id_category` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id_image` int(11) NOT NULL,
  `url` text NOT NULL,
  `id_apartment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `id_owner` int(11) NOT NULL,
  `own_name` text CHARACTER SET ucs2 COLLATE ucs2_croatian_ci NOT NULL,
  `mobile` text CHARACTER SET latin1 NOT NULL,
  `email` text CHARACTER SET latin1 NOT NULL,
  `username` text CHARACTER SET latin1 NOT NULL,
  `password` text CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`id_owner`, `own_name`, `mobile`, `email`, `username`, `password`) VALUES
(1, 'Filip Jeličić', '0956336562', 'fijelicic@gmail.com', 'fijelicic', 'password');

-- --------------------------------------------------------

--
-- Table structure for table `poi`
--

CREATE TABLE `poi` (
  `id_poi` int(11) NOT NULL,
  `poi_name` text NOT NULL,
  `description` text NOT NULL,
  `id_category` int(11) NOT NULL,
  `id_address` int(11) NOT NULL,
  `id_town` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `town`
--

CREATE TABLE `town` (
  `id_town` int(11) NOT NULL,
  `t_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `town`
--

INSERT INTO `town` (`id_town`, `t_name`) VALUES
(1, 'Zadar'),
(2, 'Dubrovnik'),
(3, 'Šibenik');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id_address`),
  ADD KEY `id_town` (`id_town`);

--
-- Indexes for table `apartment`
--
ALTER TABLE `apartment`
  ADD PRIMARY KEY (`id_apartment`),
  ADD KEY `id_address` (`id_address`),
  ADD KEY `id_owner` (`id_owner`),
  ADD KEY `id_town` (`id_town`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id_category`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id_image`),
  ADD KEY `id_apartment` (`id_apartment`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`id_owner`);

--
-- Indexes for table `poi`
--
ALTER TABLE `poi`
  ADD PRIMARY KEY (`id_poi`),
  ADD KEY `category` (`id_category`),
  ADD KEY `id_address` (`id_address`),
  ADD KEY `id_town` (`id_town`);

--
-- Indexes for table `town`
--
ALTER TABLE `town`
  ADD PRIMARY KEY (`id_town`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id_address` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `apartment`
--
ALTER TABLE `apartment`
  MODIFY `id_apartment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id_image` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `id_owner` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `poi`
--
ALTER TABLE `poi`
  MODIFY `id_poi` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `town`
--
ALTER TABLE `town`
  MODIFY `id_town` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `address_ibfk_1` FOREIGN KEY (`id_town`) REFERENCES `town` (`id_town`);

--
-- Constraints for table `apartment`
--
ALTER TABLE `apartment`
  ADD CONSTRAINT `apartment_ibfk_1` FOREIGN KEY (`id_address`) REFERENCES `address` (`id_address`),
  ADD CONSTRAINT `apartment_ibfk_2` FOREIGN KEY (`id_owner`) REFERENCES `owner` (`id_owner`),
  ADD CONSTRAINT `apartment_ibfk_3` FOREIGN KEY (`id_town`) REFERENCES `town` (`id_town`);

--
-- Constraints for table `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `images_ibfk_1` FOREIGN KEY (`id_apartment`) REFERENCES `apartment` (`id_apartment`);

--
-- Constraints for table `poi`
--
ALTER TABLE `poi`
  ADD CONSTRAINT `poi_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`),
  ADD CONSTRAINT `poi_ibfk_2` FOREIGN KEY (`id_address`) REFERENCES `address` (`id_address`),
  ADD CONSTRAINT `poi_ibfk_3` FOREIGN KEY (`id_town`) REFERENCES `town` (`id_town`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
