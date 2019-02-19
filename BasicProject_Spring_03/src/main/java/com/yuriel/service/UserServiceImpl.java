package com.yuriel.service;

import java.util.ArrayList;
import java.util.List;

import com.yuriel.domain.LoginDTO;
import com.yuriel.domain.UserVO;

public class UserServiceImpl implements UserService {

	// user 회원가입한다.
	public int registerMember() throws Exception {
		return 1;
	}
	
	// 로그인한다.
	public LoginDTO login() throws Exception {
		return new LoginDTO();
	}
	
	// 모든 회원 명단을 가져온다.
	public List<UserVO> getUserList() throws Exception {
		return new ArrayList<UserVO>();
	}
	
	// 회원의 정보를 수정한다.
	public int modifyUser() throws Exception {
		return 1;
	}
	
	// 회원탈퇴한다.
	public int deleteUser() throws Exception {
		return 1;
	}
	
}
