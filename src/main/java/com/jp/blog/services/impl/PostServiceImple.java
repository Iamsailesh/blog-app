package com.jp.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jp.blog.entities.Category;
import com.jp.blog.entities.Post;
import com.jp.blog.entities.User;
import com.jp.blog.exceptions.ResourceNotFoundException;
import com.jp.blog.payloads.CategoryDto;
import com.jp.blog.payloads.PostDto;
import com.jp.blog.repo.CategoryRepo;
import com.jp.blog.repo.PostRepo;
import com.jp.blog.repo.UserRepo;
import com.jp.blog.services.PostService;

@Service
public class PostServiceImple implements PostService {
	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setAddedDate(new Date());
		post.setImgName("Default.png");
		post.setUser(user);
		post.setCategory(cat);

		Post newPost = this.postRepo.save(post);

		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		Post updatedPost=this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		return this.modelMapper.map(post, PostDto.class);

	}

//	@Override
//	public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize) {
//		
//		Pageable p=PageRequest.of(pageNumber, pageSize);
//		Page<Post> pagePost = this.postRepo.findAll(p);
//		List<Post> posts=pagePost.getContent();
//		List<PostDto> postDto = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class))
//				.collect(Collectors.toList());
//		return postDto;
//	}
	@Override
	public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		Sort sort=null;
		if(sortDir.equalsIgnoreCase("asc")) {
			sort=Sort.by(sortBy).ascending();	
		}else {
			sort=Sort.by(sortBy).descending();
		}
	    Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
	    Page<Post> pagePost = this.postRepo.findAll(pageable);
	    List<Post> posts = pagePost.getContent();
	    List<PostDto> postDto = posts.stream()
	            .map(post -> this.modelMapper.map(post, PostDto.class))
	            .collect(Collectors.toList());
	    return postDto;
	}


	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "category id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDtos;

	}

	@Override
	public List<PostDto> postSearch(String keyword) {
		List<Post> posts =this.postRepo.findByTitleContaining(keyword);
		List<PostDto> postDto=posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}

}
