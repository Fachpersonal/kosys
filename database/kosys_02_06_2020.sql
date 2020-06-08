-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2020 at 08:22 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kosys`
--

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(11) NOT NULL,
  `username` text NOT NULL,
  `power` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `onlineStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `username`, `power`, `email`, `password`, `onlineStatus`) VALUES
(0, 'falscherIdiot', 2, 'falscherIdiot@gmail.com', 'admin', 1),
(1, 'gomfol12', 2, 'gomfol12@gmail.com', 'admin2', 0),
(2, 'Menimus', 1, 'Menimus@gmail.com', 'affe', 1),
(3, 'Noven', 0, 'Noven@gmail.com', 'user', 0);

-- --------------------------------------------------------

--
-- Table structure for table `todo`
--

CREATE TABLE `todo` (
  `id` tinyint(4) NOT NULL,
  `title` tinytext NOT NULL,
  `user` tinytext NOT NULL,
  `status` tinyint(4) NOT NULL,
  `commitdate` datetime NOT NULL,
  `finishdate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `todo`
--

INSERT INTO `todo` (`id`, `title`, `user`, `status`, `commitdate`, `finishdate`) VALUES
(0, 'todo', 'falscherIdiot', 3, '2020-06-01 16:57:40', '2020-06-01 18:57:40');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `todo`
--
ALTER TABLE `todo`
  ADD UNIQUE KEY `UNIQUE` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
