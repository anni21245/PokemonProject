package springbootpokemon.pokemonproject.service;


import java.util.List;

import springbootpokemon.pokemonproject.dto.PokemonDto;
import springbootpokemon.pokemonproject.dto.PokemonResponse;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);
 //   PokemonResponse getAllPokemon(int pageNo, int pageSize);
   PokemonDto getPokemonById(int id);
    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);
   void deletePokemonId(int id);
}