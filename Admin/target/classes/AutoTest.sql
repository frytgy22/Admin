SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `AutoTest`
--
CREATE DATABASE IF NOT EXISTS `AutoTest` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `AutoTest`;

-- --------------------------------------------------------

--
-- Table structure for table `Admins`
--

CREATE TABLE IF NOT EXISTS `Admins` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(20),
  PRIMARY KEY (`adminID`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `Admins`
--

INSERT INTO `Admins` (`adminID`, `login`, `password`, `name`) VALUES
(1, "admin", "123", "name");

-- --------------------------------------------------------

--
-- Table structure for table `Groups`
--

CREATE TABLE IF NOT EXISTS `Groups` (
  `groupID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`groupID`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `GroupsStudents`
--

CREATE TABLE IF NOT EXISTS `GroupsStudents` (
  `groupID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  KEY `fk1_groups_students` (`groupID`),
  KEY `fk2_groups_students` (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `GroupsSubjects`
--

CREATE TABLE IF NOT EXISTS `GroupsSubjects` (
  `groupID` int(11) NOT NULL,
  `subjectID` int(11) NOT NULL,
  KEY `fk1_groups_subjects` (`groupID`),
  KEY `fk2_groups_subjects` (`subjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `GroupsTeachers`
--

CREATE TABLE IF NOT EXISTS `GroupsTeachers` (
  `groupID` int(11) NOT NULL,
  `teacherID` int(11) NOT NULL,
  KEY `fk1_groups_teachers` (`groupID`),
  KEY `fk2_groups_teachers` (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Roles`
--

CREATE TABLE IF NOT EXISTS `Roles` (
  `roleID` int(11) NOT NULL AUTO_INCREMENT,
  `role` set('STUDENT','USER','ADMIN') NOT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Roles`
--

INSERT INTO `Roles` (`roleID`, `role`) VALUES
(1, "STUDENT"),
(2, "USER"),
(3, "ADMIN");

-- --------------------------------------------------------

--
-- Table structure for table `RolesAdmins`
--

CREATE TABLE IF NOT EXISTS `RolesAdmins` (
  `roleID` int(11) NOT NULL,
  `adminID` int(11) NOT NULL,
  KEY `fk1_roles_admins` (`roleID`),
  KEY `fk2_roles_admins` (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `RolesAdmins`
--

INSERT INTO `RolesAdmins` (`roleID`, `adminID`) VALUES
(3, 1);
-- --------------------------------------------------------

--
-- Table structure for table `RolesTeachers`
--

CREATE TABLE IF NOT EXISTS `RolesTeachers` (
  `roleID` int(11) NOT NULL,
  `teacherID` int(11) NOT NULL,
  KEY `fk1_roles_teachers` (`roleID`),
  KEY `fk2_roles_teachers` (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Students`
--

CREATE TABLE IF NOT EXISTS `Students` (
  `studentID` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name`varchar(255) NOT NULL,
  `phone`varchar(20),
  `roleID` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`studentID`),
  UNIQUE KEY `login` (`login`),
  KEY `fk_students_roles` (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Subjects`
--

CREATE TABLE IF NOT EXISTS `Subjects` (
  `subjectID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`subjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Teachers`
--

CREATE TABLE IF NOT EXISTS `Teachers` (
  `teacherID` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name`varchar(255) NOT NULL,
  `phone`varchar(20),
  PRIMARY KEY (`teacherID`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `GroupsStudents`
--
ALTER TABLE `GroupsStudents`
  ADD CONSTRAINT `fk1_groups_students` FOREIGN KEY (`groupID`) REFERENCES `Groups` (`groupID`) ON DELETE CASCADE;,
  ADD CONSTRAINT `fk2_groups_students` FOREIGN KEY (`studentID`) REFERENCES `Students` (`studentID`) ON DELETE CASCADE;;

--
-- Constraints for table `GroupsSubjects`
--
ALTER TABLE `GroupsSubjects`
  ADD CONSTRAINT `fk1_groups_subjects` FOREIGN KEY (`groupID`) REFERENCES `Groups` (`groupID`) ON DELETE CASCADE;,
  ADD CONSTRAINT `fk2_groups_subjects` FOREIGN KEY (`subjectID`) REFERENCES `Subjects` (`subjectID`) ON DELETE CASCADE;;

--
-- Constraints for table `GroupsTeachers`
--
ALTER TABLE `GroupsTeachers`
  ADD CONSTRAINT `fk1_groups_teachers` FOREIGN KEY (`groupID`) REFERENCES `Groups` (`groupID`) ON DELETE CASCADE;,
  ADD CONSTRAINT `fk2_groups_teachers` FOREIGN KEY (`teacherID`) REFERENCES `Teachers` (`teacherID`) ON DELETE CASCADE;;

--
-- Constraints for table `RolesAdmins`
--
ALTER TABLE `RolesAdmins`
  ADD CONSTRAINT `fk1_roles_admins` FOREIGN KEY (`roleID`) REFERENCES `Roles` (`roleID`) ON DELETE CASCADE;,
  ADD CONSTRAINT `fk2_roles_admins` FOREIGN KEY (`adminID`) REFERENCES `Admins` (`adminID`) ON DELETE CASCADE;;

--
-- Constraints for table `RolesTeachers`
--
ALTER TABLE `RolesTeachers`
  ADD CONSTRAINT `fk1_roles_teachers` FOREIGN KEY (`roleID`) REFERENCES `Roles` (`roleID`) ON DELETE CASCADE;,
  ADD CONSTRAINT `fk2_roles_teachers` FOREIGN KEY (`teacherID`) REFERENCES `Teachers` (`teacherID`) ON DELETE CASCADE;;

--
-- Constraints for table `Students`
--
ALTER TABLE `Students`
  ADD CONSTRAINT `fk_students_roles` FOREIGN KEY (`roleID`) REFERENCES `Roles` (`roleID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
