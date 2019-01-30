package org.zerock.service;

import org.zerock.domain.LoginDTO;
import org.zerock.domain.UserVO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
}