drop database if exists monitoreasy;
CREATE DATABASE  IF NOT EXISTS `monitoreasy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `monitoreasy`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: monitoreasy
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `matricula` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `periodo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=20190052 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (20190001,'Ajuricaba Ferraz','AjuricabaFerraz@gmail.com','20190000',1),(20190002,'Albino Castel-Branco','AlbinoCastelBranco@gmail.com','20190000',2),(20190003,'Almor Mendonça','AlmorMendonça@gmail.com','20190000',3),(20190004,'Augusta Ruela','AugustaRuela@gmail.com','20190000',4),(20190005,'Basilio Boga','BasilioBoga@gmail.com','20190000',5),(20190006,'Belmiro Lira','BelmiroLira@gmail.com','20190000',6),(20190007,'Bernardete Álvares','BernardeteAlvares@gmail.com','20190000',1),(20190008,'Brenda Murtinho','BrendaMurtinho@gmail.com','20190000',2),(20190009,'Brígida Rivero','BrígidaRivero@gmail.com','20190000',2),(20190010,'Calisto Peixoto','CalistoPeixoto@gmail.com','20190000',3),(20190011,'Carla Cotrim','CarlaCotrim@gmail.com','20190000',3),(20190012,'Cauê Salgueiro','CaueSalgueiro@gmail.com','20190000',3),(20190013,'Celestina Silvera','CelestinaSilvera@gmail.com','20190000',4),(20190014,'Constantino Roriz','ConstantinoRoriz@gmail.com','20190000',4),(20190015,'Donato Souto Maior','DonatoSoutoMaior@gmail.com','20190000',4),(20190016,'Dulce Quintella','DulceQuintella@gmail.com','20190000',4),(20190017,'Estefânia Camilo','EstefaniaCamilo@gmail.com','20190000',4),(20190018,'Eva Gutiérrez','EvaGutierrez@gmail.com','20190000',4),(20190019,'Evaristo Javier','EvaristoJavier@gmail.com','20190000',4),(20190020,'Fabrício Imperial','FabricioImperial@gmail.com','20190000',4),(20190021,'Ferdinando Luz','FerdinandoLuz@gmail.com','20190000',4),(20190022,'Frederica Batista','FredericaBatista@gmail.com','20190000',1),(20190023,'Greice Vilaça','GreiceVilaca@gmail.com','20190000',1),(20190024,'Guadalupe Amorín','GuadalupeAmorin@gmail.com','20190000',1),(20190025,'Gui Lucas','GuiLucas@gmail.com','20190000',1),(20190026,'Heloísa Moura','HeloisaMoura@gmail.com','20190000',1),(20190027,'Juliano Varela','JulianoVarela@gmail.com','20190000',1),(20190028,'Julieta Quinzeiro','JulietaQuinzeiro@gmail.com','20190000',1),(20190029,'Juçara Suaçuna','JucaraSuacuna@gmail.com','20190000',2),(20190030,'Leonel Vázquez','LeonelVazquez@gmail.com','20190000',2),(20190031,'Lídia Cerveira','LidiaCerveira@gmail.com','20190000',2),(20190032,'Marcelo Ignacio','MarceloIgnacio@gmail.com','20190000',2),(20190033,'Marcos Cezar','MarcosCezar@gmail.com','20190000',2),(20190034,'Marli Salguero','MarliSalguero@gmail.com','20190000',2),(20190035,'Martim Dinis','MartimDinis@gmail.com','20190000',4),(20190036,'Moema Linhares','MoemaLinhares@gmail.com','20190000',3),(20190037,'Nádia Garcés','NadiaGarces@gmail.com','20190000',3),(20190038,'Nádia Noguera','NadiaNoguera@gmail.com','20190000',5),(20190039,'Paulo Guará','PauloGuara@gmail.com','20190000',5),(20190040,'Piedade Maia','PiedadeMaia@gmail.com','20190000',5),(20190041,'Ramiro Flores','RamiroFlores@gmail.com','20190000',5),(20190042,'Ricardina González','RicardinaGonzalez@gmail.com','20190000',5),(20190043,'Severino Higuera','SeverinoHiguera@gmail.com','20190000',6),(20190044,'Simão Coelho','SimaoCoelho@gmail.com','20190000',6),(20190045,'Socorro Azeredo','SocorroAzeredo@gmail.com','20190000',6),(20190046,'Valmor Rabelo','ValmorRabelo@gmail.com','20190000',6),(20190047,'Virgília Muniz','VirgiliaMuniz@gmail.com','20190000',6),(20190048,'Viridiano Capistrano','ViridianoCapistrano@gmail.com','20190000',1),(20190049,'Viviana Cisneiros','VivianaCisneiros@gmail.com','20190000',1),(20190050,'Átila Varela','AtilaVarela@gmail.com','20190000',1),(20190051,'teste','teste','teste',1);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordenador`
--

DROP TABLE IF EXISTS `coordenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coordenador` (
  `login` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenador`
