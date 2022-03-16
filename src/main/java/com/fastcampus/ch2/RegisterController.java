package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}
	
	
//	@RequestMapping("/register/add")	// 신규회원 가입 화면. 회원가입 화면만 호출하므로 POST방식으로 할 필요없음.
//	@GetMapping("/register/add")		// 그래서 @RequstMapping을 간단하게 쓸수있게 해주는게 @GetMapping, @PostMapping
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm";
	}

	
//	@RequestMapping("/register/save")		// @RequestMapping에 method를 안써주면, GET, POST둘다 허용하겠다.
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
//	@RequestMapping(value="/register/save", method={RequestMethod.GET, RequestMethod.POST)    GET, POST 둘다 허용
	@PostMapping("/register/save") 		// @PostMapping 스프링 4.3부터 지원.
	public String save(User user, BindingResult result, Model m) throws Exception {
		System.out.println("result=" + result);
		
		// 사용자가 registerForm.jsp에서 회원가입 정보를 입력하면, 로직
		// 1. 유효성 검사.
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "UTF-8");

			m.addAttribute("msg", msg);
			return "forward:/register/add?msg="+msg;       // redirect - 재요청
//			return "redirect:/register/add?msg="+msg;		// URL재작성(rewriting)
			
		}
		
		// 2. DB에 신규회원 정보를 저장.
		return "registerInfo";
	}

	private boolean isValid(User user) {
		
		return true;
	}
	
}
