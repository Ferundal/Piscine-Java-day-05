INSERT INTO chat.users (login, password) VALUES ('boba_fett', 1);
INSERT INTO chat.users (login, password) VALUES ('darth_sidius', 2);
INSERT INTO chat.users (login, password) VALUES ('darth_vader', 3);
INSERT INTO chat.users (login, password) VALUES ('han_solo', 4);
INSERT INTO chat.users (login, password) VALUES ('luke_skywalker', 5);

INSERT INTO chat.rooms (chat_owner, chat_name) VALUES (1, 'chat1');
INSERT INTO chat.rooms (chat_owner, chat_name) VALUES (2, 'chat2');
INSERT INTO chat.rooms (chat_owner, chat_name) VALUES (3, 'chat3');
INSERT INTO chat.rooms (chat_owner, chat_name) VALUES (4, 'chat4');
INSERT INTO chat.rooms (chat_owner, chat_name) VALUES (5, 'chat5');

INSERT INTO chat.messages (room_id, sender, message, time) VALUES (1, 2, 'YOBA ETO TY?', '2022-07-26 16:47:34');
INSERT INTO chat.messages (room_id, sender, message, time) VALUES (1, 3, 'TY OPYAT VIHODISH NA SVYAS?', '2022-07-26 16:53:34');
INSERT INTO chat.messages (room_id, sender, message, time) VALUES (2, 1, 'KOD LOH', '2022-07-26 15:24:34');
INSERT INTO chat.messages (room_id, sender, message, time) VALUES (2, 4, 'NO U!', '2022-07-26 15:24:45');
INSERT INTO chat.messages (room_id, sender, message, time) VALUES (2, 5, 'lol kek cheburek', '2022-07-26 15:27:12');