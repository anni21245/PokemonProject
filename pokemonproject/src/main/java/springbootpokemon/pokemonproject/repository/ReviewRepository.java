package springbootpokemon.pokemonproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import springbootpokemon.pokemonproject.review.Review;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByPokemonId(int pokemonId);
}