package com.boot.service;

import com.boot.domain.Member;

public interface MemberService {

   //로그인
   Member getMember(Member member);
   
   //회원가입
   void signup(Member member);
   
   //id 중복확인
   int checkID(String id);
   
   //회원 정보
   Member getOne(String id);
   
   //회원 탈퇴
   void delelte(Member member);
   
   //회원 수정
   void updateMember(Member member);
   
}