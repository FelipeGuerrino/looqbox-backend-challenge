package com.looqbox.pokechallenge.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
@ToString
public class PokemonPojo {

    private ArrayList<HashMap> results;

    public PokemonPojo(ArrayList<HashMap> results) {
        this.results = results;
    }

    public PokemonPojo() {
    }

    public ArrayList<HashMap> getResults() {
        return results;
    }

}
