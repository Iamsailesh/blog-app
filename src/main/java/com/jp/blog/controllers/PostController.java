package com.jp.blog.controllers;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.blog.payloads.PostDto;
import com.jp.blog.services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/user/{userId}/category/{categoryId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);

	}

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
		List<PostDto> posts = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
		List<PostDto> posts = this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

//	@GetMapping("/posts")
//	public ResponseEntity<List<PostDto>> getAllPost(
//			@RequestParam(value="pageNumber", defaultValue="1", required=false) Integer pageNumber,
//			@RequestParam(value="pageSize", defaultValue="5", required=false) Integer pageSize
//			) {
//		List<PostDto> posts = this.postService.getAllPost(pageNumber, pageSize);
//		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
//
//	}
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir) {
		List<PostDto> posts = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getById(@PathVariable Integer postId) {
		PostDto postDto = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}

	@DeleteMapping("/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return ResponseEntity.ok(Map.of("Message", "UserDeleted"));
	}

	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
		PostDto updatedPost= this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
	}

	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(
			@PathVariable("keyword") String keyword)
			{
				List<PostDto> result=this.postService.postSearch(keyword);
				return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
		
	
			}
}
