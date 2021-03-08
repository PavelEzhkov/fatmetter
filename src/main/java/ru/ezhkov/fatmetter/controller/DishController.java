package ru.ezhkov.fatmetter.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ezhkov.fatmetter.DTO.DishDTO;
import ru.ezhkov.fatmetter.entity.Dish;
import ru.ezhkov.fatmetter.service.DishService;

@RestController
@AllArgsConstructor
public class DishController {

    @Autowired
    private final DishService dishService;

    @Autowired
    private final ModelMapper modelMapper;

    @PostMapping("/dish")
    public Long saveDish(@RequestBody Dish dish) {
        return dishService.saveDish(dish).getId();
    }

    @GetMapping("/dish/{id}")
    public DishDTO getDish(@PathVariable Long id) {
        return modelMapper.map(dishService.getDish(id), DishDTO.class);
    }

    @GetMapping("/dish/{id}/caloriestotal")
    public Integer getTotalCalories(@PathVariable Long id) {
        return dishService.getTotalCalories(id);
    }

    @GetMapping("/dish/{id}/calories")
    public Integer getCaloriesPer100Gram(@PathVariable Long id) {
        return dishService.getCaloriesPer100Gram(id);
    }

}
