package com.looqbox.pokechallenge.client;

import com.looqbox.pokechallenge.model.PokemonList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PokeApiClientTest {
    @Autowired
    PokeApiClient underTest = new PokeApiClient();

    @Test
    void itShouldReturnPokemonPojo(){
        //when
        PokemonList response = underTest.getPokemon();

        //then
        assertThat(response).isInstanceOf(PokemonList.class);

    }
    @Test
    void itShouldReturnNameList(){
        //given
        PokemonList pokemonList = underTest.getPokemon();

        //when
        ArrayList<String> names = underTest.getPokemonNames(pokemonList);

        //then
        assertThat(names).isInstanceOf(ArrayList.class);
    }
}