--

LOCK TABLES `coordenador` WRITE;
/*!40000 ALTER TABLE `coordenador` DISABLE KEYS */;
INSERT INTO `coordenador` VALUES ('jorlene','123');
/*!40000 ALTER TABLE `coordenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data` (
  `dia` date NOT NULL,
  `loccodigo` varchar(10) NOT NULL,
  PRIMARY KEY (`dia`,`loccodigo`),
  KEY `loccodigo` (`loccodigo`),
  CONSTRAINT `data_local_fk` FOREIGN KEY (`loccodigo`) REFERENCES `local` (`codigo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
INSERT INTO `data` VALUES ('2019-10-21','LAB I'),('2019-10-23','LAB I'),('2019-11-04','LAB I'),('2019-12-06','LAB I'),('2019-10-21','LAB II'),('2019-10-21','LAB III'),('2019-10-22','LAB III'),('2019-11-18','LAB III'),('2019-11-19','LAB III'),('2019-10-21','LAB IV'),('2019-10-21','LAB IX');
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina` (
  `codigo` varchar(7) NOT NULL,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES ('AOP','Análise Organizacional e de Processos'),('ATP','Algoritmo e Técnicas de Programação'),('CDI','Cálculo Diferencial e Integral'),('DRA','Desenvolvimento Rápido de Aplicações'),('ED','Estrutura de Dados'),('ERAS','Engenharia de Requisitos e Análise de Sistemas'),('FAC','Filosofia Aplicada à Computação'),('IHM','Interface Homem Máquina'),('II','Inglês Instrumental'),('LM','Lógica Matemática'),('LPOO','Linguagem e Programação Orientada a Objetos'),('MPES','Metodologia de Pesquisa Aplicada à Computação'),('MPIBD','Modelagem, Projeto e Implementação de BD'),('OC','Organização de Computadores'),('PA','Programação Aplicada'),('PDS','Processos de Desenvolvimento de Software'),('PE','Probabilidade e Estatística'),('PIG','Projeto de Interface Gráfica'),('PP','Padrões de Projeto'),('PT','Produção de Textos'),('RC','Redes de Computadores'),('SO','Sistemas Operacionais');
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hora`
--

DROP TABLE IF EXISTS `hora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hora` (
  `hora` time NOT NULL,
  `datdia` date NOT NULL,
  `datloccodigo` varchar(10) NOT NULL,
  PRIMARY KEY (`hora`,`datdia`,`datloccodigo`),
  KEY `datdia` (`datdia`),
  KEY `datloccodigo` (`datloccodigo`),
  CONSTRAINT `hora_data_fk1` FOREIGN KEY (`datdia`) REFERENCES `data` (`dia`) ON DELETE CASCADE,
  CONSTRAINT `hora_data_fk2` FOREIGN KEY (`datloccodigo`) REFERENCES `data` (`loccodigo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hora`
--

LOCK TABLES `hora` WRITE;
/*!40000 ALTER TABLE `hora` DISABLE KEYS */;
INSERT INTO `hora` VALUES ('13:00:00','2019-10-21','LAB IV'),('13:00:00','2019-11-19','LAB III'),('13:00:00','2019-12-06','LAB I'),('14:00:00','2019-12-06','LAB I');
/*!40000 ALTER TABLE `hora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local` (
  `codigo` varchar(10) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES ('LAB I'),('LAB II'),('LAB III'),('LAB IV'),('LAB IX'),('LAB V'),('LAB VI'),('LAB VII'),('LAB VIII');
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitora`
--

DROP TABLE IF EXISTS `monitora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monitora` (
  `dtinicio` date NOT NULL,
  `dtfim` date DEFAULT NULL,
  `discodigo` varchar(7) NOT NULL,
  `monmatricula` int(10) unsigned NOT NULL,
  `cicloletivo` char(6) DEFAULT NULL,
  PRIMARY KEY (`dtinicio`,`discodigo`,`monmatricula`),
  KEY `discodigo` (`discodigo`),
  KEY `monmatricula` (`monmatricula`),
  CONSTRAINT `monitora_aluno_fk2` FOREIGN KEY (`monmatricula`) REFERENCES `aluno` (`matricula`) ON DELETE CASCADE,
  CONSTRAINT `monitora_disciplina_fk1` FOREIGN KEY (`discodigo`) REFERENCES `disciplina` (`codigo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitora`
--

LOCK TABLES `monitora` WRITE;
/*!40000 ALTER TABLE `monitora` DISABLE KEYS */;
INSERT INTO `monitora` VALUES ('2019-10-08',NULL,'AOP',20190002,'2019/2'),('2019-10-08',NULL,'DRA',20190001,'2019/2'),('2019-10-08',NULL,'DRA',20190003,'2019/2'),('2019-10-08',NULL,'DRA',20190005,'2019/2'),('2019-10-17',NULL,'IHM',20190004,'2019/2');
/*!40000 ALTER TABLE `monitora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participa`
--

DROP TABLE IF EXISTS `participa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participa` (
  `alumatricula` int(10) unsigned NOT NULL,
  `resmonmatricula` int(10) unsigned NOT NULL,
  `resdatahora` datetime NOT NULL,
  `resloccodigo` varchar(10) NOT NULL,
  PRIMARY KEY (`alumatricula`,`resmonmatricula`,`resdatahora`,`resloccodigo`),
  KEY `resmonmatricula` (`resmonmatricula`),
  KEY `resdatahora` (`resdatahora`),
  KEY `resloccodigo` (`resloccodigo`),
  CONSTRAINT `participa_aluno_fk1` FOREIGN KEY (`alumatricula`) REFERENCES `aluno` (`matricula`) ON DELETE CASCADE,
  CONSTRAINT `participa_reserva_fk2` FOREIGN KEY (`resmonmatricula`) REFERENCES `reserva` (`monmatricula`) ON DELETE CASCADE,
  CONSTRAINT `participa_reserva_fk3` FOREIGN KEY (`resdatahora`) REFERENCES `reserva` (`datahora`) ON DELETE CASCADE,
  CONSTRAINT `participa_reserva_fk4` FOREIGN KEY (`resloccodigo`) REFERENCES `reserva` (`loccodigo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participa`
--

LOCK TABLES `participa` WRITE;
/*!40000 ALTER TABLE `participa` DISABLE KEYS */;
INSERT INTO `participa` VALUES (20190005,20190001,'2019-12-06 13:00:00','LAB I');
/*!40000 ALTER TABLE `participa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `datahora` datetime NOT NULL,
  `monmatricula` int(10) unsigned NOT NULL,
  `loccodigo` varchar(10) NOT NULL,
  PRIMARY KEY (`datahora`,`monmatricula`,`loccodigo`),
  KEY `monmatricula` (`monmatricula`),
  KEY `loccodigo` (`loccodigo`),
  CONSTRAINT `reserva_aluno_fk1` FOREIGN KEY (`monmatricula`) REFERENCES `aluno` (`matricula`) ON DELETE CASCADE,
  CONSTRAINT `reserva_local_fk2` FOREIGN KEY (`loccodigo`) REFERENCES `local` (`codigo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES ('2019-10-22 13:00:00',20190001,'LAB III'),('2019-10-23 13:00:00',20190001,'LAB I'),('2019-10-28 13:00:00',20190001,'LAB I'),('2019-11-04 13:00:00',20190001,'LAB I'),('2019-11-06 13:00:00',20190001,'LAB I'),('2019-11-19 13:00:00',20190001,'LAB III'),('2019-12-06 13:00:00',20190001,'LAB I'),('2019-10-21 13:00:00',20190002,'LAB III'),('2019-10-21 13:00:00',20190003,'LAB I'),('2019-10-21 13:00:00',20190005,'LAB IV');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'monitoreasy'
--

--
-- Dumping routines for database 'monitoreasy'
--
/*!50003 DROP FUNCTION IF EXISTS `fnCancelarAtendimento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnCancelarAtendimento`(alumat int, dthr datetime, loc varchar(7)) RETURNS int(11)
    DETERMINISTIC
begin
	declare validacao int;
    set validacao = 0;
    
    -- verifica se existe instância desse usuário e caso exista, verifica se ainda falta menos de 24 horas
    select count(*) into validacao
	from participa
	where alumatricula = alumat and resdatahora = dthr and resloccodigo = loc
	and now() <  date_sub(resdatahora, interval 1 day) ;
    
    -- caso exista e falte menos que 24 horas, então cancela
    if validacao > 0 then
		
        delete from participa
        where alumatricula = alumat and resdatahora = dthr and resloccodigo = loc;
        return 0;
    else
		-- caso contrario, retorna 1
        return 1;
    end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnCancelarReserva` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnCancelarReserva`(monmat int, dthr datetime, local varchar(7)) RETURNS int(11)
    DETERMINISTIC
begin 
	declare validacao int;
    set validacao = 0;
    
    -- verifica se existe referencia na tablea participa
	select count(resmonmatricula) into validacao
	from reserva
	inner join participa on resmonmatricula = monmatricula and resdatahora = datahora and resloccodigo = loccodigo
	where resmonmatricula = monmat and resdatahora = dthr and resloccodigo = local;
    
    -- caso exista, retorna 1
    if validacao > 0 then
		return 1;
	end if;
    -- remove a reserva caso não haja alunos com agendamento
    delete from reserva
    where monmatricula = monmat and datahora = dthr and loccodigo = local;
    -- retorna 0 se tudo ocorrer bem
    return 0;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnLoginAluno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnLoginAluno`(mat int, sen varchar(50)) RETURNS int(11)
    DETERMINISTIC
begin
    -- verifica se o aluno possui uma instancia na base de dados
    if exists(select *
		from aluno
		where matricula = mat and senha = sen
    ) then    
    -- caso seja localizado uma instância, permite o acesso
		return 1;
	else
		return 0;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnLoginCoordenador` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnLoginCoordenador`(log varchar(20), sen varchar(20)) RETURNS int(11)
    DETERMINISTIC
begin
    if exists(select *
		from coordenador
		where login = log and senha = sen
    ) then    
    -- caso seja localizado uma instânciua que cumpra os requisitos anteriores, permite o acesso do monitor
		return 1;
	else
		return 0;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnLoginMonitor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnLoginMonitor`(mat int, sen varchar(50)) RETURNS int(11)
    DETERMINISTIC
begin
    if exists(select *
		from aluno
		inner join monitora on monmatricula = matricula
		where matricula = mat and senha = sen and dtfim is null
    ) then    
    -- caso seja localizado uma instânciua que cumpra os requisitos anteriores, permite o acesso do monitor
		return 1;
	else
		return 0;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnRemoverLocalDataHorario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnRemoverLocalDataHorario`(loc varchar(7), dt date, hr time) RETURNS int(11)
    DETERMINISTIC
begin
	-- verifica se existe reserva com esse loca, data e horário
	if exists (
		select h.hora
		from hora h
		inner join data d on h.datdia = d.dia and h.datloccodigo = d.loccodigo
		inner join local l on d.loccodigo = l.codigo
		inner join reserva r on l.codigo = r.loccodigo and concat(h.datdia, ' ', h.hora) = datahora
		where h.datdia = dt and h.hora = hr and h.datloccodigo = loc
    ) then
    
		return 1;
	
    else
		-- remove a hora
		delete from hora
		where hora = hr and datdia = dt and datloccodigo = loc;
        
        -- verifica se não existe horários associados a uma data
        -- OBS: essa parte tá afetanto a inconsistencia do banco
		/*if not exists (
			select hora
			from hora
			inner join data on datdia = dia and datloccodigo = loccodigo
			where datdia = dt and datloccodigo = loc
		) then
        
				-- caso não haja nenhuma instancia em data, então remove a data
				delete from data
				where dia = dt and loccodigo = loc;
		end if;*/
        
    end if;
		 
    
    -- caso tudo tenha ocorrido corretamente, retorna 0 
    return 0;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnReservaLocal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnReservaLocal`(dthr datetime, monmat int, loccod varchar(10)) RETURNS int(11)
    DETERMINISTIC
begin
	declare validacao int;
    
    select count(*) into validacao
    from reserva
    where datahora = dthr and loccodigo = loccod;
    
    if validacao != 0 then
		return 0;
	else
		insert into reserva (datahora, monmatricula, loccodigo) 
		values (dthr, monmat, loccod);
        return 1;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnReservarAtendimento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnReservarAtendimento`(alumat int, monmat int, dthr datetime, localcod varchar(10)) RETURNS int(11)
    DETERMINISTIC
