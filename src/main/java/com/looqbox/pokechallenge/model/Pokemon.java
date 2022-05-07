package com.looqbox.pokechallenge.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
@RequiredArgsConstructor
public class Pokemon {

    private final ArrayList<String> result;
    private final ArrayList<HashMap<String, Object>> highlightedResult;
}
