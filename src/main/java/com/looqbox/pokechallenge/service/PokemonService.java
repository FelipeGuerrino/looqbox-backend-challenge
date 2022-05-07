package com.looqbox.pokechallenge.service;

import com.looqbox.pokechallenge.client.PokeApiClient;
import com.looqbox.pokechallenge.model.PokemonList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PokemonService {
    private final PokeApiClient pokeApiClient = new PokeApiClient();

    public ArrayList<String> searchBySubstring(String substring) {
        PokemonList pokeList = pokeApiClient.getPokemon();
        ArrayList<String> pokeNamesList = pokeApiClient.getPokemonNames(pokeList);
        ArrayList<String> results = new ArrayList<>();

        for (String s : pokeNamesList) {
            if (s.contains(substring)) {
                results.add(s);
            }
        }

        return results;
    }

    public HashMap<String, Object> highlightBySubstring(String name, String substring) {

        HashMap<String, Object> result = new HashMap<>();

        Pattern pattern = Pattern.compile(substring);
        Matcher match = pattern.matcher(name);

        while(match.find()) {
            result.put("name", name);
            result.put("start", match.start());
            result.put("end", match.end());
        }
        return result;
    }
}