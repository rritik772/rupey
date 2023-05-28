package com.f15t.rupey.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f15t.rupey.Response.CategoryResponse;
import com.f15t.rupey.Service.CategoryService;

@RestController
@RequestMapping("/apiV1/category")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    CategoryResponse createCategory(@RequestBody CategoryResponse response) {
        return categoryService.createCategory(response);
    }

    @GetMapping("/{username}")
    List<CategoryResponse> findCategoryByUsername(@PathVariable String username) {
        return categoryService.findCategoryByUsername(username);
    }

    @PutMapping
    Optional<CategoryResponse> updateCategory(@RequestBody CategoryResponse response) {
        return categoryService.updateCategory(response);
    }

    @DeleteMapping
    Optional<CategoryResponse> deleteCategory(@RequestBody CategoryResponse response) {
        return categoryService.deleteCategory(response);
    }
}
