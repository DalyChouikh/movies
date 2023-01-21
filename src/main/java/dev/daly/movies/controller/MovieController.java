package dev.daly.movies.controller;

import dev.daly.movies.models.Movie;
import dev.daly.movies.service.MovieService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/movies")
@AllArgsConstructor
public class MovieController {
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.oneMovie(imdbId), HttpStatus.OK);
    }
}
