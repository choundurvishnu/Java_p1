package vishnu.push.api.movie.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import vishnu.push.api.movie.model.Movie;
import vishnu.push.api.movie.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies") //Extra
    public List<Movie> allMovies()
    {
        return movieRepository.findAll();
    }


    public Optional<Movie> singleMovie(ObjectId id)
    {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(ObjectId id, Movie movie)
    {
        Optional<Movie> movieOptional = movieRepository.findById(id);//
        if(movieOptional.isPresent())
        {
            Movie movieToAdd = movieOptional.get();
            movieToAdd.setYear(movie.getYear());
            movieToAdd.setGenres(movie.getGenres());
            movieToAdd.setRuntime(movie.getRuntime());
            movieToAdd.setCast(movie.getCast());
            movie.setPoster(movie.getPoster());
            movieToAdd.setTitle(movie.getTitle());
            movie.setFullplot(movie.getFullplot());
            movie.setLanguages(movie.getLanguages());
            movie.setReleased(movie.getReleased());
            movie.setDirectors(movie.getDirectors());
            movie.setRated(movie.getRated());
            movie.setLastupdated(movie.getLastupdated());
            movie.setAwards(movie.getAwards());
            movie.setCountries(movie.getCountries());
            movie.setType(movie.getType());
            movie.setImdb(movie.getImdb());
            movie.setYear(movie.getYear());

            return movieRepository.save(movieToAdd);

        }
        else
        {
            return null;
        }
    }


    public boolean deleteMovie(ObjectId id)
    {
        Optional<Movie> movieOptional = movieRepository.findById(id); //
        if(movieOptional.isPresent())
        {
            movieRepository.delete(movieOptional.get());
            return true;
        }
        else
        {
            return false;
        }
    }
}
