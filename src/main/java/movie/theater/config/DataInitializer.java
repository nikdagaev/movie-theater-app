package movie.theater.config;

import java.util.Set;
import javax.annotation.PostConstruct;
import movie.theater.model.Role;
import movie.theater.model.User;
import movie.theater.service.RoleService;
import movie.theater.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        User admin = new User();
        admin.setEmail("admin@theater.ua");
        admin.setPassword("admin111");
        admin.setRoles(Set.of(adminRole));
        userService.add(admin);

        Role userRole = new Role();
        userRole.setName(Role.RoleName.USER);
        roleService.add(userRole);
        User user = new User();
        user.setEmail("user@theater.ua");
        user.setPassword("user111");
        user.setRoles(Set.of(userRole));
        userService.add(user);
    }
}
