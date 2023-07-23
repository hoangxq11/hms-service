-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: yocare_clinic
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password_hash` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `authority_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_k8h1bgqoplx0rkngj01pm1rgp` (`username`),
  UNIQUE KEY `UK_n7ihswpy07ci568w34q0oi8he` (`email`),
  KEY `FKtgkaqcesrvakbxvi4etukjwku` (`authority_id`),
  CONSTRAINT `FKtgkaqcesrvakbxvi4etukjwku` FOREIGN KEY (`authority_id`) REFERENCES `authorities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (12,'admin@gmail.com','$2a$10$0FqoVRGMbltSpyxl9psHAOlu6D.frjHMygwO/Qv/aQozJUMfP7zUC','admin',3),(13,'patient1@gmail.com','$2a$10$xwj/yX4s0rsU4OZ61z8Z9eYtAxzIXfFg8ObxireqCRna7rJ1GwJBO','patient1',1),(14,'doctor1@gmail.com','$2a$10$AFun/AbCp8LcC7AGYLxdYuTOuHzpWaJis57UFQf202AMi3yFJnTiS','doctor1',4),(15,'nursing1@gmail.com','$2a$10$5K6GGEg0.KrK90Codq1uKefHq1vx150rtuBVEqi3Co/MimDD7iim2','nursing1',2),(16,'0475836574@gmail.com','$2a$10$Awbq9W4p6QG225iALhfSqeSxZ3cQ4BC47BRYorNjaClQ6gTYcSfuC','0475836574',1),(17,'0905138346@gmail.com','$2a$10$IKw0.UXFyBnB.OEEB7UH3.eJe/e.O1mGAch59VCl6i/FG1bsbRCXm','0905138346',4),(18,'hoangxq01@gmail.com','$2a$10$47rA9HLb9a7VlceUMPyJGebGZRoByYVCPHzz2dzETPu.HFTKFKO/C','hoangxq01',1);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment_schedules`
--

DROP TABLE IF EXISTS `appointment_schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment_schedules` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `time_frame` varchar(255) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `staff_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkp0v2vk1gf5379p6mrnd4ii1y` (`patient_id`),
  KEY `FKl4d79gbl9793n58wqa7xygfsf` (`staff_id`),
  CONSTRAINT `FKkp0v2vk1gf5379p6mrnd4ii1y` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKl4d79gbl9793n58wqa7xygfsf` FOREIGN KEY (`staff_id`) REFERENCES `staffs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment_schedules`
--

