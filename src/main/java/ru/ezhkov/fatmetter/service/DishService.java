package ru.ezhkov.fatmetter.service;

import ru.ezhkov.fatmetter.entity.Dish;

public interface DishService {

    Dish saveDish(Dish dish);

    Dish getDish(Long id);

    Integer getTotalCalories(Long id);

    Integer getCaloriesPer100Gram(Long id);
}
