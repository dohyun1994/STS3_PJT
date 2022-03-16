package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class ExceptionController {
	
//	 별도의 예외처리를 하는 메서드로 빼냈음. 아래 try-catch 중복 제거하기 위함.
//	@ExceptionHandler(Exception.class) : 매개변수에는 이 메서드가 처리할 예외 종류를 적어준다.
//	그러면 이 컨트롤러 내부에있는 메서드에서 예외가 발생하면, 이 catcher메서드가 받는다.
//	이 메서드를 catch 블럭이라 생각하면 된다.
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)	// 200 -> 500
	public String catcher(Exception ex, Model m) {
		
		System.out.println("m=" + m);
		System.out.println("catcher() in ExceptionController");
//		m.addAttribute("ex", ex);
		return "error";
	}
	
	// 다른 예외를 처리할 메서드 여러개 추가 가능. 이 메서드는 NullPointerException예외를 처리함.
	// 배열로 여러개 예외 선언 가능.
	@ExceptionHandler( {NullPointerException.class, FileNotFoundException.class} )
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main(Model m) throws Exception {
		m.addAttribute("msg", "message from ExceptionController.main()");
		throw new Exception("예외가 발생했습니다.");
//		try {
//			throw new Exception("예외가 발생했습니다");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "error";
//		}
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new FileNotFoundException("예외가 발생했습니다.");
//		try {
//			throw new Exception("예외가 발생했습니다");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "error";
//		}
	}
		
}
