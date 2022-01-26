-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 25 Jan 2022 pada 10.58
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `PemesananTiketKAI`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal`
--

CREATE TABLE `jadwal` (
  `berangkat` varchar(10) NOT NULL,
  `tiba` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jadwal`
--

INSERT INTO `jadwal` (`berangkat`, `tiba`) VALUES
('12.00', '15.00'),
('13.00', '16.00'),
('16.00', '18.00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kereta`
--

CREATE TABLE `kereta` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `stasiunAsal` varchar(50) NOT NULL,
  `stasiunAkhir` varchar(50) NOT NULL,
  `jumlahKursi` int(11) NOT NULL,
  `harga` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kereta`
--

INSERT INTO `kereta` (`id`, `nama`, `jenis`, `stasiunAsal`, `stasiunAkhir`, `jumlahKursi`, `harga`) VALUES
(1, 'argo parahyangan', 'eksekutif', 'bandung', 'bekasi', 3, 100000),
(2, 'argo parahyangan', 'bisnis', 'bandung', 'bekasi', 3, 75000),
(3, 'argo parahyangan', 'ekonomi', 'bekasi', 'bandung', 5, 60000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penumpang`
--

CREATE TABLE `penumpang` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nomor_hp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penumpang`
--

INSERT INTO `penumpang` (`id`, `nama`, `username`, `password`, `email`, `nomor_hp`) VALUES
(1, 'azhar', 'p', 'p', 'azhar@gmail.com', '081223727292'),
(5, 'tasya', 'tasya', 'tasya', 'tasya@gmail.com', '0812123213'),
(6, 'pandu', 'pandu', '123', 'pandu@gmail.com', '08121232132');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tiketTerpesan`
--

CREATE TABLE `tiketTerpesan` (
  `id` int(11) NOT NULL,
  `namaPenumpang` varchar(50) NOT NULL,
  `kereta` varchar(50) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `rute` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `berangkat` varchar(10) NOT NULL,
  `tiba` varchar(50) NOT NULL,
  `kursi` varchar(50) NOT NULL,
  `harga` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tiketTerpesan`
--

INSERT INTO `tiketTerpesan` (`id`, `namaPenumpang`, `kereta`, `jenis`, `rute`, `tanggal`, `berangkat`, `tiba`, `kursi`, `harga`) VALUES
(5, 'azhar', 'argo parahyangan', 'ekonomi', 'bekasi-bandung', '2022-01-01', '12.00', '15.00', '3', '60000'),
(6, 'tasya', 'argo parahyangan', 'eksekutif', 'bandung-bekasi', '2022-01-01', '12.00', '15.00', '1', '100000'),
(7, 'tasya', 'argo parahyangan', 'ekonomi', 'bekasi-bandung', '2022-01-02', '12.00', '15.00', '1', '60000');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kereta`
--
ALTER TABLE `kereta`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `penumpang`
--
ALTER TABLE `penumpang`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tiketTerpesan`
--
ALTER TABLE `tiketTerpesan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `kereta`
--
ALTER TABLE `kereta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `penumpang`
--
ALTER TABLE `penumpang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `tiketTerpesan`
--
ALTER TABLE `tiketTerpesan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
