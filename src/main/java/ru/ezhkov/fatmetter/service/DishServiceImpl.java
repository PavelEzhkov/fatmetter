package ru.ezhkov.fatmetter.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezhkov.fatmetter.entity.Dish;
import ru.ezhkov.fatmetter.entity.Ingredient;
import ru.ezhkov.fatmetter.repository.DishRepository;

@Service
@AllArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    private final IngredientService ingredientService;

    @Override
    public Dish saveDish(Dish dish) {
        dish.getIngredients().forEach(ingredient ->  ingredientService.save(ingredient));
        return dishRepository.save(dish);
    }

    @Override
    public Dish getDish(Long id) {
        return dishRepository.getOne(id);
    }

    @Override
    public Integer getTotalCalories(Long id) {
        int sum = getDish(id).getIngredients().stream().map(ingredient ->
                ingredient.getWeight() * ingredient.getProduct().getCalories() / 100).mapToInt(Integer::intValue).sum();
        return sum;
    }

    @Override
    public Integer getCaloriesPer100Gram(Long id) {
        int sum = getDish(id).getIngredients().stream().map(Ingredient::getWeight).mapToInt(Integer::intValue).sum();
        return getTotalCalories(id)*100/sum;
    }
}
