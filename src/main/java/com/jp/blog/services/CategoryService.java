package com.jp.blog.services;

import java.util.List;

import com.jp.blog.payloads.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto category);

	CategoryDto updateCategory(CategoryDto category, Integer categoryId);

	CategoryDto getCategoryById(Integer categoryId);

	List<CategoryDto> getAllCategory();
	
	void deleteCategory(Integer categoryId);

}
