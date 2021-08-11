package movie.theater.security;

import movie.theater.exception.AuthenticationException;
import movie.theater.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
