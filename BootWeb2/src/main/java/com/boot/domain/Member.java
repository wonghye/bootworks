package com.boot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//클래스 - 엔티티 - 테이블 역할

@ToString
@Setter
@Getter
@Entity
public class Member {

	@Id	//pk - primary key
	private String id;
	private String password;
	private String name;
	private String role;
}
