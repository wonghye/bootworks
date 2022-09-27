package com.boot.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	//일다다 관계 매핑
	//@OneToMany
	//private List<E>
}
