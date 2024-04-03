package com.jp.blog.services;

import java.util.List;

import com.jp.blog.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	UserDto deleteUser(Integer userId);

}
