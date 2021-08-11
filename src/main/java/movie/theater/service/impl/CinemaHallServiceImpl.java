package movie.theater.service.impl;

import java.util.List;
import movie.theater.dao.CinemaHallDao;
import movie.theater.lib.Inject;
import movie.theater.lib.Service;
import movie.theater.model.CinemaHall;
import movie.theater.service.CinemaHallService;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    @Inject
    private CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallDao.get(id).orElseThrow();
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
