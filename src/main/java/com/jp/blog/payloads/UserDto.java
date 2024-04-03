package com.jp.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private Integer id;

	@NotEmpty
	private String name;

	@Email(message="your email is not valid")
	private String email;

	@NotEmpty
	@Size(min=6, message= "you password shouldn't be empty and  must be 6 character long")
	private String password;

	@NotEmpty
	private String about;

}
