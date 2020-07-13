INSERT INTO book (id, title, version)
VALUES (1, 'Hibernate Tips', 0);

insert into review(id,fk_book, comment )
VALUES (1, 1, 'First comment');
insert into review(id,fk_book, comment )
VALUES (2, 1, 'Second comment');
insert into review(id,fk_book, comment )
VALUES (3, 1, 'Third comment');
insert into review(id,fk_book, comment )
VALUES (4, 1, 'Forth comment');

INSERT INTO institution(id, name)
VALUES (1, 'INS1');
INSERT INTO institution(id, name)
VALUES (2, 'INS2');
INSERT INTO institution(id, name)
VALUES (3, 'INS3');
INSERT INTO institution(id, name)
VALUES (4, 'INS4');
INSERT INTO institution(id, name)
VALUES (5, 'INS5');



INSERT INTO country_institution_config(`country_alpha3`, `currency` ,`currency_help`,`wallet_transfer_time`,`bank_transfer_time`,`cash_transfer_time`,`required_on_cash_collection`,`time_created`,`time_updated`)
VALUES('ZAF','ZAR','Currency help text','WalTransfer','BankTransfer','CashTransfr','IDENTITY_DOCUMENT', now(), now());
INSERT INTO country_institution_config(`country_alpha3`, `currency` ,`currency_help`,`wallet_transfer_time`,`bank_transfer_time`,`cash_transfer_time`,`required_on_cash_collection`,`time_created`,`time_updated`)
VALUES('ZIM','USD','Currency help text 2','WalTransfer2','BankTransfer2','CashTransfr2','IDENTITY_DOCUMENT', now(), now());

INSERT INTO country_wallet_list(`id`,`institution_id`,`country_alpha3`,`institution_currency`,`help_text`,`time_created`,`time_updated`)
VALUES (1,1,'ZAF','ZAR','Wallet help text', now(), now());
INSERT INTO country_wallet_list(`id`,`institution_id`,`country_alpha3`,`institution_currency`,`help_text`,`time_created`,`time_updated`)
VALUES (2,2,'ZAF','ZAR','Wallet help text', now(), now());
