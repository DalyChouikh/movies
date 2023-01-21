package dev.daly.movies.controller;


import dev.daly.movies.models.Review;
import dev.daly.movies.service.ReviewService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/movies")
@AllArgsConstructor
public class ReviewController {

    private ReviewService reviewService;

    @PostMapping("/{imdbId}")
    public ResponseEntity<Review> createReview(@PathVariable String imdbId, @RequestBody Review review){
        return new ResponseEntity<>(reviewService.createReview(review.getBody(), imdbId), HttpStatus.CREATED);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Optional<Review>> getReview(@PathVariable ObjectId reviewId){
        return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
    }

}
