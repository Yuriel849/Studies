package com.yuriel.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String email;
	private String name;
	private String pw;
	private String fullName;
	private MultipartFile img = null;
}