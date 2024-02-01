-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.14 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table db_oop.anggota
CREATE TABLE IF NOT EXISTS `anggota` (
  `no_anggota` varchar(5) DEFAULT NULL,
  `no_pin` varchar(5) DEFAULT NULL,
  `nama_lengkap` varchar(50) DEFAULT NULL,
  `tmpt_lahir` varchar(30) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `jenis_kelamin` enum('Laki-Laki','Perempuan') DEFAULT NULL,
  `pendidikan_terakhir` varchar(10) DEFAULT NULL,
  `no_identitas` varchar(30) DEFAULT NULL,
  `alamat_tinggal` varchar(100) DEFAULT NULL,
  `no_telp_rmh` varchar(20) DEFAULT NULL,
  `pekerjaan` varchar(30) DEFAULT NULL,
  `alamat_kerja` varchar(100) DEFAULT NULL,
  `no_telp_kerja` varchar(20) DEFAULT NULL,
  `kota` varchar(35) DEFAULT NULL,
  `propinsi` varchar(35) DEFAULT NULL,
  `kode_pos` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table db_oop.anggota: 1 rows
/*!40000 ALTER TABLE `anggota` DISABLE KEYS */;
INSERT INTO `anggota` (`no_anggota`, `no_pin`, `nama_lengkap`, `tmpt_lahir`, `tgl_lahir`, `jenis_kelamin`, `pendidikan_terakhir`, `no_identitas`, `alamat_tinggal`, `no_telp_rmh`, `pekerjaan`, `alamat_kerja`, `no_telp_kerja`, `kota`, `propinsi`, `kode_pos`) VALUES
	('C0001', '4308', 'Budi Darmawan', 'Denpasar', '1980-12-07', 'Laki-Laki', 'S1', '5171980071280', 'Denpasar', '0361233738', 'Pedagang', 'Denpasar', '0361234546', 'Denpasar', 'Bali', '80113');
/*!40000 ALTER TABLE `anggota` ENABLE KEYS */;

-- Dumping structure for table db_oop.mahasiswa
CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `nim` varchar(10) NOT NULL DEFAULT '',
  `nama` varchar(50) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `no_hp` varchar(18) NOT NULL,
  `jns_kelamin` enum('L','P') NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `jurusan` varchar(50) NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table db_oop.mahasiswa: ~2 rows (approximately)
/*!40000 ALTER TABLE `mahasiswa` DISABLE KEYS */;
INSERT INTO `mahasiswa` (`nim`, `nama`, `tgl_lahir`, `no_hp`, `jns_kelamin`, `alamat`, `jurusan`) VALUES
	('1104405003', 'Bagus', '1992-05-05', '081804056070', 'L', 'Jl. Diponegoro Gang Mawar No. 45', 'Teknik Elektro'),
	('1104405004', 'Diana Arum', '1992-12-07', '08123604567', 'P', 'Jl. Teuku Umar Barat Gang Melon No. 2', 'Teknik Elektro');
/*!40000 ALTER TABLE `mahasiswa` ENABLE KEYS */;

-- Dumping structure for table db_oop.pelanggan
CREATE TABLE IF NOT EXISTS `pelanggan` (
  `id_pelanggan` varchar(5) NOT NULL,
  `nama_pelanggan` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  PRIMARY KEY (`id_pelanggan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table db_oop.pelanggan: ~6 rows (approximately)
/*!40000 ALTER TABLE `pelanggan` DISABLE KEYS */;
INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `alamat`, `no_hp`) VALUES
	('P0001', 'David Setiawan', 'Jl. Gejayan Gang Buntu No. 123', '+6281556476389'),
	('P0002', 'Supriyanto123', 'Jl. Babarsari No. 45, Sleman, Yogyakarta', '+6281801236456'),
	('P0003', 'anto', 'Jl. Imam Bonjol Gang Sukun No. 5', '+6281834455767'),
	('P0004', 'Anto Kurniawan', 'Jl. WR Supratman No. 55 123', '+6281254366552'),
	('P0005', 'Ririn Ekasari', 'Jl. Raya Janti Gang Jeruk No. 8', '+6281257988676');
/*!40000 ALTER TABLE `pelanggan` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
