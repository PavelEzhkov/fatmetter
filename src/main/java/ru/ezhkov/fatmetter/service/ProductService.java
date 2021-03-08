package ru.ezhkov.fatmetter.service;

import ru.ezhkov.fatmetter.DTO.ProductDTO;
import ru.ezhkov.fatmetter.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product saveProduct(Product product);
}
