package com.jp.blog.payloads;

import java.sql.Date;

import com.jp.blog.entities.Category;
import com.jp.blog.entities.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	private Integer postId;
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String content;
	
	private String imgName;
	
	private UserDto user;
	
	private CategoryDto category;
	
	private Date addedDate;
 
	

}
