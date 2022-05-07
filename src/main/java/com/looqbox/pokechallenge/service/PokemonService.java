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

    public ArrayList<HashMap<String, Object>> highlightBySubstring(ArrayList<String> names, String substring) {

        ArrayList<HashMap<String, Object>> result = new ArrayList<>();

        for (String name : names
             ) {

        HashMap<String, Object> highlight = new HashMap<>();

        Pattern pattern = Pattern.compile(substring);
        Matcher match = pattern.matcher(name);

        while(match.find()) {
            highlight.put("name", name);
            highlight.put("start", match.start());
            highlight.put("end", match.end());
            }

        result.add(highlight);
        }

        return result;
    }
}