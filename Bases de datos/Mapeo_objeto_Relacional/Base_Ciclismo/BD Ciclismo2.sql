-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ciclismo
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ciclismo` ;

-- -----------------------------------------------------
-- Schema ciclismo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ciclismo` DEFAULT CHARACTER SET latin1 ;
USE `ciclismo` ;

-- -----------------------------------------------------
-- Table `ciclismo`.`equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciclismo`.`equipo` (
  `nomeq` VARCHAR(25) NOT NULL,
  `director` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`nomeq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES ('Amore Vita','Ricardo Padacci'),('Artiach','José Peréz'),('Banesto','Miguel Echevarria'),('Bresciali-Refin','Pietro Armani'),('Carrera','Luigi Petroni'),('Castorama','Jean Philip'),('dam55','Javier Garcia'),('Euskadi','Pedro Txucaru'),('Gatorade','Gian Luca Pacceli'),('Gewiss','Moreno Argentin'),('Jolly Club','Johan Richard'),('Kelme','Álvaro Pino'),('Lotus Festina','Suarez Cuevas'),('Mapei-Clas','Juan Fernandez'),('Mercatone Uno','Ettore Romano'),('Motorola','John Fidwell'),('Navigare','Lonrenzo Sciacci'),('ONCE','Manuel Sainz'),('PDM','Piet Van Der Kruis'),('Seguros Amaya','Minguez'),('Telecom','Morgan Reikcard'),('TVM','Steveens Henk'),('Wordperfect','Bill Gates');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `ciclismo`.`ciclista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciclismo`.`ciclista` (
  `dorsal` SMALLINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `nomeq` VARCHAR(25) NOT NULL,
  `nacimiento` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`dorsal`),
  INDEX `equipociclista` (`nomeq` ASC) ,
  INDEX `FK_ciclistaequipo_idx` (`nomeq` ASC) ,
  CONSTRAINT `FK_ciclistaequipo`
    FOREIGN KEY (`nomeq`)
    REFERENCES `ciclismo`.`equipo` (`nomeq`))
ENGINE = InnoDB
AUTO_INCREMENT = 103
DEFAULT CHARACTER SET = latin1;

--
-- Dumping data for table `ciclista`
--

LOCK TABLES `ciclista` WRITE;
/*!40000 ALTER TABLE `ciclista` DISABLE KEYS */;
INSERT INTO `ciclista` VALUES (1,'Miguel Induráin','Banesto','1982-11-13'),(2,'Pedro Delgado','Banesto','1979-11-13'),(3,'Alex Zulle','ONCE','1987-11-13'),(4,'Tony Rominger','Mapei-Clas','1984-11-13'),(5,'Gert-Jan Theunisse','PDM','1982-11-13'),(6,'Adriano Baffi','Mercatone Uno','1981-11-13'),(7,'Massimiliano Lelli','Mercatone Uno','1984-11-13'),(8,'Jean Van Poppel','Lotus Festina','1981-11-13'),(9,'Massimo Podenzana','Navigare','1980-11-13'),(10,'Mario Cipollini','Mercatone Uno','1986-11-13'),(11,'Flavio Giupponi','Bresciali-Refin','1983-11-13'),(12,'Alessio Di Basco','Amore Vita','1983-11-13'),(13,'Lale Cubino','Seguros Amaya','1986-11-13'),(14,'Roberto Pagnin','Navigare','1981-11-13'),(15,'Jesper Skibby','TVM','1983-11-13'),(16,'Dimitri Konishev','Jolly Club','1985-11-13'),(17,'Bruno Leali','Bresciali-Refin','1977-11-13'),(18,'Robert Millar','TVM','1977-11-13'),(19,'Julian Gorospe','Banesto','1980-11-13'),(20,'Alfonso Gutiérrez','Artiach','1985-11-13'),(21,'Erwin Nijboer','Artiach','1983-11-13'),(22,'Giorgio Furlan','Gewiss','1982-11-13'),(23,'Lance Armstrong','Motorola','1987-11-13'),(24,'Claudio Chiappucci','Carrera','1985-11-13'),(25,'Gianni Bugno','Gatorade','1982-11-13'),(26,'Mikel Zarrabeitia','Banesto','1987-11-13'),(27,'Laurent Jalabert','ONCE','1986-11-13'),(28,'Jesus Montoya','Banesto','1981-11-13'),(29,'Angel Edo','Kelme','1986-11-13'),(30,'Melchor Mauri','Banesto','1986-11-13'),(31,'Vicente Aparicio','Banesto','1984-11-13'),(32,'Laurent Dufaux','ONCE','1986-11-13'),(33,'Stefano della Santa','Mapei-Clas','1985-11-13'),(34,'Angel Yesid Camargo','Kelme','1984-11-13'),(35,'Erik Dekker','Wordperfect','1986-11-13'),(36,'Gian Matteo Fagnini','Mercatone Uno','1982-11-13'),(37,'Scott Sunderland','TVM','1985-11-13'),(38,'Javier Palacin','Euskadi','1989-11-13'),(39,'Rudy Verdonck','Lotus Festina','1984-11-13'),(40,'Viatceslav Ekimov','Wordperfect','1982-11-13'),(41,'Rolf Aldag','Telecom','1989-11-13'),(42,'Davide Cassani','TVM','1985-11-13'),(43,'Francesco Casagrande','Mercatone Uno','1986-11-13'),(44,'Luca Gelfi','Gatorade','1987-11-13'),(45,'Alberto Elli','Artiach','1988-11-13'),(46,'Agustin Sagasti','Euskadi','1990-11-13'),(47,'Laurent Pillon','Gewiss','1982-11-13'),(48,'Marco Saligari','Gewiss','1985-11-13'),(49,'Eugeni Berzin','Gewiss','1991-11-13'),(50,'Fernando Escartin','Mapei-Clas','1987-11-13'),(51,'Udo Bolts','Telecom','1984-11-13'),(52,'Vladislav Bobrik','Gewiss','1988-11-13'),(53,'Michele Bartoli','Mercatone Uno','1986-11-13'),(54,'Steffen Wesemann','Telecom','1984-11-13'),(55,'Nicola Minali','Gewiss','1986-11-13'),(56,'Andrew Hampsten','Banesto','1985-11-13'),(57,'Stefano Zanini','Navigare','1986-11-13'),(58,'Gerd Audehm','Telecom','1980-11-13'),(59,'Mariano Picolli','Mercatone Uno','1986-11-13'),(60,'Giovanni Lombardi','Bresciali-Refin','1986-11-13'),(61,'Walte Castignola','Navigare','1988-11-13'),(62,'Raul Alcala','Motorola','1984-11-13'),(63,'Alvaro Mejia','Motorola','1982-11-13'),(64,'Giuseppe Petito','Mercatone Uno','1986-11-13'),(65,'Pascal Lino','Amore Vita','1985-11-13'),(66,'Enrico Zaina','Gewiss','1990-11-13'),(67,'Armand de las Cuevas','Castorama','1986-11-13'),(68,'Angel Citracca','Navigare','1986-11-13'),(69,'Eddy Seigneur','Castorama','1987-11-13'),(70,'Sandro Heulot','Banesto','1985-11-13'),(71,'Prudencio Induráin','Banesto','1987-11-13'),(72,'Stefano Colage','Bresciali-Refin','1986-11-13'),(73,'Laurent Fignon','Gatorade','1979-11-13'),(74,'Claudio Chioccioli','Amore Vita','1978-11-13'),(75,'Juan Romero','Seguros Amaya','1982-11-13'),(76,'Marco Giovannetti','Gatorade','1980-11-13'),(77,'Javier Mauleon','Mapei-Clas','1981-11-13'),(78,'Antonio Esparza','Kelme','1979-11-13'),(79,'Johan Bruyneel','ONCE','1981-11-13'),(80,'Federico Echave','Mapei-Clas','1977-11-13'),(81,'Piotr Ugrumov','Gewiss','1981-11-13'),(82,'Edgar Corredor','Kelme','1984-11-13'),(83,'Hernan Buenahora','Kelme','1982-11-13'),(84,'Jon Unzaga','Mapei-Clas','1983-11-13'),(85,'Dimitri Abdoujaparov','Carrera','1984-11-13'),(86,'Juan Martinez Oliver','Kelme','1982-11-13'),(87,'Fernando Mota','Artiach','1982-11-13'),(88,'Angel Camarillo','Mapei-Clas','1986-11-13'),(89,'Stefan Roche','Carrera','1978-11-13'),(90,'Ivan Ivanov','Artiach','1987-11-13'),(91,'Nestor Mora','Kelme','1986-11-13'),(92,'Federico Garcia','Artiach','1987-11-13'),(93,'Bo Hamburger','TVM','1985-11-13'),(94,'Marino Alonso','Banesto','1984-11-13'),(95,'Manuel Guijarro','Lotus Festina','1983-11-13'),(96,'Tom Cordes','Wordperfect','1985-11-13'),(97,'Casimiro Moreda','ONCE','1986-11-13'),(98,'Eleuterio Anguita','Artiach','1989-11-13'),(99,'Per Pedersen','Seguros Amaya','1985-11-13'),(100,'William Palacios','Jolly Club','1984-11-13'),(101,'nuevo','Banesto',NULL),(102,'nuevo2','Banesto',NULL);
/*!40000 ALTER TABLE `ciclista` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ciclismo`.`etapa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciclismo`.`etapa` (
  `netapa` SMALLINT NOT NULL,
  `km` SMALLINT NOT NULL,
  `salida` VARCHAR(35) NOT NULL,
  `llegada` VARCHAR(35) NOT NULL,
  `dorsal` SMALLINT NULL DEFAULT NULL,
  PRIMARY KEY (`netapa`),
  INDEX `ciclistaetapa` (`dorsal` ASC) ,
  INDEX `fk_etapaciclista_idx` (`dorsal` ASC) ,
  CONSTRAINT `fk_etapaciclista`
    FOREIGN KEY (`dorsal`)
    REFERENCES `ciclismo`.`ciclista` (`dorsal`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


--
-- Dumping data for table `etapa`
--

LOCK TABLES `etapa` WRITE;
/*!40000 ALTER TABLE `etapa` DISABLE KEYS */;
INSERT INTO `etapa` VALUES (1,9,'Valladolid','Valladolid',1),(2,180,'Valladolid','Salamanca',36),(3,240,'Salamanca','Caceres',12),(4,230,'Almendralejo','Córdoba',83),(5,170,'Córdoba','Granada',27),(6,150,'Granada','Sierra Nevada',52),(7,250,'Baza','Alicante',22),(8,40,'Benidorm','Benidorm',1),(9,150,'Benidorm','Valencia',35),(10,200,'Igualada','Andorra',2),(11,195,'Andorra','Estación de Cerler',65),(12,220,'Benasque','Zaragoza',12),(13,200,'Zaragoza','Pamplona',93),(14,172,'Pamplona','Alto de la Cruz de la Demanda',86),(15,207,'Santo Domingo de la Calzada','Santander',10),(16,160,'Santander','Lagos de Covadonga',5),(17,140,'Cangas de Onis','Alto del Naranco',4),(18,195,'Ávila','Ávila',8),(19,190,'Ávila','Destilerias Dyc',2),(20,52,'Segovia','Destilerias Dyc',2),(21,170,'Destilerias Dyc','Madrid',27);
/*!40000 ALTER TABLE `etapa` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ciclismo`.`puerto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciclismo`.`puerto` (
  `nompuerto` VARCHAR(35) NOT NULL,
  `altura` SMALLINT NOT NULL,
  `categoria` VARCHAR(1) NOT NULL,
  `pendiente` DOUBLE(15,5) NULL DEFAULT NULL,
  `netapa` SMALLINT NOT NULL,
  `dorsal` SMALLINT NULL DEFAULT NULL,
  PRIMARY KEY (`nompuerto`),
  INDEX `ciclistapuerto` (`dorsal` ASC) ,
  INDEX `etapapuerto` (`netapa` ASC) ,
  INDEX `fk_puertociclista_idx` (`dorsal` ASC) ,
  INDEX `fk_puertoetapa_idx` (`netapa` ASC) ,
  CONSTRAINT `fk_puertociclista`
    FOREIGN KEY (`dorsal`)
    REFERENCES `ciclismo`.`ciclista` (`dorsal`),
  CONSTRAINT `fk_puertoetapa`
    FOREIGN KEY (`netapa`)
    REFERENCES `ciclismo`.`etapa` (`netapa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

--
-- Dumping data for table `puerto`
--

LOCK TABLES `puerto` WRITE;
/*!40000 ALTER TABLE `puerto` DISABLE KEYS */;
INSERT INTO `puerto` VALUES ('Alto del Naranco',565,'1',6.90000,10,30),('Angliru',1500,'E',15.00000,7,2),('Arcalis',2230,'E',6.50000,10,4),('Cerler-Circo de Ampriu',2500,'E',5.87000,11,9),('Coll de la Comella',1362,'1',8.07000,10,2),('Coll de Ordino',1980,'E',5.30000,10,7),('Cruz de la Demanda',1850,'E',7.00000,11,20),('La Pandereta',1456,'E',12.00000,8,4),('Lagos de Covadonga',1134,'E',6.86000,16,42),('Navacerrada',1860,'1',7.50000,19,2),('Puerto de Alisas',672,'1',5.80000,15,1),('Puerto de la Morcuera',1760,'2',6.50000,19,2),('Puerto de Mijares',1525,'1',4.90000,18,24),('Puerto de Navalmoral',1521,'2',4.30000,18,2),('Puerto de Pedro Bernardo',1250,'1',4.20000,18,25),('Sierra Nevada',2500,'E',6.00000,2,26),('Tourmalet',2100,'E',10.00000,3,4);
/*!40000 ALTER TABLE `puerto` ENABLE KEYS */;
UNLOCK TABLES;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
