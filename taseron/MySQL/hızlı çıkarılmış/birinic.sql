-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 03 Haz 2022, 09:15:38
-- Sunucu sürümü: 8.0.29
-- PHP Sürümü: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `birinic`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kisi`
--

CREATE TABLE `kisi` (
  `ad` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `soyad` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `tarih` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `telefon` varchar(75) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `adres` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `firma` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mevki` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ucret` int NOT NULL,
  `calisma_suresi` int NOT NULL,
  `sigorta` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `bulundugu_proje` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `kisi`
--

INSERT INTO `kisi` (`ad`, `soyad`, `tarih`, `telefon`, `adres`, `firma`, `mevki`, `ucret`, `calisma_suresi`, `sigorta`, `bulundugu_proje`) VALUES
('ibrahim halil', 'metin', '2022-01-01', '5442502613', 'meydan', 'iste', 'demir ustası', 5000, 35, 'iste', 'rezidans');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
