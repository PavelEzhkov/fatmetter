package ru.ezhkov.fatmetter.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.ezhkov.fatmetter.entity.Dish;
import ru.ezhkov.fatmetter.entity.Product;

@Data
@Getter
@Setter
public class IngredientDTO {
    private Integer id;

    private Dish dish;

    private Product product;

    private Integer weight;


}
