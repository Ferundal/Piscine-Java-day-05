package edu.school21.chat.repositories;

import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private final DataSource dataSource;
    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> findAll(int page, int size) {
        return null;
    }
}
