
CREATE DATABASE ejemploh;

USE ejemploh;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `departamentos` (
`dept_NO` TINYINT NOT NULL,
`dnombre` VARCHAR(15) ,
`loc` VARCHAR(15)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `departamentos` VALUES (10, 'INFORMATICA', 'DESPA6');
INSERT INTO `departamentos` VALUES (20, 'COMERCIO', 'DESPA7');
INSERT INTO `departamentos` VALUES (30, 'ADMINISTRATIVO', 'DESPA8');
INSERT INTO `departamentos` VALUES (40, 'FOL', 'DESPA5');



CREATE TABLE `empleados` (
	`emp_no` SMALLINT NOT NULL,
	`nombre` VARCHAR(20),
	`oficio` VARCHAR(15),
	`fecha_alta` DATE,
	`salario` FLOAT(6,2),
	`comision` FLOAT(6,2),
	`dept_NO` TINYINT
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `empleados` VALUES (1, 'Luz Martinez', 'Profesor','1990-01-01', 900, 0, 10);
INSERT INTO `empleados` VALUES (2, 'Cristina Ausina', 'Profesor', '1990-02-01', 800, 0, 10);
INSERT INTO `empleados` VALUES (3, 'Imma Cabanes', 'Profesor', '1990-03-01', 800, 0, 10);
INSERT INTO `empleados` VALUES (4, 'Gissela García', 'Profesor', '2020-10-20', 800, 0, 40);
INSERT INTO `empleados` VALUES (5, 'María Sánchez', 'Profesor', '1990-03-01', 800, 0, 40);
INSERT INTO `empleados` VALUES (112, 'Fernanda Sánchez', 'Profesor', '1990-03-01', 700, 0, 40);
INSERT INTO `empleados` VALUES (200, 'Pepe Sánchez', 'Profesor', '2016-03-01', 700, 0, 40);


ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`dept_NO`);

ALTER TABLE `empleados`
  ADD PRIMARY KEY (`emp_no`);



ALTER TABLE `empleados`
  ADD CONSTRAINT `restrict_dept_NO` FOREIGN KEY (`dept_NO`) REFERENCES `departamentos` (`dept_NO`);
COMMIT;