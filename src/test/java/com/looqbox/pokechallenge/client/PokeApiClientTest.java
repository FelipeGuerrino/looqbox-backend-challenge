package com.looqbox.pokechallenge.client;

import com.looqbox.pokechallenge.model.PokemonPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PokeApiClientTest {
    @Autowired
    PokeApiClient underTest = new PokeApiClient();

    @Test
    void itShouldReturnPokemonPojo(){
        //when
        PokemonPojo response = underTest.getPokemon();

        //then
        assertThat(response).isInstanceOf(PokemonPojo.class);

    }
    @Test
    void itShouldReturnNameList(){
        //given
        PokemonPojo pokemonPojo = underTest.getPokemon();

        //when
        ArrayList<String> names = underTest.getPokemonNames(pokemonPojo);

        //then
        assertThat(names).isInstanceOf(ArrayList.class);
    }
}