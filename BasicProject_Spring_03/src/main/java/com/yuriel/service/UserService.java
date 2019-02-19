package com.yuriel.service;

import java.util.List;

import com.yuriel.domain.LoginDTO;
import com.yuriel.domain.UserVO;

public interface UserService {
	
	// user 회원가입한다.
	public int registerMember() throws Exception;
	
	// 로그인한다.
	public LoginDTO login() throws Exception;
	
	// 모든 회원 명단을 가져온다.
	public List<UserVO> getUserList() throws Exception;
	
	// 회원의 정보를 수정한다.
	public int modifyUser() throws Exception;
	
	// 회원탈퇴한다.
	public int deleteUser() throws Exception;
	
}