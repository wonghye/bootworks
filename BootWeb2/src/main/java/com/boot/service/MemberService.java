package com.boot.service;

import com.boot.domain.Member;

public interface MemberService {

   //로그인
   Member getMember(Member member);
   
   //회원가입
   void signup(Member member);
}