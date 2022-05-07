package com.looqbox.pokechallenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class PokemonController {
    @GetMapping("/pokemon")
    public void getPokemonBySubstring() {}
}
