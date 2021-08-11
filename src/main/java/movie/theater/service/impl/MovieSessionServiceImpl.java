package movie.theater.service.impl;

import java.time.LocalDate;
import java.util.List;
import movie.theater.dao.MovieSessionDao;
import movie.theater.lib.Inject;
import movie.theater.lib.Service;
import movie.theater.model.MovieSession;
import movie.theater.service.MovieSessionService;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao sessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return sessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession get(Long id) {
        return sessionDao.get(id).orElseThrow();
    }

    @Override
    public MovieSession add(MovieSession session) {
        return sessionDao.add(session);
    }
}
