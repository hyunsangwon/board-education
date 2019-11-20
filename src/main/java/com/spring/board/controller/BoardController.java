package com.spring.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.conf.BoardFlag;
import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVO;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String VIEW_PREFIX = "board/";

	@Autowired 
	private BoardService boardService;
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : String
	 * @param : Model
	 * @throws : 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadMain(Model model) {
		
		logger.debug("[ Call / - GET ]");
		
		List<BoardVO> list = boardService.getBoardList();
		logger.debug("[ list size =======> ]"+list.size());
		
		model.addAttribute("boardList",list);
		return "index";
	}

	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : String
	 * @param : Model
	 * @throws : 
	 */
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String loadBoardWrite(Model model) {
		
		model.addAttribute("FLAG",BoardFlag.WRITE);
		return VIEW_PREFIX+"write";
	}
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : Boolean
	 * @param : BoardVO
	 * @throws : 
	 */
	@RequestMapping(value= "/board/write", method= RequestMethod.POST)
	public @ResponseBody Boolean doBoardWrite(@RequestBody BoardVO boardVO) {

		logger.debug("[ Call /board/write - POST ]");
		logger.debug("==> Parameters        : " + boardVO.getTitle());
		logger.debug("==> Parameters        : " + boardVO.getContent());
		
		return boardService.setBoardList(boardVO);
	}
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : String
	 * @param : Model, String
	 * @throws : 
	 */
	@RequestMapping(value= "/board/detail/{boardNo}", method= RequestMethod.GET)
	public String loadBoardDetailView(Model model,@PathVariable("boardNo") String boardNo) {
		
		logger.debug("[ Call /board/write - GET ]");
		logger.debug("==> Parameters        : " + boardNo);
		
		BoardVO vo = boardService.selectBoardListFindByNo(boardNo);
		model.addAttribute("boardVO",vo);
		model.addAttribute("FLAG",BoardFlag.VIEW);
		
		return VIEW_PREFIX+"write";
	}
	
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : String
	 * @param : Model, String
	 * @throws : 
	 * 게시판 삭제
	 */
	@RequestMapping(value= "/board/remove/{boardNo}", method= RequestMethod.GET)
	public String doDeleteboard(Model model,@PathVariable("boardNo") String boardNo) {
		return null;
	}
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : Boolean
	 * @param : BoardVO
	 * @throws : 
	 * 게시판 업데이트
	 */
	@RequestMapping(value= "/board/update", method= RequestMethod.POST)
	public @ResponseBody Boolean doBoardUpdate(@RequestBody BoardVO boardVO) {
		return null;
	}
		
}
