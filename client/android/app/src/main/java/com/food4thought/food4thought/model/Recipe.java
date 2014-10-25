package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roxy on 25/10/14.
 */
public class Recipe implements JSONSource {

    private static String[] names = {
            "Fried alpaca Meat",
            "Fried alpaca Feet",
            "Fried alpaca Hands",
            "Fried alpaca legs",
            "Fried alpaca head",
            "Fried alpaca eyes",
            "Fried alpaca dick",
            "Fried alpaca fingers",
            "Fried alpaca hair",
            "Fried alpaca nose",
            "Fried alpaca mouth"
    };

    public Publisher<Recipe> publisher;

    private boolean selected;

    private String name;
    private JSONSourceList<Ingredient> ingredients;
    private String description;

    public Recipe() {
        publisher = new Publisher<Recipe>(this);
        selected = false;
        ingredients = new JSONSourceList<Ingredient>();
        ingredients.add(new Ingredient());
        ingredients.add(new Ingredient());
        ingredients.add(new Ingredient());
    }

    @Override
    public void updateFromJSON() {
        name = names[(int) (names.length * Math.random())];
        ingredients.updateFromJSON();
        description = "Put Fried alpaca in poo";
        publisher.publishWithCode(PublishCode.RECIPE_UPDATED);
    }

}