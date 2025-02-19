-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 19, 2025 at 07:18 PM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agritech`
--

-- --------------------------------------------------------

--
-- Table structure for table `farmers`
--

DROP TABLE IF EXISTS `farmers`;
CREATE TABLE IF NOT EXISTS `farmers` (
  `farmer_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`farmer_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `farmers`
--

INSERT INTO `farmers` (`farmer_id`, `name`, `email`, `password`, `location`, `phone_number`, `created_at`) VALUES
(1, 'John Doe', 'john.doe@example.com', 'hashed_password_1', 'Village A', '1234567890', '2024-09-23 15:23:40'),
(2, 'Jane Smith', 'jane.smith@example.com', 'hashed_password_2', 'Village B', '0987654321', '2024-09-23 15:23:40'),
(3, 'Mike Johnson', 'mike.johnson@example.com', 'hashed_password_3', 'Village C', '1122334455', '2024-09-23 15:23:40'),
(4, 'Emily Davis', 'emily.davis@example.com', 'hashed_password_4', 'Village D', '5566778899', '2024-09-23 15:23:40'),
(5, 'Sarah Wilson', 'sarah.wilson@example.com', 'hashed_password_5', 'Village E', '2233445566', '2024-09-23 15:23:40'),
(6, 'chimtu', 'chimtu@gmail.com', 'Chimtu@143', 'vellore', '6302373595', '2024-09-23 15:57:00'),
(7, 'Nithish', 'Nithish@gmail.com', 'Chimtu@143', 'T.M Manu', '9492235036', '2024-09-23 15:58:47'),
(8, 'RaviTeja', 'Raviteja@gmail.com', 'Chimtu@123', 'T.M Manu', '0987654321', '2024-10-08 03:08:03');

-- --------------------------------------------------------

--
-- Table structure for table `farmer_booking`
--

DROP TABLE IF EXISTS `farmer_booking`;
CREATE TABLE IF NOT EXISTS `farmer_booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `farmer_id` int NOT NULL,
  `tractor_owner_id` int NOT NULL,
  `slots` varchar(255) NOT NULL,
  `booking_date` date NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `farmer_id` (`farmer_id`),
  KEY `tractor_owner_id` (`tractor_owner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `farmer_booking`
--

INSERT INTO `farmer_booking` (`booking_id`, `farmer_id`, `tractor_owner_id`, `slots`, `booking_date`) VALUES
(1, 7, 1, 'slot2,slot4,', '2024-09-28'),
(2, 7, 1, 'slot1,slot5,', '2024-09-28'),
(3, 7, 1, 'slot3,', '2024-09-28'),
(4, 7, 1, 'slot7,slot9,', '2024-09-28'),
(5, 7, 1, 'slot1,slot2,', '2024-10-05'),
(6, 7, 1, 'slot1,slot5,', '2024-10-08'),
(7, 8, 1, 'slot6,slot8,', '2024-10-08'),
(8, 7, 1, 'slot2,slot3,', '2024-10-08'),
(9, 7, 1, 'slot1,slot2,', '2024-11-06'),
(10, 7, 1, 'slot1,', '2024-11-12'),
(11, 7, 1, 'slot2,slot3,', '2024-11-12'),
(12, 7, 1, 'slot1,slot2,', '2025-01-24'),
(13, 7, 1, 'slot1,slot2,', '2025-02-15'),
(14, 7, 1, 'slot1,slot5,', '2025-02-20');

-- --------------------------------------------------------

--
-- Table structure for table `landrent`
--

DROP TABLE IF EXISTS `landrent`;
CREATE TABLE IF NOT EXISTS `landrent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `farmer_name` varchar(100) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `water_availability` varchar(50) DEFAULT NULL,
  `land_area` int DEFAULT NULL,
  `rent_period` int DEFAULT NULL,
  `rent_price` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `farmer_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_farmer_id` (`farmer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `landrent`
--

INSERT INTO `landrent` (`id`, `farmer_name`, `location`, `water_availability`, `land_area`, `rent_period`, `rent_price`, `created_at`, `farmer_id`) VALUES
(1, 'Nithish', 'vellore', 'Yes', 3, 3, 10000, '2024-09-24 18:07:19', 0),
(2, 'chimtu', 'T.M Manu', 'Yes', 4, 6, 10000, '2024-09-27 17:07:32', 0),
(3, 'New Farmer', 'New Location', 'Yes', 5, 12, 20000, '2024-09-27 17:19:33', 1),
(4, 'Nithish', 'T.M Manu', 'Yes', 6, 4, 10000, '2024-09-27 18:32:28', 7);

--
-- Triggers `landrent`
--
DROP TRIGGER IF EXISTS `after_landrent_insert`;
DELIMITER $$
CREATE TRIGGER `after_landrent_insert` AFTER INSERT ON `landrent` FOR EACH ROW BEGIN
    INSERT INTO LandStatus (land_id, farmer_id, availability)
    VALUES (NEW.id, NEW.farmer_id, 'Yes');
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `landstatus`
--

DROP TABLE IF EXISTS `landstatus`;
CREATE TABLE IF NOT EXISTS `landstatus` (
  `land_id` int NOT NULL,
  `farmer_id` int NOT NULL,
  `availability` enum('Yes','No') NOT NULL DEFAULT 'Yes',
  KEY `land_id` (`land_id`),
  KEY `farmer_id` (`farmer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `landstatus`
--

INSERT INTO `landstatus` (`land_id`, `farmer_id`, `availability`) VALUES
(3, 1, 'Yes'),
(4, 7, 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `slots`
--

DROP TABLE IF EXISTS `slots`;
CREATE TABLE IF NOT EXISTS `slots` (
  `tractor_id` int NOT NULL,
  `date` date NOT NULL,
  `slot1` tinyint(1) DEFAULT '0',
  `slot2` tinyint(1) DEFAULT '0',
  `slot3` tinyint(1) DEFAULT '0',
  `slot4` tinyint(1) DEFAULT '0',
  `slot5` tinyint(1) DEFAULT '0',
  `slot6` tinyint(1) DEFAULT '0',
  `slot7` tinyint(1) DEFAULT '0',
  `slot8` tinyint(1) DEFAULT '0',
  `slot9` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`tractor_id`,`date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `slots`
--

INSERT INTO `slots` (`tractor_id`, `date`, `slot1`, `slot2`, `slot3`, `slot4`, `slot5`, `slot6`, `slot7`, `slot8`, `slot9`) VALUES
(1, '2024-09-27', 1, 1, 1, 1, 1, 0, 0, 0, 0),
(1, '2024-09-28', 1, 0, 1, 0, 1, 0, 1, 0, 1),
(1, '2024-09-29', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-09-30', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-01', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-02', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-03', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-04', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-05', 1, 1, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-06', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-07', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-08', 1, 1, 1, 0, 1, 1, 0, 1, 0),
(1, '2024-10-09', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-10', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-11', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-12', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-13', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-14', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-15', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-16', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-17', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-18', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-19', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-20', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-21', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-22', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-23', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-24', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-25', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-26', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-27', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-28', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-29', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-30', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-10-31', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-11-01', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-11-02', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-11-03', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-11-04', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-11-05', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-11-06', 1, 1, 0, 0, 0, 0, 0, 0, 0),
(1, '2024-11-12', 1, 1, 1, 0, 0, 0, 0, 0, 0),
(1, '2025-01-24', 1, 1, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-01-25', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-01-26', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-01-27', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-01-28', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-01-29', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-01-30', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-01-31', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-01', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-02', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-03', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-04', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-05', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-06', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-07', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-08', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-09', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-10', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-11', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-12', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-13', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-14', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-15', 1, 1, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-16', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-17', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-18', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-19', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-20', 1, 0, 0, 0, 1, 0, 0, 0, 0),
(1, '2025-02-21', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(1, '2025-02-22', 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tractorowner`
--

DROP TABLE IF EXISTS `tractorowner`;
CREATE TABLE IF NOT EXISTS `tractorowner` (
  `owner_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `phone_number` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`owner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tractorowner`
--

INSERT INTO `tractorowner` (`owner_id`, `name`, `email`, `password`, `location`, `created_at`, `phone_number`) VALUES
(1, 'Nithish', 'nithish@gmail.com', 'Chimtu@143', 'T.M Manu', '2024-09-27 05:07:53', '9441057037');

-- --------------------------------------------------------

--
-- Table structure for table `tractors`
--

DROP TABLE IF EXISTS `tractors`;
CREATE TABLE IF NOT EXISTS `tractors` (
  `tractor_id` int NOT NULL AUTO_INCREMENT,
  `owner_id` int DEFAULT NULL,
  `tractor_name` varchar(100) DEFAULT NULL,
  `equipment_list` text,
  `location` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`tractor_id`),
  KEY `fk_owner` (`owner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tractors`
--

INSERT INTO `tractors` (`tractor_id`, `owner_id`, `tractor_name`, `equipment_list`, `location`, `created_at`) VALUES
(1, 1, 'John Deere 5075E', 'Plow, Harrow, Seeder', 'T.M Manu', '2024-09-24 15:12:26');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
