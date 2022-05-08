package com.looqbox.pokechallenge.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Sorting {

    public ArrayList<String> sortByAlphabeticalOrder(ArrayList<String> names) {

        int size = names.size();

        for (int i = 0; i < size; i++) { //iterates for each element
            for (int j = 0; j < size; j++) { //check if every element is sorted
                if(names.get(i).compareTo(names.get(j))<0) {

                    //swap strings if the first comes after the second alphabetically
                    String temp = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, temp);
                }
            }
        }
        return names;
    }

    public ArrayList<String> sortByNameLength(ArrayList<String> names) {
        //pretty much the same logic as the alphabetical order
        int size = names.size();

        for (int i = 0; i < size; i++) { //iterates for each element
            for (int j = 0; j < size; j++) { //check if everything is ordered
                if(names.get(i).length() < names.get(j).length()) {

                    //swap if length of the first is smaller than the second
                    String temp = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, temp);
                }
            }
        }
        return names;
    }
}
