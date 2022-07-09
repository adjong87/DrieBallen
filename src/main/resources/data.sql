INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('janjansen', 'Jan', 'Jansen', 64, 44);
INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('pieterpost', 'Pieter', 'Post', 70, 38);
INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('dikkiedik', 'Dikkie', 'Dik', 83, 25);
INSERT INTO profiles (username, first_name, last_name, age, aim_score) VALUES('dickjaspers', 'Dick', 'Jaspers', 65, 27);

INSERT INTO users (username, password, email, user_profile) VALUES('janjansen','$2a$12$CXD2Jxe3QZrA3ZeI9WG8zuowy/K9flbePeK.VpLyz0RR29kdc/rl.', 'janjansen@dummy.com', 'janjansen');
INSERT INTO users (username, password, email, user_profile) VALUES('pieterpost','$2a$12$CXD2Jxe3QZrA3ZeI9WG8zuowy/K9flbePeK.VpLyz0RR29kdc/rl.', 'pieterpost@dummy.com', 'pieterpost');
INSERT INTO users (username, password, email, user_profile) VALUES('dikkiedik','$2a$12$CXD2Jxe3QZrA3ZeI9WG8zuowy/K9flbePeK.VpLyz0RR29kdc/rl.', 'dikkiedik@dummy.com', 'dikkiedik');
INSERT INTO users (username, password, email, user_profile) VALUES('dickjaspers','$2a$12$CXD2Jxe3QZrA3ZeI9WG8zuowy/K9flbePeK.VpLyz0RR29kdc/rl.', 'dickjaspers@gmail.com', 'dickjaspers');


INSERT INTO user_roles (user_username, role_id) VALUES('janjansen', 1);
INSERT INTO user_roles (user_username, role_id) VALUES('pieterpost', 1);
INSERT INTO user_roles (user_username, role_id) VALUES('pieterpost', 2);
INSERT INTO user_roles (user_username, role_id) VALUES('dikkiedik', 1);
INSERT INTO user_roles (user_username, role_id) VALUES('dikkiedik', 3);
INSERT INTO user_roles (user_username, role_id) VALUES('dickjaspers', 2);
INSERT INTO user_roles (user_username, role_id) VALUES('dickjaspers', 1);
INSERT INTO user_roles (user_username, role_id) VALUES('dickjaspers', 3);

INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (66, 44, 38, 1.22, 2,true,'2022-07-01',5,7,19,'Pieter','Jan', 21, 0);
INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (67, 38, 44, 1.00, 1.46,true,'2022-07-01',8,7,30,'Jan','Pieter', 8, 0);
INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (68, 25, 38, 0.80, 1.5,true,'2022-07-01',2,3,20,'Dikkie','Pieter', 9, 8);
INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (69, 44, 25, 1.3, 1.00,true,'2022-07-01',8,5,25,'Jan','Dikkie', 12, 0);

INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (70, 44, 38, 1.22, 2,true,'2022-07-01',5,7,19,'Pieter','Jan', 21, 0);
INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (71, 38, 44, 1.00, 1.46,true,'2022-07-01',8,7,30,'Jan','Pieter', 8, 0);
INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (72, 25, 38, 0.80, 1.5,true,'2022-07-01',2,3,20,'Dikkie','Pieter', 9, 8);
INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (73, 44, 25, 1.3, 1.00,true,'2022-07-01',8,5,25,'Jan','Dikkie', 12, 0);

INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (74, 44, 38, 1.22, 2,true,'2022-07-01',5,7,19,'Pieter','Jan', 21, 0);
INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (75, 38, 44, 1.00, 1.46,true,'2022-07-01',8,7,30,'Jan','Pieter', 8, 0);
INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (76, 25, 38, 0.80, 1.5,true,'2022-07-01',2,3,20,'Dikkie','Pieter', 9, 8);
INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (77, 44, 25, 1.3, 1.00,true,'2022-07-01',8,5,25,'Jan','Dikkie', 12, 0);

INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (78, 44, 38, 1.22, 2,false,'2022-07-02',3,2,0,'Dick','Pieter', 41, 38);
INSERT INTO score_card(id, aim_scorep1, aim_scorep2, averagep1, averagep2, filled_in, gespeeld_op, highest_seriep1, highest_seriep2, nr_of_turns, player_one_name, player_two_name, remainderp1, remainderp2) VALUES (79, 38, 44, 1.00, 1.46,false,'2022-07-02',4,5,0,'Jan','Dick', 38, 44);

INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (78, 'dickjaspers', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (78, 'pieterpost', true);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (79, 'janjansen', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (79, 'dickjaspers', true);

INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (66, 'pieterpost', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (66, 'janjansen', true);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (67, 'janjansen', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (67, 'pieterpost', true);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (68, 'dikkiedik', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (68, 'pieterpost', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (69, 'janjansen', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (69, 'dikkiedik', true);

INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (70, 'pieterpost', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (70, 'janjansen', true);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (71, 'janjansen', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (71, 'pieterpost', true);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (72, 'dikkiedik', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (72, 'pieterpost', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (73, 'janjansen', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (73, 'dikkiedik', true);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (74, 'pieterpost', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (74, 'janjansen', true);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (75, 'janjansen', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (75, 'pieterpost', true);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (76, 'dikkiedik', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (76, 'pieterpost', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (77, 'janjansen', false);
INSERT INTO played_game(scorecard_id, profile_username, uitgespeeld) VALUES (77, 'dikkiedik', true);
