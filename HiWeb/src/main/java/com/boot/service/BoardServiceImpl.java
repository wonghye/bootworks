package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.boot.domain.Board;
import com.boot.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{
   
   @Autowired
   private BoardRepository boardRepo;
   
   //목록보기
   @Override
   public List<Board> getBoardList() {
      return boardRepo.findAll(Sort.by(Sort.Direction.DESC, "seq"));
   }

   //상세보기
	@Override
	public Board getBoard(Long seq) {
		return boardRepo.findById(seq).get();
	}

}