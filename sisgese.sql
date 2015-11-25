-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sisgese
-- ------------------------------------------------------
-- Server version	5.5.46-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `nota` float NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `processo_seletivo_id` bigint(20) NOT NULL,
  `tipo_avaliacao_id` bigint(20) NOT NULL,
  `avaliador_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_avaliacao_processo_seletivo1_idx` (`processo_seletivo_id`),
  KEY `fk_avaliacao_tipo_avaliacao1_idx` (`tipo_avaliacao_id`),
  KEY `fk_avaliacao_funcionario1_idx` (`avaliador_id`),
  CONSTRAINT `fk_avaliacao_funcionario1` FOREIGN KEY (`avaliador_id`) REFERENCES `funcionario` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_processo_seletivo1` FOREIGN KEY (`processo_seletivo_id`) REFERENCES `processo_seletivo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_tipo_avaliacao1` FOREIGN KEY (`tipo_avaliacao_id`) REFERENCES `tipo_avaliacao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidato_selecionado`
--

DROP TABLE IF EXISTS `candidato_selecionado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidato_selecionado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` int(11) NOT NULL,
  `vaga_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_candidato_selecionado_vaga1_idx` (`vaga_id`),
  CONSTRAINT `fk_candidato_selecionado_vaga1` FOREIGN KEY (`vaga_id`) REFERENCES `vaga` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidato_selecionado`
--

