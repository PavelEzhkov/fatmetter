package ru.ezhkov.fatmetter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ezhkov.fatmetter.entity.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish,Long> {
}
