package com.multi.myboot02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	//JSP 페이지 없이 응답 문서 body에 출력
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/") public String home() { return "myboot02"; }
	 */
	
	/*
	 * @RequestMapping("/") public String home() { return "index"; //index.jsp 뷰페이지
	 * 출력되도록 }
	 */
}
