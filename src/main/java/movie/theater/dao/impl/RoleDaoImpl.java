package movie.theater.dao.impl;

import java.util.Optional;
import movie.theater.dao.AbstractDao;
import movie.theater.dao.RoleDao;
import movie.theater.exception.DataProcessingException;
import movie.theater.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(Role.RoleName roleName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Role r WHERE r.name = :roleName", Role.class)
                    .setParameter("roleName", roleName)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get role by name " + roleName, e);
        }
    }
}
