CREATE TABLE `bankaccount` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `accountOwner` varchar(45) DEFAULT NULL,
                               `balance` varchar(45) DEFAULT NULL,
                               `currency` varchar(45) DEFAULT NULL,
                               `accountNumber` varchar(45) DEFAULT NULL,
                               PRIMARY KEY (`id`)
);
