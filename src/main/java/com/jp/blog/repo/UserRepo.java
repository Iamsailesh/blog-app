package com.jp.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
