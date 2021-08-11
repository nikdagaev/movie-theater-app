package movie.theater.dao;

import java.util.Optional;
import movie.theater.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);
}