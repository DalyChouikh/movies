package dev.daly.movies.service;

import dev.daly.movies.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.daly.movies.models.Movie;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return  movieRepository.findAll();
    }
    public Optional<Movie> oneMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
