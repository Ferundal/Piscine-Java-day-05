package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    Long identifier;
    User author;
    Chatroom room;
    String text;
    LocalDateTime messageDateTime;

    public Message(Long identifier, User author, Chatroom room, String text, LocalDateTime messageDateTime) {
        this.identifier = identifier;
        this.author = author;
        this.room = room;
        this.text = text;
        this.messageDateTime = messageDateTime;
    }

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
        return "Message={\n" +
                "identifier=" + identifier +
                "\n" + author +
                "\n" + room +
                "\ntext=\"" + text + '\"' +
                "\nmessageDateTime=" + messageDateTime +
                "\n}";
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public User getAuthor() {
        return author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getMessageDateTime() {
        return messageDateTime;
    }


}
