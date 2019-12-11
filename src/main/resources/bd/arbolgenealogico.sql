--
-- Base de datos: `arbolgenealogico`
--

-- --------------------------------------------------------

--
-- Estructura para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pass` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidos` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ruta_imagen` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `online` int(1) DEFAULT NULL,
  `ultima_conexion` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `username`, `pass`, `nombre`, `apellidos`, `email`, `ruta_imagen`, `online`, `ultima_conexion`) VALUES
(1, 'maria', 'maria', 'Maria', 'Gonzalez Palacios', 'mgonzalezpalac@uoc.edu', 'resources/images/usuario/default.png', 0, '2019-12-03');


-- --------------------------------------------------------

--
-- Estructura para la tabla `parentesco`
--

CREATE TABLE IF NOT EXISTS `parentesco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rama` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=10;

--
-- Volcado de datos para la tabla `parentesco`
--

INSERT INTO `parentesco` (`id`, `descripcion`, `rama`) VALUES
(1, 'Hermano', 0),
(2, 'Hermana', 0),
(3, 'Primo', 0),
(4, 'Prima', 0),
(5, 'Padre', 1),
(6, 'Madre', 1),
(7, 'Tio', 1),
(8, 'Tia', 1),
(9, 'Abuelo', 2),
(10, 'Abuela', 2);



-- --------------------------------------------------------

--
-- Estructura para la tabla `miembro`
--

CREATE TABLE IF NOT EXISTS `miembro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ruta_imagen` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `anio_nacimiento` varchar(4) COLLATE utf8_spanish_ci DEFAULT NULL,
  `anio_defuncion` varchar(4) COLLATE utf8_spanish_ci DEFAULT NULL,
  `historial_medico` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `parentesco` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUsuario` (`usuario`),
  KEY `idParentesco` (`parentesco`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2;

--
-- Volcado de datos para la tabla `miembro`
--

INSERT INTO `miembro` (`id`, `nombre`, `apellido`, `ruta_imagen`, `anio_nacimiento`, `anio_defuncion`, `historial_medico`, `usuario`, `parentesco`) VALUES
(1, 'Juan', 'Gonzalez', 'resources/images/arbol/miembro.png', '1960', NULL, 'enfermedad cardiovascular', 1, 5);

-- --------------------------------------------------------

--
-- Restricciones para tablas volcadas con claves de otras tablas
--

ALTER TABLE `miembro`
  ADD CONSTRAINT `miembro_ibfk_2` FOREIGN KEY (`parentesco`) REFERENCES `parentesco` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `miembro_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;


