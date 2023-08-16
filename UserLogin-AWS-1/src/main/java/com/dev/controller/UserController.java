package com.dev.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.DTO.UserImageDTO;
import com.dev.entity.User;
import com.dev.entity.UserFormData;
import com.dev.service.UserService;

@RestController
@RequestMapping("/user/v1")
@CrossOrigin("*")
public class UserController {

	private static final Logger _logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/user-login")
	public User userLogin(@RequestBody User user) {
		_logger.debug("user-login function call");

		User userLogin = userService.userLogin(user);
		_logger.debug("user-login function ended");
		return userLogin;
	}

	@GetMapping("/user-login-v2")
	public User userLogin(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		_logger.debug("user-login function call");

		User userLogin = userService.userLoginV2(email, password);
		_logger.debug("user-login function ended");
		return userLogin;
	}

	@PostMapping("/create")
	public UserFormData createUser(@RequestBody UserFormData userFormData) {
		_logger.debug("create user function call");

		UserFormData createUser = userService.createUser(userFormData);
		_logger.debug("create user function ended");
		return createUser;
	}

//	@PostMapping("/create")
//	public UserImageDTO uploadUserImage(@RequestBody UserImageDTO userImageDTO) throws IOException {
//		_logger.debug("create user function call");
//
//		UserFormData createUser = userService.uploadUserImage(userImageDTO);
//		_logger.debug("create user function ended");
//		return null;
//	}

}
