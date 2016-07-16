TRUNCATE TABLE authority;
INSERT INTO authority (id, name) VALUES(1, 'ROLE_USER');
INSERT INTO authority (id, name) VALUES(2, 'ROLE_ADMIN');

TRUNCATE TABLE users;
INSERT INTO users (id, created_date, update_date, email, enabled, full_name, last_password_reset_date, password, username) VALUES(1, '2016-06-25 00:00:00', '2016-06-25 00:00:00', 'josebatista15@gmail.com', TRUE, 'Jose Batista', '2016-06-10 00:00:00', '$2a$08$.5Ev0tOtuNCfV0Oh1HIGDup/weNeVa2r4WNbfVK2ZUB1mkubP7R42', 'wyldkat');

TRUNCATE TABLE users_authorities;
INSERT INTO users_authorities (user_id, authority_id) VALUES(1, 1);

TRUNCATE TABLE accounts;
INSERT INTO accounts (created_date, update_date, active, name, notes, account_type, user_id) VALUES('2016-06-25 13:25:40', '2016-06-25 13:25:40', TRUE, 'Wallet', 'Your wallet', 'CASH', 1);
INSERT INTO accounts (created_date, update_date, active, name, notes, account_type, user_id) VALUES('2016-06-25 13:25:40', '2016-06-25 13:25:40', TRUE, 'Santander', 'Notes go here', 'DEBIT_CARD', 1);
insert into accounts (name, notes, active, account_type, created_date, update_date, user_id) values ('Maestro Card', '(ﾉಥ益ಥ）ﾉ﻿ ┻━┻', true, 'CREDIT_CARD', '2016-03-12 16:30:32', '2016-01-15 23:35:09', 1);
insert into accounts (name, notes, active, account_type, created_date, update_date, user_id) values ('JCB', 'Ω≈ç√∫˜µ≤≥÷', true, 'BANK', '2015-11-19 01:54:11', '2016-02-24 04:05:04', 1);
insert into accounts (name, notes, active, account_type, created_date, update_date, user_id) values ('PayPal', 'NIL', false, 'PAYPAL', '2015-07-31 12:40:30', '2016-01-20 01:22:55', 1);
insert into accounts (name, notes, active, account_type, created_date, update_date, user_id) values ('Home Savings', '1.00', false, 'CASH', '2015-09-21 04:48:20', '2016-05-24 16:22:39', 1);
