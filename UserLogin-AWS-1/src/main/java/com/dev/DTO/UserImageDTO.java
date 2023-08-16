package com.dev.DTO;

import org.springframework.web.multipart.MultipartFile;

public class UserImageDTO {

	private MultipartFile image;

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
