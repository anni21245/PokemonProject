package springbootpokemon.pokemonproject.service;



import java.util.List;

import springbootpokemon.pokemonproject.dto.ReviewDto;

public interface ReviewService {
    ReviewDto createReview(int pokemonId, ReviewDto reviewDto);
    List<ReviewDto> getReviewsByPokemonId(int id);
    ReviewDto getReviewById(int reviewId, int pokemonId);
    ReviewDto updateReview(int pokemonId, int reviewId, ReviewDto reviewDto);
    void deleteReview(int pokemonId, int reviewId);
}