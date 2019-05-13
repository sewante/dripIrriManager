-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2019 at 11:16 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dripirrimanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `crop`
--

CREATE TABLE `crop` (
  `cropId` int(3) UNSIGNED NOT NULL,
  `cropcategory` int(11) NOT NULL,
  `name` varchar(15) NOT NULL,
  `grossirrrequirement` float UNSIGNED DEFAULT NULL,
  `shallowRootDepth` float UNSIGNED NOT NULL,
  `deepRootDepth` float NOT NULL,
  `cropspacing` float UNSIGNED NOT NULL,
  `rowspacing` float NOT NULL,
  `initialKc` float NOT NULL,
  `midKc` float NOT NULL,
  `lateKc` float NOT NULL,
  `plantingScheme` enum('sparse','dense') DEFAULT NULL,
  `datecreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `crop`
--

INSERT INTO `crop` (`cropId`, `cropcategory`, `name`, `grossirrrequirement`, `shallowRootDepth`, `deepRootDepth`, `cropspacing`, `rowspacing`, `initialKc`, `midKc`, `lateKc`, `plantingScheme`, `datecreated`) VALUES
(1, 1, 'Onions-green', NULL, 0.3, 0.5, 0.08, 0.15, 0.7, 0.95, 0.75, 'dense', '2019-04-26 10:52:16'),
(2, 1, 'Onions-dry', NULL, 0.3, 0.5, 0.08, 0.15, 0.7, 0.95, 0.75, 'dense', '2019-04-26 11:04:49'),
(3, 1, 'carrots', NULL, 0.4, 0.7, 0.1, 0.45, 0.7, 1, 0.75, 'dense', '2019-05-03 13:27:26'),
(4, 1, 'Cabbage', NULL, 0.4, 0.6, 0.45, 0.45, 0.7, 1, 0.85, 'dense', '2019-05-04 11:52:36'),
(5, 1, 'Radish', NULL, 0.3, 0.3, 0.1, 0.45, 0.7, 0.95, 0.75, 'dense', '2019-05-04 20:08:02'),
(6, 2, 'Egg Plant', NULL, 0.4, 0.6, 0.91, 0.6, 0.7, 1, 0.85, 'dense', '2019-05-04 20:12:06'),
(7, 2, 'Tomatoes', NULL, 0.6, 1.2, 0.6, 0.6, 0.7, 1.1, 0.6, 'dense', '2019-05-04 20:14:57'),
(8, 3, 'Cucumber', NULL, 0.5, 1, 1.5, 2, 0.6, 0.9, 0.8, 'dense', '2019-05-09 06:41:51'),
(9, 4, 'Irish Potatoes', NULL, 0.4, 0.6, 0.2, 0.6, 0.5, 1.1, 0.47, 'sparse', '2019-05-09 06:44:48');

-- --------------------------------------------------------

--
-- Table structure for table `cropcategories`
--

CREATE TABLE `cropcategories` (
  `categoryId` int(11) NOT NULL,
  `categoryName` varchar(30) NOT NULL,
  `avgRootDepth` float NOT NULL COMMENT 'average root depth',
  `initialKc` float NOT NULL,
  `midKc` float NOT NULL,
  `lateKc` float NOT NULL,
  `foASoilWater` float NOT NULL COMMENT 'fraction of available soil water'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cropcategories`
--

INSERT INTO `cropcategories` (`categoryId`, `categoryName`, `avgRootDepth`, `initialKc`, `midKc`, `lateKc`, `foASoilWater`) VALUES
(1, 'Small Vegetables', 0.4, 0.7, 0.95, 0.75, 0.25),
(2, 'Solanum Vegetables', 0.6, 0.6, 1.05, 0.75, 0.3),
(3, 'Cucumber Vegetables', 0.6, 0.5, 0.95, 0.7, 0.45),
(4, 'Roots and Tubbers', 0.5, 0.5, 1.1, 0.47, 0.3),
(5, 'Legumes', 0.5, 0.45, 1, 0.5, 0.4),
(6, 'Fibre Crops', 1.2, 0.3, 1.1, 0.5, 0.6),
(7, 'Oil Crops', 1, 0.35, 1.1, 0.4, 0.6),
(8, 'Cereals', 1.2, 0.35, 1.1, 0.3, 0.55),
(9, 'Sugarcane', 0.9, 0.5, 1.15, 0.65, 0.55),
(10, 'Tropical Fruits', 1.2, 0.8, 1, 0.6, 0.55),
(11, 'Fruit Trees', 1.5, 0.8, 1, 0.6, 0.5),
(12, 'Pasture and Fodder', 0.7, 0.35, 1.1, 0.3, 0.5),
(13, 'Divers Vegetables', 0.8, 0.6, 0.9, 0.7, 0.5),
(14, 'Grapes and Berries', 1, 0.8, 0.8, 0.65, 0.5);

-- --------------------------------------------------------

--
-- Table structure for table `emitter`
--

CREATE TABLE `emitter` (
  `emitterId` int(3) UNSIGNED NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `modelName` varchar(300) NOT NULL,
  `inletType` varchar(100) NOT NULL,
  `color` varchar(50) NOT NULL,
  `filtration` int(4) NOT NULL,
  `flowrate` float UNSIGNED NOT NULL,
  `lifetime` int(3) UNSIGNED DEFAULT NULL,
  `cost` float UNSIGNED NOT NULL,
  `datecreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `emitter`
--

INSERT INTO `emitter` (`emitterId`, `category`, `modelName`, `inletType`, `color`, `filtration`, `flowrate`, `lifetime`, `cost`, `datecreated`) VALUES
(1, 'Dripper', 'XB-05PC', 'Barb', 'Blue', 75, 1.89, NULL, 2400, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `pipe`
--

CREATE TABLE `pipe` (
  `pipeId` int(3) UNSIGNED NOT NULL,
  `pipecategory` varchar(9) NOT NULL,
  `pressurerating` float NOT NULL,
  `internaldiameter` float UNSIGNED NOT NULL,
  `cost` float UNSIGNED NOT NULL,
  `lifetime` int(3) UNSIGNED NOT NULL,
  `material` varchar(10) NOT NULL,
  `datecreated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `pipecategory`
--

CREATE TABLE `pipecategory` (
  `categoryId` int(11) NOT NULL,
  `categoryName` varchar(20) NOT NULL,
  `type` enum('blank tubing','dripline') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `pipedripline`
--

CREATE TABLE `pipedripline` (
  `pipeId` int(11) NOT NULL,
  `modelName` varchar(30) NOT NULL,
  `flowRate` float NOT NULL,
  `color` varchar(20) NOT NULL COMMENT 'internal diameter',
  `interDiameter` float NOT NULL COMMENT 'external diameter',
  `exterDiameter` float NOT NULL,
  `coilLength` float NOT NULL,
  `material` varchar(40) NOT NULL,
  `cost` float NOT NULL,
  `comments` text NOT NULL,
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `emitterSpacing` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pipedripline`
--

INSERT INTO `pipedripline` (`pipeId`, `modelName`, `flowRate`, `color`, `interDiameter`, `exterDiameter`, `coilLength`, `material`, `cost`, `comments`, `dateCreated`, `emitterSpacing`) VALUES
(1, '1/4\" Landscape Dripline', 3.03, 'Brown', 0.17, 0.25, 100, 'Linear Low Density Polyethylene LLDPE', 6100, 'Flexible tubing with dog-resistant built-in filtration', '2019-05-09 06:27:38', 6),
(2, 'XFD On-Surface Dripline', 2.271, 'Brown', 0.536, 0.634, 250, 'Linear Low Density Polyethylene LLDPE', 15240, 'Extra flexible and dual-layered', '2019-05-09 06:31:20', 12),
(3, 'XFCV Dripline', 3.40686, 'Brown', 0.536, 0.634, 500, 'Linear Low Density Polyethylene LLDPE', 30480, 'Built-in check valve', '2019-05-09 06:34:26', 18);

-- --------------------------------------------------------

--
-- Table structure for table `pipelateral`
--

CREATE TABLE `pipelateral` (
  `pipeId` int(11) NOT NULL,
  `modelName` varchar(30) NOT NULL,
  `flowRate` float NOT NULL,
  `color` varchar(20) NOT NULL,
  `interDiameter` float NOT NULL COMMENT 'internal diameter',
  `exterDiameter` float NOT NULL COMMENT 'external diameter',
  `coilLength` float NOT NULL,
  `material` varchar(40) NOT NULL,
  `cost` float NOT NULL,
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pipelateral`
--

INSERT INTO `pipelateral` (`pipeId`, `modelName`, `flowRate`, `color`, `interDiameter`, `exterDiameter`, `coilLength`, `material`, `cost`, `dateCreated`) VALUES
(1, 'XFS-CV Sub-Surface Dripline', 1.51416, 'Black', 0.6, 0.7, 100, 'Low Density Polyethylene LDPE', 6100, '2019-05-09 06:20:43'),
(2, 'XT-700', 1.514, 'Black', 0.58, 0.7, 500, 'Linear Low Density Polyethylene LLDPE', 30480, '2019-05-09 06:37:04');

-- --------------------------------------------------------

--
-- Table structure for table `pipemain`
--

CREATE TABLE `pipemain` (
  `pipeId` int(11) NOT NULL,
  `modelName` varchar(30) NOT NULL,
  `flowRate` float NOT NULL,
  `color` varchar(20) NOT NULL,
  `interDiameter` float NOT NULL COMMENT 'internal diameter',
  `exterDiameter` float NOT NULL COMMENT 'external diameter',
  `coilLength` float NOT NULL,
  `material` varchar(40) NOT NULL,
  `cost` float NOT NULL,
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `soil`
--

CREATE TABLE `soil` (
  `soilId` int(3) UNSIGNED NOT NULL,
  `type` varchar(15) NOT NULL,
  `soilwaterholdingcap` float UNSIGNED NOT NULL,
  `sathydrconductivity` float NOT NULL,
  `datecreated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userId` int(1) UNSIGNED NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `category` varchar(15) NOT NULL,
  `datecreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userId`, `username`, `password`, `contact`, `email`, `category`, `datecreated`) VALUES
(1, 'admin', 'wavez', '0704066878', 'mwesirob@gmail.com', 'admin', '2019-02-27 23:35:10'),
(2, 'mugabi', 'mugabi', '0779350769', 'oscar.mugabi@yahoo', '', '2019-04-24 10:26:20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `crop`
--
ALTER TABLE `crop`
  ADD PRIMARY KEY (`cropId`);

--
-- Indexes for table `cropcategories`
--
ALTER TABLE `cropcategories`
  ADD PRIMARY KEY (`categoryId`);

--
-- Indexes for table `emitter`
--
ALTER TABLE `emitter`
  ADD PRIMARY KEY (`emitterId`);

--
-- Indexes for table `pipe`
--
ALTER TABLE `pipe`
  ADD PRIMARY KEY (`pipeId`);

--
-- Indexes for table `pipecategory`
--
ALTER TABLE `pipecategory`
  ADD PRIMARY KEY (`categoryId`);

--
-- Indexes for table `pipedripline`
--
ALTER TABLE `pipedripline`
  ADD PRIMARY KEY (`pipeId`);

--
-- Indexes for table `pipelateral`
--
ALTER TABLE `pipelateral`
  ADD PRIMARY KEY (`pipeId`);

--
-- Indexes for table `pipemain`
--
ALTER TABLE `pipemain`
  ADD PRIMARY KEY (`pipeId`);

--
-- Indexes for table `soil`
--
ALTER TABLE `soil`
  ADD PRIMARY KEY (`soilId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `crop`
--
ALTER TABLE `crop`
  MODIFY `cropId` int(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `cropcategories`
--
ALTER TABLE `cropcategories`
  MODIFY `categoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `emitter`
--
ALTER TABLE `emitter`
  MODIFY `emitterId` int(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `pipe`
--
ALTER TABLE `pipe`
  MODIFY `pipeId` int(3) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pipecategory`
--
ALTER TABLE `pipecategory`
  MODIFY `categoryId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pipedripline`
--
ALTER TABLE `pipedripline`
  MODIFY `pipeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `pipelateral`
--
ALTER TABLE `pipelateral`
  MODIFY `pipeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pipemain`
--
ALTER TABLE `pipemain`
  MODIFY `pipeId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `soil`
--
ALTER TABLE `soil`
  MODIFY `soilId` int(3) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(1) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
