package ru.ezhkov.fatmetter.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class DishDTO {
    private Long id;

    private String name;

    private List<IngredientDTO> ingredients;
}
