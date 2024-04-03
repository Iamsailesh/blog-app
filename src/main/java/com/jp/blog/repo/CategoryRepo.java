package com.jp.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
