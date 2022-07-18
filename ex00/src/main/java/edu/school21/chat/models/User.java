package edu.school21.chat.models;

import java.util.LinkedList;

public class User {
    private Integer identifier;
    private String login;
    private String password;
    private LinkedList<Chatroom> createdChatrooms;
    private LinkedList<Chatroom> memberRooms;
 }
