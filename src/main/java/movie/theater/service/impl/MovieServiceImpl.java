package movie.theater.service.impl;

import java.util.List;
import movie.theater.dao.MovieDao;
import movie.theater.lib.Inject;
import movie.theater.lib.Service;
import movie.theater.model.Movie;
import movie.theater.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).orElseThrow();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
