package com.lec.jpaaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.jpaaop.domain.Board;


public interface BoardRepository extends JpaRepository<Board, Integer>{

}
