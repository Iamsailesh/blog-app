

package com.jp.blog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.blog.entities.Category;
import com.jp.blog.entities.Post;
import com.jp.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String title);
}
