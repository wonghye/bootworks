package com.boot.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDto {	//상품 클래스
	
	private Long id;		//순번
	private String itemNm;	//상품이름
	private Integer price;	//가격
	private String itemDetail; //상품 상세설명
	private LocalDateTime regTime;	//상품 등록일
}
