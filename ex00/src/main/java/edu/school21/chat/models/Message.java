package edu.school21.chat.models;

import java.time.LocalDateTime;

public class Message {
    Integer identifier;
    User author;
    Chatroom room;
    String text;
    LocalDateTime messageDateTime;
}
