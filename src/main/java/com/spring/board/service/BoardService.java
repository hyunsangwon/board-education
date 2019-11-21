package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.conf.PageHandler;
import com.spring.board.mapper.BoardMapper;
import com.spring.board.vo.BoardVO;
import com.spring.board.vo.PageVO;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : List<BoardVO>
	 * @param : 
	 * @throws : 
	 */
	public List<BoardVO> getBoardList(int limitCount,int contentNum){
		
		PageVO pageVO = new PageVO();
		pageVO.setLimitCount(limitCount);
		pageVO.setContentNum(contentNum);
		
		List<BoardVO> list = boardMapper.selectBoardList(pageVO);
		int listSize = list.size();

		for(int i=0; i<listSize; i++) {
			int boardNo = listSize-i;	
			list.get(i).setNo(boardNo);
		}
		return list;
	}
	
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : boolean
	 * @param : BoardVO
	 * @throws : 
	 */
	public boolean setBoardList(BoardVO boardVO) {
		
		int rows = boardMapper.insertBoard(boardVO);
		boolean flag = false;
		
		if(rows > 0) flag = true;
		
		return flag;
	}
	
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : BoardVO
	 * @param : String
	 * @throws : 
	 */
	public BoardVO selectBoardListFindByNo(String boardNo) {
		
		return boardMapper.selectBoardListFindByNo(boardNo);
	}
	
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 21.
	 * @return : boolean
	 * @param : BoardVO
	 * @throws : 
	 */
	public boolean updateBoardFindByNo(BoardVO boardVO) {
		
		int rows =  boardMapper.insertBoard(boardVO);
		boolean flag = false;
		
		if(rows > 0) flag = true;
		
		return flag;
	}
	
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 21.
	 * @return : boolean
	 * @param : String
	 * @throws : 
	 */
	public boolean deleteBoardFindByNo(String boardNo) {
		
		int rows =  boardMapper.deleteBoardFindByNo(boardNo);
		boolean flag = false;
		
		if(rows > 0) flag = true;
		
		return flag;
	}
	
	
	public PageHandler doPage(int pageNum, int rowCnt) {
		
		int totalCnt = boardMapper.totalCnt();
		int contentNum = rowCnt; //몇줄 보일껀지
		
		PageHandler pageHandler = new PageHandler();
		pageHandler.setTotalcount(totalCnt);
		pageHandler.setPagenum(pageNum);
		pageHandler.setContentnum(contentNum);
		pageHandler.setCurrentblock(pageNum);
		pageHandler.setLastblock(pageHandler.getTotalcount());
		pageHandler.prevnext(pageNum);
		pageHandler.setStartPage(pageHandler.getCurrentblock());
		pageHandler.setEndPage(pageHandler.getLastblock(),pageHandler.getCurrentblock());
		
		return pageHandler;
	}
	
}
