package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.boot.domain.Board;
import com.boot.domain.Member;
import com.boot.service.BoardService;

//member 를 자동으로 세션 저장
@SessionAttributes("member")
@Controller
public class BoardController {
   
   @Autowired
   private BoardService service;
   
   //인증 상태 유지하기
 	@ModelAttribute("member")
 	public Member setMember() {
 		return new Member();
 	}
   
   @GetMapping("/hello")
   public void hello() {
      //return "hello";
   }
   
   //목록보기
   @GetMapping("/getBoardList")
   public String getBoardList(Model model) {
      List<Board> boardList = service.getBoardList();
      model.addAttribute("boardList",boardList);
      
      return "getBoardList";
   }
   
   //새글 등록
   @GetMapping("/insertBoard")
   public String insertBoard(@ModelAttribute("member") Member member) {
	   if(member.getId() == null) { 
		   return "redirect:login";
	   }else {
		   return "insertBoard";	//board/insertboard
	   }
   }
   
   //새글 등록 처리
   @PostMapping("/insertBoard")
   public String insertBoard(Board board) {
	   service.insertBoard(board);
	   return "redirect:getBoardList";
   }
   
   //글 상세 보기
   @GetMapping("/getBoard")
   public String getBoard(Long seq, Model model) {
	   service.updateCount(seq); //조회수 증가
	   Board board = service.getBoard(seq);	//상세처리
	   
	   model.addAttribute("board" , board);
	   return "getBoard";
   }
   
   //글 삭제
   @GetMapping("/deleteBoard")
   public String deleteBoard(Board board) {
	   //게시글 1개 객체 삭제 
	   service.deleteBoard(board);
	   return "redirect:getBoardList";
   }
   
   // 글 수정
   @PostMapping("/updateBoard")
   public String updateBoard(Board board) {
	   service.updateBoard(board);
	   return "redirect:getBoardList";
   }
   
   
   
   
   
   
   
   
   
}