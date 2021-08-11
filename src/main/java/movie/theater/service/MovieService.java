package movie.theater.service;

import java.util.List;
import movie.theater.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
