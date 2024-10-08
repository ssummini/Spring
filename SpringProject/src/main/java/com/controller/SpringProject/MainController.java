package com.controller.SpringProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping(value="/") //value => 요청 url
	public String index() {
		return "/index"; // 파일경로
	}
}
