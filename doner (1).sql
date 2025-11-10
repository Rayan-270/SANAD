-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 30, 2025 at 06:23 PM
-- Server version: 8.0.17
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sanad`
--

-- --------------------------------------------------------

--
-- Table structure for table `doner`
--

CREATE TABLE `doner` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `helptype` varchar(100) NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `facbook` varchar(100) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `zone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `doner`
--

INSERT INTO `doner` (`id`, `name`, `helptype`, `phone`, `facbook`, `email`, `zone`) VALUES
(1, 'sanad', 'food', '123456', 'sanadcharity.com', '123456', 'fashir'),
(2, 'unicif', 'orphanage', '123456', 'unicef.com', '123456', 'fashir'),
(3, 'alsahwa', 'medicine', '55599900', 'alsahwa.com', '55599900', 'aldabbah'),
(4, 'alsahwa', 'medicine', '55599900', 'alsahwa.com', '55599900', 'aldabbah'),
(5, 'sanad', 'food', '123456', 'sanadcharity.com', 'food@sanad', 'fashir'),
(6, 'sanad', 'food', '123456', 'sanadcharity.com', 'food@sanad', 'fashir'),
(7, 'alsahwa', 'medicine', '55599900', 'alsahwa.com', '55599900', 'aldabbah');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doner`
--
ALTER TABLE `doner`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doner`
--
ALTER TABLE `doner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
