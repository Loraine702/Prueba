package com.services.prueba.controller;

import com.services.prueba.model.Category;
import com.services.prueba.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nexsys/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categories;

    @GetMapping("/")
    public List<Category> getAllCategories() {
        return categories.getAllCategories();
    }


}
