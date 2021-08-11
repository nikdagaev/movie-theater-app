package movie.theater.service;

import java.util.Optional;
import movie.theater.model.User;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
