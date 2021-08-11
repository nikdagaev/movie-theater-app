package movie.theater.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import movie.theater.dao.OrderDao;
import movie.theater.lib.Inject;
import movie.theater.lib.Service;
import movie.theater.model.Order;
import movie.theater.model.ShoppingCart;
import movie.theater.model.User;
import movie.theater.service.OrderService;
import movie.theater.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        order.setUser(shoppingCart.getUser());
        order.setOrderDate(LocalDateTime.now());
        shoppingCartService.clearShoppingCart(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getByUser(user);
    }
}
