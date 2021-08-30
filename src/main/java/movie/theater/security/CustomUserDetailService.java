package movie.theater.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import movie.theater.model.User;
import movie.theater.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userService.findByEmail(email).orElseThrow(()
                -> new UsernameNotFoundException("User not found"));
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder =
                withUsername(email).password(user.getPassword())
                .roles(user.getRoles().stream()
                        .map(r -> r.getName().toString()).toArray(String[]::new));
        return userBuilder.build();
    }
}
