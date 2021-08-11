package movie.theater.dao.impl;

import movie.theater.dao.TicketDao;
import movie.theater.exception.DataProcessingException;
import movie.theater.lib.Dao;
import movie.theater.model.Ticket;
import movie.theater.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TicketDaoImpl implements TicketDao {

    @Override
    public Ticket add(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert ticket: "
                    + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
