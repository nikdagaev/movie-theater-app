package movie.theater.service;

import movie.theater.model.MovieSession;
import movie.theater.model.ShoppingCart;
import movie.theater.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
