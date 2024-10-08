package com.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value="hello.do", method = RequestMethod.GET)
	public ModelAndView hello() { //사용자가 만든 콜백메서드 
       ModelAndView mav = new ModelAndView();
       mav.addObject("result", "Hello Spring MVC!!");
       //mav.setViewName("hello"); //JSP 파일이름 => /WEB-INF/hello.jsp / 화면에 보여줘야할 이름을 실어주면 된다.
       mav.setViewName("/view/hello"); // JSP 파일이름 => /WEB-INF/view/hello.jsp
       return mav;                                                                                                                                
	}
	
	@RequestMapping(value="hello2.do", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String hello2(){
		//return "/welcome";
		return "안녕하세요 스프링!!";
	}
} 

/*
URL에서 바로 JSP가 실행되지 않게 하기위해서 /WEB-INF에 JSP 파일을 작성한다.
http://localhost:8080/Chapter06/WEB-INF/hello.jsp를 실행할 수 없다.

스프링에서 리턴 타입이 String이면 단순 문자열이 아니라 JSP 파일명으로 인식한다.
만약 단순 문자열로 처리하여 브라우저에 바로 뿌리려면 @ResponseBody를 써야한다.
*/