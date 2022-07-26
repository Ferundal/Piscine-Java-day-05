package edu.school21.chat.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Integer identifier;
    private String chatName;
    User owner;
    List<Message> messages;
    {
        messages = new LinkedList<Message>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return identifier.equals(chatroom.identifier)
                && chatName.equals(chatroom.chatName)
                && owner.equals(chatroom.owner)
                && messages.equals(chatroom.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, chatName, owner, messages);
    }

    @Override
    public String toString() {
        return "Chatroom: " +
                "identifier=" + identifier +
                ", chatName='" + chatName + '\'' +
                ", owner=" + owner +
                ", has " + messages.size() + " messages";
    }
}
