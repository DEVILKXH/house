package com.demo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "house")
public class HouseController {

	@RequestMapping(value = "/index.do")
	public String index() {
		return "house";
	}
}
