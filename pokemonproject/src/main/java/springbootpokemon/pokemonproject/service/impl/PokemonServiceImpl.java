package springbootpokemon.pokemonproject.service.impl;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import springbootpokemon.pokemonproject.dto.PokemonDto;
import springbootpokemon.pokemonproject.dto.PokemonResponse;
import springbootpokemon.pokemonproject.model.Pokemon;
import springbootpokemon.pokemonproject.repository.PokemonRepository;
import springbootpokemon.pokemonproject.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService  {

	
	  private PokemonRepository pokemonRepository;

	@Autowired
	    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
	        this.pokemonRepository = pokemonRepository;
	    }
	
	@Override
	public PokemonDto createPokemon(PokemonDto pokemonDto) {
		Pokemon pokemon = new Pokemon();
		pokemon.setName(pokemonDto.getName());
		pokemon.setType(pokemonDto.getType());
		
		Pokemon newPokemon = pokemonRepository.save(pokemon);
		 PokemonDto pokemonResponse = new PokemonDto();
		 pokemonResponse.setId(newPokemon.getId());
		 pokemonResponse.setName(newPokemon.getName());
		 pokemonResponse.setType(newPokemon.getType());
	        return pokemonResponse;
			
	}
	/*@Override
	public PokemonResponse getAllPokemon(int pageNo, int pageSize) {
	    Pageable pageable = PageRequest.of(pageNo, pageSize);
	    Page<Pokemon> pokemons = pokemonRepository.findAll(pageable);
	    List<Pokemon> listOfPokemon = pokemons.getContent();
	    List<PokemonDto> content = listOfPokemon.stream()
	                                            .map(this::mapToDto)
	                                            .collect(Collectors.toList());

	    PokemonResponse poke monResponse = new PokemonResponse();
	    pokemonResponse.setContent(content);
	    pokemonResponse.setPageNo(pokemons.getNumber());
	    pokemonResponse.setPageSize(pokemons.getSize());
	    pokemonResponse.setTotalElements(pokemons.getTotalElements());
	    pokemonResponse.setTotalPages(pokemons.getTotalPages());
	    pokemonResponse.setLast(pokemons.isLast());

	    return pokemonResponse;
	}
*/
	  @Override
	    public PokemonDto getPokemonById(int id) {
	        Pokemon pokemon = pokemonRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Pokemon not found with id: " + id));

	        PokemonDto pokemonDto = new PokemonDto();
	        pokemonDto.setId(pokemon.getId());
	        pokemonDto.setName(pokemon.getName());
	        pokemonDto.setType(pokemon.getType());

	        return pokemonDto;
	    }

	  @Override
	  public PokemonDto updatePokemon(PokemonDto pokemonDto, int id) {
	      Pokemon pokemonToUpdate = pokemonRepository.findById(id)
	              .orElseThrow(() -> new IllegalArgumentException("Pokemon not found with id: " + id));

	      pokemonToUpdate.setName(pokemonDto.getName());
	      pokemonToUpdate.setType(pokemonDto.getType());

	      Pokemon updatedPokemon = pokemonRepository.save(pokemonToUpdate);

	      PokemonDto updatedPokemonDto = new PokemonDto();
	      updatedPokemonDto.setId(updatedPokemon.getId());
	      updatedPokemonDto.setName(updatedPokemon.getName());
	      updatedPokemonDto.setType(updatedPokemon.getType());

	      return updatedPokemonDto;
	  }
	  
	  @Override
	  public void deletePokemonId(int id) {
	      pokemonRepository.deleteById(id);
	  }

	private <R> R mapToDto(Pokemon pokemon1) {
		return null;
	}



}
