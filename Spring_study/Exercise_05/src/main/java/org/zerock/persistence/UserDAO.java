package org.zerock.persistence;

import org.zerock.domain.LoginDTO;
import org.zerock.domain.UserVO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
}
