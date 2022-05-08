package com.looqbox.pokechallenge.controller;

import com.looqbox.pokechallenge.model.Pokemon;
import com.looqbox.pokechallenge.service.PokemonService;
import com.looqbox.pokechallenge.utils.Sorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController("/")
public class PokemonController {
    @Autowired
    PokemonService pokemonService = new PokemonService();
    @Autowired
    Sorting sorting = new Sorting();
    @GetMapping("/pokemon")
    public Pokemon getPokemonBySubstring(@RequestParam(value = "q") String substring, @RequestParam(value = "sort", defaultValue = "default") String sort) {
        ArrayList<String> pokeNamesList = pokemonService.searchBySubstring(substring);
        ArrayList<HashMap<String, Object>> highlightedNames = pokemonService.highlightBySubstring(pokeNamesList, substring);

        switch(sort) {
            case "alphabetical":
                pokeNamesList = sorting.sortByAlphabeticalOrder(pokeNamesList);
                break;
            case "length":
                pokeNamesList = sorting.sortByNameLength(pokeNamesList);
                break;
        }

        return new Pokemon(pokeNamesList, highlightedNames);
    }
}
