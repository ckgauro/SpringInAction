package com.gauro.data;

import com.gauro.domain.Ingredient;

/**
 * @author Chandra
 */
public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);

}
