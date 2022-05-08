package com.looqbox.pokechallenge.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    Sorting underTest = new Sorting();

    @Test
    void itShouldSortByAlphabeticalOrder() {
        ArrayList<String> legends = new ArrayList<String>(Arrays.asList("mewtwo", "rayquaza", "arceus", "moltres"));

        ArrayList<String> sortedLegends = underTest.sortByAlphabeticalOrder(legends);

        assertThat(sortedLegends.toString()).isEqualTo("[arceus, mewtwo, moltres, rayquaza]");
    }

    @Test
    void itShouldSortByNameLength() {
        ArrayList<String> initials = new ArrayList<String>(Arrays.asList("charmander", "squirtle", "bulbasaur"));

        ArrayList<String> sortedInitials = underTest.sortByNameLength(initials);

        assertThat(sortedInitials.toString()).isEqualTo("[squirtle, bulbasaur, charmander]");

    }
}