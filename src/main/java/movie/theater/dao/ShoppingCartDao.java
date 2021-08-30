package movie.theater.dao;

import movie.theater.model.ShoppingCart;
import movie.theater.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
