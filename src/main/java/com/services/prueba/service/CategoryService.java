package com.services.prueba.service;

import com.services.prueba.model.Category;
import com.services.prueba.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService {

    private final String PRODUCTS_API_URL = "https://api.escuelajs.co/api/v1/categories";

    @Autowired
    private RestTemplate restTemplate;

    public List<Category> getAllCategories() {
        Category[] categoryArray = restTemplate.getForObject(PRODUCTS_API_URL, Category[].class);
        return Arrays.asList(categoryArray);
    }
}
