package io.javabrains.dao;

import io.javabrains.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c LEFT JOIN Information i ON c.id = i.id")
    List<Category> getAllGameDetails();

    @Query("SELECT c FROM Category c LEFT JOIN Information i ON c.id = i.id WHERE c.id = (:id)")
    Category getGameDetailsById(String id);
}
