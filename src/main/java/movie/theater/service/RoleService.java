package movie.theater.service;

import movie.theater.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(Role.RoleName roleName);
}
