package com.looqbox.pokechallenge.controller;

import com.looqbox.pokechallenge.model.Pokemon;
import com.looqbox.pokechallenge.service.PokemonService;
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
    @GetMapping("/pokemon")
    public Pokemon getPokemonBySubstring(@RequestParam(value = "q") String substring) {
        ArrayList<String> pokeNamesList = pokemonService.searchBySubstring(substring);
        ArrayList<HashMap<String, Object>> highlightedNames = pokemonService.highlightBySubstring(pokeNamesList, substring);
        return new Pokemon(pokeNamesList, highlightedNames);
    }
}
