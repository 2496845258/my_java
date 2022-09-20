package main2;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    List<User> findAll() throws Exception;
}
