package com.Dao;

import java.util.List;

import com.Model.Category;
import com.Model.User;

public interface CategoryDao {
	void insertCategory(Category category);

	void updateCategory(Category category);

	void deleteCategory(Category category);

	Category getCategory(String id);

	List<Category> getAllCategories();
}