LOCK TABLES `candidato_selecionado` WRITE;
/*!40000 ALTER TABLE `candidato_selecionado` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidato_selecionado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidato_selecionado_tem_pendencia`
--

DROP TABLE IF EXISTS `candidato_selecionado_tem_pendencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidato_selecionado_tem_pendencia` (
  `candidato_id` bigint(20) NOT NULL,
  `pendencia_id` bigint(20) NOT NULL,
  PRIMARY KEY (`candidato_id`,`pendencia_id`),
  KEY `fk_candidato_selecionado_has_pendencia_pendencia1_idx` (`pendencia_id`),
  KEY `fk_candidato_selecionado_has_pendencia_candidato_selecionad_idx` (`candidato_id`),
  CONSTRAINT `fk_candidato_selecionado_has_pendencia_candidato_selecionado1` FOREIGN KEY (`candidato_id`) REFERENCES `candidato_selecionado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidato_selecionado_has_pendencia_pendencia1` FOREIGN KEY (`pendencia_id`) REFERENCES `pendencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidato_selecionado_tem_pendencia`
--

LOCK TABLES `candidato_selecionado_tem_pendencia` WRITE;
/*!40000 ALTER TABLE `candidato_selecionado_tem_pendencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidato_selecionado_tem_pendencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=403 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (2,'Ajudante de Serviços de Acessórios','Trabalhar na produção de pequenas peças'),(3,'Ajudante de Serviços de Costura','Trabalhar na máquina de costura'),(5,'Costureira(o)','Trabalhar na finalização das peças'),(107,'Ajudante de Serviços de Produção I','Dar suporte as áreas de produção'),(108,'Ajudante de Produção II','Dar suporte a área de produção'),(213,'Separador/Conferente','Auxilia na separação e conferência das peças que serão entregues'),(310,'Apontador de Produção','Responsável pela entrega dos lotes produzidos diariamente'),(401,'Auxiliar de Administração I','Auxiliar nas tarefas de emissão de relatórios, e arquivo'),(402,'Auxiliar de Contabilidade I','Auxiliar as áreas contábeis da empresa');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo_tem_competencia`
--

DROP TABLE IF EXISTS `cargo_tem_competencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo_tem_competencia` (
  `cargo_id` bigint(20) NOT NULL,
  `competencia_id` bigint(20) NOT NULL,
  PRIMARY KEY (`cargo_id`,`competencia_id`),
  KEY `fk_cargo_has_competencia_competencia1_idx` (`competencia_id`),
  KEY `fk_cargo_has_competencia_cargo1_idx` (`cargo_id`),
  CONSTRAINT `fk_cargo_has_competencia_cargo1` FOREIGN KEY (`cargo_id`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cargo_has_competencia_competencia1` FOREIGN KEY (`competencia_id`) REFERENCES `competencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo_tem_competencia`
--

LOCK TABLES `cargo_tem_competencia` WRITE;
/*!40000 ALTER TABLE `cargo_tem_competencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `cargo_tem_competencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competencia`
--

DROP TABLE IF EXISTS `competencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `obrigatoria` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competencia`
--

LOCK TABLES `competencia` WRITE;
/*!40000 ALTER TABLE `competencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `competencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `matricula` bigint(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `valor_hora` double DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `cargo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `fk_funcionario_cargo1_idx` (`cargo_id`),
  CONSTRAINT `fk_funcionario_cargo1` FOREIGN KEY (`cargo_id`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `entrada` time NOT NULL,
  `saida` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivo`
--

DROP TABLE IF EXISTS `motivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motivo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivo`
--

LOCK TABLES `motivo` WRITE;
/*!40000 ALTER TABLE `motivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `motivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pendencia`
--

DROP TABLE IF EXISTS `pendencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pendencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pendencia`
--

LOCK TABLES `pendencia` WRITE;
/*!40000 ALTER TABLE `pendencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `pendencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processo_seletivo`
--

DROP TABLE IF EXISTS `processo_seletivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `processo_seletivo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vaga_id` bigint(20) NOT NULL,
  `pessoa_id` bigint(20) NOT NULL,
  `aprovado` tinyint(4) NOT NULL DEFAULT '0',
  `data` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vaga_has_pessoa_pessoa1_idx` (`pessoa_id`),
  KEY `fk_vaga_has_pessoa_vaga1_idx` (`vaga_id`),
  CONSTRAINT `fk_vaga_has_pessoa_pessoa1` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vaga_has_pessoa_vaga1` FOREIGN KEY (`vaga_id`) REFERENCES `vaga` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processo_seletivo`
--

LOCK TABLES `processo_seletivo` WRITE;
/*!40000 ALTER TABLE `processo_seletivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `processo_seletivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `setor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `funcionario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_setor_funcionario1_idx` (`funcionario_id`),
  CONSTRAINT `fk_setor_funcionario1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setor`
--

LOCK TABLES `setor` WRITE;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
/*!40000 ALTER TABLE `setor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitacao`
--

DROP TABLE IF EXISTS `solicitacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `usuario_id` bigint(20) NOT NULL,
  `motivo_id` bigint(20) NOT NULL,
  `data_criacao` date NOT NULL,
  `data_fim` date DEFAULT NULL,
  `tipo_recrutamento` enum('Interno','Externo') NOT NULL DEFAULT 'Interno',
  `setor_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_solicitacao_usuario_idx` (`usuario_id`),
  KEY `fk_solicitacao_motivo1_idx` (`motivo_id`),
  KEY `fk_solicitacao_setor1_idx` (`setor_id`),
  CONSTRAINT `fk_solicitacao_motivo1` FOREIGN KEY (`motivo_id`) REFERENCES `motivo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitacao_setor1` FOREIGN KEY (`setor_id`) REFERENCES `setor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitacao_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacao`
--

LOCK TABLES `solicitacao` WRITE;
/*!40000 ALTER TABLE `solicitacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_avaliacao`
--

DROP TABLE IF EXISTS `tipo_avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_avaliacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `duracao` int(11) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_avaliacao`
--

LOCK TABLES `tipo_avaliacao` WRITE;
/*!40000 ALTER TABLE `tipo_avaliacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `perfil` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'284432','123456','chefe','Claudio'),(2,'55','123123','administrador','Valeria'),(3,'33','1212','usuario_adm','Rafael');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaga`
--

DROP TABLE IF EXISTS `vaga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vaga` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `solicitacao_id` bigint(20) NOT NULL,
  `horario_id` bigint(20) NOT NULL,
  `status` enum('Aberta','Pendente','Preenchida') NOT NULL DEFAULT 'Aberta',
  PRIMARY KEY (`id`),
  KEY `fk_vaga_solicitacao1_idx` (`solicitacao_id`),
  KEY `fk_vaga_horario1_idx` (`horario_id`),
  CONSTRAINT `fk_vaga_horario1` FOREIGN KEY (`horario_id`) REFERENCES `horario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vaga_solicitacao1` FOREIGN KEY (`solicitacao_id`) REFERENCES `solicitacao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaga`
--

LOCK TABLES `vaga` WRITE;
/*!40000 ALTER TABLE `vaga` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaga_tem_cargo`
--

DROP TABLE IF EXISTS `vaga_tem_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vaga_tem_cargo` (
  `vaga_id` bigint(20) NOT NULL,
  `cargo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`vaga_id`,`cargo_id`),
  KEY `fk_vaga_has_cargo_cargo1_idx` (`cargo_id`),
  KEY `fk_vaga_has_cargo_vaga1_idx` (`vaga_id`),
  CONSTRAINT `fk_vaga_has_cargo_cargo1` FOREIGN KEY (`cargo_id`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vaga_has_cargo_vaga1` FOREIGN KEY (`vaga_id`) REFERENCES `vaga` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaga_tem_cargo`
--

LOCK TABLES `vaga_tem_cargo` WRITE;
/*!40000 ALTER TABLE `vaga_tem_cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaga_tem_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sisgese'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-19 15:40:42
