package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private static final String QUERY_TEMPLATE = "SELECT * FROM chat.messages WHERE id = ";
    private final DataSource dataSource;
    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String query = QUERY_TEMPLATE + id;
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        User tempUser = new User(1, "lupa", "pupa");
        Chatroom tempChatroom = new Chatroom(1, "deafultChatname", null);
        Optional<Message> optionalMessage = Optional.of(new Message(1,
                tempUser,
                tempChatroom,
                resultSet.getString("message"),
                LocalDateTime.now()));
        return optionalMessage;
    }
}
