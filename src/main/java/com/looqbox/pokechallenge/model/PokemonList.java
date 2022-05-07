package com.looqbox.pokechallenge.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
@ToString
public class PokemonList {

    private ArrayList<HashMap> results;

    public PokemonList(ArrayList<HashMap> results) {
        this.results = results;
    }

    public PokemonList() {
    }

}
