package com.looqbox.pokechallenge.client;

import com.looqbox.pokechallenge.model.PokemonPojo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class PokeApiClient {
    public PokemonPojo getPokemon() {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("https://pokeapi.co/api/v2/pokemon")
                .defaultHeader("User-Agent", "PokeApiClient/0.0.1")
                .build(); //builds the API request

        return restTemplate.getForObject("/", PokemonPojo.class); //response object
    }

    public ArrayList<String> getPokemonNames(PokemonPojo pokemonPojo) {
        ArrayList<String> namesList = new ArrayList<>();

        ArrayList<HashMap> pokemonPojoList = pokemonPojo.getResults();

        for (HashMap map: pokemonPojoList) {
            namesList.add((String) map.get("name"));
        }

        return namesList;

        //TODO: implement caching
    }
}
