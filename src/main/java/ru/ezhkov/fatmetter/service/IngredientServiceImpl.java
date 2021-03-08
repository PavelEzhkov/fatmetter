package ru.ezhkov.fatmetter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezhkov.fatmetter.entity.Ingredient;
import ru.ezhkov.fatmetter.repository.IngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
