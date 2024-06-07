package com.jp.blog.services;

import java.util.List;

import com.jp.blog.entities.Category;
import com.jp.blog.entities.User;
import com.jp.blog.payloads.PostDto;


public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	PostDto getPostById(Integer postId);

	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	void deletePost(Integer postId);

	List<PostDto> getPostByUser(Integer userId);

	List<PostDto> getPostByCategory(Integer categoryId);
	
	List<PostDto> postSearch(String keyword );

}
