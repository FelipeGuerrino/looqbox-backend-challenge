package com.looqbox.pokechallenge.client;

import com.looqbox.pokechallenge.model.Pokedex;
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
        Pokedex response = underTest.getPokemon();

        //then
        assertThat(response).isInstanceOf(Pokedex.class);

    }
    @Test
    void itShouldReturnNameList(){
        //given
        Pokedex pokedex = underTest.getPokemon();

        //when
        ArrayList<String> names = underTest.getPokemonNames(pokedex);

        //then
        assertThat(names).isInstanceOf(ArrayList.class);
    }
}