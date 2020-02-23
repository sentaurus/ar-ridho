-- --------------------------------------------------------
-- Host:                         localhost
-- Versi server:                 8.0.15 - MySQL Community Server - GPL
-- OS Server:                    Win64
-- HeidiSQL Versi:               10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Membuang struktur basisdata untuk penggajian
CREATE DATABASE IF NOT EXISTS `penggajian` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `penggajian`;

-- membuang struktur untuk table penggajian.absensi
CREATE TABLE IF NOT EXISTS `absensi` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `nip` varchar(20) DEFAULT NULL,
  `jml_hadir` int(2) DEFAULT NULL,
  `jml_izin` int(2) DEFAULT NULL,
  `jml_sakit` int(2) DEFAULT NULL,
  `jml_alfa` int(2) DEFAULT NULL,
  `keterangan` varchar(50) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Index 2` (`nip`),
  CONSTRAINT `FK_absensi_data_guru` FOREIGN KEY (`nip`) REFERENCES `data_guru` (`nip`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Pengeluaran data tidak dipilih.

-- membuang struktur untuk table penggajian.akun
CREATE TABLE IF NOT EXISTS `akun` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `nama` varchar(20) DEFAULT NULL,
  `sandi` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Pengeluaran data tidak dipilih.

-- membuang struktur untuk table penggajian.data_gaji
CREATE TABLE IF NOT EXISTS `data_gaji` (
  `no_slip` int(5) NOT NULL AUTO_INCREMENT,
  `nip` varchar(20) DEFAULT NULL,
  `ms_kerja` varchar(10) DEFAULT NULL,
  `pend_terakhir` varchar(10) DEFAULT NULL,
  `gaji_pokok` varchar(10) DEFAULT NULL,
  `rekening` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`no_slip`),
  KEY `Index 2` (`nip`),
  CONSTRAINT `FK_data_gaji_data_guru` FOREIGN KEY (`nip`) REFERENCES `data_guru` (`nip`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Pengeluaran data tidak dipilih.

-- membuang struktur untuk table penggajian.data_guru
CREATE TABLE IF NOT EXISTS `data_guru` (
  `nip` varchar(20) NOT NULL,
  `kd_jabatan` varchar(10) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `js_kelamin` varchar(15) DEFAULT NULL,
  `tmp_lahir` varchar(15) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `agama` varchar(15) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  `ml_kerja` date DEFAULT NULL,
  `st_pegawai` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`nip`),
  KEY `Index 2` (`kd_jabatan`),
  CONSTRAINT `FK_data_guru_jabatan` FOREIGN KEY (`kd_jabatan`) REFERENCES `jabatan` (`kd_jabatan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Pengeluaran data tidak dipilih.

-- membuang struktur untuk table penggajian.jabatan
CREATE TABLE IF NOT EXISTS `jabatan` (
  `kd_jabatan` varchar(10) NOT NULL,
  `nm_jabatan` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`kd_jabatan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Pengeluaran data tidak dipilih.

-- membuang struktur untuk table penggajian.slip_gaji
CREATE TABLE IF NOT EXISTS `slip_gaji` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `no_slip` int(5) DEFAULT '0',
  `no_telp` varchar(12) DEFAULT NULL,
  `uang_makan` int(10) DEFAULT NULL,
  `tunjangan` int(10) DEFAULT NULL,
  `uang_transport` int(10) DEFAULT NULL,
  `pph_10` int(10) DEFAULT NULL,
  `jml_gaji` int(10) DEFAULT NULL,
  `tgl_bayar` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Index 2` (`no_slip`),
  CONSTRAINT `FK_slip_gaji_data_gaji` FOREIGN KEY (`no_slip`) REFERENCES `data_gaji` (`no_slip`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Pengeluaran data tidak dipilih.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
