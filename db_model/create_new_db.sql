-- MySQL Script generated by MySQL Workbench
-- 05/09/17 13:55:33
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema RM_DB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `RM_DB` ;

-- -----------------------------------------------------
-- Schema RM_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `RM_DB` DEFAULT CHARACTER SET utf8 ;
USE `RM_DB` ;

-- -----------------------------------------------------
-- Table `RM_DB`.`TEAM`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`TEAM` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`TEAM` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(50) NOT NULL,
  `PROJECT` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`BUC`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`BUC` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`BUC` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`SPRINT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`SPRINT` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`SPRINT` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`EMPLOYEES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`EMPLOYEES` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`EMPLOYEES` (
  `SIGNUM` VARCHAR(7) NOT NULL,
  `NAME` VARCHAR(80) NOT NULL,
  `ROLE` VARCHAR(45) NOT NULL,
  `TEAM_ID` INT,
  PRIMARY KEY (`SIGNUM`),
  UNIQUE INDEX `SIGNUM_UNIQUE` (`SIGNUM` ASC),
  INDEX `fk_EMPLOYEES_TEAM_idx` (`TEAM_ID` ASC),
  CONSTRAINT `fk_EMPLOYEES_TEAM`
    FOREIGN KEY (`TEAM_ID`)
    REFERENCES `RM_DB`.`TEAM` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`TEAM_has_BUC`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`TEAM_has_BUC` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`TEAM_has_BUC` (
  `TEAM_ID` INT NOT NULL,
  `BUC_ID` INT NOT NULL,
  PRIMARY KEY (`TEAM_ID`, `BUC_ID`),
  INDEX `fk_TEAM_has_BUC_BUC1_idx` (`BUC_ID` ASC),
  INDEX `fk_TEAM_has_BUC_TEAM1_idx` (`TEAM_ID` ASC),
  CONSTRAINT `fk_TEAM_has_BUC_TEAM1`
    FOREIGN KEY (`TEAM_ID`)
    REFERENCES `RM_DB`.`TEAM` (`ID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TEAM_has_BUC_BUC1`
    FOREIGN KEY (`BUC_ID`)
    REFERENCES `RM_DB`.`BUC` (`ID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`BUC_has_SPRINT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`BUC_has_SPRINT` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`BUC_has_SPRINT` (
  `BUC_ID` INT NOT NULL,
  `SPRINT_ID` INT NOT NULL,
  PRIMARY KEY (`BUC_ID`, `SPRINT_ID`),
  INDEX `fk_BUC_has_SPRINT_SPRINT1_idx` (`SPRINT_ID` ASC),
  INDEX `fk_BUC_has_SPRINT_BUC1_idx` (`BUC_ID` ASC),
  CONSTRAINT `fk_BUC_has_SPRINT_BUC1`
    FOREIGN KEY (`BUC_ID`)
    REFERENCES `RM_DB`.`BUC` (`ID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BUC_has_SPRINT_SPRINT1`
    FOREIGN KEY (`SPRINT_ID`)
    REFERENCES `RM_DB`.`SPRINT` (`ID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`STATUS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`STATUS` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`STATUS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`BUSINESS_REQUIREMENTS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`BUSINESS_REQUIREMENTS` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`BUSINESS_REQUIREMENTS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NOT NULL,
  `DESCRIPTION` TEXT(1000) NOT NULL,
  `CUSTOMER_NEEDS` TEXT(2000) NULL,
  `COMMENTS` TEXT(2000) NULL,
  `STATUS_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_BUSINESS_REQUIREMENTS_STATUS1_idx` (`STATUS_ID` ASC),
  CONSTRAINT `fk_BUSINESS_REQUIREMENTS_STATUS1`
    FOREIGN KEY (`STATUS_ID`)
    REFERENCES `RM_DB`.`STATUS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`BUSINESS_REQUIREMENTS_has_EMPLOYEES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`BUSINESS_REQUIREMENTS_has_EMPLOYEES` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`BUSINESS_REQUIREMENTS_has_EMPLOYEES` (
  `BUSINESS_REQUIREMENTS_ID` INT NOT NULL,
  `EMPLOYEES_SIGNUM` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`BUSINESS_REQUIREMENTS_ID`, `EMPLOYEES_SIGNUM`),
  INDEX `fk_BUSINESS_REQUIREMENTS_has_EMPLOYEES_EMPLOYEES1_idx` (`EMPLOYEES_SIGNUM` ASC),
  INDEX `fk_BUSINESS_REQUIREMENTS_has_EMPLOYEES_BUSINESS_REQUIREMENT_idx` (`BUSINESS_REQUIREMENTS_ID` ASC),
  CONSTRAINT `fk_BUSINESS_REQUIREMENTS_has_EMPLOYEES_BUSINESS_REQUIREMENTS1`
    FOREIGN KEY (`BUSINESS_REQUIREMENTS_ID`)
    REFERENCES `RM_DB`.`BUSINESS_REQUIREMENTS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BUSINESS_REQUIREMENTS_has_EMPLOYEES_EMPLOYEES1`
    FOREIGN KEY (`EMPLOYEES_SIGNUM`)
    REFERENCES `RM_DB`.`EMPLOYEES` (`SIGNUM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`TECHNICAL_REQUIREMENTS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`TECHNICAL_REQUIREMENTS` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`TECHNICAL_REQUIREMENTS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NULL,
  `DESCRIPTION` TEXT(1000) NULL,
  `COMMENTS` TEXT(2000) NULL,
  `BUSINESS_REQUIREMENTS_ID` INT NOT NULL,
  `STATUS_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_TECHNICAL_REQUIREMENTS_BUSINESS_REQUIREMENTS1_idx` (`BUSINESS_REQUIREMENTS_ID` ASC),
  INDEX `fk_TECHNICAL_REQUIREMENTS_STATUS1_idx` (`STATUS_ID` ASC),
  CONSTRAINT `fk_TECHNICAL_REQUIREMENTS_BUSINESS_REQUIREMENTS1`
    FOREIGN KEY (`BUSINESS_REQUIREMENTS_ID`)
    REFERENCES `RM_DB`.`BUSINESS_REQUIREMENTS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TECHNICAL_REQUIREMENTS_STATUS1`
    FOREIGN KEY (`STATUS_ID`)
    REFERENCES `RM_DB`.`STATUS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`TEST_TYPE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`TEST_TYPE` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`TEST_TYPE` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`TEST_CASES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`TEST_CASES` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`TEST_CASES` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `FULL_PATH` VARCHAR(200) NOT NULL,
  `EMPLOYEES_SIGNUM` VARCHAR(7) NOT NULL,
  `STATUS_ID` INT NOT NULL,
  `TEST_TYPE_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_TEST_CASES_EMPLOYEES1_idx` (`EMPLOYEES_SIGNUM` ASC),
  INDEX `fk_TEST_CASES_STATUS1_idx` (`STATUS_ID` ASC),
  INDEX `fk_TEST_CASES_TEST_TYPE1_idx` (`TEST_TYPE_ID` ASC),
  CONSTRAINT `fk_TEST_CASES_EMPLOYEES1`
    FOREIGN KEY (`EMPLOYEES_SIGNUM`)
    REFERENCES `RM_DB`.`EMPLOYEES` (`SIGNUM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TEST_CASES_STATUS1`
    FOREIGN KEY (`STATUS_ID`)
    REFERENCES `RM_DB`.`STATUS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TEST_CASES_TEST_TYPE1`
    FOREIGN KEY (`TEST_TYPE_ID`)
    REFERENCES `RM_DB`.`TEST_TYPE` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RM_DB`.`TECHNICAL_REQUIREMENTS_has_TEST_CASES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RM_DB`.`TECHNICAL_REQUIREMENTS_has_TEST_CASES` ;

CREATE TABLE IF NOT EXISTS `RM_DB`.`TECHNICAL_REQUIREMENTS_has_TEST_CASES` (
  `TECHNICAL_REQUIREMENTS_ID` INT NOT NULL,
  `TEST_CASES_ID` INT NOT NULL,
  PRIMARY KEY (`TECHNICAL_REQUIREMENTS_ID`, `TEST_CASES_ID`),
  INDEX `fk_TECHNICAL_REQUIREMENTS_has_TEST_CASES_TEST_CASES1_idx` (`TEST_CASES_ID` ASC),
  INDEX `fk_TECHNICAL_REQUIREMENTS_has_TEST_CASES_TECHNICAL_REQUIREM_idx` (`TECHNICAL_REQUIREMENTS_ID` ASC),
  CONSTRAINT `fk_TECHNICAL_REQUIREMENTS_has_TEST_CASES_TECHNICAL_REQUIREMEN1`
    FOREIGN KEY (`TECHNICAL_REQUIREMENTS_ID`)
    REFERENCES `RM_DB`.`TECHNICAL_REQUIREMENTS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TECHNICAL_REQUIREMENTS_has_TEST_CASES_TEST_CASES1`
    FOREIGN KEY (`TEST_CASES_ID`)
    REFERENCES `RM_DB`.`TEST_CASES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
