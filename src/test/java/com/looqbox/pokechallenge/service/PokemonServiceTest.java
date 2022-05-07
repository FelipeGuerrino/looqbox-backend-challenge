package com.looqbox.pokechallenge.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PokemonServiceTest {

    PokemonService underTest = new PokemonService();
    @Test
    void itShouldSearchBySubstring() {
        String substring = "pi";

        ArrayList<String> query = underTest.searchBySubstring(substring);

        assertThat(query.toString()).isEqualTo("[caterpie, pidgey, pidgeotto, pidgeot]");
    }

    @Test
    void itShouldHighlightBySubstring() {
        String substring = "pi";
        ArrayList<String> query = underTest.searchBySubstring(substring);
        ArrayList<HashMap<String, Object>> highlighted = underTest.highlightBySubstring(query, substring);

        assertThat(highlighted.toString()).isEqualTo("[{name=caterpie, start=5, end=7}, {name=pidgey, start=0, end=2}, {name=pidgeotto, start=0, end=2}, {name=pidgeot, start=0, end=2}]");

    }
}