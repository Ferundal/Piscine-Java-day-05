package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    private static final String DATA_BASE_URL = "jdbc:postgresql://localhost/postgres";
    private static final String DATA_BASE_USER = "postgres";
    private static final String DATA_BASE_PASSWORD = "1984";
    public static void main(String[] args) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariDataSource.setUsername("postgres");
        hikariDataSource.setPassword("1984");
        MessagesRepositoryJdbcImpl messagesRepository = new MessagesRepositoryJdbcImpl(hikariDataSource);


        Optional<Message> messageOptional;
        try {
            messageOptional = messagesRepository.findById(messageIndex);
            messageOptional.ifPresent(message -> System.out.println(message.toString()));
        } catch (SQLException sqlException) {
            System.out.println("Wrong message ID");
        }
    }
}
