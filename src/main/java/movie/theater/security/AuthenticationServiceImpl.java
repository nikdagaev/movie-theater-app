package movie.theater.security;

import java.util.Optional;
import movie.theater.exception.AuthenticationException;
import movie.theater.lib.Inject;
import movie.theater.lib.Service;
import movie.theater.model.User;
import movie.theater.service.ShoppingCartService;
import movie.theater.service.UserService;
import movie.theater.util.HashUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> userFromDb = userService.findByEmail(email);
        if (userFromDb.isPresent() && matchPasswords(password, userFromDb.get())) {
            return userFromDb.get();
        }
        throw new AuthenticationException("Incorrect email or password.");
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }

    private boolean matchPasswords(String rawPassword, User userFromDb) {
        String hashedPassword = HashUtil.hashPassword(rawPassword, userFromDb.getSalt());
        return hashedPassword.equals(userFromDb.getPassword());
    }
}
