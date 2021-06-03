package io.javabrains.controller;

import io.javabrains.model.Category;
import io.javabrains.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/category")
    public List<Category> getGameCategory() {
        return categoryServices.getGameCategories();
    }

    @GetMapping("category/{id}")
    public Category getGameDetailsById(@PathVariable String id) {
        return categoryServices.getGameDetailsById(id);
    }
}