begin
	declare qtd int;
    declare validacao int;
    set validacao = 0;
	
    -- verifica se o aluno que quer reservar o atendimento, é o proprio monitor
	select count(*) into validacao
	from reserva
	where monmatricula = alumat and datahora = dthr and loccodigo = localcod;
    
    if validacao != 0 then
		return 4;
    end if;

	set validacao = 0;

    -- verifica se o aluno já está cadastrado em alguma monitoria nesse horario
    select count(*) into validacao
    from participa
    where alumatricula = alumat and resdatahora = dthr;
    
    if validacao != 0 then
		set validacao = 0;
		--
		select count(*) into validacao
		from participa
		where alumatricula = alumat and resdatahora = dthr and resloccodigo = localcod;
    
		if validacao != 0 then
			return 3;
        else
			return 1;
		end if;
	end if;

    set validacao = 0;   
    
     
    -- verifica se a quantidade de instacias na tabela participa
    select count(alumatricula) into qtd
    from reserva
    inner join participa on loccodigo = resloccodigo and datahora = resdatahora
    where loccodigo = localcod and datahora = dthr;
    
    -- caso a quantidade for menor que 8, então o aluno poderá reservar o atendimento
    if qtd < 8 then
		insert into participa (alumatricula, resmonmatricula, resdatahora, resloccodigo)
		values (alumat, monmat, dthr, localcod);
        return 2;
	else
		return 0;
	end if;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnReservarHorarioMonitoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnReservarHorarioMonitoria`(dthr datetime , matricula int, local varchar(7), dthrsempost datetime) RETURNS int(11)
    DETERMINISTIC
begin
	declare validacao int;
	set validacao = 0;
    
    select count(datahora) into validacao
    from reserva
    where datahora >= dthrsempost and monmatricula = matricula;
    
    if validacao >= 12 then
		return 1;
	end if;
    
    select count(datahora) into validacao
    from reserva
    where datahora = dthr and monmatricula = matricula;
    
    if validacao > 0 then
		return 2;
	end if;
    
    select count(datahora) into validacao
    from reserva
    where datahora = dthr and loccodigo = local;
    
    if validacao > 0 then
		return 3;
	end if;    

	insert into reserva (datahora, monmatricula, loccodigo) values(dthr, matricula, local);
    return 0;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnTornaAlunoMonitor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnTornaAlunoMonitor`(codigo varchar(7), matricula int, dtinicio date, periodo char(6)) RETURNS int(11)
    DETERMINISTIC
