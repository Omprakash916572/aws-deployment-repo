package com.dev.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.DTO.UserImageDTO;
import com.dev.entity.User;
import com.dev.entity.UserFormData;
import com.dev.exception.CustomException;
import com.dev.repo.UserFormRepo;
import com.dev.repo.UserRepo;

@Service
public class UserService {

	private static final Logger _logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserFormRepo userFormRepo;

	public User userLogin(User user) {

		User userObj = null;
		if (!user.getEmail().equals("") && !user.getEmail().isEmpty()) {

			if (user.getPassword().equals("") && user.getPassword().isEmpty()) {
				throw new CustomException("password can not be empty.");
			}
			userObj = userRepo.findByEmail(user.getEmail());

			if (Objects.isNull(userObj)) {
				_logger.debug("user not exist.");
				throw new CustomException("User not exist.");
			} else {
				String inputPassword = user.getPassword();
				if (!userObj.getPassword().equals(inputPassword)) {
					throw new CustomException("password is wrong!!.");
				}
			}
		} else {
			throw new CustomException("email can not be empty.");
		}
		return userObj;

	}

	public User userLoginV2(String email, String password) {

		User userObj = null;
		if (!email.equals("") && !email.isEmpty()) {

			if (password.equals("") && password.isEmpty()) {
				throw new CustomException("password can not be empty.");
			}
			userObj = userRepo.findByEmail(email);

			if (Objects.isNull(userObj)) {
				_logger.debug("user not exist.");
				throw new CustomException("User not exist.");
			} else {

				if (!userObj.getPassword().equals(password)) {
					throw new CustomException("password is wrong!!.");
				}
			}
		} else {
			throw new CustomException("email can not be empty.");
		}
		return userObj;

	}

	public UserFormData createUser(UserFormData userFormData) {
		UserFormData userFormDataObj = null;

		if (Objects.nonNull(userFormData)) {

			userFormDataObj = userFormRepo.save(userFormData);
		} else {
			throw new CustomException("User form data is Empty.");
		}
		return userFormDataObj;
	}

	public UserFormData uploadUserImage(UserImageDTO userImage) throws IOException {

		String encoded = "";
		InputStream is = userImage.getImage().getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		encoded = Base64.getEncoder().encodeToString(bytes);
		return null;
	}

}
