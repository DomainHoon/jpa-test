package com.lec.jpaaop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.jpaaop.domain.Board;
import com.lec.jpaaop.repository.BoardRepository;


@Service
public class BoardServiceImpl implements BoardService {

	private BoardRepository repository;
	
	@Autowired
	public BoardServiceImpl(BoardRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public void register(Board board) throws Exception {
		this.repository.save(board);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Board read(Integer boardNo) throws Exception {		
		return this.repository.getById(boardNo);
	}

	@Override
	@Transactional
	public void modify(Board board) throws Exception {
		Board boardEntity = this.repository.getById(board.getBoardNo());
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		boardEntity.setWriter(board.getWriter());
	}

	@Override
	@Transactional
	public void remove(Integer boardNo) throws Exception {
		this.repository.deleteById(boardNo);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Board> list() throws Exception {
		
		return repository.findAll(Sort.by(Direction.DESC, "boardNo"));
	}

}