begin
    declare qtd int;
    declare validacao int;
    
    -- consulta para verificar se o aluno já está sendo monitor
    select count(monmatricula) into validacao
    from monitora
    where monmatricula = matricula and dtfim is null;
    
    -- caso ele seja, retorna 1
    if validacao != 0 then
		return 1;
	end if;
    
    -- consulta a quantidade de vezes que determinado aluno já foi monitor
    select count(monmatricula) into qtd
    from monitora
    where monmatricula = matricula;
    
    -- se a quantidade de vezes for menor que duas, então torna o aluno monitor
    if qtd < 2 then
		insert into  monitora (dtinicio, dtfim, discodigo, monmatricula, cicloletivo) values (dtinicio, null, codigo, matricula, periodo);
        return 2;
	else
		return 0;
	end if;	
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaAgendamentoAluno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaAgendamentoAluno`(in alumat int, in busca varchar(20))
begin
	select discodigo, resdatahora, nome, alumatricula, resloccodigo
	from participa
	inner join aluno on resmonmatricula = matricula
	inner join monitora on monmatricula = matricula
	where alumatricula = alumat and resdatahora >= now() 
    and (nome like busca or discodigo like busca or resloccodigo like busca or 
	concat(substr(resdatahora, 9, 2), '/', substr(resdatahora, 6, 2), '/', substr(resdatahora, 1, 4), substr(resdatahora, 11, 9)) like busca);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaAtendimentos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaAtendimentos`(monmat int)
