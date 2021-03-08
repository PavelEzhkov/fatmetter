package ru.ezhkov.fatmetter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.ezhkov.fatmetter.entity.Dish;
import ru.ezhkov.fatmetter.entity.Ingredient;
import ru.ezhkov.fatmetter.entity.Product;
import ru.ezhkov.fatmetter.repository.DishRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class DishServiceImplTest {

    @Mock
    private DishRepository dishRepository;

    @InjectMocks
    private DishServiceImpl dishService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(dishRepository.getOne(anyLong())).thenReturn(getDish());
    }

    @Test
    void getTotalCaloriesTest() {
        Integer totalCalories = dishService.getTotalCalories(1L);
        assertEquals(250, totalCalories);
    }

    private Dish getDish() {
        Ingredient ingredient1 = Ingredient.builder().weight(100).product(Product.builder().calories(150).build()).build();
        Ingredient ingredient2 = Ingredient.builder().weight(200).product(Product.builder().calories(50).build()).build();
        return Dish.builder().ingredients(Arrays.asList(ingredient1,ingredient2)).build();
    }
}