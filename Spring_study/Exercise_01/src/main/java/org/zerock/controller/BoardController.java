package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	// GET -> 항상 사용자가 직접 브라우저에서 접근 가능한 경우 사용한다.
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		logger.info("register get ............");
	}
	
	// POST -> 외부에서 많은 정보를 입력해야 하는 경우, 브라우저 주소창에 보여져서는 안 되는 정보를 전송할 때 사용한다.
	@RequestMapping(value = "/register", method = RequestMethod.POST)
				  // 매개변수 -> 입력하는 데이터를 BoardVO에서 수집하고, view까지 데이터를 보내야할 수도 있으니까 Model을 사용한다.
	public String registPOST(BoardVO board, Model model) throws Exception {
		logger.info("regist post ............");
		logger.info(board.toString());
		
		service.regist(board);
		
		model.addAttribute("result", "success");
		
//		return "/board/success";
		return "redirect:/board/listAll"; // 사용자를 success 페이지로 보내는 대신 바로 목록 페이지로 redirect한다.
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list...............");
	}
}
