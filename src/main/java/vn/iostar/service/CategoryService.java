package vn.iostar.service;

import java.util.List;

import vn.iostar.entity.Category;

public interface CategoryService {
    List<Category> findAll();
    void save(Category category);
    Category findById(Long id);
    void deleteById(Long id);
}
