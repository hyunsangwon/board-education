package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.mapper.BoardMapper;
import com.spring.board.vo.BoardVO;

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
	public List<BoardVO> getBoardList(){
		
		List<BoardVO> list = boardMapper.selectBoardList();
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
	
}
