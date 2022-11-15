package com.example.ServiceCategogy.service;

import java.util.List;

import com.example.ServiceCategogy.entity.Category;

public interface CategoryService {
	public List<Category> getCategories();
	public Category getCaterogyById(int id);
	public Category save(Category category);
	public Category update(Category category);
	public void delete(int id);

	public Category getCaterogyByName(String name);
}
