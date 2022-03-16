package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


 @ControllerAdvice("com.fastcampus.ch3") //- 이 예외를 적용할 패키지를 적어줄수도 있음.(지정된 패키지에서 발생한 예외만 처리됨.) 안적어주면 모든 컨트롤러에서 발생하는 예외를 처리.
// @ControllerAdvice - 예외처리하는 catcher메서드를 별도의 클래스에 넣고, 이 애너테이션을 붙여주면,
// 모든 컨트롤러에서 발생하는 예외를 처리함.
//@ControllerAdvice
public class GlobarCatcher {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
//		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler( {NullPointerException.class, FileNotFoundException.class} )
	public String catcher2(Exception ex, Model m) {
//		m.addAttribute("ex",ex);
		return "error";
	}

}
