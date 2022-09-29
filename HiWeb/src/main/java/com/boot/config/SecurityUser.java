package com.boot.config;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.boot.domain.Member;

public class SecurityUser extends User{
	
	private Member member;
	
	public SecurityUser(Member member) {
		//아이디
		super(member.getId(), "{noop}" + member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
		this.member = member;
	}
	
	//인증된 회원정보를 html에서 사용
	public Member getMember() {
		return member;
	}
	

}
