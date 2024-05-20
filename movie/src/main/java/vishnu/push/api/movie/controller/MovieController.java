package vishnu.push.api.movie.controller;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vishnu.push.api.movie.service.MovieService;
import vishnu.push.api.movie.model.Movie;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id),HttpStatus.OK);
    }

    @PostMapping//("/")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie createmovie = movieService.addMovie(movie);
        return new ResponseEntity<Movie>(createmovie,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable ObjectId id ,@RequestBody Movie newmovie)
    {
        Movie updatedmovie = movieService.updateMovie(id, newmovie);
        if (updatedmovie != null) {
            return new ResponseEntity<Movie>(updatedmovie, HttpStatus.OK);
        } else {
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable ObjectId id)
    {
        boolean isdeleted = movieService.deleteMovie(id);
        if (isdeleted)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
