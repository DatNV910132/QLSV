-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2018 at 11:01 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sis`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `abc`
-- (See below for the actual view)
--
CREATE TABLE `abc` (
`MSSV` varchar(8)
,`Password` varchar(45)
,`Hoten` varchar(45)
,`Gioitinh` varchar(10)
,`Ngaysinh` varchar(20)
,`Cmnd` varchar(45)
,`Dantoc` varchar(45)
,`Diachi` varchar(45)
,`Sdt` varchar(20)
,`Email` varchar(45)
,`Lopsv` varchar(45)
,`Chuyennganhhoc` varchar(45)
,`Hehoc` varchar(45)
,`Tinhtrang` varchar(45)
);

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idadmin` int(11) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Hoten` varchar(45) NOT NULL,
  `Ngaysinh` varchar(20) NOT NULL,
  `Diachi` varchar(45) NOT NULL,
  `Sdt` varchar(20) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `baiviet`
--

CREATE TABLE `baiviet` (
  `idBaiviet` int(11) NOT NULL,
  `Tenbaiviet` varchar(45) NOT NULL,
  `Noidung` longtext NOT NULL,
  `Nguoidang` int(11) NOT NULL,
  `Ngaydang` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bangdiem`
--

CREATE TABLE `bangdiem` (
  `MaLop` varchar(10) NOT NULL,
  `MSSV` varchar(8) NOT NULL,
  `Hocky` varchar(45) NOT NULL,
  `DiemQT` float DEFAULT NULL,
  `Diemcuoiky` float DEFAULT NULL,
  `Diemheso4` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bangdiem`
--

INSERT INTO `bangdiem` (`MaLop`, `MSSV`, `Hocky`, `DiemQT`, `Diemcuoiky`, `Diemheso4`) VALUES
('100000', '20130752', '20172', NULL, NULL, NULL),
('100000', '20160952', '20181', NULL, NULL, NULL),
('100001', '20160952', '20181', NULL, NULL, NULL),
('100001', '20161113', '20181', NULL, NULL, NULL),
('100002', '20160952', '20181', NULL, NULL, NULL),
('100010', '20154484', '20151', 9, 9, 'A'),
('100010', '20160952', '20151', NULL, NULL, NULL),
('100011', '20154484', '20151', 9, 9, 'A'),
('100011', '20160952', '20151', NULL, NULL, NULL),
('100012', '20154484', '20161', 8, 8, 'B+'),
('100013', '20154484', '20152', 8, 8, 'B+'),
('100014', '20154484', '20172', 3, 3, 'F'),
('100014', '20160952', '20172', NULL, NULL, NULL),
('100015', '20154484', '20172', 9, 9, 'A'),
('100016', '20154484', '20171', 6, 6, 'C'),
('100016', '20160952', '20171', NULL, NULL, NULL),
('100017', '20154484', '20162', NULL, NULL, NULL),
('100020', '20154484', '20161', NULL, NULL, NULL),
('100020', '20160952', '20161', NULL, NULL, NULL),
('100021', '20154484', '', NULL, NULL, NULL),
('100021', '20154484', '20162', 7, 7, 'B'),
('100021', '20160952', '20181', NULL, NULL, NULL),
('100022', '20154484', '20171', NULL, NULL, NULL),
('100023', '20154484', '20172', 9, 9, 'A'),
('100023', '20160952', '20172', NULL, NULL, NULL),
('100024', '20154484', '20151', 9, 9, 'A'),
('100025', '20154484', '20152', 8, 8, 'B+'),
('100026', '20154484', '20152', 8, 8, 'B+'),
('100030', '20160952', '20182', NULL, NULL, NULL),
('100031', '20160952', '20182', NULL, NULL, NULL),
('100032', '20160952', '20182', NULL, NULL, NULL);

--
-- Triggers `bangdiem`
--
DELIMITER $$
CREATE TRIGGER `tang_SoSV` AFTER INSERT ON `bangdiem` FOR EACH ROW BEGIN
		UPDATE lop SET lop.Sosv = lop.Sosv + 1
		WHERE MaLop = NEW.MaLop;
	END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `dangkihocphan`
--

CREATE TABLE `dangkihocphan` (
  `MaHP` varchar(6) NOT NULL,
  `MSSV` varchar(8) NOT NULL,
  `Ngaydangki` varchar(20) NOT NULL,
  `Trangthai` varchar(45) DEFAULT NULL,
  `hocky` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dangkihocphan`
--

INSERT INTO `dangkihocphan` (`MaHP`, `MSSV`, `Ngaydangki`, `Trangthai`, `hocky`) VALUES
('IT4440', '20154484', '2018-11-01', 'Thành công', '20183'),
('MI1010', '20154484', '2018-11-04', 'Thành công', '20183'),
('IT1010', '20160952', '2018-12-08', 'Thành công', '20182'),
('IT3030', '20160952', '2018-12-09', 'Thành công', '20182'),
('IT4501', '20160952', '2018-12-13', 'Thành công', '20182'),
('IT4520', '20160952', '2018-12-13', 'Thành công', '20182'),
('IT3920', '20160952', '2018-12-13', 'Thành công', '20182'),
('IT4875', '20160952', '2018-12-13', 'Thành công', '20182'),
('IT4480', '20160952', '2018-12-13', 'Thành công', '20182');

-- --------------------------------------------------------

--
-- Table structure for table `dangkihocphantudo`
--

CREATE TABLE `dangkihocphantudo` (
  `MaHP` varchar(6) NOT NULL,
  `MSSV` varchar(8) NOT NULL,
  `Ngaydangki` varchar(20) NOT NULL,
  `Hocky` varchar(45) NOT NULL,
  `Tinhtrang` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `diemtoeic`
--

CREATE TABLE `diemtoeic` (
  `MSSV` varchar(8) NOT NULL,
  `Hocky` varchar(45) NOT NULL,
  `Ngaythi` varchar(45) NOT NULL,
  `Diemnghe` int(11) NOT NULL,
  `Diemdoc` int(11) NOT NULL,
  `Tongdiem` int(11) NOT NULL,
  `Ghichu` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diemtoeic`
--

INSERT INTO `diemtoeic` (`MSSV`, `Hocky`, `Ngaythi`, `Diemnghe`, `Diemdoc`, `Tongdiem`, `Ghichu`) VALUES
('20154484', '20181', '27/10/2018', 400, 340, 740, NULL),
('20160952', '20172', '12/05/2017', 300, 390, 690, NULL),
('20161113', '20171', '12/12/2017', 250, 300, 550, NULL),
('20161113', '20181', '12/12/2017', 250, 200, 450, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hocphan`
--

CREATE TABLE `hocphan` (
  `MaHP` varchar(6) NOT NULL,
  `TenHP` varchar(45) NOT NULL,
  `Sotinchi` int(11) NOT NULL,
  `Tinchihocphi` float NOT NULL,
  `Thoiluong` varchar(45) NOT NULL,
  `Trongso` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hocphan`
--

INSERT INTO `hocphan` (`MaHP`, `TenHP`, `Sotinchi`, `Tinchihocphi`, `Thoiluong`, `Trongso`) VALUES
('IT1010', 'Tin học đại cương', 4, 5.5, '4(4-1-1-6)', 0.6),
('IT3030', 'Kiến trúc máy tinh', 3, 4, '3(3-0-0-6)', 0.7),
('IT3040', 'Kĩ thuật lập trình', 2, 3, '2(2-0-0-6)', 0.7),
('IT3090', 'Project I', 3, 6, '3(0-0-0-12)', 0.6),
('IT3920', 'Project II', 3, 6, '3(0-0-0-24)', 0.7),
('IT4440', 'Thiết kế xây dựng phần mềm', 3, 4, '4-6-0-0', 4),
('IT4480', 'Làm việc nhóm', 2, 4, '3(3-0-0-6)', 0.7),
('IT4501', 'Đảm bảo chất lượng phần mềm', 2, 3, '2(2-0-1-6)', 0.7),
('IT4520', 'Kinh tế công nghiệp phần mềm', 2, 3, '2(2-0-1-6)', 0.7),
('IT4551', 'Phát triển phần mềm chuyển nghiệp', 3, 3, '3(4-0-1-6)', 0.7),
('IT4875', 'Xử lí ngôn ngữ tự nhiên', 2, 3, '2(2-0-1-6)', 0.7),
('MI1010', 'Giải tích I', 3, 5, '3(3-2-0-6)', 0.7),
('MI2020', 'Xác suất thống kê', 3, 4, '3(3-1-0-6)', 0.6),
('PE2201', 'Bóng đá 1', 0, 1, '0(1-0-0-0)', 0.7),
('PH1110', 'Vật lí đại cương I', 3, 4, '3(3-1-2-6)', 0.7),
('PH1120', 'Vật lí đại cương II', 3, 4, '3(3-1-2-6)', 0.7),
('PH1130', 'Vật lí đại cương III', 3, 4, '3(3-1-2-6)', 0.7);

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

CREATE TABLE `lop` (
  `MaLop` varchar(10) NOT NULL,
  `MaHP` varchar(6) NOT NULL,
  `Thoigian` varchar(45) NOT NULL,
  `Diadiem` varchar(45) NOT NULL,
  `Sosv` int(11) NOT NULL,
  `trangthai` varchar(45) NOT NULL,
  `Ghichu` varchar(45) DEFAULT NULL,
  `Hocky` varchar(45) NOT NULL,
  `Tuanhoc` varchar(16) NOT NULL,
  `MaxSV` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lop`
--

INSERT INTO `lop` (`MaLop`, `MaHP`, `Thoigian`, `Diadiem`, `Sosv`, `trangthai`, `Ghichu`, `Hocky`, `Tuanhoc`, `MaxSV`) VALUES
('100000', 'IT1010', '7:00 - 11:00', 'D3-101', 1, 'Điều chỉnh', NULL, '20181', '2-9,11,18', 200),
('100001', 'IT3030', '7:00 - 11:00', 'D35-201', 0, 'Điều chỉnh', NULL, '20181', '2-9,11-18', 120),
('100002', 'IT3030', '13:00 - 17:00', 'TC-207', 0, 'Điều chỉnh', NULL, '20181', '2-9,11-18', 120),
('100010', 'IT4440', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20151', '2,9 - 11,1', 100),
('100011', 'IT4440', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20151', '2,9 - 11,1', 100),
('100012', 'IT4440', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20161', '2,9 - 11,1', 100),
('100013', 'IT4440', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20152', '2,9 - 11,1', 100),
('100014', 'IT4440', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20172', '2,9 - 11,1', 100),
('100015', 'IT4440', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20172', '2,9 - 11,1', 100),
('100016', 'IT4440', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20171', '2,9 - 11,1', 100),
('100017', 'IT4440', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20162', '2,9 - 11,1', 100),
('100020', 'MI1010', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20161', '2,9 - 11,1', 100),
('100021', 'MI1010', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20162', '2,9 - 11,1', 100),
('100022', 'MI1010', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20171', '2,9 - 11,1', 100),
('100023', 'MI1010', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20172', '2,9 - 11,1', 100),
('100024', 'MI1010', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20151', '2,9 - 11,1', 100),
('100025', 'MI1010', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20152', '2,9 - 11,1', 100),
('100026', 'MI1010', 't1-t3', 'D9-102', 0, 'hoc', 'AB', '20152', '2,9 - 11,1', 100),
('100030', 'IT3920', 'NULL', 'B1-701', 1, 'Đăng kí', NULL, '20182', '21-40', 70),
('100031', 'IT4480', '7:00-10:00', 'TC-207', 1, 'Đăng kí', NULL, '20182', '21-28', 100),
('100032', 'IT4480', '7:00-10:00', 'TC-207', 1, 'Đăng kí', NULL, '20182', '30-37', 100),
('100033', 'IT4520', 'NULL', 'B1-701', 0, 'Đăng kí', NULL, '20182', '21-40', 70),
('100036', 'IT4480', '7:00-10:00', 'TC-207', 0, 'Đăng kí', NULL, '20182', '21-28', 100);

-- --------------------------------------------------------

--
-- Table structure for table `sinhvien`
--

CREATE TABLE `sinhvien` (
  `MSSV` varchar(8) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Hoten` varchar(45) NOT NULL,
  `Gioitinh` varchar(10) NOT NULL,
  `Ngaysinh` varchar(20) NOT NULL,
  `Cmnd` varchar(45) NOT NULL,
  `Dantoc` varchar(45) NOT NULL,
  `Diachi` varchar(45) NOT NULL,
  `Sdt` varchar(20) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Lopsv` varchar(45) DEFAULT NULL,
  `Chuyennganhhoc` varchar(45) NOT NULL,
  `Hehoc` varchar(45) NOT NULL,
  `Tinhtrang` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sinhvien`
--

INSERT INTO `sinhvien` (`MSSV`, `Password`, `Hoten`, `Gioitinh`, `Ngaysinh`, `Cmnd`, `Dantoc`, `Diachi`, `Sdt`, `Email`, `Lopsv`, `Chuyennganhhoc`, `Hehoc`, `Tinhtrang`) VALUES
('20130752', '25d55ad283aa400af464c76d713c07ad', 'Mai Tuấn Đạt', 'Nam', '11/04/1998', '161123321', 'Kinh', 'Vĩnh Phúc', NULL, NULL, NULL, 'HTTT', 'CNTT', 'Học'),
('20154484', '246688f07a7c1462e950228d95e265c5', 'Nguyễn Văn Đạt', 'Nam', '09.10.1997', '163447593', 'kinh', 'Nam Định', '0969991097', 'nguyendatbk910@gmail.com', 'CNTT 2-2 K60', 'CNTT-TT 2-2015', 'Đại Học', 'Học'),
('20160001', '25d55ad283aa400af464c76d713c07ad', 'Tên Là A', 'Nam', '12/01/1998', '123456789', 'Kinh', 'Hà Nội', '01234567890', 'a.tl@gmail.com', 'KTHH1.01-K61', 'Hóa dầu', 'KTHH', 'Học'),
('20160952', 'b065799cbad0e39067e0b745a98938fe', 'Nguyễn Văn Đạt', 'nam', '28/06/1998', '125850289', 'King', 'bắc Ninh', '0190124992', 'dat.nv160952@sis.hust.edu.vn', 'CNTT', 'CNPM', 'CNTT', 'Học'),
('20161113', '25d55ad283aa400af464c76d713c07ad', 'Nguyễn Trọng Đức', 'Nam', '11/01/1998', '171123321', 'Kinh', 'Thanh Hóa', NULL, NULL, NULL, 'HTTT', 'CNTT', 'Mức 1');

-- --------------------------------------------------------

--
-- Table structure for table `timeable`
--

CREATE TABLE `timeable` (
  `mssv` varchar(8) NOT NULL,
  `time` varchar(45) NOT NULL,
  `week` varchar(10) NOT NULL,
  `room` varchar(45) NOT NULL,
  `maLop` varchar(8) NOT NULL,
  `group` varchar(2) DEFAULT NULL,
  `MaHP` varchar(6) NOT NULL,
  `nameClass` varchar(20) NOT NULL,
  `ghiChu` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `timeable`
--

INSERT INTO `timeable` (`mssv`, `time`, `week`, `room`, `maLop`, `group`, `MaHP`, `nameClass`, `ghiChu`) VALUES
('20160952', '7:00-10:00', '4', 'D2-112', '100000', '1', 'IT1010', 'Tin học đai cương', NULL),
('20160952', '7:00-10:00', '7', 'D3-101', '100001', '1', 'IT3030', 'Kiến trúc máy tính', NULL);

-- --------------------------------------------------------

--
-- Structure for view `abc`
--
DROP TABLE IF EXISTS `abc`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `abc`  AS  select `sinhvien`.`MSSV` AS `MSSV`,`sinhvien`.`Password` AS `Password`,`sinhvien`.`Hoten` AS `Hoten`,`sinhvien`.`Gioitinh` AS `Gioitinh`,`sinhvien`.`Ngaysinh` AS `Ngaysinh`,`sinhvien`.`Cmnd` AS `Cmnd`,`sinhvien`.`Dantoc` AS `Dantoc`,`sinhvien`.`Diachi` AS `Diachi`,`sinhvien`.`Sdt` AS `Sdt`,`sinhvien`.`Email` AS `Email`,`sinhvien`.`Lopsv` AS `Lopsv`,`sinhvien`.`Chuyennganhhoc` AS `Chuyennganhhoc`,`sinhvien`.`Hehoc` AS `Hehoc`,`sinhvien`.`Tinhtrang` AS `Tinhtrang` from `sinhvien` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idadmin`);

--
-- Indexes for table `baiviet`
--
ALTER TABLE `baiviet`
  ADD PRIMARY KEY (`idBaiviet`),
  ADD KEY `nguoidang_idx` (`Nguoidang`);

--
-- Indexes for table `bangdiem`
--
ALTER TABLE `bangdiem`
  ADD PRIMARY KEY (`MaLop`,`MSSV`,`Hocky`),
  ADD KEY `Malopbangdiem_idx` (`MaLop`),
  ADD KEY `Mssvbangdiem_idx` (`MSSV`);

--
-- Indexes for table `dangkihocphan`
--
ALTER TABLE `dangkihocphan`
  ADD KEY `Masosinhvien_idx` (`MSSV`),
  ADD KEY `Mahpdkhp_idx` (`MaHP`);

--
-- Indexes for table `dangkihocphantudo`
--
ALTER TABLE `dangkihocphantudo`
  ADD KEY `masvdangkitudo_idx` (`MSSV`),
  ADD KEY `Mahptudo_idx` (`MaHP`);

--
-- Indexes for table `diemtoeic`
--
ALTER TABLE `diemtoeic`
  ADD PRIMARY KEY (`MSSV`,`Hocky`,`Ngaythi`),
  ADD KEY `Mssvtoeic_idx` (`MSSV`);

--
-- Indexes for table `hocphan`
--
ALTER TABLE `hocphan`
  ADD PRIMARY KEY (`MaHP`),
  ADD UNIQUE KEY `MaHP` (`MaHP`);

--
-- Indexes for table `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`MaLop`,`Hocky`),
  ADD UNIQUE KEY `MaLop` (`MaLop`),
  ADD KEY `MaHP_idx` (`MaHP`);

--
-- Indexes for table `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`MSSV`),
  ADD UNIQUE KEY `MSSV` (`MSSV`);

--
-- Indexes for table `timeable`
--
ALTER TABLE `timeable`
  ADD KEY `timeablemssv_idx` (`mssv`),
  ADD KEY `timeablemalop_idx` (`maLop`),
  ADD KEY `MaHP` (`MaHP`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `baiviet`
--
ALTER TABLE `baiviet`
  ADD CONSTRAINT `nguoidang` FOREIGN KEY (`Nguoidang`) REFERENCES `admin` (`idadmin`);

--
-- Constraints for table `bangdiem`
--
ALTER TABLE `bangdiem`
  ADD CONSTRAINT `Malopbangdiem` FOREIGN KEY (`MaLop`) REFERENCES `lop` (`MaLop`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Mssvbangdiem` FOREIGN KEY (`MSSV`) REFERENCES `sinhvien` (`MSSV`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dangkihocphan`
--
ALTER TABLE `dangkihocphan`
  ADD CONSTRAINT `Mahpdkhp` FOREIGN KEY (`MaHP`) REFERENCES `hocphan` (`MaHP`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Masosinhvien` FOREIGN KEY (`MSSV`) REFERENCES `sinhvien` (`MSSV`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dangkihocphantudo`
--
ALTER TABLE `dangkihocphantudo`
  ADD CONSTRAINT `Mahptudo` FOREIGN KEY (`MaHP`) REFERENCES `hocphan` (`mahp`),
  ADD CONSTRAINT `masvdangkitudo` FOREIGN KEY (`MSSV`) REFERENCES `sinhvien` (`mssv`);

--
-- Constraints for table `diemtoeic`
--
ALTER TABLE `diemtoeic`
  ADD CONSTRAINT `Mssvtoeic` FOREIGN KEY (`MSSV`) REFERENCES `sinhvien` (`mssv`);

--
-- Constraints for table `lop`
--
ALTER TABLE `lop`
  ADD CONSTRAINT `MaHP` FOREIGN KEY (`MaHP`) REFERENCES `hocphan` (`MaHP`);

--
-- Constraints for table `timeable`
--
ALTER TABLE `timeable`
  ADD CONSTRAINT `timeable_ibfk_1` FOREIGN KEY (`MaHP`) REFERENCES `lop` (`MaHP`),
  ADD CONSTRAINT `timeablemalop` FOREIGN KEY (`maLop`) REFERENCES `lop` (`MaLop`),
  ADD CONSTRAINT `timeablemssv` FOREIGN KEY (`mssv`) REFERENCES `sinhvien` (`MSSV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
