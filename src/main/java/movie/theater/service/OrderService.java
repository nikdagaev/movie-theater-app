package movie.theater.service;

import java.util.List;
import movie.theater.model.Order;
import movie.theater.model.ShoppingCart;
import movie.theater.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
