CREATE SCHEMA if NOT EXISTS chat;

DROP TABLE if EXISTS chat.messages, chat.rooms, chat.users;
CREATE TABLE if NOT EXISTS chat.users (
    id          serial primary key,
    login       text unique not null,
    password    text
);

CREATE TABLE if NOT EXISTS chat.rooms (
    id          serial primary key,
    chat_owner  int not null references chat.users(id),
    chat_name   text not null
);

CREATE TABLE if NOT EXISTS chat.messages (
    id          serial primary key,
    room_id     int not null references chat.rooms(id),
    sender      int not null references chat.users(id),
    message     text not null,
    time        timestamp
)

