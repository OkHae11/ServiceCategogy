package com.example.ServiceCategogy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ServiceCategogy.entity.Category;
import com.example.ServiceCategogy.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getCaterogyById(int id) {
		Category category = null;
		
		Optional<Category> result = categoryRepository.findById(id);
		
		if (result.isPresent()) {
			category = result.get();
		} else {
			throw new RuntimeException("Don't find category id - " + id);
		}
		
		return category;
	}
	

	@Override
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		 categoryRepository.deleteById(id);
	}


	@Override
	public Category getCaterogyByName(String name) {
		// TODO Auto-generated method stub
//		Category category=categoryRepository.findByName(name);
//		System.out.println(category);
		return categoryRepository.findByName(name);
	}

	

}
