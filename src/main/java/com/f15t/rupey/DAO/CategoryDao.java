package com.f15t.rupey.DAO;

import com.f15t.rupey.DAO.Interface.CategoryDaoInterface;
import com.f15t.rupey.Entities.Category;
import com.f15t.rupey.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao implements CategoryDaoInterface {

    CategoryRepository categoryRepository;

    @Autowired
    CategoryDao(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public Category createCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    public Category getCategory(Long id) {
        return categoryRepository.getReferenceById(id);
    }

    public Category updateCategory(Category category) {
        return createCategory(category);
    }

    public Category deleteCategory(Category category) {
        categoryRepository.delete(category);
        return category;
    }
}
