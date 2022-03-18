package com.lec.jpaaop.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp; 


@Entity
@Table(name = "board")
@SequenceGenerator(name="board_seq_gen", sequenceName="board_seq",  initialValue = 1, allocationSize = 1)
public class Board {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_gen")
	@Column(name ="board_no")	
	private Integer boardNo;
	
	@Column(name ="title")	private String title;
	@Column(name ="content")	private String content;	
	@Column(name ="writer")   private String writer;
	
	@CreationTimestamp
	@Column(name ="reg_date")
	private Timestamp  regDate;
	
	public Integer getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate + "]";
	}
	
	

}
