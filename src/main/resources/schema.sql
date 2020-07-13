drop table if exists review;
drop table if exists book;
drop table if exists country_wallet_list;
drop table if exists country_bank_list;
drop table if exists country_institution_config;
drop table if exists institution;

create table if not exists book
(
    `id`      BIGINT(20) UNSIGNED auto_increment NOT NULL,
    `version` int(10) DEFAULT NULL,
    `title`   VARCHAR(255)                       NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

create table if not exists review
(
    `id`      BIGINT(20) UNSIGNED auto_increment NOT NULL,
    `fk_book` BIGINT(20)                         NOT NULL,
    `comment` VARCHAR(255)                       NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS institution
(
    `id`   BIGINT(20) UNSIGNED auto_increment NOT NULL,
    `name` VARCHAR(255)                       NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS country_institution_config
(
    `country_alpha3`              VARCHAR(3)                                  NOT NULL,
    `currency`                    VARCHAR(3)                                  NOT NULL,
    `currency_help`               VARCHAR(200)                                NULL,
    `wallet_transfer_time`        VARCHAR(30)                                 NULL,
    `bank_transfer_time`          VARCHAR(30)                                 NULL,
    `cash_transfer_time`          VARCHAR(30)                                 NULL,
    `required_on_cash_collection` ENUM ('IDENTITY_DOCUMENT', 'Pick Up Token') NULL,
    `time_created`                TIMESTAMP                                   NOT NULL,
    `time_updated`                TIMESTAMP                                   NOT NULL,
    PRIMARY KEY (`country_alpha3`)
);

--
-- Create country_wallet_list table.
-- ---------------------------------
CREATE TABLE IF NOT EXISTS country_wallet_list
(
    `id`                   BIGINT(20) UNSIGNED auto_increment NOT NULL,
    `institution_id`       BIGINT UNSIGNED                    NOT NULL,
    `country_alpha3`       VARCHAR(3)                         NOT NULL,
    `institution_currency` VARCHAR(3)                         NULL,
    `help_text`            VARCHAR(200)                       NULL,
    `time_created`         TIMESTAMP                          NOT NULL,
    `time_updated`         TIMESTAMP                          NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `cwl_UQ` UNIQUE (`institution_id`, `country_alpha3`),
    CONSTRAINT `cwl_country_config_FK` FOREIGN KEY (`country_alpha3`) REFERENCES `country_institution_config` (`country_alpha3`) ON DELETE CASCADE,
    CONSTRAINT `cwl_institution_FK` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS country_bank_list
(
    `id`                   BIGINT(20) UNSIGNED auto_increment NOT NULL,
    `institution_id`       BIGINT UNSIGNED                    NOT NULL,
    `country_alpha3`       VARCHAR(3)                         NOT NULL,
    `institution_currency` VARCHAR(3)                         NULL,
    `help_text`            VARCHAR(200)                       NULL,
    `time_created`         TIMESTAMP                          NOT NULL,
    `time_updated`         TIMESTAMP                          NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `cbl_UQ` UNIQUE (`institution_id`, `country_alpha3`),
    CONSTRAINT `cbl_country_config_FK` FOREIGN KEY (`country_alpha3`) REFERENCES `country_institution_config` (`country_alpha3`) ON DELETE CASCADE,
    CONSTRAINT `cbl_institution_FK` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`) ON DELETE CASCADE
);



