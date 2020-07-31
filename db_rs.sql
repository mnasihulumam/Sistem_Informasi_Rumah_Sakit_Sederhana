-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 28, 2020 at 10:17 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rs`
--

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_penyakit`
--

CREATE TABLE `riwayat_penyakit` (
  `no` int(11) NOT NULL,
  `id_pasien` varchar(15) DEFAULT NULL,
  `id_dokter` varchar(30) DEFAULT NULL,
  `jenis_penyakit` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `riwayat_penyakit`
--

INSERT INTO `riwayat_penyakit` (`no`, `id_pasien`, `id_dokter`, `jenis_penyakit`) VALUES
(1, 'P2002', 'D2002', 'Tubercolosis'),
(2, 'P2003', 'D2001', 'Gangguan Saraf'),
(3, 'P2003', 'D2002', 'Cacar Air');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_dokter`
--

CREATE TABLE `tbl_dokter` (
  `id_dokter` varchar(30) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `jk` char(1) NOT NULL,
  `nope` varchar(15) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_dokter`
--

INSERT INTO `tbl_dokter` (`id_dokter`, `nama`, `jk`, `nope`, `alamat`) VALUES
('D2001', 'M. Nasihul Umam', 'L', '083823045047', 'Cirebon'),
('D2002', 'Lidiya Melinda', 'P', '08995770462', 'Cirebon');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE `tbl_login` (
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`username`, `password`, `nama`) VALUES
('umam', 'umam', 'umam');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pasien`
--

CREATE TABLE `tbl_pasien` (
  `id_pasien` varchar(15) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `jk` char(1) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `nope` varchar(15) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_pasien`
--

INSERT INTO `tbl_pasien` (`id_pasien`, `nama`, `jk`, `tgl_lahir`, `nope`, `alamat`) VALUES
('P2002', 'Lidiya septiyani', 'P', '1970-01-01', '08995770462', 'Cirebon'),
('P2003', 'Maroon', 'L', '2020-07-15', '08918971221', 'Cirebon');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `riwayat_penyakit`
--
ALTER TABLE `riwayat_penyakit`
  ADD PRIMARY KEY (`no`),
  ADD KEY `id_pasien` (`id_pasien`),
  ADD KEY `nip` (`id_dokter`);

--
-- Indexes for table `tbl_dokter`
--
ALTER TABLE `tbl_dokter`
  ADD PRIMARY KEY (`id_dokter`);

--
-- Indexes for table `tbl_pasien`
--
ALTER TABLE `tbl_pasien`
  ADD PRIMARY KEY (`id_pasien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `riwayat_penyakit`
--
ALTER TABLE `riwayat_penyakit`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `riwayat_penyakit`
--
ALTER TABLE `riwayat_penyakit`
  ADD CONSTRAINT `id_pasien` FOREIGN KEY (`id_pasien`) REFERENCES `tbl_pasien` (`id_pasien`),
  ADD CONSTRAINT `nip` FOREIGN KEY (`id_dokter`) REFERENCES `tbl_dokter` (`id_dokter`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
