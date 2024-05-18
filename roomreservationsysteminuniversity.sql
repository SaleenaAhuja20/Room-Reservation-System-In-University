-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 17, 2024 at 02:48 PM
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
('Syed Hurrar Hassan Rizvi\r\n', 'syed.hurrar@szabist.pk', 'Rizvi#123', 'Object Oriented Programming Lab', 3),
('SYED HASSAN', 'syed.hassan@szabist.pk', 'syed.123', 'Object Oriented Programming', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`Teacher_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `Teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


// time table schedule table
create table TimeTable(
emailAddress varchar(250),
subjectName varchar(250),
dayName varchar(250),
timings varchar(250),
class varchar(250),
RoomNo varchar(250),
BuildingName varchar(250)
);


insert into  TimeTable values("syed.hassan@gmail.com","OOPS Theory",'Thursday' ,"3-6","BSCS2B", 502, '100');
insert into  TimeTable values("syed.hassan@gmail.com","OOPS Theory",'Monday' ,"8-11","BSCS2A", 502, '100');
insert into  TimeTable values("hurairizvi@gmail.com","OOPS LAB",'Friday' ,"10-01","BSCS2B", 102, '90');

