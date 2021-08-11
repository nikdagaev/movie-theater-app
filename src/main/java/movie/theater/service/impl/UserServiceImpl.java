package movie.theater.service.impl;

import java.util.Optional;
import movie.theater.dao.UserDao;
import movie.theater.lib.Inject;
import movie.theater.lib.Service;
import movie.theater.model.User;
import movie.theater.service.UserService;
import movie.theater.util.HashUtil;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
