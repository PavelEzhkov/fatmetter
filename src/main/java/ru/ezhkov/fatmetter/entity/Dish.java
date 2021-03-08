package ru.ezhkov.fatmetter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany
    private List<Ingredient> ingredients;

}
