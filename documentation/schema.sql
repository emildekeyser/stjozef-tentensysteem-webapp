-- MySQL Script generated by MySQL Workbench
-- Tue Dec 18 11:19:21 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `username` INT NOT NULL,
  `role` VARCHAR(45) NULL,
  `grade` INT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tent` (
  `name` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`question` (
  `id` INT NOT NULL,
  `value` VARCHAR(250) NULL,
  `grade` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`answer` (
  `id` INT NOT NULL,
  `nr` INT NULL,
  `value` VARCHAR(250) NULL,
  `points` INT NULL,
  `question_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_oplossing_vraag_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `fk_oplossing_vraag`
    FOREIGN KEY (`question_id`)
    REFERENCES `mydb`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`test`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`test` (
  `id` INT NOT NULL,
  `tent_name` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_test_tent1_idx` (`tent_name` ASC) VISIBLE,
  CONSTRAINT `fk_test_tent1`
    FOREIGN KEY (`tent_name`)
    REFERENCES `mydb`.`tent` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`test_contains_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`test_contains_question` (
  `question_id` INT NOT NULL,
  `test_id` INT NOT NULL,
  PRIMARY KEY (`question_id`, `test_id`),
  INDEX `fk_vraag_has_test_test1_idx` (`test_id` ASC) VISIBLE,
  INDEX `fk_vraag_has_test_vraag1_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `fk_vraag_has_test_vraag1`
    FOREIGN KEY (`question_id`)
    REFERENCES `mydb`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vraag_has_test_test1`
    FOREIGN KEY (`test_id`)
    REFERENCES `mydb`.`test` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`attempt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`attempt` (
  `id` INT NOT NULL,
  `datetime` DATETIME NULL,
  `test_id` INT NOT NULL,
  `username` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_poging_test1_idx` (`test_id` ASC) VISIBLE,
  INDEX `fk_poging_gebruiker1_idx` (`username` ASC) VISIBLE,
  CONSTRAINT `fk_poging_test1`
    FOREIGN KEY (`test_id`)
    REFERENCES `mydb`.`test` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_poging_gebruiker1`
    FOREIGN KEY (`username`)
    REFERENCES `mydb`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`choice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`choice` (
  `id` INT NOT NULL,
  `attempt_id` INT NOT NULL,
  `answer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_keuze_poging1_idx` (`attempt_id` ASC) VISIBLE,
  INDEX `fk_keuze_oplossing1_idx` (`answer_id` ASC) VISIBLE,
  CONSTRAINT `fk_keuze_poging1`
    FOREIGN KEY (`attempt_id`)
    REFERENCES `mydb`.`attempt` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_keuze_oplossing1`
    FOREIGN KEY (`answer_id`)
    REFERENCES `mydb`.`answer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
