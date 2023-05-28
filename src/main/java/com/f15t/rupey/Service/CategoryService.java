package com.f15t.rupey.Service;

import com.f15t.rupey.DAO.Interface.CategoryDaoInterface;
import com.f15t.rupey.DAO.Interface.UserDaoInterface;
import com.f15t.rupey.Entities.Category;
import com.f15t.rupey.Entities.User;
import com.f15t.rupey.Response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    CategoryDaoInterface categoryDao;
    UserDaoInterface userDao;

    @Autowired
    CategoryService(CategoryDaoInterface categoryDao, UserDaoInterface userDao) {
        this.categoryDao = categoryDao;
        this.userDao = userDao;
    }

    public CategoryResponse createCategory(CategoryResponse response) {
        User user = userDao.findByUsername(response.getUsername());

        Category tmp = Category.builder()
                .name(response.getName())
                .description(response.getDescription())
                .isDeleted(response.isDeleted())
                .user(user)
                .build();
        categoryDao.createCategory(tmp);

        return response;
    }

    public List<CategoryResponse> findCategoryByUsername(String username) {
        List<Category> tmp = userDao.findCategoryByUsername(username);
        List<CategoryResponse> result = tmp.stream().map(category -> CategoryResponse
                        .builder()
                        .name(category.getName())
                        .description(category.getDescription())
                        .username(category.getUser().getUsername())
                        .isDeleted(category.isDeleted())
                        .build())
                .toList();
        return result;
    }

    public Optional<CategoryResponse> updateCategory(CategoryResponse categoryResponse) {
        if (categoryResponse.getCategoryId().isEmpty())
            return Optional.empty();

        Category category = Category.builder()
                .categoryId(categoryResponse.getCategoryId().get())
                .name(categoryResponse.getName())
                .description(categoryResponse.getDescription())
                .isDeleted(categoryResponse.isDeleted())
                .build();
        categoryDao.updateCategory(category);

        return Optional.of(categoryResponse);
    }

    public Optional<CategoryResponse> deleteCategory(CategoryResponse categoryResponse) {
        categoryResponse.setDeleted(true);
        return updateCategory(categoryResponse);
    }
}
