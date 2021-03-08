package ru.ezhkov.fatmetter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ezhkov.fatmetter.entity.Product;
import org.springframework.stereotype.Service;
import ru.ezhkov.fatmetter.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


}
