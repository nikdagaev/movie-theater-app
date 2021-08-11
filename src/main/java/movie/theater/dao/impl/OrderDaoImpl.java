package movie.theater.dao.impl;

import java.util.List;
import movie.theater.dao.OrderDao;
import movie.theater.exception.DataProcessingException;
import movie.theater.lib.Dao;
import movie.theater.model.Order;
import movie.theater.model.User;
import movie.theater.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert order: "
                    + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> getOrdersByUserQuery =
                    session.createQuery("FROM Order o "
                            + "JOIN FETCH o.user "
                            + "JOIN FETCH o.tickets t "
                            + "JOIN FETCH t.movieSession ms "
                            + "JOIN FETCH ms.cinemaHall "
                            + "JOIN FETCH ms.movie "
                            + "WHERE o.user = :user", Order.class);
            getOrdersByUserQuery.setParameter("user", user);
            return getOrdersByUserQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get order history by user: " + user, e);
        }
    }
}
