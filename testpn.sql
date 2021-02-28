-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-02-2021 a las 20:04:10
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `testpn`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `IDCLIENTE` int(11) NOT NULL,
  `IDELEMENTO` int(11) DEFAULT NULL,
  `NOMBRECLIENTE` varchar(256) NOT NULL,
  `EMAILCLIENTE` varchar(256) NOT NULL,
  `ESTADO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`IDCLIENTE`, `IDELEMENTO`, `NOMBRECLIENTE`, `EMAILCLIENTE`, `ESTADO`) VALUES
(1, 1, 'EDWIN LANDETA', 'landetaedwin@gmail.com', 1),
(2, 2, 'EDWIN LANDETA', 'landetaedwin@hotmail.com', 1),
(3, 3, 'EDWIN LANDETA', 'landetaedwin@gmail.com', 1),
(4, 1, 'EDWIN LANDETA', 'landetaedwin@gmail.com', 1),
(5, 1, 'EDWIN LANDETA', 'landetaedwin@gmail.com', 1),
(6, 2, 'EDWIN LANDETA', 'landetaedwin@gmail.com', 1),
(7, 2, 'EDWIN LANDETA', 'landetaedwin@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `elementosred`
--

CREATE TABLE `elementosred` (
  `IDELEMENTO` int(11) NOT NULL,
  `DESCRIPCIONELEMENTO` varchar(256) NOT NULL,
  `ESTADO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `elementosred`
--

INSERT INTO `elementosred` (`IDELEMENTO`, `DESCRIPCIONELEMENTO`, `ESTADO`) VALUES
(1, 'R1', 1),
(2, 'R2', 1),
(3, 'R3', 1),
(4, 'R4', 1),
(5, 'R5', 1),
(6, 'R6', 1),
(7, 'R7', 1),
(8, 'R8', 1),
(9, 'R9', 1),
(10, 'R10', 1),
(11, 'SW1', 1),
(12, 'SW2', 1),
(13, 'SW3', 1),
(14, 'SW4', 1),
(15, 'SW5', 1),
(16, 'SW6', 1),
(17, 'SW7', 1),
(18, 'SW8', 1),
(19, 'SW9', 1),
(20, 'SW10', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `IDESTADO` int(11) NOT NULL,
  `DESCRIPCIONESTADO` varchar(1024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`IDESTADO`, `DESCRIPCIONESTADO`) VALUES
(1, 'Open'),
(2, 'Closed'),
(3, 'Overdue'),
(4, 'Escalated'),
(5, 'High Priority');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operador`
--

CREATE TABLE `operador` (
  `IDOPERADOR` int(11) NOT NULL,
  `NOMBREOPERADOR` varchar(50) NOT NULL,
  `APELLIDOOPERADOR` varchar(50) NOT NULL,
  `ESTADO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `operador`
--

INSERT INTO `operador` (`IDOPERADOR`, `NOMBREOPERADOR`, `APELLIDOOPERADOR`, `ESTADO`) VALUES
(1, 'Edwin', 'Landeta', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prioridad`
--

CREATE TABLE `prioridad` (
  `IDPRIORIDAD` int(11) NOT NULL,
  `DESCRIPCIONPRIORIDAD` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prioridad`
--

INSERT INTO `prioridad` (`IDPRIORIDAD`, `DESCRIPCIONPRIORIDAD`) VALUES
(1, 'High'),
(2, 'Medium'),
(3, 'Low');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `IDTICKET` int(11) NOT NULL,
  `IDPRIORIDAD` int(11) DEFAULT NULL,
  `IDESTADO` int(11) DEFAULT NULL,
  `IDOPERADOR` int(11) DEFAULT NULL,
  `IDELEMENTO` int(11) DEFAULT NULL,
  `DESCRIPCIONTICKET` varchar(1024) NOT NULL,
  `FECHACREACION` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `FECHAACTUALIZACION` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`IDTICKET`, `IDPRIORIDAD`, `IDESTADO`, `IDOPERADOR`, `IDELEMENTO`, `DESCRIPCIONTICKET`, `FECHACREACION`, `FECHAACTUALIZACION`) VALUES
(20, 1, 1, 1, 2, '21313132131', '2021-02-28 15:33:45', '2021-02-28 18:52:42'),
(22, 3, 1, 1, 18, 'ASDASDASDASD', '2021-02-28 15:58:06', '2021-02-28 18:52:53'),
(23, 2, 1, 1, 2, 'ASDADASDASD', '2021-02-28 16:00:42', NULL),
(24, 2, 1, 1, 2, 'asdasdasdasd', '2021-02-28 18:52:24', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`IDCLIENTE`),
  ADD KEY `FK_RELATIONSHIP_5` (`IDELEMENTO`);

--
-- Indices de la tabla `elementosred`
--
ALTER TABLE `elementosred`
  ADD PRIMARY KEY (`IDELEMENTO`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`IDESTADO`);

--
-- Indices de la tabla `operador`
--
ALTER TABLE `operador`
  ADD PRIMARY KEY (`IDOPERADOR`);

--
-- Indices de la tabla `prioridad`
--
ALTER TABLE `prioridad`
  ADD PRIMARY KEY (`IDPRIORIDAD`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`IDTICKET`),
  ADD KEY `FK_RELATIONSHIP_1` (`IDPRIORIDAD`),
  ADD KEY `FK_RELATIONSHIP_2` (`IDESTADO`),
  ADD KEY `FK_RELATIONSHIP_3` (`IDOPERADOR`),
  ADD KEY `FK_RELATIONSHIP_4` (`IDELEMENTO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `IDTICKET` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `FK_RELATIONSHIP_5` FOREIGN KEY (`IDELEMENTO`) REFERENCES `elementosred` (`IDELEMENTO`);

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`IDPRIORIDAD`) REFERENCES `prioridad` (`IDPRIORIDAD`),
  ADD CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`IDESTADO`) REFERENCES `estado` (`IDESTADO`),
  ADD CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`IDOPERADOR`) REFERENCES `operador` (`IDOPERADOR`),
  ADD CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`IDELEMENTO`) REFERENCES `elementosred` (`IDELEMENTO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
