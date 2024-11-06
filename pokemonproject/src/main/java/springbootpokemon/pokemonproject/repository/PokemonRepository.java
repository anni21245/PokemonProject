package springbootpokemon.pokemonproject.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import springbootpokemon.pokemonproject.model.Pokemon;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Optional<Pokemon> findByType(String type);
}