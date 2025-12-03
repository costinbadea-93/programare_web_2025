CREATE TABLE `web2024`.`bank_account` (`id` INT NOT NULL AUTO_INCREMENT,
                                          `account_owner` VARCHAR(45) NULL,
                                          `account_number` VARCHAR(45) NULL,
                                          `balance` DOUBLE NULL,
                                          `currency` VARCHAR(45) NULL,
                                          PRIMARY KEY (`id`));