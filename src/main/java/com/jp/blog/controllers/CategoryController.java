package com.jp.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.blog.payloads.CategoryDto;
import com.jp.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	// create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createdCat = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createdCat, HttpStatus.CREATED);

	}

	// update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Integer categoryId) {
		CategoryDto updatedCat = this.categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(updatedCat, HttpStatus.OK);

	}

	// delete
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable Integer categoryId) {
		this.categoryService.deleteCategory(categoryId);
	}

	// Get one
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getById(@PathVariable Integer categoryId) {
		CategoryDto catDto = this.categoryService.getCategoryById(categoryId);
		return new ResponseEntity<CategoryDto>(catDto, HttpStatus.OK);

	}
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> cats= this.categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(cats, HttpStatus.OK);
		
	}
  }
