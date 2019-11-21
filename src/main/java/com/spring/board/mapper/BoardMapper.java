package com.spring.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.spring.board.vo.BoardVO;

@Repository
public interface BoardMapper {

	/**
	 * @Author : sangwon Hyun
	 * @Date : 2019. 11. 20.
	 * @return : List<BoardVO>
	 * @param : 
	 * @throws : 
	 * 게시판 전체 조회
	 */
	public List<BoardVO> selectBoardList();
	
	/**
	 * @Author : sangwon Hyun
	 * @Date : 2019. 11. 20.
	 * @return : int
	 * @param : BoardVO
	 * @throws : 
	 * 게시판 등록
	 */
	public int insertBoard(BoardVO boardVO);
	
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : BoardVO
	 * @param : String
	 * @throws : 
	 * 게시판 상세 조회
	 */
	public BoardVO selectBoardListFindByNo(@Param("boardNo") String boardNo);
	
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : int
	 * @param : BoardVO
	 * @throws : 
	 * 게시판 수정
	 */
	public int updateBoardFindByNo(BoardVO boardVO);
	
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 20.
	 * @return : int
	 * @param : String
	 * @throws : 
	 * 게시판 삭제
	 */
	public int deleteBoardFindByNo(@Param("boardNo") String boardNo);
	
	
	/**
	 * @Author : sangwon hyun
	 * @Date : 2019. 11. 21.
	 * @return : int
	 * @param : 
	 * @throws : 
	 * 게시글 총 갯수
	 */
	public int totaslCnt();
	
}
