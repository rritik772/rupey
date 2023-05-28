package com.f15t.rupey.DAO.Interface;

import com.f15t.rupey.Entities.Category;

public interface CategoryDaoInterface {
    Category createCategory(Category category);
    Category getCategory(Long id);
    Category updateCategory(Category category);
    Category deleteCategory(Category category);
}
