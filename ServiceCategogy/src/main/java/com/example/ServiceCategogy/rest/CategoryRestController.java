package com.example.ServiceCategogy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ServiceCategogy.entity.Category;
import com.example.ServiceCategogy.service.CategoryService;

@RestController
public class CategoryRestController {
	@Autowired
	private CategoryService categoryService;
	//Tim Het
	@GetMapping("/categorys")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }
	//Luu
    @PostMapping("/category")
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }
    //xoa
    @CacheEvict(value = "categories", allEntries=true)
    @DeleteMapping("/category/{id}")
	public String deleteCategory(@PathVariable int id) {
		categoryService.delete(id);
		return "Deleted category id: " + id;
	}
    //update
    @CachePut(value = "categories", key = "#category.id")
    @PutMapping("/category")
    public Category update(@RequestBody Category category) {
        System.out.println("Update category from database");
        return categoryService.save(category);
    }
    
    
    // tim theo id
    @GetMapping("/category/{id}")
    @Cacheable(value = "categories", key = "#id")
    public Category getCaterogyById(@PathVariable int id) {
        
        return categoryService.getCaterogyById(id);
    } 
    // tim theo ten
    @GetMapping("/category/name/{name}")
    public Category getCaterogyByName(@PathVariable String name) {
        return categoryService.getCaterogyByName(name);
    } 

    
    
}
