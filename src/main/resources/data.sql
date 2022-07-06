INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('gbies', 'Geeske', 'Bies', 64, 16);
INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('adjong87', 'Arjen', 'de Jong', 35, 27);
INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('kslabikova', 'Kristina', 'Slabikova', 28, 12);
INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('hermans', 'Herman', 'Schaapherder', 83, 38);
INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('jeanneau', 'Jeanneau', 'de Naamloze',  74, 41);
INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('john', 'John', 'de Man', 66, 35);
INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('hermand', 'Herman', 'Driessen', 86, 18);
INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('pieterpost', 'Pieter', 'Post', 70, 44);

INSERT INTO users (username, password, email, user_profile) VALUES('gbies','$2a$10$YwckUKeTAp1NvN4qozRSDOkXMoIKV3RHjwdox540CV9oh.DRNMZqi', 'g.bies@fryslan.nl', 'gbies');
INSERT INTO users (username, password, email, user_profile) VALUES('adjong87','$2a$10$kyVFisSyoq4y1aFiw1FIueBC3dNqDGltTDyNXWOe3bjkx.A72CA4W', 'adjong87@gmail.com', 'adjong87');
INSERT INTO users (username, password, email, user_profile) VALUES('kslabikova','$2a$10$kyVFisSyoq4y1aFiw1FIueBC3dNqDGltTDyNXWOe3bjkx.A72CA4W', 'kristina.gaudi@gmail.com', 'kslabikova');
INSERT INTO users (username, password, email, user_profile) VALUES('jeanneau','$2a$10$hUR7JaHbteZlAKiZF7mNi.sjdvtCcYZOVJUvBv1lKykgpkUVc773i', 'jeanneau@gmail.com', 'jeanneau');
INSERT INTO users (username, password, email, user_profile) VALUES('hermans','$2a$10$hUR7JaHbteZlAKiZF7mNi.sjdvtCcYZOVJUvBv1lKykgpkUVc773i', 'hermanengreetschaapherder@gmail.com', 'hermans');
INSERT INTO users (username, password, email, user_profile) VALUES('john','$2a$10$hUR7JaHbteZlAKiZF7mNi.sjdvtCcYZOVJUvBv1lKykgpkUVc773i', 'johndeman@gmail.com', 'john');
INSERT INTO users (username, password, email, user_profile) VALUES('hermand','$2a$10$hUR7JaHbteZlAKiZF7mNi.sjdvtCcYZOVJUvBv1lKykgpkUVc773i', 'hermandriessen@gmail.com', 'hermand');
INSERT INTO users (username, password, email, user_profile) VALUES('pieterpost','$2a$10$hUR7JaHbteZlAKiZF7mNi.sjdvtCcYZOVJUvBv1lKykgpkUVc773i', 'pieterpost@dummy.com', 'pieterpost');

INSERT INTO user_roles (user_username, role_id) VALUES('gbies', 1);
 INSERT INTO user_roles (user_username, role_id) VALUES('gbies', 2);

INSERT INTO user_roles (user_username, role_id) VALUES('gbies', 3);
INSERT INTO user_roles (user_username, role_id) VALUES('adjong87', 1);
INSERT INTO user_roles (user_username, role_id) VALUES('adjong87', 2);
INSERT INTO user_roles (user_username, role_id) VALUES('adjong87', 3);
INSERT INTO user_roles (user_username, role_id) VALUES('kslabikova', 1);
INSERT INTO user_roles (user_username, role_id) VALUES('kslabikova', 2);
INSERT INTO user_roles (user_username, role_id) VALUES('jeanneau', 1);
INSERT INTO user_roles (user_username, role_id) VALUES('hermans', 1);
INSERT INTO user_roles (user_username, role_id) VALUES('john', 1);

INSERT INTO user_roles (user_username, role_id) VALUES('pieterpost', 1);
INSERT INTO user_roles (user_username, role_id) VALUES('pieterpost', 3);

