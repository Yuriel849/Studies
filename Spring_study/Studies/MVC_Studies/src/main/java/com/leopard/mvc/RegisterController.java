package com.leopard.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/memberReg")
public class RegisterController {
	@RequestMapping(method = RequestMethod.GET)
	public String getForm() {
		return "member/regForm";
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView memberReg(HttpServletRequest request) {
//		String uid = request.getParameter("uid");
//		String upw = request.getParameter("upw");
//		String uname = request.getParameter("uname");
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("member/memberReg");
//		mav.addObject("result", uid + " : " + upw + " : " + uname);
//		
//		return mav;
//	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView memberReg(HttpServletRequest request, @RequestParam("uid") String id, @RequestParam("upw") String pw, @RequestParam("uname") String name, Member member) {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String uname = request.getParameter("uname");
		
		System.out.println("From request : " + uid + " : " + upw + " : " + uname);
		System.out.println("From @RequestParam : " + id + " : " + pw + " : " + name);
		System.out.println("From Member : " + member);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberReg");
		mav.addObject("result", uid + " : " + upw + " : " + uname);
		mav.addObject("obj", id + " : " + pw + " : " + name);
		mav.addObject("member", member);
		
		return mav;
	}
}