package edu.school21.chat.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class User {
    private Long identifier;
    private String login;
    private String password;
    private List<Chatroom> createdChatrooms;
    private List<Chatroom> memberRooms;

    {
        createdChatrooms = new LinkedList<Chatroom>();
        memberRooms = new LinkedList<Chatroom>();
    }

    public User (Long identifier, String login, String password) {
        this.identifier = identifier;
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(identifier, user.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public String toString() {
        return "User={" +
                "identifier=" + identifier +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdChatrooms=" + createdChatrooms +
                ", memberRooms=" + memberRooms +
                '}';
    }

    public Long getIdentifier() {
        return identifier;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