begin
	-- recupera as informações da reserva;
    -- na aplicação deve ser separado a data do horário
    -- e aplicar filtros locais para quando o aluno selecionar uma data
    -- seja exibido somente os horários daquela data
	select datahora, monmatricula, loccodigo
    from aluno
    inner join reserva on monmatricula = matricula
    inner join local on loccodigo = codigo
    where matricula = monmat;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaDatas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaDatas`(monmat int, loccod varchar(7))
begin

	select concat(substring(datahora, 1, 4), '-', substring(datahora, 6, 2), '-',substring(datahora, 9, 2)) as data
    from reserva
    where monmatricula = monmat and loccodigo = loccod and datahora > now();
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaDisciplina` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaDisciplina`()
begin
	select codigo, nome
    from disciplina;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaHorarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaHorarios`(data varchar(10), cod varchar(7))
begin
	select concat(substring(datahora, 12, 2), ':', substring(datahora, 15, 2)) as hora
    from local
    inner join reserva on loccodigo = codigo
    where codigo = cod and locate(data,datahora)
    order by hora;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaHorariosDisponibilizados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaHorariosDisponibilizados`(in busca varchar(20), in dt datetime)
begin
	select hora, datdia, datloccodigo 
	from hora 
	where concat(datdia, ' ', hora) >= dt
    and (concat(substr(datdia, 9, 2), '/', substr(datdia, 6, 2), '/', substr(datdia, 1, 4)) like busca 
		or hora like busca or datloccodigo like busca)
	order by datloccodigo, datdia, hora;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaLocais` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaLocais`()
begin
	select codigo 'local'
    from local;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaLocaisDisponiveis` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaLocaisDisponiveis`(in dt date)
begin 
	select distinct loccodigo 'local' 
    from data
	where dia >= dt;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaLocal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaLocal`()
