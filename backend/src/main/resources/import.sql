INSERT INTO authority (id, name) VALUES ('1', 'ROLE_USER'), ('2', 'ROLE_ADMIN');

INSERT INTO users (id, email, enabled, full_name, last_password_reset_date, password, username) VALUES (NULL, 'josebatista15@gmail.com', b'1', 'Jose Batista', '2016-06-10 00:00:00', '$2a$08$.5Ev0tOtuNCfV0Oh1HIGDup/weNeVa2r4WNbfVK2ZUB1mkubP7R42', 'wyldkat');

INSERT INTO users_authorities (user_id, authority_id) VALUES ('1', '1');
