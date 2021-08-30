package movie.theater.service.impl;

import movie.theater.dao.RoleDao;
import movie.theater.exception.DataProcessingException;
import movie.theater.model.Role;
import movie.theater.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow(() ->
                new DataProcessingException("Can't find role for name " + roleName));
    }
}