INSERT INTO user_roles (user_username, role_id) VALUES('hermand', 1);
--*/
-- INSERT INTO score_card(id, aim_scorep1, aim_scorep2, filled_in, gespeeld_Op, nr_of_turns, player_one_name, player_one_score, player_two_name, player_two_score) VALUES (33, 27, 38, false, '2022-07-01', 24, 'Arjen', '{'0','1','2','1','0','0','0','2','1','0','0','5','1','1','2','0','0','2','2','0','0','3','2','2'}', 'Herman', '{'0','1','2','1','0','0','0','2','1','0','0','5','1','1','2','0','0','2','2','0','0','3','2','2'}');
-- INSERT INTO score_card(id, aim_scorep1, aim_scorep2, filled_in, gespeeld_Op, nr_of_turns, player_one_name, player_one_score, player_two_name, player_two_score) VALUES (34, 41, 16, true, '2022-07-01', 26, 'Jeanneau','{3,1,5,1,0,0,0,3,0,2,1,7,0,1,1,1,2,5,0,2,2,0,0,1,1}', 'Geeske', '{0,1,0,1,0,0,0,2,1,0,0,1,1,1,0,0,2,0,0,2,2,0,0,1,1}');
-- INSERT INTO score_card(id, aim_scorep1, aim_scorep2, filled_in, gespeeld_Op, nr_of_turns, player_one_name, player_one_score, player_two_name, player_two_score) VALUES (35, 35, 38, true, '2022-07-01', 25, 'John', '{3,1,5,1,0,0,0,3,0,2,1,5,0,1,1,1,2,5,0,2,0,0,0,1,1}', 'Herman S', '{0,1,2,1,0,0,0,3,0,2,1,4,0,1,1,1,2,3,0,2,2,0,0,1,1}');
-- INSERT INTO score_card(id, aim_scorep1, aim_scorep2, filled_in, gespeeld_Op, nr_of_turns, player_one_name, player_one_score, player_two_name, player_two_score) VALUES (36, 44, 41, true, '2022-07-01', 26, 'Jan', '{3,3,5,1,0,0,0,0,3,0,2,1,5,2,1,1,1,2,5,0,2,2,0,0,1,1}', 'Jeaunneau', '{3,1,5,1,0,0,0,3,0,2,1,7,0,1,0,1,1,2,5,0,2,2,0,0,1,1}');
-- INSERT INTO score_card(id, aim_scorep1, aim_scorep2, filled_in, gespeeld_Op, nr_of_turns, player_one_name, player_one_score, player_two_name, player_two_score) VALUES (37, 18, 38, false, '2022-07-01', 0, 'Herman D', null, 'Herman S', null);
-- INSERT INTO score_card(id, aim_scorep1, aim_scorep2, filled_in, gespeeld_Op, nr_of_turns, player_one_name, player_one_score, player_two_name, player_two_score) VALUES (38, 27, 41, false, '2022-07-01', 0, 'Arjen', null, 'Jeanneau', null);
-- INSERT INTO score_card(id, aim_scorep1, aim_scorep2, filled_in, gespeeld_Op, nr_of_turns, player_one_name, player_one_score, player_two_name, player_two_score) VALUES (39, 35, 27, false, '2022-07-01', 0, 'John', null, 'Arjen', null);
-- INSERT INTO score_card(id, aim_scorep1, aim_scorep2, filled_in, gespeeld_Op, nr_of_turns, player_one_name, player_one_score, player_two_name, player_two_score) VALUES (40, 18, 16, false, '2022-07-01', 0, 'Herman D', null, 'Geeske', null);
--
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (33, 'adjong87', true);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (33, 'hermans', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (34, 'jeanneau', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (34, 'gbies', true);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (35, 'jan', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (35, 'jeanneau', true);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (36, 'jan', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (36, 'jeanneau', true);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (37, 'hermand', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (37, 'hermans', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (38, 'adjong87', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (38, 'jeanneau', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (39, 'john', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (39, 'adjong87', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (40, 'hermand', false);
-- INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (40, 'gbies', false);