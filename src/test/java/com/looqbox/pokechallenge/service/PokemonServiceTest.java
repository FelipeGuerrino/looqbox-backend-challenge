package com.looqbox.pokechallenge.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PokemonServiceTest {

    PokemonService underTest = new PokemonService();
    @Test
    void itShouldSearchBySubstring() {
        String substring = "pidge";

        ArrayList<String> query = underTest.searchBySubstring(substring);

        assertThat(query.toString()).isEqualTo("[pidgey, pidgeotto, pidgeot]");
    }

    @Test
    void itShouldHighlightBySubstring() {
        String substring = "pi";
        String name = "pidgey";

        HashMap<String, Object> highlighted = underTest.highlightBySubstring(name, substring);

        assertThat(highlighted.toString()).isEqualTo("{name=pidgey, start=0, end=2}");

    }
}