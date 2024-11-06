package springbootpokemon.pokemonproject.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springbootpokemon.pokemonproject.dto.PokemonDto;
import springbootpokemon.pokemonproject.model.Pokemon;
import springbootpokemon.pokemonproject.service.PokemonService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class Controller {
	
	
@GetMapping("pokemon")
 public ResponseEntity<List<Pokemon>> getPokemons() {
 List<Pokemon> pokemons = new ArrayList<>();
pokemons.add(new Pokemon(1, "Squirtle", "Water", null));
  pokemons.add(new Pokemon(2, "Pikachu", "Electric", null));
 pokemons.add(new Pokemon(3, "Charmander", "Fire", null));
	        return ResponseEntity.ok(pokemons);
	    }
private PokemonService pokemonService;

@Autowired
public Controller(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
}
@PostMapping("pokemon/create")
@ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto) {

	return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
}
@GetMapping("pokemon/{id}")
public ResponseEntity<PokemonDto> pokemonDetail(@PathVariable int id) {
    return ResponseEntity.ok(pokemonService.getPokemonById(id));

}
@PutMapping("pokemon/{id}/update")
public ResponseEntity<PokemonDto> updatePokemon(@RequestBody PokemonDto pokemonDto, @PathVariable("id") int pokemonId) {
    PokemonDto response = pokemonService.updatePokemon(pokemonDto, pokemonId);
    return new ResponseEntity<>(response, HttpStatus.OK);
}

@DeleteMapping("pokemon/{id}/delete")
public ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId) {
    pokemonService.deletePokemonId(pokemonId);
    return new ResponseEntity<>("Pokemon delete", HttpStatus.OK);
}




}