package movie.theater.dao.impl;

import movie.theater.dao.AbstractDao;
import movie.theater.dao.TicketDao;
import movie.theater.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
