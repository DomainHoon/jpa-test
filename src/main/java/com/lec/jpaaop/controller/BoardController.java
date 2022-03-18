package com.lec.jpaaop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.jpaaop.domain.Board;
import com.lec.jpaaop.service.BoardService;



@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardService service;

	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	@RequestMapping("/list")
	public void list(Model model) throws Exception{
		//logger.info("logger ===================== list");
		model.addAttribute("list", service.list());
	}
	@RequestMapping("/read")
	public void read(int boardNo, Model model) throws Exception{
		//logger.info("logger ===================== read");
		model.addAttribute(service.read(boardNo));
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerForm(Board board, Model model) throws Exception{
		//logger.info("logger ===================== registerForm");

	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(Board board, Model model) throws Exception{
		//logger.info("logger ===================== register");

		service.register(board);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "board/success";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(int boardNo, Model model) throws Exception{
		//logger.info("logger ===================== remove");
		service.remove(boardNo);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "board/success";
	}
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyForm(int boardNo, Model model) throws Exception{
		//logger.info("logger ===================== modify");
		model.addAttribute(service.read(boardNo));
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Board board, Model model) throws Exception{
		//logger.info("logger ===================== modify");
		service.modify(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "board/success";

	}
	
}
