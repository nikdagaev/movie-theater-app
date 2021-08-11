package movie.theater.service;

import java.time.LocalDate;
import java.util.List;
import movie.theater.model.MovieSession;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession get(Long id);

    MovieSession add(MovieSession session);
}
