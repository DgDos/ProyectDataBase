-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.20-log - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ryp
CREATE DATABASE IF NOT EXISTS `ryp` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ryp`;

-- Dumping structure for table ryp.empresacliente
CREATE TABLE IF NOT EXISTS `empresacliente` (
  `NIT` int(10) NOT NULL,
  `nombreEmpresa` varchar(30) NOT NULL,
  `usuarioE` varchar(30) NOT NULL,
  `passwordE` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `estado` int(1) NOT NULL,
  PRIMARY KEY (`NIT`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table ryp.empresacliente: 4 rows
/*!40000 ALTER TABLE `empresacliente` DISABLE KEYS */;
INSERT INTO `empresacliente` (`NIT`, `nombreEmpresa`, `usuarioE`, `passwordE`, `direccion`, `estado`) VALUES
	(830080785, 'RyP Consultores', 'rypconsultores', 'hola1', 'Av Boyaca 74 31', 1),
	(100, 'CyC Consultorias', 'cycconsultorias', 'cyc', 'Arriba', 1),
	(2000, 'McMillan', 'mcmillan', 'mcmillanpro', 'abajoooo', 0),
	(300, 'Yo y solo yo ', 'yo', 'yo', 'yo', 1);
/*!40000 ALTER TABLE `empresacliente` ENABLE KEYS */;

-- Dumping structure for table ryp.funciones
CREATE TABLE IF NOT EXISTS `funciones` (
  `idUsuario` int(5) NOT NULL,
  `idServicio` int(3) NOT NULL,
  `valoracion` int(2) NOT NULL,
  KEY `idUsuario` (`idUsuario`),
  KEY `idServicio` (`idServicio`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table ryp.funciones: 2 rows
/*!40000 ALTER TABLE `funciones` DISABLE KEYS */;
INSERT INTO `funciones` (`idUsuario`, `idServicio`, `valoracion`) VALUES
	(2, 2, 2),
	(4, 2, 5);
/*!40000 ALTER TABLE `funciones` ENABLE KEYS */;

-- Dumping structure for table ryp.horario
CREATE TABLE IF NOT EXISTS `horario` (
  `idHorario` int(5) NOT NULL AUTO_INCREMENT,
  `idTaR` int(3) NOT NULL,
  `idTrabajador` int(5) NOT NULL,
  `horaInicio` int(4) NOT NULL,
  `horaFinal` int(4) NOT NULL,
  `Fecha` varchar(12) NOT NULL,
  `estado` int(1) NOT NULL,
  PRIMARY KEY (`idHorario`),
  KEY `idTaR` (`idTaR`),
  KEY `idTrabajador` (`idTrabajador`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table ryp.horario: 4 rows
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` (`idHorario`, `idTaR`, `idTrabajador`, `horaInicio`, `horaFinal`, `Fecha`, `estado`) VALUES
	(1, 3, 2, 1016, 1017, '1/2/2018', 1),
	(2, 3, 4, 2327, 911, '22/3/2017', 1),
	(5, 2, 3, 11, 32, '7/5/2018', 1),
	(4, 1, 3, 74, 46, '9/6/2018', 1);
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;

-- Dumping structure for table ryp.mensaje
CREATE TABLE IF NOT EXISTS `mensaje` (
  `idU1` int(5) NOT NULL,
  `idU2` int(5) NOT NULL,
  `Asunto` varchar(30) NOT NULL,
  `Texto` varchar(100) NOT NULL,
  KEY `idU1` (`idU1`),
  KEY `idU2` (`idU2`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table ryp.mensaje: 2 rows
/*!40000 ALTER TABLE `mensaje` DISABLE KEYS */;
INSERT INTO `mensaje` (`idU1`, `idU2`, `Asunto`, `Texto`) VALUES
	(3, 2, 'Hola', 'Te queria decir hola'),
	(3, 4, 'Chao', 'Mensaje de Prueba');
/*!40000 ALTER TABLE `mensaje` ENABLE KEYS */;

-- Dumping structure for table ryp.servicio
CREATE TABLE IF NOT EXISTS `servicio` (
  `idServicio` int(3) NOT NULL AUTO_INCREMENT,
  `nombreS` varchar(30) NOT NULL,
  `estado` int(1) NOT NULL,
  PRIMARY KEY (`idServicio`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table ryp.servicio: 4 rows
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` (`idServicio`, `nombreS`, `estado`) VALUES
	(1, 'Contabilidad', 1),
	(2, 'Auditoria', 1),
	(3, 'Registrar Datos', 0),
	(4, 'Yo estoy probando', 1);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;

-- Dumping structure for table ryp.terminado
CREATE TABLE IF NOT EXISTS `terminado` (
  `idHorario` int(5) NOT NULL,
  `fechaTerminado` varchar(12) NOT NULL,
  `fechaRevisado` varchar(12) NOT NULL,
  `supervisor` int(5) NOT NULL,
  `estado` int(1) NOT NULL,
  KEY `idHorario` (`idHorario`),
  KEY `supervisor` (`supervisor`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table ryp.terminado: 1 rows
/*!40000 ALTER TABLE `terminado` DISABLE KEYS */;
INSERT INTO `terminado` (`idHorario`, `fechaTerminado`, `fechaRevisado`, `supervisor`, `estado`) VALUES
	(5, '08/08/2019', 'pr', 4, 0);
/*!40000 ALTER TABLE `terminado` ENABLE KEYS */;

-- Dumping structure for table ryp.trabajador
CREATE TABLE IF NOT EXISTS `trabajador` (
  `idUsuario` int(5) NOT NULL AUTO_INCREMENT,
  `usuarioT` varchar(30) NOT NULL,
  `passwordT` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `cargo` varchar(30) NOT NULL,
  `supervisor` int(5) DEFAULT NULL,
  `estado` int(1) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table ryp.trabajador: 3 rows
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
INSERT INTO `trabajador` (`idUsuario`, `usuarioT`, `passwordT`, `nombre`, `cargo`, `supervisor`, `estado`) VALUES
	(2, 'brendis', 'brendis', 'Brenda Mendez', 'e', 0, 1),
	(3, 'Osquitar', 'Hola', 'Oscar David Romero', 'e', 2, 1),
	(4, 'anfegave98', 'asdpfo', 'Andres Galeano', 'go', 0, 1);
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;

-- Dumping structure for table ryp.trabajoarealizar
CREATE TABLE IF NOT EXISTS `trabajoarealizar` (
  `idTrabajo` int(3) NOT NULL AUTO_INCREMENT,
  `idEmpresa` int(10) NOT NULL,
  `idServicio` int(3) NOT NULL,
  `Urgencia` int(2) NOT NULL,
  `Detalles` varchar(50) NOT NULL,
  `estado` int(1) NOT NULL,
  PRIMARY KEY (`idTrabajo`),
  KEY `idEmpresa` (`idEmpresa`),
  KEY `idServicio` (`idServicio`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table ryp.trabajoarealizar: 4 rows
/*!40000 ALTER TABLE `trabajoarealizar` DISABLE KEYS */;
INSERT INTO `trabajoarealizar` (`idTrabajo`, `idEmpresa`, `idServicio`, `Urgencia`, `Detalles`, `estado`) VALUES
	(1, 100, 2, 1, 'Es para el dia de Hoy', 1),
	(2, 300, 4, 6, 'Es para ya', 1),
	(3, 300, 4, 10, 'Hola', 1),
	(4, 300, 1, 3, 'Si me leen?', 0);
/*!40000 ALTER TABLE `trabajoarealizar` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
