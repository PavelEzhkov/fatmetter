package ru.ezhkov.fatmetter.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ezhkov.fatmetter.DTO.ProductDTO;
import ru.ezhkov.fatmetter.entity.Product;
import ru.ezhkov.fatmetter.service.ProductService;

import java.util.List;


@RestController
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @Autowired
    private final ModelMapper modelMapper;

    @GetMapping("/products")
    public List<Product> showAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Integer saveProduct(@RequestBody ProductDTO product) {
        return productService.saveProduct(modelMapper.map(product, Product.class)).getId();
    }

}
