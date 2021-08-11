package movie.theater.dao;

import java.util.List;
import movie.theater.model.Order;
import movie.theater.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getByUser(User user);
}
