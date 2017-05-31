-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema rm_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `rm_db` ;

-- -----------------------------------------------------
-- Schema rm_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rm_db` DEFAULT CHARACTER SET utf8 ;
USE `rm_db` ;

-- -----------------------------------------------------
-- Table `rm_db`.`buc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`buc` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`buc` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`sprint`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`sprint` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`sprint` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`buc_has_sprint`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`buc_has_sprint` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`buc_has_sprint` (
  `BUC_ID` INT(11) NOT NULL,
  `SPRINT_ID` INT(11) NOT NULL,
  PRIMARY KEY (`BUC_ID`, `SPRINT_ID`),
  INDEX `fk_BUC_has_SPRINT_SPRINT1_idx` (`SPRINT_ID` ASC),
  INDEX `fk_BUC_has_SPRINT_BUC1_idx` (`BUC_ID` ASC),
  CONSTRAINT `fk_BUC_has_SPRINT_BUC1`
    FOREIGN KEY (`BUC_ID`)
    REFERENCES `rm_db`.`buc` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_BUC_has_SPRINT_SPRINT1`
    FOREIGN KEY (`SPRINT_ID`)
    REFERENCES `rm_db`.`sprint` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`status` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`status` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`business_requirements`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`business_requirements` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`business_requirements` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NOT NULL,
  `DESCRIPTION` TEXT NOT NULL,
  `CUSTOMER_NEEDS` TEXT NULL DEFAULT NULL,
  `COMMENTS` TEXT NULL DEFAULT NULL,
  `STATUS_ID` INT(11) NOT NULL,
  `buc_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_BUSINESS_REQUIREMENTS_STATUS1_idx` (`STATUS_ID` ASC),
  INDEX `fk_business_requirements_buc1_idx` (`buc_ID` ASC),
  CONSTRAINT `fk_BUSINESS_REQUIREMENTS_STATUS1`
    FOREIGN KEY (`STATUS_ID`)
    REFERENCES `rm_db`.`status` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_business_requirements_buc1`
    FOREIGN KEY (`buc_ID`)
    REFERENCES `rm_db`.`buc` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`team` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`team` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(50) NOT NULL,
  `PROJECT` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`employees`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`employees` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`employees` (
  `SIGNUM` VARCHAR(7) NOT NULL,
  `NAME` VARCHAR(80) NOT NULL,
  `ROLE` VARCHAR(45) NOT NULL,
  `TEAM_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`SIGNUM`),
  UNIQUE INDEX `SIGNUM_UNIQUE` (`SIGNUM` ASC),
  INDEX `fk_EMPLOYEES_TEAM_idx` (`TEAM_ID` ASC),
  CONSTRAINT `fk_EMPLOYEES_TEAM`
    FOREIGN KEY (`TEAM_ID`)
    REFERENCES `rm_db`.`team` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`business_requirements_has_employees`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`business_requirements_has_employees` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`business_requirements_has_employees` (
  `BUSINESS_REQUIREMENTS_ID` INT(11) NOT NULL,
  `EMPLOYEES_SIGNUM` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`BUSINESS_REQUIREMENTS_ID`, `EMPLOYEES_SIGNUM`),
  INDEX `fk_BUSINESS_REQUIREMENTS_has_EMPLOYEES_EMPLOYEES1_idx` (`EMPLOYEES_SIGNUM` ASC),
  INDEX `fk_BUSINESS_REQUIREMENTS_has_EMPLOYEES_BUSINESS_REQUIREMENT_idx` (`BUSINESS_REQUIREMENTS_ID` ASC),
  CONSTRAINT `fk_BUSINESS_REQUIREMENTS_has_EMPLOYEES_BUSINESS_REQUIREMENTS1`
    FOREIGN KEY (`BUSINESS_REQUIREMENTS_ID`)
    REFERENCES `rm_db`.`business_requirements` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_BUSINESS_REQUIREMENTS_has_EMPLOYEES_EMPLOYEES1`
    FOREIGN KEY (`EMPLOYEES_SIGNUM`)
    REFERENCES `rm_db`.`employees` (`SIGNUM`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`team_has_buc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`team_has_buc` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`team_has_buc` (
  `TEAM_ID` INT(11) NOT NULL,
  `BUC_ID` INT(11) NOT NULL,
  PRIMARY KEY (`TEAM_ID`, `BUC_ID`),
  INDEX `fk_TEAM_has_BUC_BUC1_idx` (`BUC_ID` ASC),
  INDEX `fk_TEAM_has_BUC_TEAM1_idx` (`TEAM_ID` ASC),
  CONSTRAINT `fk_TEAM_has_BUC_BUC1`
    FOREIGN KEY (`BUC_ID`)
    REFERENCES `rm_db`.`buc` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_TEAM_has_BUC_TEAM1`
    FOREIGN KEY (`TEAM_ID`)
    REFERENCES `rm_db`.`team` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`technical_requirements`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`technical_requirements` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`technical_requirements` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NULL DEFAULT NULL,
  `DESCRIPTION` TEXT NULL DEFAULT NULL,
  `COMMENTS` TEXT NULL DEFAULT NULL,
  `BUSINESS_REQUIREMENTS_ID` INT(11) NOT NULL,
  `STATUS_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_TECHNICAL_REQUIREMENTS_BUSINESS_REQUIREMENTS1_idx` (`BUSINESS_REQUIREMENTS_ID` ASC),
  INDEX `fk_TECHNICAL_REQUIREMENTS_STATUS1_idx` (`STATUS_ID` ASC),
  CONSTRAINT `fk_TECHNICAL_REQUIREMENTS_BUSINESS_REQUIREMENTS1`
    FOREIGN KEY (`BUSINESS_REQUIREMENTS_ID`)
    REFERENCES `rm_db`.`business_requirements` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TECHNICAL_REQUIREMENTS_STATUS1`
    FOREIGN KEY (`STATUS_ID`)
    REFERENCES `rm_db`.`status` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`test_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`test_type` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`test_type` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`test_cases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`test_cases` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`test_cases` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `FULL_PATH` VARCHAR(200) NOT NULL,
  `STATUS_ID` INT(11) NOT NULL,
  `TEST_TYPE_ID` INT(11) NOT NULL,
  `team_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_TEST_CASES_STATUS1_idx` (`STATUS_ID` ASC),
  INDEX `fk_TEST_CASES_TEST_TYPE1_idx` (`TEST_TYPE_ID` ASC),
  INDEX `fk_test_cases_team1_idx` (`team_ID` ASC),
  CONSTRAINT `fk_TEST_CASES_STATUS1`
    FOREIGN KEY (`STATUS_ID`)
    REFERENCES `rm_db`.`status` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TEST_CASES_TEST_TYPE1`
    FOREIGN KEY (`TEST_TYPE_ID`)
    REFERENCES `rm_db`.`test_type` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_test_cases_team1`
    FOREIGN KEY (`team_ID`)
    REFERENCES `rm_db`.`team` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_db`.`technical_requirements_has_test_cases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rm_db`.`technical_requirements_has_test_cases` ;

CREATE TABLE IF NOT EXISTS `rm_db`.`technical_requirements_has_test_cases` (
  `TECHNICAL_REQUIREMENTS_ID` INT(11) NOT NULL,
  `TEST_CASES_ID` INT(11) NOT NULL,
  PRIMARY KEY (`TECHNICAL_REQUIREMENTS_ID`, `TEST_CASES_ID`),
  INDEX `fk_TECHNICAL_REQUIREMENTS_has_TEST_CASES_TEST_CASES1_idx` (`TEST_CASES_ID` ASC),
  INDEX `fk_TECHNICAL_REQUIREMENTS_has_TEST_CASES_TECHNICAL_REQUIREM_idx` (`TECHNICAL_REQUIREMENTS_ID` ASC),
  CONSTRAINT `fk_TECHNICAL_REQUIREMENTS_has_TEST_CASES_TECHNICAL_REQUIREMEN1`
    FOREIGN KEY (`TECHNICAL_REQUIREMENTS_ID`)
    REFERENCES `rm_db`.`technical_requirements` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_TECHNICAL_REQUIREMENTS_has_TEST_CASES_TEST_CASES1`
    FOREIGN KEY (`TEST_CASES_ID`)
    REFERENCES `rm_db`.`test_cases` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `rm_db`.`status`
-- -----------------------------------------------------
START TRANSACTION;
USE `rm_db`;
INSERT INTO `rm_db`.`status` (`ID`, `NAME`) VALUES (1, 'Enabled');
INSERT INTO `rm_db`.`status` (`ID`, `NAME`) VALUES (2, 'Disabled');
INSERT INTO `rm_db`.`status` (`ID`, `NAME`) VALUES (3, 'Postponed');

COMMIT;


-- -----------------------------------------------------
-- Data for table `rm_db`.`test_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `rm_db`;
INSERT INTO `rm_db`.`test_type` (`ID`, `NAME`) VALUES (1, 'Functional');
INSERT INTO `rm_db`.`test_type` (`ID`, `NAME`) VALUES (2, 'Unit');
INSERT INTO `rm_db`.`test_type` (`ID`, `NAME`) VALUES (3, 'E2E');
INSERT INTO `rm_db`.`test_type` (`ID`, `NAME`) VALUES (4, 'Performance');

COMMIT;

