package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // 500에러 -> 400에러로.
class MyException extends RuntimeException {
	MyException(String msg) {
		super(msg);
	}
	
	MyException() {
		this("");
	}
}

@Controller
public class ExceptionController2 {

	@RequestMapping("/ex3")
	public String main() throws Exception {
		throw new MyException("ex3 예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
		throw new FileNotFoundException("ex4 예외가 발생했습니다.");

	}
		
}
