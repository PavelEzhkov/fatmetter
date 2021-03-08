package ru.ezhkov.fatmetter.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDTO {
    private Integer id;

    private String name;

    private Integer calories;
}
