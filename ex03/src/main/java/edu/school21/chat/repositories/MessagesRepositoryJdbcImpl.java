package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final DataSource dataSource;
    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Message message) throws NotSavedSubEntityException {
        final String QUERY_TEMPLATE = "INSERT INTO chat.messages (room_id, sender, message, time) VALUES (?, ?, ?, ?) RETURNING *";
        PreparedStatement query;
        try {
            Connection connection = dataSource.getConnection();
            query = connection.prepareStatement(QUERY_TEMPLATE);

            try {
                query.setLong(1, message.getRoom().getIdentifier());
                query.setLong(2, message.getAuthor().getIdentifier());
                query.setString(3, message.getText());
                query.setTimestamp(4, Timestamp.valueOf(message.getMessageDateTime()));
            } catch (NullPointerException nullPointerException) {
                throw new NotSavedSubEntityException();
            }
        } catch (java.sql.SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        ResultSet resultSet;
        try {
            resultSet = query.executeQuery();
        } catch (java.sql.SQLException sqlException) {
            throw new NotSavedSubEntityException();
        }
        try {
            resultSet.next();
            message.setIdentifier(resultSet.getLong("id"));
        } catch (java.sql.SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        final String QUERY_TEMPLATE = "SELECT * FROM chat.messages WHERE id = ";
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String query = QUERY_TEMPLATE + id;
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        User tempUser = new User(1L, "lupa", "pupa");
        Chatroom tempChatroom = new Chatroom(1L, "deafultChatname", null);
        Optional<Message> optionalMessage = Optional.of(new Message(1L,
                tempUser,
                tempChatroom,
                resultSet.getString("message"),
                LocalDateTime.now()));
        return optionalMessage;
    }
}
