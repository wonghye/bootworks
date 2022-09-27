package com.boot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.boot.domain.Member;
import com.boot.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {

   @Autowired
   private MemberService service;

   //로그인 페이지 요청
   @GetMapping("/login")
   public String loginView() {
      return "login";
   }

   //로그인 인증 처리
   @PostMapping("/login")
   public String login(Member member, Model model) {
      Member findMember = service.getMember(member);
      //findMember의 비밀번호와 로그인 폼에 입력한 비밀번호와 비교 
      if(findMember != null 
            && findMember.getPassword().equals(member.getPassword())) {
         model.addAttribute("member",findMember);
         return "redirect:getBoardList";
      }else {
         return "redirect:login";
      }
   }
   
   
   //로그아웃 처리
   /*
   @GetMapping("/logout")
   public String logout(HttpSession session) {
	   session.invalidate();	// 모든 세션 삭제
	   return "redirect:";		// 경로가 공백이면 '/' 경로와 같음
   }
   */
   
   @GetMapping("/logout")
   public String logout(SessionStatus status) {
	   status.setComplete();	
	   return "redirect:";		// 경로가 공백이면 '/' 경로와 같음
   }
   
   //회원 가입 페이지 요청
   @GetMapping("/signup")
   public String signupView() {
	   return "signup";		//signup.html
   }
   
   //회원가입 처리
   @PostMapping("/signup")
   public String signup(Member member) {
	   service.signup(member);
	   return "redirect:login";
   }
   
   //나의 정보 페이지 요청
   @GetMapping("/mypage")
   public String mypage() {
	   return "mypage";
   }
   
   
   
}