package ru.ezhkov.fatmetter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Dish dish;

    @ManyToOne
    private Product product;

    @Column
    private Integer weight;
}
