package movie.theater.dao;

import java.util.Optional;
import movie.theater.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(Role.RoleName roleName);
}