begin
	select codigo 
    from local;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaLocalAtendimentos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaLocalAtendimentos`(monmat int)
begin
	-- recupera as informações da reserva;
    -- na aplicação deve ser separado a data do horário
    -- e aplicar filtros locais para quando o aluno selecionar uma data
    -- seja exibido somente os horários daquela data
	select distinct loccodigo 'local'
    from aluno
    inner join reserva on monmatricula = matricula
    inner join local on loccodigo = codigo
    where matricula = monmat and datahora > now();
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaMonitores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaMonitores`(in busca varchar(50))
begin
	select nome, monmatricula, discodigo, cicloletivo
	from monitora
	inner join aluno on monmatricula = matricula
	where dtfim is null 
    and (nome like (concat('%', busca, '%')) or monmatricula like (concat('%', busca, '%')) or discodigo like (concat('%', busca, '%')) or cicloletivo like (concat('%', busca, '%'))) 
    and left(cicloletivo, 4) >= left(now(),4)
    -- obs: falta filtrar o /1 ou 2
	order by nome;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaMonitoresDisciplina` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaMonitoresDisciplina`(in discod varchar(7))
begin
	-- recupera as informações básicas do monitor da disciplina
	select distinct a.matricula 'matricula', a.nome 'nome', a.email 'email', a.periodo 'periodo'
    from disciplina d
    inner join monitora m on m.discodigo = d.codigo
    inner join aluno a on m.monmatricula = a.matricula
    inner join reserva r on a.matricula = r.monmatricula
    where d.codigo = discod and m.dtfim is null and datahora >= current_date();
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultarDatasDeLocal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultarDatasDeLocal`(in loccod varchar(10))
begin
	select dia
    from data
    where loccodigo = loccod and dia > now();
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultarDatasDeLocalFuturas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultarDatasDeLocalFuturas`(in loccod varchar(10), in dt datetime)
begin
	select dia
    from data
    where loccodigo = loccod and dia > dt;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spconsultarDisciplinaComAtendimento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spconsultarDisciplinaComAtendimento`()
begin
	select distinct d.nome, d.codigo
	from disciplina d
	inner join monitora m on d.codigo = m.discodigo
	inner join aluno a on m.monmatricula = a.matricula
	inner join reserva r on r.monmatricula = a.matricula
	where r.datahora >= current_date();
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultaReservasMonitor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaReservasMonitor`(in monmat int, in busca varchar(20), in dt datetime)
begin
	select datahora, loccodigo, monmatricula
	from reserva
	where monmatricula = monmat and datahora >= dt
    and (concat(substr(datahora, 9, 2), '/', substr(datahora, 6, 2), '/', substr(datahora, 1, 4), substr(datahora, 11, 9)) like busca 
		or loccodigo like busca); 
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultarHorasDeLocal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultarHorasDeLocal`(in dia date, in local varchar(7))
begin
	select left(hora,5) as hora
	from hora
    where datdia = dia and datloccodigo = local;   
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultarHorasDeLocalDisponivel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultarHorasDeLocalDisponivel`(in dia date, in local varchar(7))
begin
	select left(hora,5) as hora
	from hora
	where concat(datdia, ' ', hora, ' ', datloccodigo) not in (
							select concat(h.datdia, ' ', h.hora, ' ', h.datloccodigo)
							from hora h
							inner join data d on h.datdia = d.dia and h.datloccodigo = d.loccodigo
							inner join local l on d.loccodigo = l.codigo
							inner join reserva r on r.loccodigo = l.codigo and r.datahora = concat(h.datdia, ' ', h.hora)    
							where h.datdia = dia and h.datloccodigo = local)
	and datdia = dia and datloccodigo = local;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spConsultarHorasMonitor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultarHorasMonitor`(in monmat int, in semanaPosterior date)
begin
	select count(m.monmatricula) as horas
	from monitora m
	inner join reserva r on m.monmatricula = r.monmatricula
	where m.monmatricula = monmat and datahora >= semanaPosterior;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDisponibilizarLocalData` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDisponibilizarLocalData`(in dt date, in local varchar(7))
begin
	declare validacao int;
	set validacao = 0;
    
    select count(dia) into validacao
    from data
    where dia = dt and loccodigo = local;
    
    if validacao = 0 then
		insert into data (dia, loccodigo) values(dt, local);
	end if;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDisponibilizarLocalHora` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDisponibilizarLocalHora`(in hr time, in dt date, in local varchar(7))
begin
	declare validacao int;
	set validacao = 0;
    
    select count(hora) into validacao
    from hora
    where hora = hr and datdia = dt and datloccodigo = local;
    
    if validacao = 0 then
		insert into hora (hora, datdia, datloccodigo) values(hr, dt, local);
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spEncerrarMonitoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;

/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEncerrarMonitoria`(in monmat int)
begin
	update monitora
	set dtfim = current_date()
	where monmatricula = monmat;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spRankAlunoMaisParticipativo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
 ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spRankAlunoMaisParticipativo`(in disciplina varchar(50))
begin
	 -- aluno mais participativo
	select nome, count(*) as qtdvezes
	from participa pout
	inner join aluno on alumatricula = matricula
    where pout.resmonmatricula = (select matricula
							from aluno
							inner join monitora on monmatricula = matricula
							inner join disciplina on discodigo = codigo
                            where matricula = pout.resmonmatricula and codigo like (concat('%',disciplina,'%')))
	group by matricula
	order by qtdvezes desc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spRankDisciplinaComMaiorNumeroAtendimento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
 ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spRankDisciplinaComMaiorNumeroAtendimento`()
