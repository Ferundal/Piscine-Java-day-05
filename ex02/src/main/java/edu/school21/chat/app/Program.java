package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    private static final String DATA_BASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DATA_BASE_USER = "postgres";
    private static final String DATA_BASE_PASSWORD = "1984";
    public static void main(String[] args) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(DATA_BASE_URL);
        hikariDataSource.setUsername(DATA_BASE_USER);
        hikariDataSource.setPassword(DATA_BASE_PASSWORD);
        MessagesRepositoryJdbcImpl messagesRepository = new MessagesRepositoryJdbcImpl(hikariDataSource);
        User creator = new User(3L, "user", "user");
        User author = creator;
        Chatroom room = new Chatroom(5L, "room", creator);
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
        try {
            messagesRepository.save(message);
        } catch (NotSavedSubEntityException e) {
            throw new RuntimeException(e);
        }
        System.out.println(message.getIdentifier());

        creator = new User(40000L, "user", "user");
        author = creator;
        room = new Chatroom(5L, "room", creator);
        message = new Message(null, author, room, "Hello!", LocalDateTime.now());
        try {
            messagesRepository.save(message);
        } catch (NotSavedSubEntityException e) {
            System.out.println(e.toString());
        }

        creator = new User(null, "user", "user");
        author = creator;
        room = new Chatroom(5L, "room", creator);
        message = new Message(null, author, room, "Hello!", LocalDateTime.now());
        try {
            messagesRepository.save(message);
        } catch (NotSavedSubEntityException e) {
            System.out.println(e.toString());
        }
    }
}
