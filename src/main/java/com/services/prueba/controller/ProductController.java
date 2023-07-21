package com.services.prueba.controller;


import com.services.prueba.model.Product;
import com.services.prueba.model.ProductRequest;
import com.services.prueba.model.ServiceResponse;
import com.services.prueba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nexsys/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

    }

    @PostMapping("/")
    public ServiceResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);

    }

}