begin
	-- disciplina com maior número de atendimento
	select d.codigo, d.nome, count(*) as qtdvezes
	from reserva r
	inner join aluno a on r.monmatricula = matricula
	inner join monitora m on matricula = m.monmatricula
	inner join disciplina d on discodigo = codigo
	group by codigo
	order by qtdvezes desc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spRankDisciplinaMaisFrequentada` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
 ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spRankDisciplinaMaisFrequentada`()
begin
	-- disciplina com maior número de participantes
	select d.codigo, d.nome, count(*) as qtdvezes
	from participa
	inner join reserva r on resmonmatricula = r.monmatricula and resdatahora = r.datahora and resloccodigo = r.loccodigo
	inner join aluno on r.monmatricula = matricula
	inner join monitora m on matricula = m.monmatricula
	inner join disciplina d on discodigo = d.codigo
	group by d.codigo
	order by qtdvezes desc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spRankMonitorQueMaisDisponibilizouAtendimento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
 ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spRankMonitorQueMaisDisponibilizouAtendimento`()
begin
	-- monitor que mais disponibilizou atendimento
	select a.nome, d.nome as disciplina, count(*) as qtdvezes
	from reserva r
	inner join aluno a on r.monmatricula = matricula
	inner join monitora m on matricula = m.monmatricula
	inner join disciplina d on discodigo = codigo
	group by r.monmatricula
	order by qtdvezes desc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-25 20:19:50
