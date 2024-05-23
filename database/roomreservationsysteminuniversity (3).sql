-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 20, 2024 at 12:59 PM
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
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Admin_Name` varchar(255) NOT NULL,
  `Admin_Email` varchar(255) NOT NULL,
  `Admin_Password` varchar(255) NOT NULL,
  `Admin_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Admin_Name`, `Admin_Email`, `Admin_Password`, `Admin_Id`) VALUES
('Sahil Kumar Valecha', 'bscs2312172@szabist.pk', 'szabist+-72', 1),
('Saleena Ahuja', 'bscs2312174@szabist.pk', 'Ahuja038#', 2),
('Paras Parveen', 'bscs2312168@szabist.pk', 'paras#123', 3);

-- --------------------------------------------------------

--
-- Table structure for table `makeupform`
--

CREATE TABLE `makeupform` (
`Id`  int auto_increment not null primary key,
  `TeacherId` int Not Null,
  `Course` varchar(255) NOT NULL,
  `section` varchar(255) NOT NULL,
  `day` varchar(255) NOT NULL,
  `slot` varchar(255) NOT NULL,
  `capacity_of_students` int NOT NULL,
  `request_status` varchar(250)
);
--
-- Dumping data for table `makeupform`
--

INSERT INTO `makeupform` (`TeacherId`,`Course`, `section`, `day`, `slot`, `capacity_of_students`,`request_status` ) VALUES
(7, 'Object Oriented Programming', '2B', 'Wednesday', '8-11', 30, 'Pending');

-- --------------------------------------------------------

--- Room Table

Create table Room (
roomId int auto_increment not null primary key,
RoomNo int unique,
Capacity int not null,
BuildingName varchar(250) not null
)

-- Room Booking Table
Create table RoomBooking (
teacherId int not null,
roomId int not null,
slot varchar(250),
day varchar(250)
)

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
) 

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

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `Teacher_Name` varchar(255) NOT NULL,
  `Teacher_Email` varchar(255) NOT NULL,
  `Teacher_Password` varchar(255) NOT NULL,
  `Course` varchar(255) NOT NULL,
  `Teacher_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`Teacher_Name`, `Teacher_Email`, `Teacher_Password`, `Course`, `Teacher_id`) VALUES
('Syed Hassan', 'syed.hassan@szabist.pk', 'syed.123', 'Object Oriented Programming', 5),
('Syed Hurrar Hasan Rizvi', 'syed.hurrar@szabist.pk', 'Rizvi#123', 'Object Oriented Programming Lab', 6),
('Usama Khalid', 'usama.khalid@szabist.pk', 'abc.123', 'Fundamental Of Programming ', 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Admin_Id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD KEY `fk_Teacher` (`Teacher_id`),
  ADD KEY `fk_teacher_name` (`Teacher_Name`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`Teacher_id`),
  ADD UNIQUE KEY `Teacher_Name` (`Teacher_Name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `Admin_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `Teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