LOCK TABLES `appointment_schedules` WRITE;
/*!40000 ALTER TABLE `appointment_schedules` DISABLE KEYS */;
INSERT INTO `appointment_schedules` VALUES (4,'DONE','2023-07-19','8:30 - 9:00',10,3),(5,'DONE','2023-07-18','7:30 - 8:00',9,3),(6,'DONE','2023-08-02','8:00 - 8:30',9,3),(7,'DONE','2023-08-05','8:30 - 9:00',9,3),(8,'DONE','2023-08-03','9:00 - 9:30',9,5),(9,'DONE','2023-07-25','8:30 - 9:00',9,3),(10,'CANCELED','2023-07-28','7:00 - 7:30',9,3);
/*!40000 ALTER TABLE `appointment_schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `id` int NOT NULL,
  `description` longtext,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,NULL,'ROLE_PATIENT'),(2,NULL,'ROLE_NURSING'),(3,NULL,'ROLE_ADMIN'),(4,NULL,'ROLE_DOCTOR');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expertises`
--

DROP TABLE IF EXISTS `expertises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expertises` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expertises`
--

LOCK TABLES `expertises` WRITE;
/*!40000 ALTER TABLE `expertises` DISABLE KEYS */;
INSERT INTO `expertises` VALUES (1,'Bác sĩ chuyên khoa',''),(2,'Trưởng khoa - Phụ trách PK Ngoại',NULL),(3,'Phòng khám Nội',NULL),(4,'Phòng khám Nhi',NULL),(5,'Phòng khám Mắt',NULL),(6,'Phòng khám Tai mũi họng',NULL),(7,'Điều dưỡng viên',NULL),(8,'Hành chính',NULL);
/*!40000 ALTER TABLE `expertises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `health_insurance_cards`
--

DROP TABLE IF EXISTS `health_insurance_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `health_insurance_cards` (
  `id` varchar(255) NOT NULL,
  `expiration_date` datetime(6) DEFAULT NULL,
  `issue_date` datetime(6) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhe7yqxt0ucfwl6atmkjdfqm82` (`patient_id`),
  CONSTRAINT `FKhe7yqxt0ucfwl6atmkjdfqm82` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_insurance_cards`
--

LOCK TABLES `health_insurance_cards` WRITE;
/*!40000 ALTER TABLE `health_insurance_cards` DISABLE KEYS */;
/*!40000 ALTER TABLE `health_insurance_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holiday_schedules`
--

DROP TABLE IF EXISTS `holiday_schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `holiday_schedules` (
  `id` int NOT NULL AUTO_INCREMENT,
  `staff_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlh2b4fjdohjr440by3sw4plgb` (`staff_id`),
  CONSTRAINT `FKlh2b4fjdohjr440by3sw4plgb` FOREIGN KEY (`staff_id`) REFERENCES `staffs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday_schedules`
--

LOCK TABLES `holiday_schedules` WRITE;
/*!40000 ALTER TABLE `holiday_schedules` DISABLE KEYS */;
/*!40000 ALTER TABLE `holiday_schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical-departments`
--

DROP TABLE IF EXISTS `medical-departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical-departments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical-departments`
--

LOCK TABLES `medical-departments` WRITE;
/*!40000 ALTER TABLE `medical-departments` DISABLE KEYS */;
INSERT INTO `medical-departments` VALUES (1,'Khoa Huyết học truyền máu - Phòng Xét nghiệm huyết học truyền máu','None'),(2,'Khoa Sinh hóa - Phòng Xét nghiệm Hóa sinh',NULL),(3,'Khoa Chẩn đoán hình ảnh - Phòng X-Q số',NULL);
/*!40000 ALTER TABLE `medical-departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical-tests`
--

DROP TABLE IF EXISTS `medical-tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical-tests` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  `medical_record_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq41wx034cghi9ukmovs0rjf7h` (`medical_record_id`),
  CONSTRAINT `FKq41wx034cghi9ukmovs0rjf7h` FOREIGN KEY (`medical_record_id`) REFERENCES `medical_records` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical-tests`
--

LOCK TABLES `medical-tests` WRITE;
/*!40000 ALTER TABLE `medical-tests` DISABLE KEYS */;
INSERT INTO `medical-tests` VALUES (2,NULL,'2023-07-20 02:15:45.910286',108400,4),(3,NULL,'2023-07-20 21:11:21.529142',244000,7),(4,NULL,'2023-07-23 12:10:45.722368',97200,6),(5,NULL,'2023-07-23 12:11:37.809681',97200,8);
/*!40000 ALTER TABLE `medical-tests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_record_informations`
--

DROP TABLE IF EXISTS `medical_record_informations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_record_informations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `blood_pressure` float DEFAULT NULL,
  `body_temperature` float DEFAULT NULL,
  `detail_medical` text,
  `diagnose` varchar(255) DEFAULT NULL,
  `heartbeat` float DEFAULT NULL,
  `height` float DEFAULT NULL,
  `solution` varchar(255) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `medical_record_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhnbpe4fsmikv42q7ynecil6o1` (`medical_record_id`),
  CONSTRAINT `FKhnbpe4fsmikv42q7ynecil6o1` FOREIGN KEY (`medical_record_id`) REFERENCES `medical_records` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_record_informations`
--

LOCK TABLES `medical_record_informations` WRITE;
/*!40000 ALTER TABLE `medical_record_informations` DISABLE KEYS */;
INSERT INTO `medical_record_informations` VALUES (1,110,36.5,'<p>Khám toàn thân:</p><ul><li>Toàn thân: Tỉnh táo, tiếp xúc tốt. Da niêm mạc hồng, không phù, không xuất huyết dưới da, Tuyến giáp không to, hạch ngoại vi không sưng đau. Thể trạng trung bình</li><li>Tuần hoàn: Mỏm tim đạp khoang liên sườn V đường giữa đòn trái. Mạch quay đều. T1, T2 nghe rõ. Chưa nghe thấy tiếng tim bệnh lý</li><li>Hô hấp: Không ho, không khó thở. Lồng ngực di động đều theo nhịp thở. Rì rào phế nang rõ, rung thanh bình thường. Không ran</li><li>Tiêu hóa: Ăn uống tốt. Đại tiện bình thường. Bụng mềm, không chướng. Gan lách không sờ thấy</li></ul><p>Khám chuyên khoa:</p><ul><li>Tai phải: Ống tai sạch, màng nhĩ sáng</li><li>Tai trái: Ống tai sạch, màng nhĩ sáng</li><li>Mũi phải: Sạch, niêm mạc bình thường, vách ngăn thẳng</li><li>Mũi trái: Sạch, niêm mạc bình thường, vách ngăn thẳng</li><li>Vòm: Nhẵn, không có u cục</li><li>Họng: Niêm mạc không xung huyết, amidan nhỏ</li></ul>','Viêm mũi dị ứng',87,169,'Uống thuốc và chăm sóc sữc khỏe',54,4),(2,110,36,'<p>Khám toàn thân:</p><ul><li>Toàn thân: Tỉnh táo, tiếp xúc tốt. Da niêm mạc hồng, không phù, không xuất huyết dưới da, Tuyến giáp không to, hạch ngoại vi không sưng đau. Thể trạng trung bình<br>Tuần hoàn: Mỏm tim đạp khoang liên sườn V đường giữa đòn trái. Mạch quay đều. T1, T2 nghe rõ. Chưa nghe thấy tiếng tim bệnh lý<br>Hô hấp: Không ho, không khó thở. Lồng ngực di động đều theo nhịp thở. Rì rào phế nang rõ, rung thanh bình thường. Không ran<br>Tiêu hóa: Ăn uống tốt. Đại tiện bình thường. Bụng mềm, không chướng. Gan lách không sờ thấy</li></ul><p>Khám chuyên khoa:</p><ul><li>Tai phải: Ống tai sạch, màng nhĩ sáng<br>Tai trái: Ống tai sạch, màng nhĩ sáng<br>Mũi phải: Sạch, niêm mạc bình thường, vách ngăn thẳng<br>Mũi trái: Sạch, niêm mạc bình thường, vách ngăn thẳng<br>Vòm: Nhẵn, không có u cục<br>Họng: Niêm mạc không xung huyết, amydan nhỏ</li></ul>','asdasdas',89,167,'asdasd',54,7),(3,12,2,'<p><b><i>Khám bệnh chi tiết!</i></b></p>','asd',1212,12,'asdas',1212,6),(4,34,344,'<p><b><i>Khám bệnh chi tiết!</i></b></p>','qwe',234,23,'asdasd',23,8);
/*!40000 ALTER TABLE `medical_record_informations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_records`
--

DROP TABLE IF EXISTS `medical_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_records` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` datetime(6) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `staff_id` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoeqsv3cw85pifwby1qvoqwsmd` (`patient_id`),
  KEY `FKs76x0rdese36jwoqiyic9imao` (`staff_id`),
  CONSTRAINT `FKoeqsv3cw85pifwby1qvoqwsmd` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKs76x0rdese36jwoqiyic9imao` FOREIGN KEY (`staff_id`) REFERENCES `staffs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_records`
--

LOCK TABLES `medical_records` WRITE;
/*!40000 ALTER TABLE `medical_records` DISABLE KEYS */;
INSERT INTO `medical_records` VALUES (4,'2023-07-17 22:09:33.950549',9,3,'DONE','PAID'),(6,'2023-07-19 16:43:04.357044',10,3,'DONE','PAID'),(7,'2023-07-20 21:09:15.961560',11,3,'DONE','PAID'),(8,'2023-07-23 12:09:51.894460',9,3,'DONE','PAID');
/*!40000 ALTER TABLE `medical_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_reports`
--

DROP TABLE IF EXISTS `medical_reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_reports` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `medical_record_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4jkisio0jhku7w2grg26rb4mm` (`medical_record_id`),
  CONSTRAINT `FK4jkisio0jhku7w2grg26rb4mm` FOREIGN KEY (`medical_record_id`) REFERENCES `medical_records` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_reports`
--

LOCK TABLES `medical_reports` WRITE;
/*!40000 ALTER TABLE `medical_reports` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine_of_prescription`
--

DROP TABLE IF EXISTS `medicine_of_prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine_of_prescription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `medicine` int DEFAULT NULL,
  `prescription` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlltfp8micf2tug6io1am2v29r` (`medicine`),
  KEY `FKgxg49e99clcy541u76s3b4541` (`prescription`),
  CONSTRAINT `FKgxg49e99clcy541u76s3b4541` FOREIGN KEY (`prescription`) REFERENCES `prescriptions` (`id`),
  CONSTRAINT `FKlltfp8micf2tug6io1am2v29r` FOREIGN KEY (`medicine`) REFERENCES `medicines` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine_of_prescription`
--

LOCK TABLES `medicine_of_prescription` WRITE;
/*!40000 ALTER TABLE `medicine_of_prescription` DISABLE KEYS */;
INSERT INTO `medicine_of_prescription` VALUES (3,21,1,2),(4,12,3,2),(5,7,2,2),(6,10,2,3),(7,9,1,3),(8,1,2,4),(9,1,2,5);
/*!40000 ALTER TABLE `medicine_of_prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicines`
--

DROP TABLE IF EXISTS `medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicines` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `use_manual` varchar(255) DEFAULT NULL,
  `declaring_unit` varchar(255) DEFAULT NULL,
  `active_element` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `packing` varchar(255) DEFAULT NULL,
  `production_unit` varchar(255) DEFAULT NULL,
  `using` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicines`
--

LOCK TABLES `medicines` WRITE;
/*!40000 ALTER TABLE `medicines` DISABLE KEYS */;
INSERT INTO `medicines` VALUES (1,'Alecizan',700,120,'Viên','Ngày 3 lần','Công ty cổ phần Dược Minh Hải','Paracetamol, Ibuprofen','325 mg; 200 mg','Hộp 5 vỉ x 20 viên; Hộp 10 vỉ x 20 viên','Công ty cổ phần Dược Minh Hải','Uống'),(2,'Comfypa 4200',2843,123,'Viên','Ngày 2 lần','Công ty TNHH DRP Inter','alphachymotrypsin','4200 đơn vị USP','Viên','Công ty TNHH DRP Inter','Uống'),(3,'Amoxicilin 500mg',1500,56,'Viên','Ngày 2 lần','Công ty cổ phần dược phẩm Tipharco','Amoxicillin (dưới dạng Amoxicillin trihydrat compacted) 500 mg','500 mg','Chai 200 viên','Công ty cổ phần dược phẩm Tipharco','Uống');
/*!40000 ALTER TABLE `medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `detail_address` varchar(255) DEFAULT NULL,
  `ethnic` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn567qsxpaku1bfdquggvb1ki1` (`account_id`),
  CONSTRAINT `FKn567qsxpaku1bfdquggvb1ki1` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (9,'Cửu Cao, Văn Giang, Hưng Yên','1977-07-06 17:32:42.713000',NULL,'Nhà 236','Kinh','Nguyễn Văn Hùng','male','Bảo vệ','0987586742',13),(10,'Văn Quán, Hà Đông, Hà Nội','2000-07-11 21:15:41.823000',NULL,'406 Tòa C405','Kinh','Vũ Văn Hùng','male','Kỹ sư','0475836574',16),(11,'Xuân Quan, Văn Giang, Hưng Yên','2001-10-04 17:03:45.462000',NULL,'Nhà 405','Kinh','Nguyễn Huy Hoàng','male','Sinh viên','0838978446',18);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS `positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `positions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` VALUES (1,'Bác sĩ',NULL),(2,'Điều dưỡng',''),(10,'Trưởng khoa',NULL),(11,'Điều dưỡng trưởng khoa',NULL),(12,'Nhân viên',NULL);
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescriptions`
--

DROP TABLE IF EXISTS `prescriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescriptions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` datetime(6) DEFAULT NULL,
  `medical_record_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdgc3qpyhfyt6klwc5qktya73p` (`medical_record_id`),
  CONSTRAINT `FKdgc3qpyhfyt6klwc5qktya73p` FOREIGN KEY (`medical_record_id`) REFERENCES `medical_records` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescriptions`
--

LOCK TABLES `prescriptions` WRITE;
/*!40000 ALTER TABLE `prescriptions` DISABLE KEYS */;
INSERT INTO `prescriptions` VALUES (2,'2023-07-20 03:25:42.826086',4),(3,'2023-07-20 21:12:30.982049',7),(4,'2023-07-23 12:10:50.719305',6),(5,'2023-07-23 12:11:41.362277',8);
/*!40000 ALTER TABLE `prescriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `medical_department_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkub5ykqvl0v6cvqjhidbbet9n` (`medical_department_id`),
  CONSTRAINT `FKkub5ykqvl0v6cvqjhidbbet9n` FOREIGN KEY (`medical_department_id`) REFERENCES `medical-departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,NULL,'Tổng phân tích tế bào máu ngoại vi (bằng máy đếm laser)',46200,1),(2,NULL,'Tổng phân tích tế bào máu ngoại vi bằng hệ thống tự động hoàn toàn (có nhuộm tiêu bản tự động)',106000,1),(3,NULL,'Tổng phân tích tế bào máu ngoại vi (bằng máy đếm tổng trở)',40400,1),(4,NULL,'Tổng phân tích nước tiểu (bằng máy tự động)',27400,2),(5,NULL,'Định lượng Urê (niệu)',16000,2),(6,NULL,'Định lượng Glucoso (niệu)',13000,2),(7,NULL,'Chụp Xquang cột sống ngực thẳng nghiêng hoặc chếch',97200,3),(8,NULL,'Chụp Xquang cột sống ngực thẳng nghiêng hoặc chếch',65400,3);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services_of_medical_test`
--

DROP TABLE IF EXISTS `services_of_medical_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services_of_medical_test` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `medical_test_id` int DEFAULT NULL,
  `services_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe7g7bbjn7o4pejmr520r97dec` (`medical_test_id`),
  KEY `FK9i698sgx31pry7751yhh4dyto` (`services_id`),
  CONSTRAINT `FK9i698sgx31pry7751yhh4dyto` FOREIGN KEY (`services_id`) REFERENCES `services` (`id`),
  CONSTRAINT `FKe7g7bbjn7o4pejmr520r97dec` FOREIGN KEY (`medical_test_id`) REFERENCES `medical-tests` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services_of_medical_test`
--

LOCK TABLES `services_of_medical_test` WRITE;
/*!40000 ALTER TABLE `services_of_medical_test` DISABLE KEYS */;
INSERT INTO `services_of_medical_test` VALUES (4,2,2,1),(5,1,2,5),(6,2,3,2),(7,2,3,5),(8,1,4,7),(9,1,5,7);
/*!40000 ALTER TABLE `services_of_medical_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staffs`
--

DROP TABLE IF EXISTS `staffs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staffs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `detail_address` varchar(255) DEFAULT NULL,
  `ethnic` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  `expertise_id` int DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7jl2rhabnfjysmtrfygcc160r` (`account_id`),
  KEY `FK8c3fxchyu03ygw3xgo801ocuh` (`expertise_id`),
  KEY `FKhsjvoxjuv4d4evtnqlbcfo5db` (`position_id`),
  CONSTRAINT `FK7jl2rhabnfjysmtrfygcc160r` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
  CONSTRAINT `FK8c3fxchyu03ygw3xgo801ocuh` FOREIGN KEY (`expertise_id`) REFERENCES `expertises` (`id`),
  CONSTRAINT `FKhsjvoxjuv4d4evtnqlbcfo5db` FOREIGN KEY (`position_id`) REFERENCES `positions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffs`
--

LOCK TABLES `staffs` WRITE;
/*!40000 ALTER TABLE `staffs` DISABLE KEYS */;
INSERT INTO `staffs` VALUES (3,'Mộ Lao, Hà Đông, Hà Nội','1973-07-12 17:40:25.603000',NULL,'708 Macplaza','Kinh','Nguyễn Văn Long','male','0848957386',14,1,1),(4,'Kim Quan, Thuận Thành, Bắc Ninh','1987-07-24 17:41:40.888000',NULL,'Nhà 106','Kinh','Phạm Thị Loan','female','0858584868',15,1,2),(5,'Thị trấn Hạ Hòa, Hạ Hòa, Phú Thọ','1984-08-06 16:49:22.326000',NULL,'Nhà 405','Kinh','Hoàng Xuân Lục ','male','0905138346',17,2,10);
/*!40000 ALTER TABLE `staffs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-23 14:05:57
