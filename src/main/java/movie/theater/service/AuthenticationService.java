package movie.theater.service;

import movie.theater.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
