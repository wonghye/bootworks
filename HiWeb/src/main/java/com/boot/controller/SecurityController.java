package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	//로그인
	@GetMapping("/system/login")
	public void login() {	//system / login
	}
	
	//로그아웃
	@GetMapping("/system/logout")
	public void logout() {
		
	}
	
	
}
