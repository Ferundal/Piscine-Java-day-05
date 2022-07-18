package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.LinkedList;

public class Chatroom {
    private Integer identifier;
    private String chatName;
    User owner;
    LinkedList<Message> messages;
}
