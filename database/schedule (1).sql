-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 20, 2024 at 10:03 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `roomreservationsysteminuniversity`
--

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `Teacher_id` int(100) NOT NULL,
  `Teacher_Name` varchar(255) NOT NULL,
  `Day` varchar(255) NOT NULL,
  `Slot` varchar(255) DEFAULT NULL,
  `Room` varchar(255) NOT NULL,
  `Section` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`Teacher_id`, `Teacher_Name`, `Day`, `Slot`, `Room`, `Section`) VALUES
(5, 'Syed Hassan', 'Monday', '11 - 1', 'LAB-4 ', '2B'),
(5, 'Syed Hassan', 'Tuesday', '8 - 11\r\n', 'CS LAB', '2B'),
(5, 'Syed Hassan', 'Friday', '11 - 1', 'Smart LAB', '2B'),
(5, 'Syed Hassan', 'Thursday', '3 - 6', 'LAB 4', '2B'),
(6, 'Syed Hurrar Hasan Rizvi', 'Monday', '8 - 11', 'CS LAB', '2A'),
(6, 'Syed Hurrar Hasan Rizvi', 'Wednesday', '3 - 6', 'AI LAB', '2A'),
(6, 'Syed Hurrar Hasan Rizvi', 'Saturday', '8 - 11', 'CS LAB', '2A'),
(6, 'Syed Hurrar Hasan Rizvi', 'Friday', '3 - 6', 'Smart Lab', '2A'),
(7, 'Usama Khalid', 'Tuesday', '3 - 6', 'LAB 4', '1B'),
(7, 'Usama Khalid', 'Wednesday', '11 - 1', 'Smart LAB', '1B'),
(7, 'Usama Khalid', 'Friday', '8 - 11', 'AI LAB', '1B');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD KEY `fk_Teacher` (`Teacher_id`),
  ADD KEY `fk_teacher_name` (`Teacher_Name`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `fk_Teacher` FOREIGN KEY (`Teacher_id`) REFERENCES `teacher` (`Teacher_id`),
  ADD CONSTRAINT `fk_teacher_name` FOREIGN KEY (`Teacher_Name`) REFERENCES `teacher` (`Teacher_Name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
