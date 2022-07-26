package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    Integer identifier;
    User author;
    Chatroom room;
    String text;
    LocalDateTime messageDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(identifier, message.identifier)
                && Objects.equals(author, message.author)
                && Objects.equals(room, message.room)
                && Objects.equals(text, message.text)
                && Objects.equals(messageDateTime, message.messageDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, author, room, text, messageDateTime);
    }

    @Override
    public String toString() {
        return "Message: " +
                "identifier=" + identifier +
                ", author=" + author +
                ", room=" + room +
                ", text='" + text + '\'' +
                ", messageDateTime=" + messageDateTime;
    }
}
