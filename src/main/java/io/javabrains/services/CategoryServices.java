package io.javabrains.services;

import io.javabrains.dao.CategoryRepository;
import io.javabrains.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getGameCategories() {
        List<Category> categoryList = repository.findAll();
        return categoryList;
    }

    public Category getGameDetailsById(String id) {
        Category gameDetails = repository.getGameDetailsById(id);
        return gameDetails;
    }

}
