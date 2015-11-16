SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `sisgese` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sisgese` ;

-- -----------------------------------------------------
-- Table `sisgese`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `matricula` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`cargo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`funcionario` (
  `matricula` BIGINT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `valor_hora` DOUBLE NULL,
  `endereco` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `cargo_id` BIGINT NOT NULL,
  PRIMARY KEY (`matricula`),
  INDEX `fk_funcionario_cargo1_idx` (`cargo_id` ASC),
  CONSTRAINT `fk_funcionario_cargo1`
    FOREIGN KEY (`cargo_id`)
    REFERENCES `sisgese`.`cargo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`setor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`setor` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `funcionario_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_setor_funcionario1_idx` (`funcionario_id` ASC),
  CONSTRAINT `fk_setor_funcionario1`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `sisgese`.`funcionario` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`competencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`competencia` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NULL,
  `obrigatoria` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`motivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`motivo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`solicitacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`solicitacao` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT NOT NULL,
  `motivo_id` BIGINT NOT NULL,
  `data_criacao` DATE NOT NULL,
  `data_fim` DATE NULL,
  `tipo_recrutamento` ENUM('Interno', 'Externo') NOT NULL DEFAULT 'Interno',
  `setor_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_solicitacao_usuario_idx` (`usuario_id` ASC),
  INDEX `fk_solicitacao_motivo1_idx` (`motivo_id` ASC),
  INDEX `fk_solicitacao_setor1_idx` (`setor_id` ASC),
  CONSTRAINT `fk_solicitacao_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `sisgese`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitacao_motivo1`
    FOREIGN KEY (`motivo_id`)
    REFERENCES `sisgese`.`motivo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitacao_setor1`
    FOREIGN KEY (`setor_id`)
    REFERENCES `sisgese`.`setor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`horario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`horario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `entrada` TIME NOT NULL,
  `saida` TIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`vaga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`vaga` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `solicitacao_id` BIGINT NOT NULL,
  `horario_id` BIGINT NOT NULL,
  `status` ENUM('Aberta', 'Pendente', 'Preenchida') NOT NULL DEFAULT 'Aberta',
  PRIMARY KEY (`id`),
  INDEX `fk_vaga_solicitacao1_idx` (`solicitacao_id` ASC),
  INDEX `fk_vaga_horario1_idx` (`horario_id` ASC),
  CONSTRAINT `fk_vaga_solicitacao1`
    FOREIGN KEY (`solicitacao_id`)
    REFERENCES `sisgese`.`solicitacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vaga_horario1`
    FOREIGN KEY (`horario_id`)
    REFERENCES `sisgese`.`horario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`pessoa` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`processo_seletivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`processo_seletivo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `vaga_id` BIGINT NOT NULL,
  `pessoa_id` BIGINT NOT NULL,
  `aprovado` TINYINT NOT NULL DEFAULT 0,
  `data` DATE NOT NULL,
  INDEX `fk_vaga_has_pessoa_pessoa1_idx` (`pessoa_id` ASC),
  INDEX `fk_vaga_has_pessoa_vaga1_idx` (`vaga_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_vaga_has_pessoa_vaga1`
    FOREIGN KEY (`vaga_id`)
    REFERENCES `sisgese`.`vaga` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vaga_has_pessoa_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `sisgese`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`cargo_tem_competencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`cargo_tem_competencia` (
  `cargo_id` BIGINT NOT NULL,
  `competencia_id` BIGINT NOT NULL,
  PRIMARY KEY (`cargo_id`, `competencia_id`),
  INDEX `fk_cargo_has_competencia_competencia1_idx` (`competencia_id` ASC),
  INDEX `fk_cargo_has_competencia_cargo1_idx` (`cargo_id` ASC),
  CONSTRAINT `fk_cargo_has_competencia_cargo1`
    FOREIGN KEY (`cargo_id`)
    REFERENCES `sisgese`.`cargo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cargo_has_competencia_competencia1`
    FOREIGN KEY (`competencia_id`)
    REFERENCES `sisgese`.`competencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`vaga_tem_cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`vaga_tem_cargo` (
  `vaga_id` BIGINT NOT NULL,
  `cargo_id` BIGINT NOT NULL,
  PRIMARY KEY (`vaga_id`, `cargo_id`),
  INDEX `fk_vaga_has_cargo_cargo1_idx` (`cargo_id` ASC),
  INDEX `fk_vaga_has_cargo_vaga1_idx` (`vaga_id` ASC),
  CONSTRAINT `fk_vaga_has_cargo_vaga1`
    FOREIGN KEY (`vaga_id`)
    REFERENCES `sisgese`.`vaga` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vaga_has_cargo_cargo1`
    FOREIGN KEY (`cargo_id`)
    REFERENCES `sisgese`.`cargo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`tipo_avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`tipo_avaliacao` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `duracao` INT NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`avaliacao` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `nota` FLOAT NOT NULL,
  `observacao` VARCHAR(255) NULL,
  `processo_seletivo_id` BIGINT NOT NULL,
  `tipo_avaliacao_id` BIGINT NOT NULL,
  `avaliador_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_avaliacao_processo_seletivo1_idx` (`processo_seletivo_id` ASC),
  INDEX `fk_avaliacao_tipo_avaliacao1_idx` (`tipo_avaliacao_id` ASC),
  INDEX `fk_avaliacao_funcionario1_idx` (`avaliador_id` ASC),
  CONSTRAINT `fk_avaliacao_processo_seletivo1`
    FOREIGN KEY (`processo_seletivo_id`)
    REFERENCES `sisgese`.`processo_seletivo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_tipo_avaliacao1`
    FOREIGN KEY (`tipo_avaliacao_id`)
    REFERENCES `sisgese`.`tipo_avaliacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_funcionario1`
    FOREIGN KEY (`avaliador_id`)
    REFERENCES `sisgese`.`funcionario` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`candidato_selecionado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`candidato_selecionado` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cpf` INT NOT NULL,
  `vaga_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_candidato_selecionado_vaga1_idx` (`vaga_id` ASC),
  CONSTRAINT `fk_candidato_selecionado_vaga1`
    FOREIGN KEY (`vaga_id`)
    REFERENCES `sisgese`.`vaga` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`pendencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`pendencia` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisgese`.`candidato_selecionado_tem_pendencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisgese`.`candidato_selecionado_tem_pendencia` (
  `candidato_id` BIGINT NOT NULL,
  `pendencia_id` BIGINT NOT NULL,
  PRIMARY KEY (`candidato_id`, `pendencia_id`),
  INDEX `fk_candidato_selecionado_has_pendencia_pendencia1_idx` (`pendencia_id` ASC),
  INDEX `fk_candidato_selecionado_has_pendencia_candidato_selecionad_idx` (`candidato_id` ASC),
  CONSTRAINT `fk_candidato_selecionado_has_pendencia_candidato_selecionado1`
    FOREIGN KEY (`candidato_id`)
    REFERENCES `sisgese`.`candidato_selecionado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidato_selecionado_has_pendencia_pendencia1`
    FOREIGN KEY (`pendencia_id`)
    REFERENCES `sisgese`.`pendencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
