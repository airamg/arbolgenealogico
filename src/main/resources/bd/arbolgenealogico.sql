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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=200 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=200 ;

--
-- Volcado de datos para la tabla `parentesco`
--

INSERT INTO `parentesco` (`id`, `descripcion`, `rama`) VALUES
(1, 'hermano', 0),
(2, 'hermana', 0),
(3, 'primo', 0),
(4, 'prima', 0),
(5, 'padre', 1),
(6, 'madre', 1),
(7, 'tio', 1),
(8, 'tia', 1),
(9, 'abuelo', 2),
(10, 'abuela', 2);



-- --------------------------------------------------------

--
-- Estructura para la tabla `miembro`
--

CREATE TABLE IF NOT EXISTS `miembro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ruta_imagen` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `anio_nacimiento` int(4) DEFAULT NULL,
  `anio_defuncion` int(4) DEFAULT NULL,
  `historial_medico` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `parentesco` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUsuario` (`usuario`),
  KEY `idParentesco` (`parentesco`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=200 ;

--
-- Volcado de datos para la tabla `miembro`
--

INSERT INTO `miembro` (`id`, `nombre`, `apellido`, `ruta_imagen`, `anio_nacimiento`, `anio_defuncion`, `historial_medico`, `usuario`, `parentesco`) VALUES
(1, 'Juan', 'Gonzalez', 'resources/images/arbol/miembro.png', 1960, NULL, 'enfermedad cardiovascular', 1, 5);

-- --------------------------------------------------------

--
-- Restricciones para tablas volcadas con claves de otras tablas
--

ALTER TABLE `miembro`
  ADD CONSTRAINT `miembro_ibfk_2` FOREIGN KEY (`parentesco`) REFERENCES `parentesco` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `miembro_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;


